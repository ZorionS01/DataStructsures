package cn.szw.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Szw 2001
 * @Date 2023/3/29 16:07
 * @Slogn 致未来的你！
 */
public class Demo1 {
    public static void main(String[] args) {
//        System.out.println("输入一个数:");
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        isSuShu(i);
        /*System.out.println(Math.pow(16, 15)%4731);
        System.out.println("111111111111111");
        System.out.println("2222222222222222");
        System.out.println("master1");
        System.out.println("hot-fix");
        System.out.println("github 提交");
        System.out.println("pull 提交");
        System.out.println("Gitee 提交");
        System.out.println("Gitee 提交 11");*/


        /*final int[] value ={1,2,3};
        int[] num = {};
        num = value;
        System.out.println("==="+ Arrays.toString(num));
        num[0]=0;
        System.out.println("-----"+Arrays.toString(num));
        System.out.println("-----"+Arrays.toString(value));*/
        String a = "123";
        String b = "";
        b=a;
        System.out.println(b);
        String replace = b.replace("1", "0");
        System.out.println(replace);
        System.out.println(b);
        System.out.println("2023-4-1");

        
    }

    public static void isSuShu(int n){
        boolean flag=false;
        for(int j=2;j<=Math.sqrt(n);++j){
            if(n%j==0)
                flag=true; // Not primes
        }
        if(flag==false)
            System.out.println(n+" 是素数 ");
        else
            System.out.println(n+" 不是素数 ");
    }

//    public static void powFuncDel(int m,int n,int q){
//        int[] num = new int[n];
//        int k = 0;
//        for (int i = 1; i < n; i++) {
//            num[i-1]= (int) (Math.pow(m,i)%q);
//            k += i;
//            if (n==k){
//                break;
//            }
//        }
//    }
}
