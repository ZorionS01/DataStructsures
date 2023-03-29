package cn.szw.queue;

import java.util.Scanner;

/**
 * @author 宋祖威 20级
 * @date 2022/10/31 21:00
 * @slogn 致未来的你！
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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

class ArrayQueue{
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//数组存放数据 模拟队列

    //创建队列的构造器

    public ArrayQueue(int arrMaxSize) {
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;//指向队列头部,指向队列头的前一个位置
        rear=-1;//指向队列尾的具体（包含就是最后一个）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满！！");
            return;
        }
        rear++;//rear后移
        arr[rear]=n;
    }

    //获取队列数据 出队列

    public int getQueue(){
        //判断队列是否空
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空！！！");
        }
        front++;//front后移
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列已空!!");
            return;
        }
        for (int i = 0;i<arr.length;i++){
            System.out.println(""+i+" "+arr[i]+"\t");
        }
    }
    //显示队列头数据 不是取数据
    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列空！！！");
        }
        return arr[front+1];
    }
}
