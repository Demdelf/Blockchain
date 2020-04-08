import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        Map<String, Integer> map = new TreeMap<>();

        for (String s: strings
             ) {
            if (map.containsKey(s)) {
                Integer put = map.get(s);
                map.put(s, put + 1);
            }else map.put(s, 1);
        }
        return (SortedMap<String, Integer>) map;
    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        for (Map.Entry e: map.entrySet()
             ) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}