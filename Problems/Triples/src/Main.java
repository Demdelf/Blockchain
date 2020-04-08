import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int counter = 0;
        for (int i = 0; i < n - 2; i++){
            if (a[i + 1] == a[i] + 1 && a[i + 2] == a[i + 1] + 1) counter++;
        }
        System.out.println(counter);
    }
}