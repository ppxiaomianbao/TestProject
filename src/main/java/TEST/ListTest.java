package TEST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: demo
 * @Package: TEST
 * @ClassName: ListTest
 * @Author: limingxing
 * @Description: todo 测试集合类的迭代器，为什么集合类的删除会报错，而iterator迭代里面删除就没问题
 * @Date: 2019/8/10 12:19
 * @Version: 1.0
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(next.equals("zhangsan")){
                iterator.remove();
            }
        }
        /*for(String str : list){
            if(str.equals("zhangsan")){
                list.remove(str);
            }
        }*/
        System.err.println(list);
    }
}
