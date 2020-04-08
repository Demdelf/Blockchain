

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        // implement this method
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            if (hasLowerCase(s)){
                System.out.println(s.toUpperCase());
            }else {
                System.out.println("FINISHED");
                break;
            }
        }
    }
    public boolean hasLowerCase(String s){
        char[] chars = s.toCharArray();
        boolean flag = false;
        for (char c: chars
             ) {
            if (Character.isLowerCase(c)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}