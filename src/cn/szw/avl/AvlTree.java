
package cn.szw.avl;

/**
 * @Author Szw 2001
 * @Date 2023/1/28 14:12
 * @Slogn 致未来的你！
 */
public class AvlTree {

    public static void main(String[] args) {
//        int arr[] = {4,3,6,5,7,8};
//        int arr[] = {10,12,8,9,7,6};
        int arr[] = {10,11,7,6,8,9};
        Tree tree = new Tree();
        for (int i = 0; i < arr.length; ++i){
            tree.add(new Node(arr[i]));
        }

        System.out.println("中序遍历：");
        tree.infixOrder();

        System.out.println("平衡处理后:");
        System.out.println("树高度："+tree.getRoot().height());
        System.out.println("左子树高度："+tree.getRoot().leftHeight());
        System.out.println("右子树高度："+tree.getRoot().rightHeight());
        System.out.println("根节点："+tree.getRoot());

    }
}
class Tree{
    private Node root;

    public Node getRoot() {
        return root;
    }

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

    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }

    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }

    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height())+1;
    }


    //左旋转
    private void leftRotate(){
        //创建新的节点
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = this.right.left;
        value = this.right.value;
        this.right = this.right.right;
        this.left = newNode;

    }

    //右旋转
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
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

        //当添加完一个节点后如果左右子树的高度差大于1 进行旋转 右 > 左 => 左旋转
        if (rightHeight() - leftHeight() > 1){
            if (right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }

        //当添加完一个节点后如果左右子树的高度差大于1 进行旋转 左 > 右 => 右旋转
        if (leftHeight() - rightHeight() > 1){
            if (left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
            return;
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


