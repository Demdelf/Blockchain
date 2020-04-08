//put imports you need here

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
54755356
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            list.add(scanner.nextLine());
        }
        System.out.println("The form for " + list.get(0) +
                " is completed. We will contact you if we need a chef that cooks " + list.get(4) + " dishes.");

    }
}