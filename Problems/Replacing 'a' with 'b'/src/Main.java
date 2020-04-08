import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == 'a') chars[i] = 'b';
            System.out.print(chars[i]);
        }


    }
}