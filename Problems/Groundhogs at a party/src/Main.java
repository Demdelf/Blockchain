import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int n = scanner.nextInt();
        boolean flag = scanner.nextBoolean();
        if(flag) System.out.println(n >= 15 && n <= 25);
        else
            System.out.println(n >= 10 && n <= 20);
    }
}