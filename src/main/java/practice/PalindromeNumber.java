package practice;

public class PalindromeNumber {
    public static void main(String[] args) {


        int x = 123;
        int original = x;
        int r = 0;
        while (x > 0) {
            r = r * 10 + x % 10;
            x = x / 10;
        }

        System.out.println((original == r ) ? true : false);

    }
}
