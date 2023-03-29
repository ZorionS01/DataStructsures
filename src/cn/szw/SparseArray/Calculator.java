package cn.szw.SparseArray;

/**
 * @author 宋祖威 20级
 * @date 2022/11/9 19:20
 * @slogn 致未来的你！
 */
public class Calculator {
    public static void main(String[] args) {
        //
        String expression = "10/2+20*6-2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String keepnum = "";//拼接多位数
        char ch = ' ';//每次扫描得到的char保存到ch
        while (true){
            //依次得到expression中的每个字符
            ch = expression.substring(index , index + 1).charAt(0);
            //判断ch是什么
            if (operStack.isOper(ch)){
                //判断当前符号栈是否为空
                if (!operStack.isEmpty()){
                    //如果符号栈中有符号，进行比较 如果当前的操作符优先级小于或者等于栈中的操作符
                    //就需要从数栈中pop俩个数 在从符号栈中pop出一个符号 进行运算 得到结果 入数栈
                    //然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接入栈
                    operStack.push(ch);
                }
            }else {
//                numStack.push(ch-48);
                //当处理多位数时
                //1.处理数时 需要向expression的表达式后面的index后再看一位
                //因此需要定义一个变量(字符串) 用于拼接
                keepnum += ch;

                //如果ch已经时expression最后一位 直接入栈
                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepnum));
                }else {
                    //判断下一个字符是不是数字 如果是数字则进行 继续扫描,如果时运算符则 入栈
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepnum));
                        keepnum = "";
                    }
                }
            }
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        //当表达式扫描完毕 就顺序的从数栈pop出相应的数和符号 并运行
        while (true){
            //如果符号栈为空 则计算结束
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println("表达式:"+expression+" 结果:"+numStack.pop());
    }
}
class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组 数组模拟栈
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        //判断是否满
        if (isFull()){
            System.out.println("栈满！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        //是否为空！
        if (isEmpty()){
//            System.out.println("栈空！！");
            throw new RuntimeException("栈空！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈

    public void list(){
        if (isEmpty()){
            System.out.println("栈空！！");
            return;
        }
        for (int i = top; i >= 0; i--){
            System.out.println("stack["+i+"]:"+stack[i]);
        }
    }

    //返回运算符的优先级
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;//假设表达式只有+ - * /
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1 , int num2 ,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

    public int peek(){
        return stack[top];
    }


}
