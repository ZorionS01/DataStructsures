package cn.szw.Greedy;

import java.util.*;

/**
 * @Author Szw 2001
 * @Date 2023/2/15 17:25
 * @Slogn 致未来的你！
 */
public class GreedAlgorithm {

    public static void main(String[] args) {
        //创建广播电台
        Map<String, HashSet<String>> map = new HashMap<String,HashSet<String>>();
        //将各个电台放入map
        HashSet<String> hashSet1 = new HashSet<>();

        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();

        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();

        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        map.put("k1",hashSet1);
        map.put("k2",hashSet2);
        map.put("k3",hashSet3);
        map.put("k4",hashSet4);
        map.put("k5",hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        List<String> list = new ArrayList<>();

        String maxKey = null;
        HashSet<String> temptSet = new HashSet<>();
        while (allAreas.size() != 0){
            maxKey = null;
            for (String key : map.keySet()){
                HashSet<String> area = map.get(key);
                temptSet.addAll(area);
                temptSet.retainAll(allAreas);//俩个集合的交集
                if (temptSet.size() > 0 && (maxKey == null || temptSet.size() > map.get(maxKey).size())){
                    maxKey = key;
                }
                temptSet.clear();
            }
            if (maxKey != null){
                list.add(maxKey);
                allAreas.removeAll(map.get(maxKey));
//                System.out.println("allAreas=="+allAreas.size());
            }


        }
        System.out.println(list);

    }
}
