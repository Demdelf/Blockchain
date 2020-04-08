import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        n = (int) Math.sqrt(n);
        for (int i = 1; i <=n; i++){
            System.out.println(i*i);
        }
    }
}