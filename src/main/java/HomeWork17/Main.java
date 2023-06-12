package HomeWork17;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        Integer[] array = {1,2,3,5,7,8,9,11};
//        List<Integer> list = ConvertMassiveToList.toList(array);
//        System.out.println(list);
//
//        String[] arrayString = {"Cat", "Dog", "Duck", "Mouse"};
//        List<String> listString = ConvertMassiveToList.toList(arrayString);
//        System.out.println(listString);

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruits(new Apple());
        appleBox1.addFruits(new Apple());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruits(new Orange());
        orangeBox1.addFruits(new Orange());
        orangeBox1.addFruits(new Orange());

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruits(new Orange());
        orangeBox2.addFruits(new Orange());

        List<Apple> additionalApples = new ArrayList<>();
        additionalApples.add(new Apple());
        additionalApples.add(new Apple());
        appleBox1.addFruits(additionalApples);

        float appleBox1Weight = appleBox1.getWeight();
        float orangeBox1Weight = orangeBox1.getWeight();
        float orangeBox2Weight = orangeBox2.getWeight();

        System.out.println("Weight first box with apples: " + appleBox1Weight);
        System.out.println("Weight first box with oranges: " + orangeBox1Weight);
        System.out.println("Weight second box with oranges: " + orangeBox2Weight);

        boolean isBoxesEqual = appleBox1.compare(orangeBox1);
        System.out.println("Compare first box with apples and " +
                "first box with oranges: " + isBoxesEqual);

        orangeBox1.merge(orangeBox2);

        orangeBox1Weight = orangeBox1.getWeight();
        System.out.println("Box weight with apples after compare: " + orangeBox1Weight);

    }


}
