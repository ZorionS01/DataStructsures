package cn.szw.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 宋祖威 20级
 * @date 2023/1/4 21:08
 * @slogn 致未来的你！
 */
public class shellSort {
    public static void main(String[] args) {
        int arr[] = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date);
    }

    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){
                for (int j = i - gap; j >= 0; j -= gap){
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

        }
        System.out.println("希尔排序："+ Arrays.toString(arr));
    }

    public static void shellSort2(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){
                int j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(":"+Arrays.toString(arr));
    }
}
