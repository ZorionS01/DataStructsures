package cn.szw.Floyd;

import java.util.Arrays;

/**
 * @Author Szw 2001
 * @Date 2023/2/17 16:47
 * @Slogn 致未来的你！
 */
public class FloyAlgorithm {

    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int [][] matrix = new int[vertex.length][vertex.length];
    }
}
class Graph{
    private char[] vertex;

    private int[][] dis;//保存任意俩个顶点间的最短距离

    private int[][] pre;

    public Graph(int length,int[][] matrix,char[] vertex){
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        for (int i = 0; i < length; ++i){
            Arrays.fill(pre[i],i);
        }
    }

    public void show(){
        for (int k = 0; k < dis.length; ++k){
            for (int i = 0; i < dis.length; ++i){
                System.out.print(pre[k][i]+" ");
            }
            System.out.println();
            for (int i = 0; i < dis.length; ++i){
                System.out.print(dis[k][i]+" ");
            }
            System.out.println();
        }

    }

    public void floyd(){
        int len = 0;//变量保存距离
        for (int k = 0; k < dis.length; ++k){
            for (int i = 0; i < dis.length; ++i){
                for (int j = 0; j < dis.length; ++j){
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]){
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
