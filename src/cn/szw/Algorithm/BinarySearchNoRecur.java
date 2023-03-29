package cn.szw.Algorithm;

/**
 * @Author Szw 2001
 * @Date 2023/2/14 16:48
 * @Slogn 致未来的你！
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {


        int arr[] = {1,3,8,10,11,67,100};
        int index = binarySearch(arr,1);
        System.out.println("index = "+index);
    }

    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
