package cn.szw.SparseArray;

/**
 * @author 宋祖威 20级
 * @date 2022/10/30 21:07
 * @slogn 致未来的你！
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个二维数组11*11
        //0表述没有棋子 1:表示黑子 2:表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        System.out.println("原始二维数组:");
        for(int[] row :chessArr1){
            for (int data:row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
        //将二维数组转为稀疏数组
        //1.先遍历数组得到非0个数
        int sum=0;
        for(int i= 0;i<11;i++){
            for(int j = 0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);

        //2.创建对应的稀疏数组
        int sparseArray[][]=new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;
        //遍历二维数组将非0值存储到稀疏数组
        int count=0;//用于记录第几个非0数据
        for(int i= 0;i<11;i++){
            for(int j = 0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println("得到的稀疏数组:");
        for (int i =0;i<sparseArray.length;i++){
            for(int j=0;j<3;j++){
                System.out.print(sparseArray[i][j]+"\t");
            }
            System.out.println();
        }
        //将稀疏数组恢复 原始二维数组
        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i = 1;i<sparseArray.length;i++){
            chessArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
    }
}
