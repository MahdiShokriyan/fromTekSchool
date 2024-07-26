package practice;

public class MaxNumber2 {
    public static void main(String[] args) {

        try {
            int[] arr = {-11,-10,10};
            int max = arr[0];

            for (int num : arr) if (num > max) max = num;

            System.out.println(max);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("array is empty");
        }
    }
}
