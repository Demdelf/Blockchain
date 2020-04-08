import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        if (n == 1) System.out.println(a[0]);
        else {
            int max = 0;
            for (int i = 1; i < n; i++){
                if (a[i]*a[i-1] > max) max = a[i]*a[i-1];
            }
            System.out.println(max);
        }
    }
}