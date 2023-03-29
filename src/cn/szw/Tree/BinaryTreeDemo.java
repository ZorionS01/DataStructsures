package cn.szw.Tree;

/**
 * @author 宋祖威 20级
 * @date 2023/1/13 14:28
 * @slogn 致未来的你！
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "林冲");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(node1);
       /* System.out.println("前序遍历:");
        tree.preOrder();
        System.out.println("中序遍历:");
        tree.infixOrder();
        System.out.println("后序遍历:");
        tree.postOrder();*/
        /*System.out.println("后序查：");
        HeroNode heroNode = tree.postOrderSearch(5);
        if ( heroNode != null){
            System.out.println("找到,name:"+heroNode.getName());
        }else {
            System.out.println("没找到");
        }*/

        System.out.println("中序遍历:");
        tree.infixOrder();
        /*System.out.println("删除前：");
        tree.preOrder();
        System.out.println("删除后：");
        tree.delNode(5);
        tree.preOrder();*/
    }

}

class BinaryTree{
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
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
