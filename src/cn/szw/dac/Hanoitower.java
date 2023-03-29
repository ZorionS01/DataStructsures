package cn.szw.dac;

/**
 * @Author Szw 2001
 * @Date 2023/2/14 17:26
 * @Slogn 致未来的你！
 */
public class Hanoitower {
    private static  int count = 0;
    public static void main(String[] args) {
        hanoiTower(3,'a','b','c');
        System.out.println("步数:"+count);
    }

    public static void hanoiTower(int num,char a,char b,char c){
        count++;
        if (num == 1){
            System.out.println("第一个盘从 "+a+"->"+c);
        }else {
            hanoiTower(num - 1,a,c,b);
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            hanoiTower(num - 1,b,a,c);
        }
    }
}
