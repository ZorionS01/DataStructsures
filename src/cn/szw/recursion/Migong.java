package cn.szw.recursion;

/**
 * @author 宋祖威 20级
 * @date 2022/11/24 18:58
 * @slogn 致未来的你！
 */
public class Migong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //1:墙
        for (int i = 0; i < 7; i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        System.out.println("地图:");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //使用递归回溯 给小球找路
//        setWay(map,1,1);
        setWay1(map,1,1);
        System.out.println("走过后的地图:");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //使用递归回溯给小球找路
    //1.map:地图 2:i,j地图起始位置(1,1) 如果小球能到达map(6,5)则通路找到
    //4.当地图map[i][j]为0 表示该点没走过 当为1表示墙 为2表示通路可以走 3表示该点已经走过但是走不通
    //在走迷宫时需要确定一个策略(方法) 下->右->上->左走不通回溯
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){//如果当前这个点没走过
                //按照下->右->上->左
                map[i][j] = 2;//假定可以走通
                if (setWay(map, i+1, j)){
                    return true;
                }else if (setWay(map, i, j+1)){//向右走
                    return true;
                }else if(setWay(map, i-1, j)){
                    return true;
                }else if (setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
    //修改策略 上->右->下->左
    public static boolean setWay1(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){//如果当前这个点没走过
                //按照上->右->下->左
                map[i][j] = 2;//假定可以走通
                if (setWay1(map, i-1, j)){
                    return true;
                }else if (setWay1(map, i, j+1)){//向右走
                    return true;
                }else if(setWay1(map, i+1, j)){
                    return true;
                }else if (setWay1(map, i, j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
