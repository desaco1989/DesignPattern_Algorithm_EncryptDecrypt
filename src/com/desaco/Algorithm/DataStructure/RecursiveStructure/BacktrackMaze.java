package com.desaco.Algorithm.DataStructure.RecursiveStructure;

import java.util.Scanner;
import java.util.Stack;

/**
 * 用数组、递归等数据结构知识，掌握、提高分析、设计、实现及测试程序的综合能力。
 * 
 * 以一个M×N的长方阵表示迷宫，0和1分别表示迷宫中的通路和障碍。
 * 
 * @author desaco
 *
 */
public class BacktrackMaze {
	public BacktrackMaze(){
		 
    }
 
    public BacktrackMaze(int row, int col){
        this.col = col;
        this.row = row;
    }
 
    public String toString(){
        return "(" + row + " ," + col + ")";
    }
 
    int row;
    int col;
}
 
class Maze{
//	Stack<BacktrackMaze> stack;
    public Maze(){
        maze = new int[15][15];
        stack = new Stack<BacktrackMaze>();
        p = new boolean[15][15];
    }
 
    /*
     * 构造迷宫
     */
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入迷宫的行数");
        row = scanner.nextInt();
        System.out.println("请输入迷宫的列数");
        col = scanner.nextInt();
        System.out.println("请输入" + row + "行" + col + "列的迷宫");
        int temp = 0;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                temp = scanner.nextInt();
                maze[i][j] = temp;
                p[i][j] = false;
            }
        }
    }
 
    /*
     * 回溯迷宫，查看是否有出路
     */
    public void findPath(){
        // 给原始迷宫的周围家一圈围墙
        int temp[][] = new int[row + 2][col + 2];
        for(int i = 0; i < row + 2; ++i) {
            for(int j = 0; j < col + 2; ++j) {
                temp[0][j] = 1;
                temp[row + 1][j] = 1;
                temp[i][0] = temp[i][col + 1] = 1;
            }
        }
        // 将原始迷宫复制到新的迷宫中
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                temp[i + 1][j + 1] = maze[i][j];
            }
        }
        // 从左上角开始按照顺时针开始查询
 
        int i = 1;
        int j = 1;
        p[i][j] = true;
        stack.push(new BacktrackMaze(i, j));
        while (!stack.empty() && (!(i == (row) && (j == col)))) {
 
            if ((temp[i][j + 1] == 0) && (p[i][j + 1] == false)) {
                p[i][j + 1] = true;
                stack.push(new BacktrackMaze(i, j + 1));
                j++;
            } else if ((temp[i + 1][j] == 0) && (p[i + 1][j] == false)) {
                p[i + 1][j] = true;
                stack.push(new BacktrackMaze(i + 1, j));
                i++;
            } else if ((temp[i][j - 1] == 0) && (p[i][j - 1] == false)) {
                p[i][j - 1] = true;
                stack.push(new BacktrackMaze(i, j - 1));
                j--;
            } else if ((temp[i - 1][j] == 0) && (p[i - 1][j] == false)) {
                p[i - 1][j] = true;
                stack.push(new BacktrackMaze(i - 1, j));
                i--;
            } else {
                stack.pop();
                if(stack.empty()){
                    break;
                }
                i = stack.peek().row;
                j = stack.peek().col;
            }
 
        }
 
        Stack<BacktrackMaze> newPos = new Stack<BacktrackMaze>();
        if (stack.empty()) {
            System.out.println("没有路径");
        } else {
            System.out.println("有路径");
            System.out.println("路径如下：");
            while (!stack.empty()) {
            	BacktrackMaze pos = new BacktrackMaze();
                pos = stack.pop();
                newPos.push(pos);
            }
        }
         
        /*
         * 图形化输出路径
         * */
         
        String resault[][]=new String[row+1][col+1];
        for(int k=0;k<row;++k){
            for(int t=0;t<col;++t){
                resault[k][t]=(maze[k][t])+"";
            }
        }
        while (!newPos.empty()) {
        	BacktrackMaze p1=newPos.pop();
            resault[p1.row-1][p1.col-1]="#";
         
        }
         
        for(int k=0;k<row;++k){
            for(int t=0;t<col;++t){
                System.out.print(resault[k][t]+"\t");
            }
            System.out.println();
        }
     
 
    }
 
    int maze[][];
    private int row = 9;
    private int col = 8;
    Stack<BacktrackMaze> stack;
    boolean p[][] = null;
}
 
//class hello{
//    public static void main(String[] args){
//        Maze demo = new Maze();
//        demo.init();
//        demo.findPath();
//    }
//}
