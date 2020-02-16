package cn.wendaocp.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lq
 * create 2020-02-13 21:00
 */
public class findRepeatNumber {

    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//
//        set.add(1);
//        set.add(1);
//        set.add(1);
//        set.add(11);
//
////        System.out.println(set);
//
//        for (Integer i : set) {
//
//            System.out.println(i);
//        }
//
//        System.out.println(set.contains(1));
//        System.out.println(set.contains(2));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 1);
        map.put(2, 2);
        map.put(3, 1);

        System.out.println(map);
        System.out.println(map.get(22));

        for(Integer k: map.keySet()) {
            System.out.println(k);
        }


    }

}
