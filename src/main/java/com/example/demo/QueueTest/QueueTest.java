package com.example.demo.QueueTest;

public class QueueTest {
    // todo 保存数据的数组
    private int[] elements;

    // todo 实例化对象的时候创建int数组
    public QueueTest() {
        elements = new int[0];
    }

    // todo 向队列添加元素
    public boolean push (int data){
        int[] element = new int[elements.length + 1];
        for(int i=0; i<elements.length; i++){
            element[i] = elements[i];
        }
        element[element.length - 1] = data;
        elements = element;
        return true;
    }

    // todo 从队列取出元素
    public int pop(){
        if(elements.length == 0){
            throw new RuntimeException("elements is empty!!!");
        }
        int element = elements[0];
        int[] newElements = new int[elements.length-1];
        for(int i=0; i<newElements.length; i++){
            newElements[i] = elements[i + 1];
        }
        elements = newElements;
        return element;
    }

    // todo 查看队列最先加入的元素
    public int look(){
        return elements[0];
    }

    public static void main(String[] objects) {
        QueueTest queue = new QueueTest();
        queue.push(1);
        queue.push(3);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
