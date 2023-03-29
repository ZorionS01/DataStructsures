package cn.szw.Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Szw 2001
 * @Date 2023/2/16 15:50
 * @Slogn 致未来的你！
 */
public class Test {

    private  int[] arr;
    private  List<String> list;
    public static void main(String[] args) {

//        System.out.println(Arrays.toString(arr));
        /*List<String> list = new ArrayList<>();
        Test test = new Test(list);
        test.add();*/
        List<String> list = new ArrayList<>();
        Test test = new Test(list);
        test.add();

    }

    public Test(List<String> list) {
        this.list = list;
    }

    public  void add(){
        list.add("1");
        System.out.println(list);
    }
}
