import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = Stream.iterate(a, x -> x + 1).limit(b - a + 1).filter(x -> x%n == 0 || x%m == 0).
                reduce(0, (acc, elem) -> acc + elem);
        System.out.println(sum);

    }
}