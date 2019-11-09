package sort_test;

import java.util.Arrays;

/**
 * @ProjectName: demo
 * @Package: sort_test
 * @ClassName: BubblingSort
 * @Author: limingxing
 * @Description: todo 冒泡排序
 * @Date: 2019/8/22 14:59
 * @Version: 1.0
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] sorce = new int[]{1,5,8,3,7,9,4,6,2};
        System.out.println(Arrays.toString(sorce));
        bubblingSort(sorce);
        System.out.println(Arrays.toString(sorce));
    }

    private static void bubblingSort(int[] sorce){
        for(int i=0; i<sorce.length-1; i++){
            boolean flag = false;
            for(int j =i+1; j< sorce.length;j++){
                flag = true;
                if(sorce[i]>sorce[j]){
                    int bs = sorce[i];
                    sorce[i] = sorce[j];
                    sorce[j] = bs;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
