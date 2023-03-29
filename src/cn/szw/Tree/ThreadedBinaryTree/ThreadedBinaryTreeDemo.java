package cn.szw.Tree.ThreadedBinaryTree;

/**
 * @author 宋祖威 20级
 * @date 2023/1/17 14:07
 * @slogn 致未来的你！
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        BinaryTree tree = new BinaryTree();
        tree.setRoot(root);
        tree.threadedNodes();

        HeroNode left = node5.getLeft();
        System.out.println(left);
        System.out.println(node5.getLeftType());
        System.out.println(node5.getRight());


        System.out.println("使用线性线索化遍历树：");
        tree.threadList();
    }
}

class BinaryTree{

    private HeroNode pre = null;
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        threadedNodes(root);
    }


    public void threadList(){
        HeroNode node = root;
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1){
                 node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
    /**
     * @Author @Szw2001
     * @Description //TODO
     * @Date 14:38 2023/1/17
     * @param node
     * @return void
     **/

    public void threadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        threadedNodes(node.getLeft());
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadedNodes(node.getRight());
    }


    public void delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树不能删除！");
        }
    }

    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树空！");
        }
    }

    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树空！");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树空！");
        }
    }


    public HeroNode preOrderSearch(int no){
        if (this.root != null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if (this.root != null){
            return this.root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if (this.root != null){
            return this.root.postOrderSearch(no);
        }else{
            return null;
        }
    }
}


class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if (this.left != null){
            this.left.delNode(no);
        }

        if (this.right != null){
            this.right.delNode(no);
        }
    }



    public void preOrder(){
        System.out.println(this);

        if (this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
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

    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }

        if (this.right != null){
            this.right.postOrder();
        }

        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序");
        if (this.no == no){
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }

        if (this.right != null){
            heroNode = this.right.preOrderSearch(no);
        }

        return heroNode;
    }

    public HeroNode infixOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.infixOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        System.out.println("进入中序查找");
        if (this.no == no){
            return this;
        }

        if (this.right != null){
            heroNode = this.right.infixOrderSearch(no);
        }

        return heroNode;
    }

    public HeroNode postOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.postOrderSearch(no);
        }

        if (heroNode != null){
            return heroNode;
        }

        if (this.right != null){
            heroNode = this.right.postOrderSearch(no);
        }

        if (heroNode != null){
            return heroNode;
        }
        System.out.println("进入后序查找");
        if (this.no == no){
            return this;
        }

        return heroNode;
    }
}




