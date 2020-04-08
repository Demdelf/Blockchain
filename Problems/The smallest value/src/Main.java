import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = 1;
        int k = 0;
        while (n <= m){
            k++;
            n = n*k;

        }
        System.out.println(k);
    }
}