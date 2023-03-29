package cn.szw.Test;

import java.util.Scanner;

/**
 * @Author Szw 2001
 * @Date 2023/3/16 20:00
 * @Slogn 致未来的你！
 */
public class Test1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Arithmetic arithmetic = new Arithmetic();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入欧几里得算法求最大公因数的两个数（中间用空格隔开）：");
        int first = in.nextInt();
        int second = in.nextInt();
//        System.out.println("gcd("+first+","+second+")="+arithmetic.euclid(first,second));
        System.out.println("请输入欧几里得扩展算法求逆元的两个数（中间用空格隔开）：");
        int third = in.nextInt();
        int fourth = in.nextInt();
        int result = arithmetic.euclid_2(third,fourth);
        if(result<0) {
            result = result+ fourth;
        }
        System.out.println(third+"(mod"+fourth+")="+result);
    }
}
class Arithmetic {
    int x = 0;
    int y = 0;

   /* public int euclid(int a,int b){
        int first,second;
        first = a;
        second = b;
        int temp;
        if(first<second){
            temp = first;
            first = second;
            second = temp;
        }
        while(first%second!=0){
            temp = first%second;
            first = second;
            second = temp;
        }
        return second;
    }*/

    public int euclid_2(int a,int b)
    {
        int first = a;
        int second = b;
        if(second == 0)
        {
            x=1;
            y=0;
            return first;
        }
        int r=euclid_2(second,first%second);
        int t=y;
        y=x-(first/second)*y;
        x=t;
        return x;   //结束循环
    }
}