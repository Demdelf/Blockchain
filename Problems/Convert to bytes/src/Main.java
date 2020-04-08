import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        while (inputStream.available() > 0){
            System.out.print(inputStream.read());
        }
        inputStream.close();
    }
}