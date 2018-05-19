package com.desaco.Algorithm;

import java.util.Deque;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainTest {
    public static void main(String[] args) {
        Stack stack = new Stack(); // 创建堆栈对象
        System.out.println("11111, absdder, 29999.3 三个元素入栈");
        stack.push(new Integer(11111)); //向 栈中 压入整数 11111
        printStack(stack);  //显示栈中的所有元素
         
        stack.push("absdder"); //向 栈中 压入
        printStack(stack);  //显示栈中的所有元素
         
        stack.push(new Double(29999.3)); //向 栈中 压入
        printStack(stack);  //显示栈中的所有元素
         
        String s = new String("absdder");
        System.out.println("元素absdder在堆栈的位置"+stack.search(s));     
        System.out.println("元素11111在堆栈的位置"+stack.search(11111));
         
        System.out.println("11111, absdder, 29999.3 三个元素出栈"); //弹出 栈顶元素
        System.out.println("元素"+stack.pop()+"出栈");
        printStack(stack);  //显示栈中的所有元素
        System.out.println("元素"+stack.pop()+"出栈");
        printStack(stack);  //显示栈中的所有元素
        System.out.println("元素"+stack.pop()+"出栈");
        printStack(stack);  //显示栈中的所有元素
    }
     
    private static void printStack(Stack<Integer> stack ){
        if (stack.empty())
            System.out.println("堆栈是空的，没有元素");
            else {
                System.out.print("堆栈中的元素：");
                Enumeration items = stack.elements(); // 得到 stack 中的枚举对象
                while (items.hasMoreElements()) //显示枚举（stack ） 中的所有元素
                    System.out.print(items.nextElement()+" ");
            }
        System.out.println(); //换行
    }
}
