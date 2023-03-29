package cn.szw.Tree;

/**
 * @author 宋祖威 20级
 * @date 2023/1/16 15:08
 * @slogn 致未来的你！
 */
public class ArrayBinaryTree {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        ArrayTree tree = new ArrayTree(arr);
        tree.preOrder();
    }
}

class ArrayTree{
    private int[] arr;

    public ArrayTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空！");
        }
        System.out.println(arr[index]);

        if ((index * 2 + 1) < arr.length){
            preOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length){
            preOrder(index * 2 + 2);
        }
    }
}
