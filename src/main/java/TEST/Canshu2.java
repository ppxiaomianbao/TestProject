package TEST;

import org.apache.poi.hwpf.sprm.SprmUtils;

import java.util.Scanner;

/**
 * @ProjectName: demo
 * @Package: TEST
 * @ClassName: Canshu2
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/23 20:56
 * @Version: 1.0
 */
public class Canshu2 {

    public String name;
    public int score;

    public Canshu2(String name,int score) {
        this.name = name;
        this.score = score;
    }

    public void showinfo() {
        System.out.println(this.name + " 的成绩是 " + this.score);
    }

    public static void t2(Canshu2[] stu) {
        for (Canshu2 student : stu) {
            if (student.score < 60) {
                student.score += 2;
            }
        }

    }

    public static void showInfo(Canshu2[] stu) {
        for (Canshu2 student : stu) {
            student.showinfo();
        }
    }

    public static void main(String[] objects) {
        Scanner input = new Scanner(System.in);

        Canshu2[] stu = new Canshu2[2];


        Canshu2 student = null;
        for(int i=0;i<stu.length;i++){
            System.out.println("请输入你的姓名：");
            String name= input.next();
            System.out.println("请输入你的分数：");
            int score = input.nextInt();
            student = new Canshu2(name,score);
            stu[i] = student;
        }

        t2(stu);
        showInfo(stu);
    }

}
