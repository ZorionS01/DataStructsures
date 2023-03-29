package cn.szw.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author Szw 2001
 * @Date 2023/2/17 18:24
 * @Slogn 致未来的你！
 */
public class HorseChessBoard {
    private static int x;//列数
    private static int y;//行数
    private static boolean visited[];
    private static boolean finished;

    public static void traversalChessBoard(int[][] chessBoard,int row,int column,int step){
        chessBoard[row][column] = step;
        visited[row * x + column] = true;
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        while (!ps.isEmpty()){
            Point p = ps.remove(0);
            if (!visited[p.y*x+p.x]){
                traversalChessBoard(chessBoard,p.y,p.x,step+1);
            }
        }
        if (step < x*y && !finished){
            chessBoard[row][column]=0;
            visited[row * x + column] = false;
        }else {
            finished = true;
        }
    }

    public static void main(String[] args) {
        x=8;
        y=8;
        int row=1;
        int column=1;
        int[][] chessBoard = new int[x][y];
        visited = new boolean[x*y];

    }

    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> ps = new ArrayList<>();

        Point p1 = new Point();
        if ((p1.x = curPoint.x - 2) >=0 &&(p1.y = curPoint.y - 1) >=0){
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >=0){
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < x && (p1.y = curPoint.y - 2) >=0){
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < x && (p1.y = curPoint.y - 1) >=0){
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < x && (p1.y = curPoint.y + 1) < y){
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < x && (p1.y = curPoint.y + 2) < y){
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < y){
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >=0){
            ps.add(new Point(p1));
        }
        return ps;
    }

    //根据当前所有的下一步的选择数目进行非递减排序
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取o1下一步的所有位置个数
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                }else if (count1 == count2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }
}
