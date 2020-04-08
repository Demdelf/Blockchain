import java.util.*;

public class Main {

    public static int convert(Double val) {
        // write your code here
        if (val.isInfinite()) {
            if (val > 0)
            return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        } else if (val.isNaN()) return 0;
        else return Integer.parseInt(String.valueOf(val));
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double doubleVal = new Double(scanner.nextDouble() / scanner.nextDouble());
        System.out.println(convert(doubleVal));
    }
}