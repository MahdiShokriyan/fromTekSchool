package practice;

public class AddTwoNum {

    public static void main(String[] args) {

        int[] nums = {2 , 5 , 8 , 9};
        var num = new AddTwoNum();

        for (int number: num.twoSum(nums , 17)) {
            System.out.println(number);
        }



    }
    public int[] twoSum(int[] nums, int target){
        for (int i=0 ; i < nums.length; i++){
            for (int j= i+1; j< nums.length; j++){
                if(nums [i] + nums[j] == target ){
                    return new int[] {i,j};
                }
            }
        }
return new int[0];
    }
}
