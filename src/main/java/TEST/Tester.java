package TEST;

import com.example.demo.ClassLoaderTest.Test;

import java.io.ObjectInputStream;
import java.net.SocketTimeoutException;
import java.security.KeyStore;
import java.util.*;

/**
 * @ProjectName: demo
 * @Package: TEST
 * @ClassName: Tester
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/6 17:00
 * @Version: 1.0
 */
public class Tester {
    private String name;
    public void test(){}

    @Override
    protected void finalize() throws Throwable {
        // todo 一般用来关闭外部资源
        super.finalize();
    }

    public static void getTest(){
        //非静态变量在静态方法中不可用
        //name = "";
        System.gc();
    }

    public static void main(String[] args) {
        boolean is64bit = false;
        if(System.getProperty("os.name").contains("Windows")){
            is64bit = (System.getenv("ProgramFiles(x86)")!=null);
        }else{
            is64bit = (System.getProperty("os.arch").indexOf("64")!=-1);
        }
        System.out.println(is64bit);
        System.out.println(System.getProperty("sun.arch.data.model"));

        byte b = 1;
        int ints = 127;
        double dou = b;
        Byte.toString(b);
        String str = String.valueOf(b);
        b = (byte) ints;
        System.out.println(b);
        System.err.println(Byte.MIN_VALUE + "    " + Byte.MAX_VALUE);

        char c1 = 5;
        c1 += 4;

        double d = 3434D;
        long l = (long) d;

        double dd = l;

        System.out.println(3*0.1 == 0.3);

        A aa = new A();
        B bb = new B();
        //B bbb = (B) aa;

        List<Integer> list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(5);
        System.out.println("list遍历：" + list);
        ListIterator<Integer> integerListIterator = list.listIterator();
        while (integerListIterator.hasNext()){
            Integer next = integerListIterator.next();
            if(next==3){
                integerListIterator.remove();
            }
        }
        /*for (Integer i : list) {
            if(i==3){
                list.remove(i);
            }
        }*/
        System.out.println("list遍历：" + list);
    }

}

final class TestOverride extends Tester {
    private Girl girl;
    @Override
    public void test(){}
}
/** todo 抽象类可以有构造方法*/
abstract class Girl{
    public Girl(){};
}

/** todo 接口不能定义构造方法*/
interface Boy{
    //public Boy(){};
}

