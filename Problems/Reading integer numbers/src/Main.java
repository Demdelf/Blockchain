import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(scanner.nextInt());
        }

            List<String> x = new ArrayList<>();
            Set<String> set = new HashSet<>(x);
            for(String s: x){
                set.add(s);
            }
            x = set.


    }
}