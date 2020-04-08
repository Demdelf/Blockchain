import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        char[] first = scanner.nextLine().toLowerCase().toCharArray();
        char[] second = scanner.nextLine().toLowerCase().toCharArray();
        int counter = 0;
        Map<Character, Integer> mapF = new HashMap<>();

        for (char c: first
        ) {
            if (mapF.containsKey(c)) {
                Integer put = mapF.get(c);
                mapF.put(c, put + 1);
            }else mapF.put(c, 1);
        }

        Map<Character, Integer> mapS = new HashMap<>();

        for (char c: second
        ) {
            if (mapS.containsKey(c)) {
                Integer put = mapS.get(c);
                mapS.put(c, put + 1);
            }else mapS.put(c, 1);
        }


        for (char c: first
        ) {
            if (mapS.containsKey(c)){
                Integer put = mapS.get(c);
                if (put > 1){
                    mapS.put(c, put - 1);
                }else mapS.remove(c);

                Integer putF = mapF.get(c);
                if (putF > 1){
                    mapF.put(c, putF - 1);
                }else mapF.remove(c);

            }
        }
        for (Map.Entry e: mapF.entrySet()
        ) {
            counter += (int) e.getValue();
        }
        for (Map.Entry e: mapS.entrySet()
        ) {
            counter += (int) e.getValue();
        }
        System.out.println(counter);
    }
}