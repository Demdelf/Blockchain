import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x == 1) System.out.println(1);
        else {
            do {

                System.out.print(x + " ");
                if (x % 2 == 0) x = x/2;
                else x = x*3 +1;
            }
            while (x != 1);
            System.out.print(x);
        }

    }
}