package com.example.demo.file_read;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.file_read
 * @ClassName: FileTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/16 12:43
 * @Version: 1.0
 */
public class FileReadTest {
    // todo 用来计算次数的
    private static int total;

    public static void main(String[] args) throws Exception {
        // todo 计算的字符
        String flag = "x";
        // todo 读取的文件
        File file = new File("d://test.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = -1;
        String str = "";
        StringBuilder sb = new StringBuilder();
        while ((len = fis.read(b,0,1024))!= -1){
            // todo 将字节数组转化为字符串并转码
            str = new String(b,0,b.length,"gbk");
            System.out.println(str);
            sb.append(str);
        }
        str = sb.toString();
        String x = getTotal(str, flag);
        System.err.println(x);
    }
    /**
     * @Method getTotal
     * @Author limingxing
     * @Version  1.0
     * @Description todo 计算出flag在str字符串中出现的次数
     * @param str
     * @param flag
     * @Return java.lang.String
     * @Exception
     * @Date 2019/8/16 18:21
     */
    private static String getTotal(String str,String flag){

        while (str.indexOf(flag) !=-1){
            int i = str.indexOf(flag);
            str = str.substring(i+1);
            total++;
        }
        return "字符串 '" + flag +"' 出现的次数为：" + total;
    }
}
