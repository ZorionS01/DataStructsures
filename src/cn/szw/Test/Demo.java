package cn.szw.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Szw 2001
 * @Date 2023/3/22 23:57
 * @Slogn 致未来的你！
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入p(素数):");
        int p = scanner.nextInt();
        System.out.println("请输入q(素数):");
        int q = scanner.nextInt();
        System.out.println("请输入s(s与p*q互素):");
        int s = scanner.nextInt();
        System.out.println(Arrays.toString(bbs(p * q, s)));
    }

    public static int[] bbs(int n,int s){
        int[] x = new int[1000];
        x[0] = s*s%n;
        int[] b = new int[1000];
        b[0] =0;
        for (int i = 1; i <100 ; i++) {
            x[i] = x[i-1]*x[i-1]%n;
            b[i] = x[i]%2;

        }
        return b;
    }
}
