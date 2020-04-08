import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        LocalTime time1 = LocalTime.of(scanner.nextByte(), scanner.nextByte(), scanner.nextByte());
        LocalTime time2 = LocalTime.of(scanner.nextByte(), scanner.nextByte(), scanner.nextByte());
        System.out.println(time2.toSecondOfDay() - time1.toSecondOfDay());
    }
}