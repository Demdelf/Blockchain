import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        boolean flag = true;
        for(int i = 1; i < s.length; i++){
            if (s[i].compareTo(s[i - 1]) < 0) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}