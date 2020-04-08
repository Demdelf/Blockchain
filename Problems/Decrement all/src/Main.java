import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int q1, q2, q3, q4;
        q1 = scanner.nextInt();
        q2 = scanner.nextInt();
        q3 = scanner.nextInt();
        q4 = scanner.nextInt();
        System.out.println(--q1 + " " + --q2 + " " + --q3 + " " + --q4);
    }
}