import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < n; i++){
            switch (scanner.nextInt()){
                case 0: a++;
                break;
                case 1: b++;
                break;
                case -1: c++;
                break;
            }
        }
        System.out.println(a + " " + b + " " + c);

    }
}