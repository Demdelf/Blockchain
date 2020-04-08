import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());

        System.out.println(
                localDateTime.toLocalDate().getDayOfYear()*24 - 24 + localDateTime.getHour());
    }
}