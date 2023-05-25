package HomeWork12;

import HomeWork12.Phonebook.PhoneDictionary;
import HomeWork12.Phonebook.Record;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<String> worldList = List.of("elephant", "toy", "toy", "PS", "java");
//        String targetWorld = "toy";
//        int countWorlds = countOccurance(worldList, targetWorld);
//        System.out.println("Count uniq worlds: " + countWorlds);
//
//        Integer[] array = {1,2,3};
//        List<Integer> list = toList(array);
//        System.out.println("Massive: " + Arrays.toString(array));
//        System.out.println("ArrayList: " + list);
//
//
//        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 3, 5, 6, 1, 7, 7, 8, 9, 9, 10);
//        List<Integer> uniqNumbers = findUnique(numbers);
//        System.out.println("Uniq numbers: " + uniqNumbers);

//        List<String> animal = List.of("elephant", "bird", "fox", "fox");
//        Map<String, Integer> occurentMap = calcOccurance(animal);
//        printOccurances(occurentMap);

        PhoneDictionary directory = new PhoneDictionary();
        directory.addRecord(new Record("Vitalii", 0501234567));
        directory.addRecord(new Record("Kate", 05012345666));
        directory.addRecord(new Record("Molly", 0501234566));
        directory.addRecord(new Record("Natali", 050123415));
        directory.addRecord(new Record("Natali", 050123416));

        String findName = "Natali";

        Record record = directory.find(findName);
        if (record != null) {
            System.out.println("Find record name: " + record.getName() + " phone: " + record.getPhone());
        } else {
            System.out.println("Record doesn't find");
        }

        List<Record> foundRecords = directory.findAll(findName);
        if (foundRecords != null) {
            System.out.println("Found records: ");
            for (Record foundRecord : foundRecords) {
                System.out.println("Name: " + foundRecord.getName());
                System.out.println("Phone: " + foundRecord.getPhone());
            }
        }else {
            System.out.println("Records don't find");
        }
    }

    public static int countOccurance(List<String> list, String value) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                count++;
            }
        }
        return count;
    }

    public static <T> List<T> toList(T[] array) {
        List<T> list;
        list = new ArrayList<>(Arrays.asList(array));
        return list;
    }

    public static List<Integer> findUnique(List<Integer> list) {
        Set<Integer> uniqSet = new HashSet<>(list);
        return new ArrayList<>(uniqSet);
    }

    public static Map<String, Integer> calcOccurance(List<String> worlds) {
        Map<String, Integer> ocurrenceMap = new HashMap<>();

        for (String word : worlds) {
            int count = ocurrenceMap.getOrDefault(word, 0);
            ocurrenceMap.put(word, count+1);
        }
        return ocurrenceMap;
    }

    public static void printOccurances(Map<String, Integer> occurentMap) {
        for (Map.Entry<String, Integer> entry : occurentMap.entrySet()) {
            System.out.printf("{name: \"%s\", occurrence: %d},%n", entry.getKey(), entry.getValue());
        }
    }

}
