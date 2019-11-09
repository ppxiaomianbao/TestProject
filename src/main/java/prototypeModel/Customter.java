package prototypeModel;

/**
 * @ProjectName: demo
 * @Package: prototypeModel
 * @ClassName: Custom
 * @Author: limingxing
 * @Description: TODO 这里是深克隆，对象的引用属性也会重新克隆一份
 *            TODO  这种设计模式适用于构造函数里需要进行大量引用的情况
 * @Date: 2019/7/12 18:17
 * @Version: 1.0
 */
public class Customter {
    public static void main(String[] objects) throws CloneNotSupportedException {
        //创建的简历对象
        Resume resume = new Resume();
        //给创建的对象设置属性值
        resume.setAge(20);
        resume.setName("李明星");
        resume.setHobby(new String[]{"吃饭","睡觉","打豆豆"});
        //克隆一份新的简历对象
        Resume resume1 = resume.clone();
        resume1.getHobby()[0] = "玩游戏";
        System.out.println(resume);
        System.out.println(resume1);
    }
}
