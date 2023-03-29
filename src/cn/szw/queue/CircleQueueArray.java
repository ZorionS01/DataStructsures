package cn.szw.queue;

import java.util.Scanner;

/**
 * @author 宋祖威 20级
 * @date 2022/11/3 18:46
 * @slogn 致未来的你！
 */
public class CircleQueueArray {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(4);
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):从队列中取数据");
            System.out.println("h(head):查看队列头的数据");
            key=scanner.next().charAt(0);//接受一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value=scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res=arrayQueue.getQueue();
                        System.out.println("取出数据是:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res=arrayQueue.headQueue();
                        System.out.println("队列头数据是:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
            }
        }
        System.out.println("程序退出!!!");
    }
}

class CircleArray{
    private int maxSize;
    private int front;//首个元素
    private int rear;//最后一个元素
    private int[] arr;

    public CircleArray(int arrMaxsize){
        maxSize=arrMaxsize;
        arr=new int[maxSize];
    }

    public boolean isFull(){

        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满！！");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }

    public int getQueue(){
        //判断队列是否空
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空！！！");
        }
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列已空!!");
            return;
        }
        for (int i = front;i<front+size();i++){
            System.out.println("arr["+i%maxSize+"]"+"="+arr[i%maxSize]);
        }
    }

    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列空！！！");
        }
        return arr[front];
    }
}
