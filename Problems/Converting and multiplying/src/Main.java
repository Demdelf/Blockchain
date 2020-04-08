import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String s = scanner.nextLine();
            try{
                int n = Integer.parseInt(s);
                if (n == 0) break;
                System.out.println(n*10);
            } catch (Exception e){
                System.out.println("Invalid user input: " + s);
            }
        }


    }
}