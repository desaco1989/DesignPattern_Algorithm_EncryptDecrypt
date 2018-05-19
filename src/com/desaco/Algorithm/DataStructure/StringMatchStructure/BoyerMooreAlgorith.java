package com.desaco.Algorithm.DataStructure.StringMatchStructure;

/**
 * Boyer-Moore算法,模式匹配
 * 
 * http://blog.csdn.net/chndata/article/details/43792363
 * 
 * Boyer-Moore算法是一种基于后缀匹配的模式串匹配算法，后缀匹配就是模式串从右到左开始比较，但模式串的移动还是从左到右的。
 * 字符串匹配的关键就是模式串的如何移动才是最高效的。BM的时间复杂度，最好O(n/m)，最坏O(n)，通常在longer pattern下BM表现更出色。
 * 
 * 尽可能的“向右滑动”模式串next数组对应位置的值。
 * 
 * 部分匹配还有更优化的最大右移量。
 * 
 * @author desaco
 *
 */
public class BoyerMooreAlgorith {
	/**
	 * 计算滑动距离
	 *
	 * @param c
	 *            主串（源串）中的字符
	 * @param T
	 *            模式串（目标串）字符数组
	 * @param noMatchPos
	 *            上次不匹配的位置
	 * @return 滑动距离
	 */
	private static int dist(char c, char T[], int noMatchPos) {
		int n = T.length;

		for (int i = noMatchPos; i >= 1; i--) {
			if (T[i - 1] == c) {
				return n - i;
			}
		}

		// c不出现在模式中时
		return n;
	}

	/**
	 * 找出指定字符串在目标字符串中的位置
	 *
	 * @param source
	 *            目标字符串
	 * @param pattern
	 *            指定字符串
	 * @return 指定字符串在目标字符串中的位置
	 */
	public static int match(String source, String pattern) {
		char[] s = source.toCharArray();
		char[] t = pattern.toCharArray();
		int slen = s.length;
		int tlen = t.length;

		if (slen < tlen) {
			return -1;
		}

		int i = tlen;
		int j = -1;

		while (i <= slen) {
			j = tlen;
			// S[i-1]与T[j-1]若匹配，则进行下一组比较；反之离开循环。
			while (j > 0 && s[i - 1] == t[j - 1]) {
				i--;
				j--;
			}

			// j=0时，表示完美匹配，返回其开始匹配的位置
			if (0 == j) {
				return i;
			} else {
				// 把主串和模式串均向右滑动一段距离dist(s[i-1]).
				i = i + dist(s[i - 1], t, j - 1);
			}
		}

		// 模式串与主串无法匹配
		return -1;
	}
}
