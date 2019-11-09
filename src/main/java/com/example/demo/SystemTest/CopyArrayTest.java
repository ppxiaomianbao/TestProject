package com.example.demo.SystemTest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyArrayTest {

    public static void main(String[] objects) {
        Integer[] str = {123,456,789,111,333,777};
        System.out.println("原数组：" + Arrays.toString(str));
        str = getNewDataBy1(str,5);
        System.err.println("新数组：" + Arrays.toString(str));
    }

    // todo 此方法是从0到数组长度减一
    public static <T> T[] getNewData(T[] str,int i){
        if(str == null || i<0 || i>str.length -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        T[] newStr = (T[]) Array.newInstance(str[0].getClass(),str.length - 1);
        //复制一个新数组，不要第三个元素
        System.arraycopy(str,0,newStr,0,i);
        System.out.println(Arrays.toString(newStr));
        System.arraycopy(str,i+1,newStr,i,str.length - i - 1);
        System.out.println(Arrays.toString(newStr));
        return newStr;
    }

     // todo 此方法是从1到数组长度
    public static <T> T[] getNewDataBy1(T[] str,int i){
        if(str == null || i<0 || i>str.length -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        T[] newStr = (T[]) Array.newInstance(str[0].getClass(),str.length - 1);
        //复制一个新数组，不要第i个元素
        System.arraycopy(str,0,newStr,0,i-1);
        System.out.println(Arrays.toString(newStr));
        System.arraycopy(str,i,newStr,i-1,str.length - i);
        System.out.println(Arrays.toString(newStr));
        return newStr;
    }
}
