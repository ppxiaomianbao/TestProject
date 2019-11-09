package TEST;

import java.util.Scanner;

/**
 * @ProjectName: demo
 * @Package: TEST
 * @ClassName: LineTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/13 19:11
 * @Version: 1.0
 */
public class LineTest {

    public static void main(String[] objects) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入行数：");
        int line = scanner.nextInt();

        for(int i=0; i<line; i++){
            int s = line - i - 1;
            for(int j=0;j<s;j++){
                System.out.print(" ");
            }
            for(int k=0;k<(i*2)+1;k++){
                System.out.print(i+1);
            }
            System.out.println();
        }
    }


}
