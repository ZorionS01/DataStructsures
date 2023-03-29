package cn.szw.HashTable;

import java.util.Scanner;

/**
 * @author 宋祖威 20级
 * @date 2023/1/11 14:28
 * @slogn 致未来的你！
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");

            key = scanner.next();

            switch (key){
                case "add":
                    System.out.println("输入id:");
                    int id = scanner.nextInt();
                    System.out.println("输入name:");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入查找的id:");
                    id = scanner.nextInt();
                    hashTab.findById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}

class HashTab{
   private EmpLinkedList[] empLinkedListArray;
   private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int empLinkedListNo = hasFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++){
            empLinkedListArray[i].list(i);
        }
    }

    public int hasFun(int id){
        return id % size;
    }

    public void findById(int id){
        int empLinkedListNo = hasFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.println("第"+(empLinkedListNo+1)+"条找到雇员 id = "+id);
        }else {
            System.out.println("没找到该雇员");
        }
    }
}






class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }

        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }

        curEmp.next = emp;
    }

    public void list(int no){
        if (head == null){
            System.out.println("第"+(no+1)+"条链表为空！");
            return;
        }
        System.out.print("第"+(no+1)+"条链表信息:");
        Emp curEmp = head;
        while (true){
            System.out.print("=>id="+curEmp.id+" name="+curEmp.name+"\t");
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表空！");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }

        return curEmp;
    }
}


