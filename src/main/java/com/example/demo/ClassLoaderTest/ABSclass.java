package com.example.demo.ClassLoaderTest;

public abstract class ABSclass {

    private static int b=3,a;
    static{
        int s=8;
        System.out.println("父类静态块");
    }

    public ABSclass() {
        b=b+3;
        System.out.println("父类构造方法");
    }
    public ABSclass(int a) {
        b=b+3;
        System.out.println("带参数的父类构造方法");
    }
    {System.out.println("父类构造块");}

    //i=i+3;  错   逻辑操作，要放在方法中执行
    public abstract void m(int a);
    private int me(){
        return a;

    };
    private void me(int a){};
}
