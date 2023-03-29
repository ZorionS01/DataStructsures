package cn.szw.LinkedList;

/**
 * @author 宋祖威 20级
 * @date 2022/11/5 20:10
 * @slogn 致未来的你！
 */
public class Josepfu {
    /**
     * 约瑟夫解题思路:
     * 1.需要创建一个辅助接点变量 helper 事先应该指向环形链表的最后一个节点
     * 2.小孩报数先让first和helper移动k-1次
     * 3.当小孩报数 让first和helper同时移动m-1次
     * 4.这是就可以将first指向的小孩出圈
     * 5.first=first.next
     * helper.next = first
     * 原来的first指向的节点就被回收
     * @param args
     */
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//创建一个环形单链表
class CircleSingleLinkedList{
    private Boy first = null;
    //添加小孩节点构建一个环形链表

    public void add(int nums){
        //对nums进行数据校验
        if (nums < 1){
            System.out.println("nums不能小于1");
            return;
        }
        //for循环创建链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++){
         Boy boy = new Boy(i);
         //如果是第一个小孩
            if (i ==1 ){
                first = boy;
                first.setNext(first);//构成一个环
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    //遍历当前环形链表
    public void showBoy(){
        //判断链表是否为空
        if (first == null){
            System.out.println("链表空！！");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号:"+curBoy.getNo());
            if (curBoy.getNext() == first){
            break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * startNo  表示从第几个小孩
     * countNum 表示数几下
     * nums 最初有几个
     * @param startNo
     * @param countNum
     * @param nums
     */
    public void countBoy(int startNo, int countNum ,int nums){
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误！！！");
            return;
        }
        //创建一个辅助指针
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        for (int j = 0; j < startNo - 1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if (helper == first) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++){
                    first = first.getNext();
                    helper = helper.getNext();
            }
            System.out.println("小孩出圈:"+first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中编号:"+first.getNo());
 }
}


//创建一个Boy类表示一个节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