/**
* 面向对象 就是一切都可以看做对象，把对任何事物的操作转换为操作对象，todo 是一种对现实世界的理解和抽象
 * ；extension classloader bootstrap classloader applicationclassloader  customclassloader
 * 类加载过程，一加载，把类的字节码对象加载至内存，二链接（1，验证,看编写的类是够符合java代码规范
 *  2，准备，为类的静态变量分配内存空间，并设置 todo 默认值，如果静态变量被final修饰，则直接复值
 *  3，解析，把类的符号引用转换为直接引用）
 *  ；
 *  类加载器大致有四种，bootstrap classloader 系统类加载器，加载java核心api
 *   2，扩展类加载器 extclassloaders
 *   3.程序类加载器appclassloader todo 最常用
 *
 *  ；
 *  双亲委派模式
 *   双亲委派机制原理，双亲委派模式除了启动类加载器外，其他加载器都需要有自己的父亲类加载器、也就是当一个类
 *   加载器收到一个类加载请求时，不会先去自己加载，而是把这个请求委托给自己的父类加载器去加载，请求会最终将
 *   达到顶层的启动类加载器。当父类加载器无法加载时，子类加载器会去执行加载
 *
 *   ；
 *   编写自己的列加载器
 *
 *   ;
 *   对象创建，先在堆里创建一块内存区域用来存放改对象，然后创建对象，在吧此对象的堆内存地址赋值给变量
 *   ；
 *   jvm优化，不知道不知道不知道
 *   ；
 *   java虚拟机用来执行编译过后的class文件，因为只要编译过后的class文件满足java虚拟机的语法就可以被执行，
 *   ；
 *   jdk是java开发工具包，jre是java运行时环境，理论上说只需要安装jre就可以运行编写好的java文件
 *   ；
 *   static 用在变量上是静态变量，在内存中只有一份，用在方法上表示此方法不可被重写（OverRide）不可以
 *
 *   ；
 *   不能再static关键字申明的方法中调用非static申明的变量，因为有可能在加载方法的时候变量还没有创建
 *   ；
 *   八种基本数据类型和引用类型
 *   八种基本数据类型：byte，short，char，int，long，float，double，boolean
 *   自动拆箱，就是基本数据类型的引用类型自动转为基本数据类型，
 *   自动装箱，就是把基本数据类型转为引用类型
 *   ；
 *   方法覆盖（override）方法重载（overload）
 *   方法重写是子类与父类之间，方法重载一般是在一个类中方法名相同，当参数不同的情况
 *   ；
 *   构造函数就是创建类的时候调用的方法
 *   ；
 *   java不支持多继承，但是支持同事实现多个接口
 *   ；
 *   1，接口里面只有常量和抽象方法，
 *   2，抽象类里可以有普通方法和普通变量
 *   3，抽象类只能单继承
 *   4，可以同时实现多个接口
 *   5，抽象类里可以定义构造方法，接口不能定义构造方法
 *
 *   ；
 *   java中只存在值传递，没有引用传递，值传递就是传给一个方法参数，就算在接受参数的方法里修改了传递的值
 *   但是原始的值不会改变，引用传递传的值是引用类型在内存中的地址，如果在接受参数的方法中修改了参数，原始
 *   参数也会改变
 *   ；
 *   在switch中可以用String类型（1.7版本之后才支持String类型的）
 *   ；
 *   如果一个类有父类，那创建这个对象的时候回先调用父类的构造方法，然后在调用自身的构造方法
 *   ；
 *   64位的jvm中，int的长度是32位（4字节）不管在32位还是64位的操作系统中，int类型的字节数都是4
 *   ；
 *   a==b比较的是两个对象的内存地址，a.equals（b）比较的是两个对象的具体值，而不是内存地址
 *   ；
 *   a.hashcode（）方法得到的是a对象的哈希值（一般来说就是对象内存地址的16进制表示）
 *   一般来说如果要重写hashcode方法就要重写equals方法，因为将对象存放在hashMap里的时候
 *   第一步先计算hashcode看是否相等，如果相等就在比较两个对象的equals方法看两个对象是否相等
 *   所以如果重写了只重写了hashcode方法缺灭有重写equals方法会导致对象在hashmap中太分散或太集中
 *
 *   ；
 *   1、final是java中的关键字，表示不可变，用在变量上表示变量是常量（不可变），用在方法上表示此方法
 *   不能被重写，用在类上表示类不能被继承
 *   2、finalize方法是java中垃圾回收器在回收对象的时候调用回收对象的方法的，一般用来关闭一些外部资源
 *   3、finally是异常处理中的关键字，表示不管被处理的代码是否报异常都会执行，一般用来关闭资源
 *
 *   ；
 *   java中编译期的常量会被替换掉，如果使用了一个外部或者第三方jar包中的常量，但是后来有人更改看jar包
 *   中变量的值，可能导致虽然更新了jar包，但是启动项目缺发现常量的值还是没有改变，所以我们在项目中
 *   如果更新了jar包就一定要编译过后再打包部署
 *
 *   ；
 *   最有效计算2*8的方法是2<<3左移多少位就是乘以2的几次方，右移就是除以2的几次方
 *
 *   ；
 *   堆区，栈区，方法区，程序计数器，本地方法区（用来储存用c语言写的方法）
 *   Gc算法，分为新生代和老生代，新生代里包含两个区域，一直循环迭代，直到一个区满了之后，就会
 *   转移至老生代，老生代满了就会调用Gc回收无用对象
 *
 *   ；
 *   垃圾回收可以有效的帮助程序员清理项目中的无效对象（没有被任何对象引用），一般在程序内存快满的时候进行
 *   垃圾回收，回收的时间不确定
 *
 *   ；
 *   调用System.gc()的底层就是调用的Tuntime.gc()；
 *
 *   ；
 *   finalize()方法是在垃圾回收器回收这个对象之前被调用，一般用来关闭资源
 *
 *   ；
 *    如果对象引用被之置null，垃圾回收器不会立即回收被置null的对象
 *
 *   ；
 *   堆结构，新生代和老生代，新生代分为两个区，老生代一个区，永久代在方法区中，具体是什么不清楚
 *
 *   ；
 *   吞吐量收集器使用并行版本的新生代垃圾收集器，它用于中等规模和大规模数据的应用程序。
 *   而串行收集器对大多数的小应用就足够了
 *
 *   ；
 *   对象没有被任何对象引用的时候会被垃圾回收器回收
 *
 *   ；
 *   垃圾回收不会发生在永久代，如果永久代内存满了就会触发垃圾回收，所以要正确的管理永久代的内存空间
 *
 *   ；
 *   通过java程序判断jvm是多少位System.out.println(System.getProperty("sun.arch.data.model"));
 *
 *   ；
 *   jre（java运行时环境），jdk（java开发工具包），jvm（java虚拟机），jit（）
 *
 *   ；
 *   堆空间，新生代和老生代
 *   gc，程序不定时调用
 *
 *   ；
 *   不能保证gc执行
 *
 *   ；
 *   可以用可视化工具，没用过
 *
 *   ；
 *   java中堆是共享区域，是用来存放引用数据类型的位置，栈是java中的私有区域，没个线程都会有一个栈
 *
 *   ；
 *   动态代理，一种是jdk中自带的api实现的，这种动态代理要求目标对象必须实现接口，
 *   还有一种动态代理是cjlib，这种动态代理也称之为子类代理，不需要目标实现接口，
 *
 *   ；
 *   异常：：：：：：：：：：：：：：：：：：：：：
 *
 *   一种是运行时异常，编译期间不会报出，在项目运行期间可能会出现问题，还有一种是错误，
 *   是一种在编译期间就会报出的异常（两种异常，一种是受检查的异常，一种是不受检查的异常）
 *
 *   ；
 *   throw是在方法体内部使用的，throws是在方法上跑出的异常
 *
 *   ；
 *   finally表示不管是否出现异常都会执行finally快里面的语句
 *
 *   ；
 *
 *   不可变对象：：：：：：：：：：：：：：：：：
 *
 *   被final关键字修饰的类被称为不可变对象
 *   ；
 *
 *   数据类型：：：：：：：：：：：：：：：：：：
 *
 *   &是非短路与，表示不管怎样表达式都会执行，……&&是短路与，表示只要前一个表达式已经可以得出计算结果就
 *   不再往下执行
 *
 *   ；
 *   java中应该使用双精度浮点型数据类型（double）表示价格
 *
 *   ；
 *   可以用string.valueof（），也可以用Byte.toString方法
 *
 *   ；
 *   可以强制吧int类型转换为byte类型，如果大于就会在byte类型的范围内（-128 ~~~ 127）轮转一遍
 *
 *   ；
 *   java中向上转型是自动的，但是向下转型确实不安全的，向下转型虽然在编译期间不会包错，但是在运行期间可能会包
 *   出classCastException类转换异常
 *
 *   ；
 *   object方法包含clone方法，只有继承了Cloneable接口的才能调用clone方法，不然会报异常
 *
 *   ；
 *   a = a+ b 不会自动进行类型装换，所以如果a是char类型b是int类型的话，编译期间会包错，二用a +=b则不会包错
 *   因为这种写法在a和b的数据类型不一致的时候会自动转换为低精度的数据类型
 *
 *   ；
 *   不行
 *
 *   ;
 *   integet会占用更多的内存
 *
 *   ；
 *   因为String类型被final关键字修饰了
 *
 *   ；
 *   String不可变
 *   StringBuilder可变，不是线程安全的，因此他的拼接速度比另外两个都快
 *   StringBuffer可变，并且是线程安全的
 *
 *   ；
 *   集合类
 *
 *   ；
 *   java集合类型有List Map Set 其中List和Set继承自collection,而Map是一个单独的接口
 *
 *   ;
 *   因为克隆或者序列化的语义是跟具体类相关的，应该由具体的类去决定是否需要Cloneable和序列化接口
 *
 *   ；
 *   Iterator迭代器接口提供了很多对集合元素进行迭代的方法，每一个集合类都包括了可以返回迭代器实例的迭代方法、
 *   迭代器可以在迭代过程中删除底层集合的元素，但是不可以直接调用即可的remobe方法删除
 *   ;
 *   iterator可用来遍历set和list集合，但是listiterator只能用来遍历list
 *   iterator对集合只能是向前遍历，listiterator既可以向前遍历也可以向后遍历，
 *   listiterator实现了iterator接口，并包含其他的功能
 *
 *   ；
 *   hashcode相同equals不一定相同，单equals相同，hashcode一定相同，所以重写了equals相同，则一定
 *   要重写hashcode相同
 *
 *   ；
 *   体现在向Map里添加元素的时候，如果equals比较相同就要保证hahcode一定相同，否则会导致
 *   分布在hashmap里的元素太紧密或者太分散，会消耗大量的内存空间
 *
 *   ；
 *   因为hashmap要保证扩容的时候转移元素的方式不会太过于复杂
 *
 *   ；
 *   hashmap不是线程安全的，所以最好不要用在多线程环境下，hashtable是线程安全的，但是数据越多，效率就会越低
 *   currenthashmap是在1.7新加入进来的，优点就是在处理多数据的时候效率会更快
 *
 *   ；
 *   concurrenthashmap在理论上来说是可以同时处理16个读写操作的，所以说concurrenthahmap性能更好
 *
 *   ；
 *   在明确知道有多少个元素的情况下应该用数组
 *
 *   ；
 *   arraylist是列表，查询速度快，linkedlist是链表，添加删除速度快，
 *
 *   ；
 *   arraylist和vector基本一样，知识vector是线程安全的，而arraylist不是线程安全的，因此，在单线程环境下建议用arraylist
 *
 *   ；
 *   comparable和comparator两个接口都是用来排序的，知识用法不一样，
 *   comparable接口的使用需要待排序的类继承此接口并重写排序方法，
 *   comparator接口是独立的，不需要待排序的接口继承，更加灵活
 *
 *   ；
 *   java中打印数组可以用Arrays.toString方法
 *
 *   ；
 *   linkedList是双向列表结构
 *
 *   ；
 *   hashtable是线程安全的，
 *   hashMap不是线程安全的
 *
 *   ；
 *   arrayLisr默认容量为10，hashMap默认容量为16，并且hashMap每次增长数为原始容量乘以2
 *   arrayList每次增长原始容量的一半
 *
 *   ；
 *   提高代码的复用性，不用针对不同的数据类型分别写方法
 *
 *   ；
 *   因为conleable和序列化接口都是需要具体的类来决定是否需要继承这两个接口
 *
 *   ；
 *   接口分离原则，list，set存储的是元素，而map存储的是键值对，两种存储的形式不一样，继承collection接口
 *   必然会多出很多list和set无法使用的方法
 *
 *   ；
 *   流====================================================================================
 *
 *
 *
 *
 *
 *
 *
 *   ；
 *
 *
 *
 *   ;
 *
 *
 *
 *
 *
* */

class A implements Cloneable{

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(100);
        list.add(3);
        list.add(2);
        list.add(5);
        for (Integer i : list) {
            if(i==2){
                list.remove(i);
            }
        }
        /*Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.remove();
        }*/
    }
    List list = new LinkedList();
    Map map = new HashMap(16,1);
    String sre;
 Object p;
}

class B extends A{

}

class C extends B{

}