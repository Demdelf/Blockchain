import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int minus = scanner.nextInt();
        System.out.println(LocalDate.of(year, month + 1, 1).
                minusDays(minus));
    }
}