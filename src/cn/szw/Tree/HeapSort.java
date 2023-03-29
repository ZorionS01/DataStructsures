package cn.szw.Tree;

import java.util.Arrays;

/**
 * @Author Szw 2001
 * @Date 2023/1/18 16:13
 * @Slogn 致未来的你！
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4,6,8,5,9};
        heapSort(arr);
    }

    public static void heapSort(int arr[]){
        int temp = 0;
        System.out.println("堆排序:");
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));

        for (int j = arr.length - 1; j > 0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * @Author @Szw2001
     * @Description //
     * @Date 16:17 2023/1/18
     * @param arr 待调整的数组
     * @param i   表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素进行调整
     * @return void
     **/

    public static void adjustHeap(int arr[],int i,int length){

        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if (k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }

        arr[i] = temp;
    }


}
