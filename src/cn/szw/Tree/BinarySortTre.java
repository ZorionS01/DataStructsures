package cn.szw.Tree;

/**
 * @Author Szw 2001
 * @Date 2023/1/25 14:13
 * @Slogn 致未来的你！
 */
public class BinarySortTre {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,0};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; ++i){
            binarySortTree.add(new Node(arr[i]));
        }

        System.out.println("中序遍历:");
        binarySortTree.infixOrder();

        /*System.out.println("测试删除叶子节点 :");
        binarySortTree.deleteNode(2);
        binarySortTree.deleteNode(1);
        System.out.println("中序遍历:");
        binarySortTree.infixOrder();*/


        binarySortTree.deleteNode(0);
        binarySortTree.deleteNode(5);
        binarySortTree.deleteNode(9);
        binarySortTree.deleteNode(12);
        binarySortTree.deleteNode(7);
        binarySortTree.deleteNode(3);
        binarySortTree.deleteNode(10);
        System.out.println("删除后：");
        binarySortTree.infixOrder();

    }
}



class BinarySortTree{
    private Node root;

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("树空");
        }
    }

    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    public void deleteNode(int value){
        if (root == null){
            return;
        }else {
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            if (root.left == null && root.right == null){
                root = null;
                return;
            }

            Node parentNode = searchParent(value);

            if (targetNode.left == null && targetNode.right == null){
                if (parentNode.left != null && parentNode.left.value == value){
                    parentNode.left = null;
                }else if (parentNode.right != null && parentNode.right.value == value){
                    parentNode.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null){
                int min = deleteRightMin(targetNode.right);
                targetNode.value = min;
            }else {
                if (targetNode.left != null){
                   if (parentNode != null){
                       if (parentNode.left.value == value){
                           parentNode.left = targetNode.left;
                       }else {
                           parentNode.right = targetNode.left;
                       }
                   }else {
                       root = targetNode.left;
                   }
                }else {
                    if (parentNode != null){
                        if (parentNode.left.value == value){
                            parentNode.left = targetNode.right;
                        }else {
                            parentNode.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }

    }

    public int deleteRightMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node search(int value){
        if (value == this.value){
            return this;
        }else if (value < this.value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right == null){
                return null;
            }

            return this.right.search(value);
        }
    }

    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right!= null &&
                this.right.value == value)){
            return this;
        }else {
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if (value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }



    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){
        if (node == null){
            return;
        }

        if (node.value<this.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null){
            this.right.infixOrder();
        }
    }
}