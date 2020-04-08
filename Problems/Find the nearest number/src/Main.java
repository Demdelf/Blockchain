import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = readArrayList(scanner);
        int n = scanner.nextInt();
        ArrayList<Integer> listOfDif = new ArrayList<>();
        for (int x: list
             ) {
            listOfDif.add(Math.abs(x - n));
        }
        int min = Integer.MAX_VALUE;
        for (int x: listOfDif
        ) {
            if (x < min) min =x;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if(listOfDif.get(i) == min){
                result.add(list.get(i));
            }
        }
        Collections.sort(result);
        for (int x: result
             ) {
            System.out.print(x + " ");
        }

    }
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}