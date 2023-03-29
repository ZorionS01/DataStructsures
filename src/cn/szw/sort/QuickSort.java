package cn.szw.sort;

import java.util.Arrays;

/**
 * @author 宋祖威 20级
 * @date 2023/1/5 17:23
 * @slogn 致未来的你！
 */
public class QuickSort {
    public static void main(String[] args) {
      int arr[] = {-9,78,0,23,-567,70};
      quickSort(arr,0,arr.length-1);
        System.out.println(":"+ Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r){
            while (arr[l] < pivot){
                l += 1;
            }
            while (arr[r] > pivot){
                r -= 1;
            }
            if( l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot){
                r -= 1;
            }
            if (arr[r] == pivot){
                l += 1;
            }
        }
        if (l == r){
            l += 1;
            r -= 1;
        }
        if (left < r){
            quickSort(arr,left,r);
        }
        if (right > l){
            quickSort(arr,l,right);
        }
    }


}
