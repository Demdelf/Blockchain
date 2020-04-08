import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        if (x > max) max = x;
        while (x != 0){
            x = scanner.nextInt();
            if (x > max) max = x;
        }
        System.out.println(max);
    }
}