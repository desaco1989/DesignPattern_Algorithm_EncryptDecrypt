package com.desaco.Algorithm.DataStructure.SearchStructure;

/**
 * http://www.cnblogs.com/wxd0108/p/5465926.html
 * 
 * 二分查找又称折半查找，它是一种效率较高的查找方法。
 * 
 * 折半查找的算法思想是将数列按有序化(递增或递减)排列，查找过程中采用跳跃式方式查找，即先以有序数列的中点位置为比较对象，如果要找的元素值小
 * 于该中点元素，则将待查序列缩小为左半部分，否则为右半部分。通过一次比较，将查找区间缩小一半。
 * 折半查找是一种高效的查找方法。它可以明显减少比较次数，提高查找效率。但是，折半查找的先决条件是查找表中的数据元素必须有序。
 * 
 * 折半查找法的优点是比较次数少，查找速度快，平均性能好;其缺点是要求待查表为有序表，且插入删除困难。因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 * 
 * @author desaco
 * 
 */
public class BinarySearch {
	/** 
	 * http://www.cnblogs.com/wxd0108/p/5465926.html
	 * 
     * 二分查找算法 
     * 
     * @param srcArray 有序数组 
     * @param key 查找元素 
     * @return key的数组下标，没找到返回-1 
     */  
     public static void main(String[] args) { 
         int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};  
         System.out.println("----------------二分查找递归实现------------------");
         binSearch(srcArray, 0, srcArray.length - 1, 81);
         System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 81));  
         
         System.out.println("----------------二分查找普通循环实现------------------");
         int srcArray2[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
         System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 21));
     } 

     // 二分查找递归实现   
     public static int binSearch(int srcArray[], int start, int end, int key) {   
         int mid = (end - start) / 2 + start;   
         if (srcArray[mid] == key) {   
             return mid;   
         }   
         if (start >= end) {   
             return -1;   
         } else if (key > srcArray[mid]) {   
             return binSearch(srcArray, mid + 1, end, key);   
         } else if (key < srcArray[mid]) {   
             return binSearch(srcArray, start, mid - 1, key);   
         }   
         return -1;   
     } 

     // 二分查找普通循环实现   
     public static int binSearch(int srcArray[], int key) {   
         int mid = srcArray.length / 2;   
         if (key == srcArray[mid]) {   
             return mid;   
         }   

         int start = 0;   
         int end = srcArray.length - 1;   
         while (start <= end) {   
             mid = (end - start) / 2 + start;   
             if (key < srcArray[mid]) {   
                end = mid - 1;   
             } else if (key > srcArray[mid]) {   
                 start = mid + 1;   
             } else {   
                 return mid;   
             }   
         }   
         return -1;   
     } 
}
