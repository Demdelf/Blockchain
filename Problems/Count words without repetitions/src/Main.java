import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            strings.addAll(Arrays.asList(scanner.nextLine().toLowerCase().split(" ")));
        }

        System.out.println(strings.stream().distinct().count() - 1);
    }
}