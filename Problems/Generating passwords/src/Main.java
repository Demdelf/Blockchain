import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();

        List<Character> chars = new ArrayList<>();

        while (a > 0){
            chars.add(UpGenerate());
            a--;
        }
        while (b > 0){
            chars.add(LowGenerate());
            b--;
        }
        while (c > 0){
            chars.add(DigGenerate());
            c--;
        }

        while (!notsame(chars)){
            Collections.shuffle(chars);
        }
        while (chars.size() < n){
            char add = RandomChar((int) (Math.random()*3));
            if (chars.size() == 0) chars.add(add);
            else if(!chars.get(chars.size() - 1).equals(add)) chars.add(add);
        }

        for (char q: chars
             ) {
            System.out.print(q);
        }

    }

    private static boolean notsame(List<Character> chars) {

        for (int i = 1; i < chars.size(); i++){
            if (chars.get(i).equals(chars.get(i - 1))) return false;
        }
        return true;
    }

    public static char UpGenerate(){
        return (char) (Math.random()*25 + 65);
    }
    public static char LowGenerate(){
        return (char) (Math.random()*25 + 97);
    }
    public static char DigGenerate(){
        return (char) (Math.random()*10 + 48);
    }
    public static char RandomChar(int z){
        switch (z){
            case 0: return UpGenerate();
            case 1: return LowGenerate();
            case 2: return DigGenerate();
        }
        return 'q';
    }

}