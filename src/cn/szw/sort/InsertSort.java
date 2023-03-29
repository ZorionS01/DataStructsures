package cn.szw.sort;

import java.util.Arrays;

/**
 * @author 宋祖威 20级
 * @date 2022/12/19 20:35
 * @slogn 致未来的你！
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        //使用逐步推导的方式
        //第一轮{101，34，119，1} -》{34，101，119，1}
        //定义待插入的数
        int insertVal = 0;
        int insetIndex = 0;
       for (int i = 1; i < arr.length; i++){
           insertVal = arr[i];
           insetIndex = i-1;//即arr[1]的前面这个数的下标
           //给insetVal找到插入的位置
           while (insetIndex >= 0 && insertVal < arr[insetIndex]){
               arr[insetIndex + 1] = arr[insetIndex];
               insetIndex--;
           }
           if (insetIndex + 1 != i)
           {
               arr[insetIndex + 1] = insertVal;
           }

           System.out.println("第"+i+"轮插入:");
           System.out.println(Arrays.toString(arr));
       }
    }
}
