import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String [] s = scanner.nextLine().split(" ");
        String r = "";
        int max = 0;
        for (String string: s
             ) {
            if (string.length() > max){
                max = string.length();
                r = string;
            }
        }
        System.out.println(r);
    }
}