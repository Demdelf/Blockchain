import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = n; i <= m; i++){
            if(i % 3 == 0){
                if (i % 5 == 0) System.out.println("FizzBuzz");
                else System.out.println("Fizz");
            } else if(i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }
}