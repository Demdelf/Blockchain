import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split("-");
        String year = s[0];
        String month = s[1];
        String day = s[2];
        if (Integer.parseInt(day) > 31 || Integer.parseInt(day) == 0 ||  Integer.parseInt(year)== 0||
                Integer.parseInt(month) == 0 || Integer.parseInt(month) > 12)
            System.out.println("Incorrect input");
        else System.out.println(month + "/" + day + "/" + year);
    }
}