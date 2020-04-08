import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int vowels = 0;
        int consonats = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if (isVowel(s.charAt(i))) {
                vowels++;
                consonats = 0;
            } else {
                vowels = 0;
                consonats++;
            }
            if (vowels == 3){
                result++;
                vowels = 1;
            }
            if (consonats == 3){
                result++;
                consonats = 1;
            }
        }
        System.out.println(result);
    }
    public static boolean isVowel(char c){
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') return true;
        else return false;
    }
}