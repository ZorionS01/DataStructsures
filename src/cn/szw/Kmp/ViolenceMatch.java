package cn.szw.Kmp;

/**
 * @Author Szw 2001
 * @Date 2023/2/15 15:26
 * @Slogn 致未来的你！
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        //测试暴力匹配算法

    }

    //暴力匹配算法
    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;//索引指向s1
        int j = 0;//索引指向s2

        while ( i < s1Len && j < s2Len){//保证匹配时不越界
            if (s1[i] == s2[j]){//匹配成功
                i++;
                j++;
            }else {//没匹配成功
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len){
            return i - j;
        }else {
            return -1;
        }
    }
}
