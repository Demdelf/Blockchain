import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while(scanner.hasNext()){
            numbers.add(scanner.nextInt());
        }

        numbers.stream().map(x -> Math.abs(x)).sorted().forEach(x -> System.out.print(x + " "));

    }
}