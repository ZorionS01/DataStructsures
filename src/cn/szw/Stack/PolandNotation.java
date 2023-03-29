package cn.szw.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 宋祖威 20级
 * @date 2022/11/9 20:40
 * @slogn 致未来的你！
 */
public class PolandNotation {
    public static void main(String[] args) {
        //将中缀表达式转换成后缀表达式
        //1+((2+3)*4)-5 => 1 2 3 + 4 * + 5 -
        //2.因为直接对字符串操作不方便 因此将字符串转成 一个中缀形式的list
        //即 "1+((2+3)*4)-5" => ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
        //3.将得到的中缀表达式对应的List=》后缀表达式的List
        //即ArrayList[1,+,(,(,2,+,3,),*,4,),-,5] =>ArrayList[1,2,3,+,4,*,+,5,-]

        String expression = "1+((2+3)*4)-5";
        List<String> strings = toInfixExpressionList(expression);
        System.out.println(strings);
        List<String> strings1 = parseSuffixExpressionList(strings);
        System.out.println("后缀表达式:");
        System.out.println(strings1);
        System.out.println(calculate(strings1));

        //（30+4)*5-6=>30 4 + 5 * 6 - 逆波兰表达式
        //4*5-8+60+8/2=>4 5 * 8 - 60 + 8 2 / +
/*        String sufferExpression = "4 5 * 8 - 60 + 8 2 / +";
        //1.先将sufferExpression放到ArrayList中
        //2.将ArrayList传递给一个方法  遍历ArrayList配合栈完成计算
        List<String> listString = getListString(sufferExpression);
        System.out.println(listString);

        int res = calculate(listString);
        System.out.println("结果："+res);*/
    }
    //即ArrayList[1,+,(,(,2,+,3,),*,4,),-,5] =>ArrayList[1,2,3,+,4,*,+,5,-]
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //初始化栈
        Stack<String> s1 = new Stack<String>();//符号栈
//        Stack<String> s2 = new Stack<>();//没出栈操作还逆序 用list代替
        List<String> s2 = new ArrayList<>();

        //遍历ls
        for (String item: ls
             ) {
            //如果是一个数就入栈 加入到s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号 则弹出s1栈顶元素 并压入S2 直到左括号 此时一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//消除(
            }else{
                //当item优先级小于等于栈顶运算符优先级将s1栈顶运算符弹出并加入s2中反复以上操作
                //缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈中
                s1.push(item);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }







    //将中缀转成对应的list
    public static List<String> toInfixExpressionList(String s){
        //定义一个List 存放中缀表达式对应内容
        List<String> ls = new ArrayList<>();
        int i = 0;//指针 用于遍历 s
        String str;//对多位数的拼接工作
        char c;
        do{
            //如果c是非数字 就需要加入到 ls
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(""+c);
                i++;
            }else {
                //如果是一个多位数
                str = "";
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }







    //将逆波兰表达式 依次放入到ArrayList中
    public static List<String> getListString(String sufferExpression){
        String[] s = sufferExpression.split(" ");
        List<String>  list = new ArrayList<String>();
        for (String s1 : s ){
            list.add(s1);
        }
        return list;
    }

    //计算
    public static int calculate(List<String> list){
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : list){
            //这里用正则表达式
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误！！");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

//编写一个类:Operation可以返回一个运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法 返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
