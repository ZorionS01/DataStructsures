package cn.szw.Stack;

import java.util.Scanner;

/**
 * @author 宋祖威 20级
 * @date 2022/11/9 18:37
 * @slogn 致未来的你！
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入你的选择:");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数据");
                    String value = scanner.next();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try{
                        String res = arrayStack.pop();
                        System.out.println("出栈的数据是:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出！！");
    }
}

class ArrayStack{
    private int maxSize;//栈的大小
    private String[] stack;//数组 数组模拟栈
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new String[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(String value){
        //判断是否满
        if (isFull()){
            System.out.println("栈满！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public String pop(){
        //是否为空！
        if (isEmpty()){
//            System.out.println("栈空！！");
            throw new RuntimeException("栈空！");
        }
        String value = stack[top];
        top--;
        return value;
    }

    //遍历栈

    public void list(){
        if (isEmpty()){
            System.out.println("栈空！！");
            return;
        }
        for (int i = top; i >= 0; i--){
            System.out.println("stack["+i+"]:"+stack[i]);
        }
    }
}