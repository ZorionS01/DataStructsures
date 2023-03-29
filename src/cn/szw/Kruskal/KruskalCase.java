package cn.szw.Kruskal;

/**
 * @Author Szw 2001
 * @Date 2023/2/16 15:42
 * @Slogn 致未来的你！
 */
public class KruskalCase {
    private int edgeNum;//边的个数

    private char[] vertex;//顶点集合

    private int[][] matrix;//邻接矩阵

    private static final int INF = Integer.MAX_VALUE;//使用INF表示俩个顶点不连通
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
    }

    public KruskalCase(char[] vertex, int[][] matrix) {
        int vlen = vertex.length;
        this.vertex = new char[vlen];
        for (int i = 0; i < vlen; ++i){
            this.vertex[i] = vertex[i];
        }

        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; ++i){
            for (int j = 0; j < vlen; ++j){
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < vlen; ++i){
            for (int j = 0; j < vlen; ++j){
                if (this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    public void print(){
        System.out.println("邻接矩阵:");
        for (int i = 0; i < vertex.length; ++i){
            for (int j = 0; j < vertex.length; ++j){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对边进行排序处理
    private void sortEdges(EData[] eData,int ele){
        for (int i = 0; i < eData.length; ++i){
            for (int j = 0; j < eData.length - 1 - i; ++j){
                if (eData[j].weight > eData[j + 1].weight){
                    EData eData1 = eData[j];
                    eData[j] = eData[j + 1];
                    eData[j + 1] = eData1;
                }
            }
        }
    }

    //顶点的值 返回下标
    private int getPosition(char ch){
        for (int i = 0; i < vertex.length; ++i){
            if (vertex[i] == ch){
                return i;
            }
        }
        return -1;
    }

    //获取图中边
    private EData[] getEdges(){
        int index = 0;
        EData[] eData = new EData[edgeNum];
        for (int i = 0; i < vertex.length; ++i){
            for (int j = i + 1; j < vertex.length; ++j){
                if (matrix[i][j] != INF){
                    eData[index++] = new EData(vertex[i],vertex[j],matrix[i][j]);
                }
            }
        }
        return eData;
    }

    //获取下标位i的顶点的终点，用于后面判断俩个顶点是否相同
    private int getEnd(int[] ends,int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }
}
class EData{
    char start;//边的起点
    char end;//边的终点
    int weight;//边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //重写toString
    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}