package com.example.demo.Comparator;

import java.util.*;

public class ComparatorTest {

    public static void main(String[] objects) {
        String[] strs = {"abc","cdf","abd","bbb","efg"};
        List<String> list = Arrays.asList(strs);
        System.err.println(list.toString());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list.toString());
    }
}
