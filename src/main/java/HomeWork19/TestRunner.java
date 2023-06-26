package HomeWork19;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void start(Class<?> testClass) {
        try {
            Object instance = testClass.getDeclaredConstructor().newInstance();

            Method beforeSuiteMethod = getSingleMethodWithAnnotation(testClass, BeforeSuite.class);
            Method afterSuiteMethod = getSingleMethodWithAnnotation(testClass, AfterSuite.class);
            List<Method> testMethods = getMethodsWithAnnotation(testClass, Test.class);
            
            if (beforeSuiteMethod != null) {
                invokeMethod(instance, beforeSuiteMethod);
            }

            testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));
            for (Method testMethod : testMethods) {
                invokeMethod(instance, testMethod);
            }

            if (afterSuiteMethod != null) {
                invokeMethod(instance, afterSuiteMethod);
            }
        }catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Method getSingleMethodWithAnnotation(Class<?> testClass, Class<? extends Annotation> annotationClass) {
        Method[] methods =  testClass.getDeclaredMethods();
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                annotatedMethods.add(method);
            }
        }
        if (annotatedMethods.size() > 1) {
            throw new RuntimeException("Multiple methods with the annotation " + annotationClass.getSimpleName());
        }
        return annotatedMethods.isEmpty() ? null : annotatedMethods.get(0);
    }

    private static List<Method> getMethodsWithAnnotation(Class<?> testClass, Class<? extends Annotation> annotationClass) {
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }

    private static void invokeMethod(Object instance, Method method) throws IllegalAccessException, InvocationTargetException{
        method.setAccessible(true);
        method.invoke(instance);
    }

    public static void main(String[] args) {
        start(TestClass.class);
    }
}
