package cn.szw.Dijkstra;

import java.util.Arrays;

/**
 * @Author Szw 2001
 * @Date 2023/2/16 19:00
 * @Slogn 致未来的你！
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};

        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
    }
}

class Graph{
    private char[] vertex;//顶点数组

    private int[][] matrix;//邻接矩阵

    public Graph(char[] vertex,int[][] matrix){
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph(){
        for (int[] link : matrix){
            System.out.println(Arrays.toString(link));
        }
    }
}
class VisitedVertex{
    private int[] already_arr;

    private int[] pre_visited;

    private int[] dis;

    public VisitedVertex(int length,int index){
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis,65535);
        this.dis[index] = 0;
    }

    //index顶点是否访问过
    public boolean in(int index){
        return already_arr[index] == 1;
    }

    public void updateDis(int index,int len){
        dis[index] = len;
    }

    //更新顶点的前驱为index的节点
    public void updatePre(int pre,int index){
        pre_visited[pre] = index;
    }

    //返回出发顶点到index的距离
    public int getDis(int index){
        return dis[index];
    }
}
