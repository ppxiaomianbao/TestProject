package FileTest;

import java.io.File;

public class FileForTest {

    public static void main(String[] objects) {
        find(new File("E:\\视频\\Java并发编程与高并发解决方案(完整)"));
    }

    private static void find(File filePath) {
        // todo 获取路径下所有文件及目录
        File[] files = filePath.listFiles();
        if(files !=null && files.length>0){
            // todo 遍历获取的所有目录及文件
            for(File file : files){
                // todo 判断是否是一个文件
                if(file.isFile()){
                    if(file.getName().endsWith(".mp4")){
                        System.out.println("mp4:" + file.getName());
                    }else{
                        System.out.println("others:" + file.getName());
                    }
                }else {
                    System.err.println("dir:" + file.getName());
                    // todo 如果是目录则继续查询改目录下的文件
                    find(file);
                }
            }
        }
    }
}
