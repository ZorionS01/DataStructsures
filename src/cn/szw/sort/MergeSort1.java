package cn.szw.sort;

/**
 * @author 宋祖威 20级
 * @date 2023/1/7 14:10
 * @slogn 致未来的你！
 */
public class MergeSort1 {

    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right){
            if (arr[i]<arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        while (i <= mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
