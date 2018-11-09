package com.desaco.Algorithm.CommonlyUsedAlgorithm.SelectSort;

/**
 * 选择排序：选取最大或最小的元素
 * 
 * 直接选择排序
 * 
 * 基本过程：假设一序列为R[0]~R[n-1]，第一次用R[0]和R[1]~R[n-1]相比较，若小于R[0]，则交换至R[0]位置上。
 * 第二次从R[1]~R[n-1]中选取最小值，与R[1]交换，....，第i次从R[i-1]~R[n-1]中选取最小值，与R[i-1]交换，.....，
 * 第n-1次从R[n-2]~R[n-1]中选取最小值，与R[n-2]交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 * 
 * 从待排序的元素集合中选取关键字最小的数据元素并将它与原始数据元素集合中的第一个数据元素交换位置；
 * 然后从不包括第一个位置的数据元素集合中选取关键字最小的数据元素并将它与原始数据集合中的第二个数据元素交换位置；
 * 如此重复，直到数据元素集合中只剩下一个数据元素为止
 * 
 * @author desaco
 *
 */
public class DirectSelectSort {

	public static void main(String[] args) {
           
    }
	
	//直接选择排序
	public void sort1(){
		int [] s = {8,3,2,1,7,4,6,5};
        int temp = 0;
        for(int i=0;i<s.length-1;i++){
            for(int j=i+1;j<s.length;j++){
                if(s[i]>s[j]){
                    temp=s[i];
                    s[i]=s[j];
                    s[j]=temp;
                }
            }
        }
        for(int value:s)
        System.out.println(value); 
	}
	
	//---------------------------------------------------------------
	//----------------------------------------------------------------
	//上面排序方法存在效率问题。因为当我们发现当前数比被比较数小的时候我们就交换两个数，
	//其实我们可以把当前数的位置保存下来，等到第一次比较完后在进行交换。
	public void optimizatSort(){
		int [] s = {8,3,2,1,7,4,6,5};
        int temp = 0;
        for(int i=0;i<s.length-1;i++){
            temp = i;
            for(int j=i+1;j<s.length;j++){
                if(s[temp]>s[j]){
                    temp=j;  //保存位置
                }
            }
            if(temp!=i) exchang(s,i,temp);  //进行交换
        }
        for(int value:s)
        System.out.print(value); 
	}
	private static void exchang(int[] s, int i, int j) {
        int temp = s[j];
        s[j]=s[i];
        s[i]=temp;    
    }
	
}
