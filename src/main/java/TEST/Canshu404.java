package TEST;

import java.util.Scanner;

/**
 * @ProjectName: demo
 * @Package: TEST
 * @ClassName: Canshu404
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/24 9:12
 * @Version: 1.0
 */
public class Canshu404 {
    public static void main(String[] objects) {
        Canshu4 bc = new Canshu4();

        Scanner input = new Scanner(System.in);
        /*System.out.println("请输入两个整数：");

        System.out.println(bc.zheng(input.nextInt(),input.nextInt()));*/
        System.out.println("请输入三个浮点数：");
        System.out.println(bc.fu(input.nextDouble(),input.nextDouble(),input.nextDouble()));

    }

}
