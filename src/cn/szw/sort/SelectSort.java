package cn.szw.sort;

import java.util.Arrays;

/**
 * @author 宋祖威 20级
 * @date 2022/11/26 20:16
 * @slogn 致未来的你！
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        //使用逐步推到的方式讲解
        //第一轮
        for (int i = 0; i < arr.length - 1; i++){
            int minIndx = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++){
                if (min>arr[j]){
                    min = arr[j];
                    minIndx = j;
                }
            }
            //将最小值 放在arr[0] 交换
            if (minIndx!=i){
                arr[minIndx] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i+1)+"轮后~");
            System.out.println(Arrays.toString(arr));
        }
    }
}
