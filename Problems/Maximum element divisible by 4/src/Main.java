import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 1000; i++){
            if (!scanner.hasNext()) break;
            else {
                int x = scanner.nextInt();
                if (x == 30_000){
                    max = x;


                    break;
                } else if (x % 4 == 0 && x > max){
                    max = x;
                }
            }
        }

        System.out.println(max);
    }
}