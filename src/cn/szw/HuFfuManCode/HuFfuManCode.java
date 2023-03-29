package cn.szw.HuFfuManCode;

import java.io.*;
import java.util.*;

/**
 * @Author Szw 2001
 * @Date 2023/1/20 13:59
 * @Slogn 致未来的你！
 */
public class HuFfuManCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        System.out.println("前："+bytes.length);
        System.out.println("字节数组"+Arrays.toString(bytes));

        //分步:
       /* List<Node> nodes = getNodes(bytes);
        System.out.println(nodes);

        System.out.println("二叉树:");
        Node node = createHuFuManTree(nodes);
        System.out.println("前序遍历:");
        preOrder(node);

        System.out.println("哈夫曼编码:");
        Map<Byte, String> code = getCode(node);
        System.out.println(code);

        byte[] zip = zip(bytes, code);
        System.out.println("哈夫曼code:"+Arrays.toString(zip));*/

        //-----------------------------------------
        byte[] bytes1 = huFuManZip(bytes);



        System.out.println("压缩后的结果:"+Arrays.toString(bytes1));
        System.out.println("长度："+bytes1.length);
        System.out.println("压缩率:"+(float)(str.length() - bytes1.length) / str.length());

        byte[] decode = decode(huffmanCodes, bytes1);
        System.out.println(new String(decode));

        //------------------------------测试压缩文件
       /* String srcFile = "e://新建文本文档.txt";
        String dstFile = "e://ds.zip";

        zipFile(srcFile,dstFile);
        System.out.println("压缩文件成功：");*/

        //------------------------------测试解压文件
        /*String zipFile = "e://ds.zip";
        String dstFile = "e://srcFile2.bmp";
        unZipFile(zipFile,dstFile);
        System.out.println("解压成功！");*/



    }

    public static void unZipFile(String zipFile,String dstFile){
        //定义文件的输入流
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(zipFile);
            objectInputStream = new ObjectInputStream(inputStream);
            byte[] code = (byte[]) objectInputStream.readObject();
            //读取哈夫曼表
            Map<Byte,String> map = (Map<Byte, String>) objectInputStream.readObject();

            byte[] bytes = decode(map, code);
            outputStream = new FileOutputStream(dstFile);
            outputStream.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                objectInputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void zipFile(String srcFile,String dstFile){
        OutputStream outputStream = null;
        FileInputStream inputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);

            byte[] b = new byte[inputStream.available()];

            inputStream.read(b);


            byte[] huFuManBytes = huFuManZip(b);
            outputStream = new FileOutputStream(dstFile);

            objectOutputStream = new ObjectOutputStream(outputStream);
            //对象流方式 写入
            objectOutputStream.writeObject(huFuManBytes);

            //注意将哈夫曼编码写入压缩文件
            objectOutputStream.writeObject(huffmanCodes);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huFuBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huFuBytes.length; i++){
            boolean flag = (i == huFuBytes.length -1 );
            stringBuilder.append(byteToBitString(!flag,huFuBytes[i]));
        }

//        System.out.println("哈夫曼字节数组解码后的二进制字符串:"+stringBuilder.toString());

        Map<String,Byte> map = new HashMap<>();

        for (Map.Entry<Byte,String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
//        System.out.println("map:"+map);
        List<Byte> list = new ArrayList<>();

        for (int i = 0;i < stringBuilder.length();){
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag){
                String key = stringBuilder.substring(i,i+count);
                b = map.get(key);
                if (b == null){
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; ++i){
            b[i] = list.get(i);
        }
        return b;
    }




    //将一个byte 字节 转换成一个二进制的字符串
    private static String byteToBitString(boolean flag,byte b){
        int temp = b;

        //将正整数补高位操作 10000 0000 | 0000 0001 => 1 0000 0001
        if (flag){
            temp |= 256;  //二进制或运算
        }

        String s = Integer.toBinaryString(temp);

//        System.out.println("子串"+s);
        if (flag){
            return s.substring(s.length() - 8);
        }else {
            return s;
        }


    }







    private static byte[] huFuManZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        System.out.println(nodes);

        Node huFuManTree = createHuFuManTree(nodes);
//        System.out.println(huFuManTree);


        Map<Byte, String> code = getCode(huFuManTree);
        //根据哈夫曼编码得到压缩后的哈夫曼编码字节数组
        byte[] zip = zip(bytes, code);

        return zip;

    }



    private static byte[] zip(byte[] bytes,Map<Byte,String> huFuMapCode){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes){
            stringBuilder.append(huFuMapCode.get(b));
        }
//        System.out.println(stringBuilder.toString());

        int len;
        //len = (stringBuilder.length() + 7) / 8
        if (stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huFuCodeByte = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8){
            String strByte;
            if (i + 8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }
            huFuCodeByte[index] = (byte) Integer.parseInt(strByte,2);
//            System.out.println(i+","+strByte);
            index++;
        }
        return huFuCodeByte;
    }



    static Map<Byte,String> huffmanCodes = new HashMap<Byte, String>();
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte,String> getCode(Node node){
        if (node == null){
            return null;
        }

        getCode(node,"",stringBuilder);

        return huffmanCodes;
    }
    private static void getCode(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null){
            if (node.data == null){
                getCode(node.left,"0",stringBuilder1);
                getCode(node.right,"1",stringBuilder1);
            }else {
                huffmanCodes.put(node.data,stringBuilder1.toString());
            }
        }
    }



    private static void preOrder(Node node){
        if (node != null){
            node.preOrder();
        }else {
            System.out.println("空");
        }
    }

    private static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte,Integer> map = new HashMap<>();
        for (byte b : bytes){
            Integer c = map.get(b);
            if (c == null){
                map.put(b,1);
            }else {
                map.put(b,c + 1);
            }
        }
        for (Map.Entry<Byte,Integer> entry : map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;

    }

    private static Node createHuFuManTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

            Collections.sort(nodes);
        }
        return nodes.get(0);
    }
}
class Node implements Comparable<Node>{
    Byte data; //存放数据本身
    int weight; //权值
    Node left,right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}