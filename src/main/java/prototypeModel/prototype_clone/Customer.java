package prototypeModel.prototype_clone;

import java.io.*;

/**
 * @ProjectName: demo
 * @Package: prototypeModel.prototype_clone
 * @ClassName: Customer
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/13 9:53
 * @Version: 1.0
 */
public class Customer {
    public static void main(String[] objects) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        CatBean catBean = new CatBean();
        CatBean clone = catBean.deepClone();

        System.out.println(catBean);
        System.out.println(clone);


        System.out.println("catBean  == clone " + (catBean  == clone));
        System.out.println("catBean.getHolder() == clone.getHolder() " + (catBean.getHolder() == clone.getHolder()));


        /*String str = "guowuxin";
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        transform(in, out);

        byte[] result = out.toByteArray();

        System.out.println(out);*/



    }

    public static void transform(InputStream in, OutputStream out)
    {
        int ch = 0;

        try
        {
            while ((ch = in.read()) != -1)
            {
                int upperChar = Character.toUpperCase((char) ch);
                out.write(upperChar);
            }
            return;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
