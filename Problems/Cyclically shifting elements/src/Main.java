import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            if(i == n - 1) a[0] = scanner.nextInt();
            else {
                a[i + 1] = scanner.nextInt();
            }
        }
        for (int e:a
             ) {
            System.out.print(e + " ");
        }
    }
}