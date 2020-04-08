import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        boolean flag = true;

            for (int i = 0; i < n/2; i++){
                if (s.charAt(i) != s.charAt(n - 1 - i)){
                    flag = false;
                    break;
                }
            }
        if (flag) System.out.println("yes");
            else System.out.println("no");
    }
}