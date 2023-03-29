package cn.szw.search;

/**
 * @author 宋祖威 20级
 * @date 2023/1/9 14:56
 * @slogn 致未来的你！
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {100};
        for (int i = 0; i < 100; i++){
            arr[i] = i + 1;
        }
    }

    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];
        if (findVal > midVal){
            return insertValueSearch(arr,mid + 1,right,findVal);
        }else if (findVal < midVal){
            return insertValueSearch(arr,left,mid - 1,findVal);
        }else {
            return mid;
        }
    }
}
