package practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class ComibiningTwoSet {
    public static void main(String[] args) {
        Random random = new Random();

        HashSet<Integer> list1 = new HashSet<>();
        HashSet<Integer> list2 = new HashSet<>();
        HashSet<Integer> list3 = new HashSet<>();

        for (int i = 1 ; i < 100 ; i++){
            list1.add(random.nextInt(100));
            list2.add(random.nextInt(100));
        }
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list2);
        System.out.println(list2.size());
        list1.addAll(list2);
        System.out.println(list1);
        System.out.println(list1.size());

        for (int even : list1){
            if (even % 2 == 0){
                list3.add(even);
            }
        }
        System.out.println(list3);
        System.out.println("there is "+ list3.size()+ " even Number in the list");
    }
}
