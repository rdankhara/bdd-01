import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

@Slf4j
public class HashSetExample {
    // HashSet - input is always object
    // HashMap - key is always object

    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {1, 2, 3, 10, 4, 3, 10, 2, 4, 1, -1, -1, -1, -1};
        String[] names = new String[] {"apple", "banana", "apple", "banana", "pair"};
        HashSet<String> uniqueNames = addToHashSet(names);

        log.info("Unique Items - {}", uniqueNames);
        log.info("is banana present - {}", uniqueNames.contains("banana"));
        log.info("is mango present - {}", uniqueNames.contains("mango"));

        uniqueNames.remove("banana");
        log.info("after removing banana -> {} ", uniqueNames);
//        addToHashSet(numbers);
    }

    public static HashSet<String> addToHashSet(String [] inputs) {
        HashSet<String> unique= new HashSet<>();

        for (String input: inputs) {
            unique.add(input);
        }

        return unique;
    }

    public static void addToHashSet(Integer [] inputs) {
        HashSet<Integer> unique= new HashSet<>();
        for (Integer input: inputs) {
            unique.add(input);
        }
        log.info("Unique Items - {}", unique);
        log.info("-1 present in items - {}", unique.contains(-1));
        log.info("100 present in items - {}", unique.contains(100));
    }
}
