import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // start coding here
            List<Character> list = new ArrayList<>();
            list.add((char) reader.read());
            while (reader.ready()){
                list.add((char) reader.read());
            }
            int words = 0;
            boolean currentIsLetter = false;
            for (char c: list
                 ) {

                if (Character.isLetter(c)){
                    if (!currentIsLetter){
                        words++;
                    }
                    currentIsLetter = true;
                }else currentIsLetter = false;
            }
            System.out.println(words);
        }
    }

}