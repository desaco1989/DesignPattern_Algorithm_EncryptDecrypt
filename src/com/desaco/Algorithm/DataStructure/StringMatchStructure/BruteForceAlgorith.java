package com.desaco.Algorithm.DataStructure.StringMatchStructure;

/**
 * Brute-Force算法,模式匹配。时间复杂度最坏为O(mn)
 * 
 * http://blog.csdn.net/chndata/article/details/43792363
 * 
 * 从目标字符串初始位置开始，依次分别与Pattern的各个位置的字符比较，如相同，比较下一个位置的字符直至完全匹配；
 * 如果不同则跳到目标字符串下一位置继续如此与Pattern比较，直至找到匹配字符串并返回其位置。
 * 
 * @author desaco
 *
 */
public class BruteForceAlgorith {
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
		int index = -1;
		boolean match = true;

		for (int i = 0, len = source.length() - pattern.length(); i <= len; i++) {
			match = true;

			for (int j = 0; j < pattern.length(); j++) {
				if (source.charAt(i + j) != pattern.charAt(j)) {
					match = false;
					break;
				}
			}

			if (match) {
				index = i;
				break;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		int index = match("frgsgtrgwtsfgewrrgds", "rgd");
		System.out.println(index);
	}
}
