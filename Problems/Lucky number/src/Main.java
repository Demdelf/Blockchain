import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split("");
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length/2; i++){
            left += Integer.parseInt(s[i]);
        }
        for (int i = s.length/2; i < s.length; i++){
            right += Integer.parseInt(s[i]);
        }
        if (left == right) System.out.println("YES");
        else System.out.println("NO");
    }
}