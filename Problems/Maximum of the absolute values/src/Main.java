import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while(scanner.hasNext()){
            numbers.add(scanner.nextInt());
        }

        int max = numbers.stream().map(x -> Math.abs(x)).max((x1, x2) -> x1.compareTo(x2)).get();
        System.out.println(max);
    }
}