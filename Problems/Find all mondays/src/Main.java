import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextByte();
        int lenOfMonth = LocalDate.of(year, month, 1).lengthOfMonth();
        for (int i = 1; i <= lenOfMonth; i++){
            LocalDate date = LocalDate.of(year, month, i);
            if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)){
                System.out.println(date);
            }
        }
    }
}