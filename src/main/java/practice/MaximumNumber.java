package practice;

public class MaximumNumber {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        int maxNumber = maxNumber(array);

        System.out.println(maxNumber);


    }

    public static int maxNumber (int[] arr){
        if (arr ==null || arr.length == 0){
            throw new IllegalArgumentException("Array is empty ");
        }
        int max= arr[0];
        for(int num : arr){
            if (num>max){
                max=num;
            }
        }
        return max;
    }
}
