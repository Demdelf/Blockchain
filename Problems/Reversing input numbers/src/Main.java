import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int a = scanner.nextInt();
        sum += a%2 == 0 ? a/2 : a/2 + 1;
        int b = scanner.nextInt();
        sum += b%2 == 0 ? b/2 : b/2 + 1;
        int c = scanner.nextInt();
        sum += c%2 == 0 ? c/2 : c/2 + 1;

        System.out.println(sum);
    }
}