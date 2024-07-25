package practice;

public class BiggestString {
    public static void main(String[] args) {
        String str = "we are learning Fundamental java  with mathias and farhad ";
        String bigWord = "";
        String[] str2 = str.split(" ");

        for (int i = 0; i < str2.length; i++) {
            if (str2[i].length() > bigWord.length()) {
                bigWord = str2[i];
            }
        }
        System.out.println(bigWord);

    }
}
