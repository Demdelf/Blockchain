import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (char c: s.toCharArray()
             ) {
            System.out.print(c);
            System.out.print(c);
        }
    }
}