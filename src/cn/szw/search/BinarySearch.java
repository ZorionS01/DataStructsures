package cn.szw.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋祖威 20级
 * @date 2023/1/8 15:42
 * @slogn 致未来的你！
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1000,1000,1234};
        System.out.println(":"+binarySearch2(arr,0,arr.length-1,1000));
    }

    public static int binarySearch(int[] arr,int left,int right,int findVal){
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left > right){
            return -1;
        }
        if (findVal > midVal){
            return binarySearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid - 1,findVal);
        }else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left > right){
            return new ArrayList<Integer>();
        }
        if (findVal > midVal){
            return binarySearch2(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){
            return binarySearch2(arr,left,mid - 1,findVal);
        }else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            list.add(mid);

            temp = mid + 1;
            while (true){
                if (temp > arr.length - 1  || arr[temp] != findVal){
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            return list;
        }
    }
}
