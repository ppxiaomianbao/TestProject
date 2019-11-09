package com.example.demo.SetTest;

import java.lang.reflect.Array;
import java.util.*;

public class SetTest {
    public static void main(String[] objects) {
        Set set = new HashSet<String>();
        set.add("abc");
        set.add("cef");
        set.add("abc");
        set.add("edg");
        Iterator iterator = set.iterator();
        // todo 遍历HashSet
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.print(next.toString().toUpperCase() + " ");
        }
        System.out.println();
        System.out.println(set);

        // todo 测试HashSet去重，利用set不可添加重复元素的特性
        String[] str = {"123","456","789","123","555"};
        // todo 数组转为集合
        List<String> list = Arrays.asList(str);
        str =  noRepet(list);
        System.err.println(Arrays.toString(str));
    }

    // todo set去除重复数据,传入一个集合，返回一个数组（也可转为集合）
    private static <T> T[] noRepet(List<T> list) {
        if(list.isEmpty()){
            throw new RuntimeException("list is empty!!!");
        }
        System.out.println(list.toString());
        // todo 将list转为set
        Set set = new HashSet(list);
        // todo 创建泛型数组,因为泛型不能直接实例化对象，所以借助反射创建泛型对象
        T[] t = (T[]) Array.newInstance(list.get(0).getClass(),set.size());
        // todo 将set集合转为泛型数组,因为用了泛型，所以此方法可用于多种数据类型
        return (T[]) set.toArray(t);
    }
}
