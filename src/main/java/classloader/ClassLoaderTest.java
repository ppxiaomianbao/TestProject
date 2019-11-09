package classloader;

import java.io.*;

/**
 * @ProjectName: demo
 * @Package: classloader
 * @ClassName: ClassLoaderTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/6 19:35
 * @Version: 1.0
 */
public class ClassLoaderTest {

    /** todo 查看类加载器*/
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
            while (classLoader != null) {
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);
    }
    /*public static void main(String[] args) throws Exception {
        String srcPath = args[0];
        String destDir = args[1];
        FileInputStream fis = new FileInputStream(srcPath);
        String destFileName = srcPath.substring(srcPath.lastIndexOf("\\") + 1);
        String destPath = destDir + "\\" + destFileName;
        FileOutputStream fos = new FileOutputStream(destPath);
        cypher(fis,fos);
        fis.close();
        fos.close();
    }*/

    private static void cypher(InputStream fis, OutputStream fos) throws Exception {
        int b = -1;
        while ((b = fis.read())!=-1){
            fos.write(b ^ 0);
        }
    }
}
