package com.desaco.Algorithm.DataStructure.StringMatchStructure;

/**
 * KMP算法， http://blog.csdn.net/chndata/article/details/43792363
 * 
 * 试图通过尽可能的“向右滑动”模式串next数组对应位置的值
 * 
 * KMP算法是一种改进的字符串匹配算法，关键是利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的。
 * 在BF算法的基础上使用next函数来找出下一次目标函数与Pattern比较的位置，因为BF算法每次移动一位的比较是冗余的，
 * KMP利用Pattern字符重复的特性来排除不必要的比较，从而可以每次移动n位来排除冗余。对于Next函数近似接近O(m)，
 * KMP算法的时间复杂度为O(n)，所以整个算法的时间复杂度为O(n+m)。
 * 
 * @author desaco
 *
 */
public class KMP_Algorith {
	/**
	 * 获得字符串的next函数值
	 *
	 * @param str
	 * @return next函数值
	 */
	private static int[] calculateNext(String str) {
		int i = -1;
		int j = 0;
		int length = str.length();
		int next[] = new int[length];
		next[0] = -1;

		while (j < length - 1) {
			if (i == -1 || str.charAt(i) == str.charAt(j)) {
				i++;
				j++;
				next[j] = i;
			} else {
				i = next[i];
			}
		}
		
//		int len = next.length;
//		if(len > 0){
//			for(int m=0;m<len;m++){
//				System.out.println("需要匹配的数组处理 后："+next[m]+" ");
//			}
//		}
		
		return next;
	}

	/**
	 * KMP匹配字符串，模式匹配
	 *
	 * @param source
	 *            目标字符串
	 * @param pattern
	 *            指定字符串
	 * @return 若匹配成功，返回下标，否则返回-1
	 */
	public static int match(String source, String pattern) {
		int i = 0;
		int j = 0;
		int input_len = source.length();
		int kw_len = pattern.length();
		int[] next = calculateNext(pattern);

		while ((i < input_len) && (j < kw_len)) {
			// 如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
			if (j == -1 || source.charAt(i) == pattern.charAt(j)) {
				j++;
				i++;
			} else {
				// 如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j],
				// next[j]即为j所对应的next值
				j = next[j];
			}
		}

		if (j == kw_len) {
			return i - kw_len;
		} else {
			return -1;
		}
	}
	public static void main(String[] args) {
		int index = match("frgsgtrgwtsfgewrrggds", "rrggd");
		System.out.println(index);
	}
	
}
