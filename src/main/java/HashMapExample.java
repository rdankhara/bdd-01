import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HashMapExample {
    public static void main(String[] args) {
//        hashMapUniqueKeyExample();
//        hashMapWithNumber();
        Integer[] inputs = new Integer[] {1, 2, 3, 10, 4, 3, 10, 2, 4, 1, -1, -1, -1, -1};
        log.info("are all numbers in pair: {}", checkPairOfNumbersAreEvenInArray(inputs));
        inputs = new Integer[] {1, 10, 4, 3, 10, 2, 4, 1};
        log.info("are all numbers in pair: {}", checkPairOfNumbersAreEvenInArray(inputs));
    }

    public static boolean checkPairOfNumbersAreEvenInArray(Integer[] values) {
        HashMap<Integer, Integer> mapOfNumber = new HashMap<>();
        for (Integer value: values) {
            addOrIncrementValue(mapOfNumber, value);
        }
        int oddEntryCount = 0;
        for (Map.Entry<Integer, Integer> entry: mapOfNumber.entrySet()) {
            boolean isOdd = entry.getValue() % 2 != 0;
            if (isOdd) {
                oddEntryCount++;
            }
        }
        log.info("count of each item in array {}", mapOfNumber);
        log.info("odd entry in array {}", oddEntryCount);
        return oddEntryCount == 0;
    }

    public static void hashMapWithNumber() {
        HashMap<String, Integer> fruitWithColor = new HashMap<>();
//        addOrIncrementValue(fruitWithColor, "apple");
//        addOrIncrementValue(fruitWithColor, "apple");
//        addOrIncrementValue(fruitWithColor, "apple");
//        addOrIncrementValue(fruitWithColor, "banana");
        String[] names = new String[] {"apple", "apple", "apple", "banana"};
        for (String name: names) {
            addOrIncrementValue(fruitWithColor, name);
        }

        log.info("fruit name and count {}", fruitWithColor);
//        if (fruitWithColor.containsKey("apple")) {
//            Integer count = fruitWithColor.get("apple");
//            fruitWithColor.put("apple", count + 1);
//        } else {
//            fruitWithColor.put("apple", 1);
//        }


        log.info("Fruit Items {} ", fruitWithColor);
    }

//    public static void addOrIncrementValue(HashMap<TKey, TValue> fruitCount, String key){
//        if (fruitCount.containsKey(key)) {
//            Integer count = fruitCount.get(key);
//            fruitCount.put(key, count + 1);
//        } else {
//            fruitCount.put(key, 1);
//        }
//    }

    public static void addOrIncrementValue(HashMap<Integer, Integer> fruitCount, Integer key){
        Integer existingValue = fruitCount.getOrDefault(key, 0).intValue();
        fruitCount.put(key, existingValue + 1);

//        if (fruitCount.containsKey(key)) {
//            Integer count = fruitCount.get(key);
//            fruitCount.put(key, count + 1);
//        } else {
//            fruitCount.put(key, 1);
//        }
    }
    public static void addOrIncrementValue(HashMap<String, Integer> fruitCount, String key){
        if (fruitCount.containsKey(key)) {
            Integer count = fruitCount.get(key);
            fruitCount.put(key, count + 1);
        } else {
            fruitCount.put(key, 1);
        }
    }

    public static void hashMapUniqueKeyExample() {
        HashMap<String, String> fruitWithColor = new HashMap<>();

        fruitWithColor.put("apple", "red");
        fruitWithColor.put("mango", "yellow");
        fruitWithColor.put("banana", "green");
        fruitWithColor.put("apple", "red");

        log.info("Fruit Items {} ", fruitWithColor);
    }
}
