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
        int k = 1;
        int max = 1;
        for (int i = 1; i < n; i++){
            if (a[i] > a[i-1]){
                k++;
                if (i == n - 1) max = k > max ? k : max;
            } else {
                max = k > max ? k : max;
                k = 1;
            }

        }
        System.out.println(max);


    }
}