package cn.szw.LinkedList;

import java.util.Stack;

/**
 * @author 宋祖威 20级
 * @date 2022/11/3 20:07
 * @slogn 致未来的你！
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(8, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);

        System.out.println("单链表1：");
        singleLinkedList.list();
     /*   HeroNode hero = new HeroNode(2, "卢义", "麒麟");

        singleLinkedList.list();
        singleLinkedList.update(hero);
        singleLinkedList.list();

        singleLinkedList.del(1);
        singleLinkedList.del(3);
        singleLinkedList.list();

        HeroNode res = finLastIndexNode(singleLinkedList.getHead(),2);
        System.out.println(res);
        */
      /*  System.out.println("原链表:");
        singleLinkedList.list();

        System.out.println("反向链表:");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
*/
        /*System.out.println("原链表:");
        singleLinkedList.list();

        System.out.println("逆序打印单链表:");
        reversePrint(singleLinkedList.getHead());
        singleLinkedList.list();
        */

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add(new HeroNode(2, "宋江1", "及时雨1"));
        singleLinkedList1.add(new HeroNode(4, "卢俊义1", "玉麒麟1"));
        singleLinkedList1.add(new HeroNode(5, "吴用1", "智多星1"));
        singleLinkedList1.add(new HeroNode(6, "林冲1", "豹子头1"));

        System.out.println("单链表2:");
        singleLinkedList1.list();


        System.out.println("合并后的单链表:");


        HeroNode merge = merge(singleLinkedList.getHead(), singleLinkedList1.getHead());

        System.out.println(merge);


    }
    public static HeroNode merge(HeroNode heroNode1, HeroNode heroNode2){
        if (heroNode1.next == null || heroNode2.next == null){
            return null;
        }
        if (heroNode1.next == null && heroNode2.next != null){
            return heroNode2;
        }
        if (heroNode1.next != null && heroNode2.next == null){
            return heroNode1;
        }

        HeroNode mergeNOde = new HeroNode(0,"","");
        HeroNode temp = mergeNOde;
        HeroNode temp1 = heroNode1.next;
        HeroNode temp2 = heroNode2.next;

        while (temp1 != null && temp2 != null){
            if (temp1.no < temp2.no){
                     temp.next = temp1;
                     temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 == null? temp2:temp1;

        return  mergeNOde.next;
    }






    //利用栈
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }




    //将单链表进行反转
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        //先定义一个辅助指针
        HeroNode cur = head.next;
        HeroNode next = null; //定义当前指向节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null){
            next = cur.next;//暂时保持当前节点的下一个节点
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表最前端
            reverseHead.next = cur;
            cur = next;//将cur后移
        }
        //将head.next指向reverseHead.next
        head.next = reverseHead.next;
    }


    //查找单链表中倒数第k个节点
    public static HeroNode finLastIndexNode(HeroNode head,int index){
        if (head.next == null){
            return null;
        }
        int size = getLength(head);
        if (index <=0 || index > size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i< size - index; i++){
            cur = cur.next;
        }
        return cur;
    }

    public static int getLength(HeroNode heroNode){
        if (heroNode.next==null){
            return 0;
        }
        int length=0;
        HeroNode cur = heroNode.next;
        while (cur!=null){
            length++;
            cur = cur.next;
        }
        return length;
    }

}

class SingleLinkedList{
    //初始化一个头节点 头节点不要东
    private HeroNode head = new HeroNode(0,"","");
    //添加节点到单向链表

    //找到当前链表的最后一个节点 将最后一个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为头节点不能动 需要一个辅助指针
        HeroNode temp = head;
        //遍历链表找到最后
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next==null){
                break;
            }
            if (temp.next.no>heroNode.no){
                break;
            }else if(temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("准备插入的英雄编号已经存在!!!");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    public void update(HeroNode heroNode){

        //判断是否为空
        if (head.next==null)
        {
            System.out.println("链表空！！！！");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=heroNode.name;
            temp.nickname=heroNode.nickname;
        }else {
            System.out.println("没有找到！！！");
        }
    }

    public void del(int no){
        HeroNode temp=head;
        boolean flag = false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no == no){
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if (flag){
            temp.next=temp.next.next;
        }else {
            System.out.println("未找到要删除的！！！");
        }
    }



    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表空！！！");
        }
        //因为头节点不能动 需要一个辅助指针
        HeroNode temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int hNo,String hName,String hNickName){
        no=hNo;
        name=hName;
        nickname=hNickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
