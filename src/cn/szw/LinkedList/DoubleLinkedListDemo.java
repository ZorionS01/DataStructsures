package cn.szw.LinkedList;

/**
 * @author 宋祖威 20级
 * @date 2022/11/5 18:36
 * @slogn 致未来的你！
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);

        doubleLinkedList.list();

        /*HeroNode2 newh = new HeroNode2(1,"松江1","");
        doubleLinkedList.update(newh);
        doubleLinkedList.list();

        doubleLinkedList.del(1);
        doubleLinkedList.list();

        HeroNode2 new2 = new HeroNode2(5,"五五","");
        System.out.println("====================");
        doubleLinkedList.add(new2);
        doubleLinkedList.list();*/
    }
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead(){
        return head;
    }

    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表空！！！");
        }
        //因为头节点不能动 需要一个辅助指针
        HeroNode2 temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public void add(HeroNode2 heroNode){
        //因为头节点不能动 需要一个辅助指针
        HeroNode2 temp = head;
        //遍历链表找到最后
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(HeroNode2 heroNode){

        //判断是否为空
        if (head.next==null)
        {
            System.out.println("链表空！！！！");
            return;
        }
        HeroNode2 temp = head.next;
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
        if (head.next==null){
            System.out.println("链表空！！！");
            return;
        }
        HeroNode2 temp=head.next;
        boolean flag = false;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no == no){
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if (flag){
            temp.pre.next=temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("未找到要删除的！！！");
        }
    }


    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("准备插入的英雄编号已经存在!!!");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
            temp.next.pre = heroNode;
            heroNode.pre = temp;
        }

    }



}

class HeroNode2{
        public int no;
        public String name;
        public String nickname;
        public HeroNode2 next;//默认Null
        public HeroNode2 pre;//默认null


        public HeroNode2(int hNo, String hName, String hNickName) {
            no = hNo;
            name = hName;
            nickname = hNickName;
        }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

