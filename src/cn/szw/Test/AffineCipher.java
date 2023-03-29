package cn.szw.Test;

import java.util.*;

/**
 * @Author Szw 2001
 * @Date 2023/3/16 18:38
 * @Slogn 致未来的你！
 */
public class AffineCipher {

    private static boolean flag = true;

    private static int x=0,y=0,n=0,m=26;


    //chars明文数组 chars加密后的数组 chars2解密后的字符组
    private static char[] chars,chars1,chars2;

    //加密后的字符对应数值集合
    private static List<Integer> list;

    private static String k1,k2;

    private static char[]  chr= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
    'v','w','x','y','z'};

    public static void main(String[] args) {

        while (flag) {
        System.out.println("---------------仿射密码----------------");
        System.out.println("------------1.仿射密码加密---------------");
        System.out.println("------------2.仿射密码解密---------------");
        System.out.println("------------3.仿射密码验证---------------");
        System.out.println("--------------4.程序退出---------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想选择功能的数字:");
        String s = scanner.next();
            switch (s.charAt(0)) {
                case '1':
                    encode();
                    break;
                case '2':
                    decode();
                    break;
                case '3':
                    validate();
                    break;
                case '4':
                    exit();
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }


    //加密 y = (k1x + k2)(mod 26)
    public static void encode(){
        System.out.println("encode");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入明文:");
        String next = scanner.next();
        String s = next.toLowerCase();
        chars = s.toCharArray();
        System.out.println("请输入k1,k2两个密钥(逗号隔开):");
        String next1 = scanner.next();
        String[] split = next1.split(",");
        k1 = split[0];
        k2 = split[1];
        //明文对应的数值
        int [] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chr.length; j++) {
                if (chars[i] == chr[j]){
                    ints[i] = j;
                }
            }
        }
        System.out.println("明文对应的数值");
        System.out.println(Arrays.toString(ints));
        //加密后字符串对应的数值
        list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            list.add((Integer.parseInt(k1)*ints[i]+Integer.parseInt(k2))%m);
        }
        //加密后的字符数组
        chars1 = new char[chars.length];
        for (Integer e:list) {
            for (int i = 0; i < chr.length; i++) {
                if (e==i){
                    chars1[n] = chr[i];
                    n++;
                }
            }
        }
        System.out.println("加密变换后密文字符：");
        System.out.println(Arrays.toString(chars1));


    }

    //解密 x= k1'(y-k2)(mod 26)  k1'(k1关于26的逆元)
    public static void decode(){
        System.out.println("decode");
        System.out.println("请输入欧几里得扩展算法求逆元的两个数（空格隔开）："); //next() nextInt() 默认空格是俩个字符的间隔
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        m=b;
        int result=gcd_1(a,m);
        if(result<0) {
            result = result+ m;
        }
        System.out.println(a+"(mod"+m+")="+result);

        //解密后的字符对应的数值数组
        int[] ints = new int[chars.length];

        for (int i = 0; i < list.size(); i++) {
            ints[i] = (result * (list.get(i) - Integer.parseInt(k2))) % m;
            if (ints[i] < 0){
                ints[i] = ints[i] + m;
            }
        }

        System.out.println("解密后的字符对应数值数组 ：");
        System.out.println(Arrays.toString(ints));

        chars2 = new char[ints.length];
        for (int i = 0; i < ints.length ; i++) {
            for (int j = 0; j < chr.length; j++) {
                if (ints[i] == j){
                    chars2[i] = chr[j];
                }
            }
        }

        System.out.println("解密后原明文对应的字符数组：");
        System.out.println(Arrays.toString(chars2));

    }

    public static void validate(){
        System.out.println("validate");
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars2[i] != chars[i]){
                System.out.println("仿射密码解密失败！！！！");
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("仿射密码解密成功！！！");
        }


    }


    public static void exit(){
        flag = false;
        System.out.println("程序退出。。。。。。");
    }



    //求最大公约数
    public static int gcd(int a, int b){
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
    }

    //a关于模b的逆元
    public static int gcd_1(int a,int b){
        int f = a;
        int s = b;
        if(s == 0)
        {
            x=1;
            y=0;
            return f;
        }
        int r=gcd_1(s,f%s);
        int t=y;
        y=x-(f/s)*y;
        x=t;
        return x;   //结束循环
    }


}
