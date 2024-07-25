package practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CombiningTwoArray {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
       for( int i = 1 ; i <=10 ; i++){
          list1.add(random.nextInt(100));
          list2.add(random.nextInt(100));
       }

        //Adding all element in list 2 into the list 1
        list1.addAll(list2);
        System.out.println(list1);
        Collections.reverse(list1);
        System.out.println(list1.size());
        for (int even : list1) {
            if (even % 2 == 0) {
                list3.add(even);
            }
        }
        Collections.reverse(list3);

        System.out.println("All the even number in this array are: " + list3);
        System.out.println(list3.size());
    }
}