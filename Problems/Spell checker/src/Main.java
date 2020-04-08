import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        //System.out.println(d);
        Set<String> enterSet = new HashSet<>();
        for (int i = 0; i <= d; i++){
            String string = scanner.nextLine().toLowerCase();
            enterSet.add(string);
        }
        int l = Integer.parseInt(scanner.nextLine());
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < l; i++){
            String[] s = scanner.nextLine().split(" ");
            for (String ss: s
                 ) {
                if (!enterSet.contains(ss.toLowerCase())) resultSet.add(ss.toLowerCase());
            }
        }
        for (String ss: resultSet
             ) {
            System.out.println(ss);
        }
    }
}