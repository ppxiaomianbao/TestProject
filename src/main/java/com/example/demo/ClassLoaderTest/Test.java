package com.example.demo.ClassLoaderTest;

public class Test extends ABSclass {

    public Test(){
        System.out.println("子类构造方法");
    }
    public Test(int a){
        System.out.println("A"+a);
    }

    {
        System.out.println("子类构造块");
    }
    static{
        System.out.println("子类静态块");
    }
    @Override
    public void m(int a) {
        // TODO Auto-generated method stub
        System.out.println("继承");
    }


    public static void main(String[] objects) {
        new Test(2);
    }
}
