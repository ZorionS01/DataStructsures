package cn.szw.prim;

import java.util.Arrays;

/**
 * @Author Szw 2001
 * @Date 2023/2/15 19:34
 * @Slogn 致未来的你！
 */
public class PrimAlgorithm {
    public static void main(String[] args) {

        //测试图是否创建成功
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verx = data.length;
    }
}
class MGraph{
    int verx;//图节点
    char[] data;//存放节点数据
    int[][] weight;//存放边 邻接矩阵

    public MGraph(int verx) {
        this.verx = verx;
        data = new char[verx];
        weight = new int[verx][verx];
    }
}
class MinTree{
    /**
     * @Author @Szw2001
     * @Description //TODO
     * @Date 19:41 2023/2/15
     * @param mGraph 图对象
     * @param verxs 图对应的顶点数
     * @param data
     * @param weight 图的邻接矩阵
     * @return void
     **/

    public void createGraph(MGraph mGraph,int verxs,char[] data,
                            int[][] weight){
        int i,j;
        for (i = 0; i < verxs; ++i){
            mGraph.data[i] = data[i];
            for (j = 0; j < verxs; ++j){
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph mGraph){
        for (int[] link : mGraph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph mGraph,int v){
        int[] visited = new int[mGraph.verx];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;

        int minWeight = 10000;
        for (int k = 1; k < mGraph.verx; ++k){

            for (int i = 0; i < mGraph.verx; ++i){

                for (int j = 0; j < mGraph.verx; ++j){

                    if (visited[i] == 1 && visited[j] == 0 && mGraph.weight[i][j] < minWeight){
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<"+mGraph.data[h1]+","+mGraph.data[h2]+">权值:"+minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}