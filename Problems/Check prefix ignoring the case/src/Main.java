import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s.startsWith("j") || s.startsWith("J"));
    }
}