package cn.szw.recursion;

/**
 * @author 宋祖威 20级
 * @date 2022/11/24 20:49
 * @slogn 致未来的你！
 */
public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义一个数组array,保存皇后放置位置的结果
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有"+count+"解法");
    }
    private void check(int n){
        if (n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++){
            //先把当前皇后n 放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时是否冲突
            if (jude(n)){
                check(n+1);
            }
        }
    }



    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean jude(int n){
        for (int i = 0; i < n; i++){
            //说明
            //array[i] == array[n] 表示第n个皇后和前面N-1个皇后是否同一列
            //Math.abs(n-i) == Math.abs(array[n]-array[i])  表示第n个皇后和第i个皇后是否同一斜
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }


    //写一个方法,可以将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
