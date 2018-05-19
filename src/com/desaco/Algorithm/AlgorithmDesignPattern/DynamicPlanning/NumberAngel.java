package com.desaco.Algorithm.AlgorithmDesignPattern.DynamicPlanning;

/**
 * 动态规划法
 * 
 * 计算数字三角形
 * @author Aaron
 * @blog http://blog.csdn.net/lemon_tree12138
 * 2015年8月1日
 */
public class NumberAngel {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4, 10, 1, 4, 3, 2, 20};
        
        calculateByRecall(a);
        
        calculateByRecursion(a);
        
        calculateByMemory(a);
    }
    
    /**
     * 计算二维矩阵的行数
     */
    private static int getRawNumber(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        
        return (int) Math.sqrt(a.length * 2);
    }
    
    /**
     * 将一维数组转化为二维数组
     * @author Aaron
     * @blog http://blog.csdn.net/lemon_tree12138
     * 2015年8月1日
     */
    private static int[][] getMatrix(int[] a) {
        int n = getRawNumber(a);
        int[][] m = new int[n][n];
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (j <= i) {
                    m[i][j] = a[i * (i + 1) / 2 + j];
                }
            }
        }
        
        return m;
    }
    
    /**
     * 通过回溯法获得第(i, j)处的最大值
     * @author Aaron
     * 2015年8月2日
     */
    private static int getNodeMaxByRecall(int[][] m, int i, int j) {
        int max = Integer.MIN_VALUE;
        
        System.out.println("m[" + i + "][" + j + "]");
        
        max = m[i][j] + (i == m.length - 1 ? 0 : Math.max(getNodeMaxByRecall(m, i + 1, j), getNodeMaxByRecall(m, i + 1, j + 1)));
        
        return max;
    }
    
    /**
     * 算法之动态规划初步
     * 
     * 回溯法求解
     * @author Aaron
     * 2015年8月1日
     */
    public static void calculateByRecall(int[] a) {
        int[][] m = getMatrix(a);
        
        int max = getNodeMaxByRecall(m, 0, 0);
        
        System.out.println("max[0][0] = " + max);
    }
    
    /**
     * 通过递推法获得第(i, j)处的最大值
     * @author Aaron
     * 2015年8月2日
     */
    private static int getNodeMaxByRecursion(int[][] m, int i, int j) {
        int max = Integer.MIN_VALUE;
        
        System.out.println("m[" + i + "][" + j + "]");
        
        max = m[i][j] + (i == m.length - 1 ? 0 : Math.max(m[i + 1][j], m[i + 1][j + 1]));
        
        return max;
    }
    
    /**
     * 递推法求解
     * @author Aaron
     * 2015年8月2日
     */
    private static void calculateByRecursion(int[] a) {
        int[][] m = getMatrix(a);
        
        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                m[i][j] = getNodeMaxByRecursion(m, i, j);
            }
        }
        
        int max = m[0][0];
        
        System.out.println("max[0][0] = " + max);
    }
    
    private static int[][] initMatrix(int n) {
        int[][] m = new int[n][n];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = -1;
            }
        }
        
        return m;
    }
    
    /**
     * 将一维数组转化为二维数组
     * @author Aaron
     * @blog http://blog.csdn.net/lemon_tree12138
     * 2015年8月1日
     */
    private static int[][] getMatrix2(int[] a) {
        int n = getRawNumber(a);
        int[][] m = initMatrix(n);
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (j <= i) {
                    m[i][j] = a[i * (i + 1) / 2 + j];
                }
            }
        }
        
        return m;
    }
    
    /**
     * 通过记忆化搜索获得第(i, j)处的最大值
     * @author Aaron
     * 2015年8月2日
     */
    private static int getNodeMaxByMemory(int[][] m, int[][] d, int i, int j) {
        if (d[i][j] >= 0) {
            return d[i][j];
        }
        
        System.out.println("m[" + i + "][" + j + "]");
        
        d[i][j] = m[i][j] + (i == m.length - 1 ? 0 : Math.max(getNodeMaxByMemory(m, d, i + 1, j), getNodeMaxByMemory(m, d, i + 1, j + 1)));
        
        return d[i][j];
    }
    
    /**
     * 记忆化搜索
     * @author Aaron
     * 2015年8月2日
     */
    private static void calculateByMemory(int[] a) {
        int[][] m = getMatrix2(a);
        
        int[][] d = initMatrix(m.length);
        
        int max = getNodeMaxByMemory(m, d, 0, 0);
        
        System.out.println("max[0][0] = " + max);
    }
}
