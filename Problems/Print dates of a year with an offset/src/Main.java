import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        int offset = scanner.nextInt();
        LocalDate localDate = LocalDate.parse(date);
        int year = localDate.getYear();
        while (localDate.getYear() == year){
            System.out.println(localDate);
            localDate = localDate.plusDays(offset);
        }
    }
}