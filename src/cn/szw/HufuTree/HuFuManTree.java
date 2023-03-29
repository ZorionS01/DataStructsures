package cn.szw.HufuTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Szw 2001
 * @Date 2023/1/19 14:48
 * @Slogn 致未来的你！
 */
public class HuFuManTree {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        int count;
        int a = 0;
        System.out.println(createHuFfuManTree(arr));
        createHuFfuManTree(arr).preOrder();
        
    }

    public void preOrder(Node node){
        if (node != null){
            node.preOrder();
        }else {
            System.out.println("树空！");
        }
    }

    public static Node createHuFfuManTree(int arr[]){
        List<Node> nodes = new ArrayList<>();
        for (int value : arr){
            nodes.add(new Node(value));
        }


        while (nodes.size() > 1){
            Collections.sort(nodes);

            System.out.println("nodes =" + nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

            Collections.sort(nodes);
        }

        return nodes.get(0);

    }
}




class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
        }
    }
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
