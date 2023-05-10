package cn.szw.sort;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author 宋祖威 20级
 * @date 2022/11/26 19:34
 * @slogn 致未来的你！
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*int arr[] = {3, 9, -1, 10, 20};
        bubbleSort(arr);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));*/
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++){
            arr[i] = (int)(Math.random()*80000);
        }
        /*Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前时间:"+format);*/
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("排序前时间:"+format);
        bubbleSort(arr);
        /*Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat1.format(date1);
        System.out.println("排序后时间:"+format1);*/
        String format1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("排序后的时间:"+format1);
//        System.out.println("排序后:");
//        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            /*System.out.println("第" + (i + 1) + "趟排序后数组");
            System.out.println(Arrays.toString(arr));*/

            if (!flag) {
                //一趟排序中都没有发生交换
                break;
            } else {
                flag = false;
            }
        }
    }
}