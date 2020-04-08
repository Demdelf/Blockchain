class ConstantsAndUtilities {

    public static final String A_CONSTANT_TTT = "ttt";// here is a value

    public static final String B_CONSTANT_QQQ = "qqq";// here is another value

    public static String getMagicString() {
        return "www";// a string
    }

    public static String convertStringToAnotherString(String s) {
        return "eee";// a string
    }

    public static void main(String args[]) {
        // write your code using the existing class ConstantsAndUtilities
        System.out.println(ConstantsAndUtilities.A_CONSTANT_TTT);
        System.out.println(ConstantsAndUtilities.B_CONSTANT_QQQ);
        System.out.println(ConstantsAndUtilities.getMagicString());
        System.out.println(ConstantsAndUtilities.convertStringToAnotherString("aa"));
    }
}