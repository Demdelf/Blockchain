import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                if (k > n) break;
                System.out.print(i + " ");
                k++;
            }
        }
        Arrays.binarySearch(nums, key);
    }
}