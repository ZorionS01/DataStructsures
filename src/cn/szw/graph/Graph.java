package cn.szw.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Szw 2001
 * @Date 2023/2/13 15:54
 * @Slogn 致未来的你！
 */
public class Graph {

    private ArrayList<String> vertexList;//顶点

    private int[][] edges;//存储图的对应邻阶矩阵

    private int numberOfEdges;

    private boolean isVisited[];
    public static void main(String[] args) {
        int n = 5;
        String vertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String value : vertexValue){
            graph.insertVertex(value);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();

        /*System.out.println("测试深度优先遍历:");
        graph.dfs();*/

        System.out.println("广度优先遍历:");
        graph.bfs();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        isVisited = new boolean[5];
    }

    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); ++i){
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1,int v2){
        for (int j = v2 + 1; j < vertexList.size(); ++j){
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    public void dfs(){
        for (int i = 0; i < getNumberOfVertex(); ++i){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    private void bfs(boolean[] isVisited,int i){
        int u;
        int w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i] = true;
        queue.addLast(i);

        while (!queue.isEmpty()){
            u = (int) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    public void bfs(){
        for (int i = 0; i < getNumberOfVertex(); ++i){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numberOfEdges++;
    }

    public int getNumberOfVertex(){
        return vertexList.size();
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

}
