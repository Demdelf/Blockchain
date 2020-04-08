import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] a = new int[s.length];
        for(int i = 0; i < s.length; i++){
            a[i] = Integer.parseInt(s[i]);
        }
        int n = scanner.nextInt();
        n = n % a.length;
        for (int i = 0; i < n; i++){
            int end = a[a.length - 1];
            for (int j = a.length - 1; j >= 0 ; j--){
                if (j == 0) a[j] = end;
                else {
                    a[j] = a[j - 1];
                }
            }
        }
        for (int q: a
             ) {
            System.out.print(q + " ");
        }

    }
}