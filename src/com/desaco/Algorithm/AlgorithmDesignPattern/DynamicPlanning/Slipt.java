package com.desaco.Algorithm.AlgorithmDesignPattern.DynamicPlanning;

/**
 * 算法之动态规划初步
 * 
 * 切割钢条
 * @author Aaron
 * @blog http://blog.csdn.net/lemon_tree12138
 * 2015年8月2日
 */
public class Slipt {

    /** 价格表 */
    private static final int[] PRICE_LIST_RAW = {
        1, 1,
        2, 5,
        3, 8,
        4, 9,
        5, 10,
        6, 17,
        7, 17,
        8, 20,
        9, 24,
        10, 30
    };
    private static int[][] PRICE_LIST = new int[10][2];
    
    private static void initPriceList() {
        for (int i = 0; i < PRICE_LIST.length; i++) {
            for (int j = 0; j < PRICE_LIST[i].length; j++) {
                PRICE_LIST[i][j] = PRICE_LIST_RAW[i * 2 + j];
            }
        }
    }
    
    /**
     * 计算长度为n的钢条的最佳切割方案(递归)
     * @author Aaron
     * 2015年8月3日
     */
    private static int getMax(int[] p, int n) {
        System.out.println(n);
        if (n <= 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, p[i - 1] + getMax(p, n - i));
        }
        
        return max;
    }
    
    /**
     * 通过递归计算钢条的切割算法
     * @author Aaron
     * 2015年8月3日
     */
    private static void calculateMaxByRecursive(int n) {
        initPriceList();
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        
        int max = getMax(p, n);
        
        System.out.println("max = " + max);
    }
    
    private static int[] getRecordArray(int n) {
        if (n <= 0) {
            return null;
        }
        
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        
        return r;
    }
    
    /**
     * 计算长度为n的钢条的最佳切割方案(记忆化搜索)
     * @author Aaron
     * 2015年8月3日
     */
    private static int getMaxByMemory(int[] p, int n, int[] r) {
        if (n <= 0) {
            return 0;
        }
        
        if (r[n] >= 0) {
            return r[n];
        }
        
        System.out.println(n);
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, p[i - 1] + getMaxByMemory(p, n - i, r));
        }
        
        r[n] = max;
        
        return max;
    }
    
    /**
     * 通过记忆化搜索计算钢条的切割算法
     * @author Aaron
     * 2015年8月3日
     */
    private static void calculateMaxByMemory(int n) {
        initPriceList();
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        
        int[] r = getRecordArray(n + 1);
        
        int max = getMaxByMemory(p, n, r);
        
        System.out.println("max = " + max);
    }
    
    public static void main(String[] args) {
        calculateMaxByRecursive(7);
        
        calculateMaxByMemory(7);
    }
}
