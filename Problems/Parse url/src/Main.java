import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split("\\?");
        String[] par = s[1].split("&");
        int n = par.length;
        boolean havePass = false;
        String pass = "";
        for (int i = 0; i < n; i++){
            String[] e = par[i].split("=");
            if (e.length < 2){
                System.out.println(e[0] + " : not found");
            }else System.out.println(e[0] + " : " + e[1]);
            if (e[0].equals("pass")) {
                havePass = true;
                pass = e[1];
            }
        }
        if (havePass) System.out.println("password : " + pass);
    }
}