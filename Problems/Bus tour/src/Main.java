import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int busH = scanner.nextInt();
        int n = scanner.nextInt();
        boolean crash = false;
        for (int i = 0; i < n; i++){
            if (scanner.nextInt() <= busH){
                System.out.println("Will crash on bridge " + (i + 1));
                crash = true;
                break;
            }
        }
        if (!crash) System.out.println("Will not crash");
    }
}