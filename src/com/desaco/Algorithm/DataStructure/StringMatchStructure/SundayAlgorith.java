package com.desaco.Algorithm.DataStructure.StringMatchStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * http://blog.csdn.net/chndata/article/details/43792363
 * 
 * Sunday算法
 * 
 * Sunday算法的思想和BM算法中的坏字符思想非常类似。差别只是在于Sunday算法在匹配失败之后，
 * 是取String串中当前和Pattern字符串对应的部分后面一个位置的字符来做坏字符匹配。当发现匹配失败的时候就判断母串中当前偏移量+
 * Pattern字符串长度
 * (假设为K位置)的字符在Pattern字符串中是否存在。如果存在，则将该位置和Pattern字符串中的该字符对齐，再从头开始匹配；如果不存在，
 * 就将Pattern字符串向后移动，和母串k处的字符对齐，再进行匹配。重复上面的操作直到找到，或母串被找完结束。
 * 
 * 该算法最坏情况下的时间复杂度为O(NM)。对于短模式串的匹配问题，该算法执行速度较快。
 * 
 * @author desaco
 *
 */
public class SundayAlgorith {
	private static int currentPos = 0;

	// 匹配字符的Map,记录改匹配字符串有哪些char并且每个char最后出现的位移
	private static Map<Character, Integer> map = new HashMap<Character, Integer>();

	// Sunday匹配时，用来存储Pattern中每个字符最后一次出现的位置，从右到左的顺序
	public static void initMap(String pattern) {
		for (int i = 0, plen = pattern.length(); i < plen; i++) {
			map.put(pattern.charAt(i), i);
		}
	}

	/**
	 * Sunday匹配，假定Text中的K字符的位置为：当前偏移量+Pattern字符串长度+1
	 *
	 * @param source
	 *            目标字符串
	 * @param pattern
	 *            指定字符串
	 * @return 指定字符串在目标字符串中的位置
	 */
	public static int match(String source, String pattern) {
		int slen = source.length();
		int plen = pattern.length();

		// 当剩下的原串小于指定字符串时，匹配不成功
		if ((slen - currentPos) < plen) {
			return -1;
		}

		// 如果没有匹配成功
		if (!isMatchFromPos(source, pattern, currentPos)) {
			int nextStartPos = currentPos + plen;

			// 如果移动位置正好是结尾，即是没有匹配到
			if ((nextStartPos) == slen) {
				return -1;
			}

			// 如果匹配的后一个字符没有在Pattern字符串中出现，则跳过整个Pattern字符串长度
			if (!map.containsKey(source.charAt(nextStartPos))) {
				currentPos = nextStartPos;
			} else {
				// 如果匹配的后一个字符在Pattern字符串中出现，则将该位置和Pattern字符串中的最右边相同字符的位置对齐
				currentPos = nextStartPos - (Integer) map.get(source.charAt(nextStartPos));
			}

			return match(source, pattern);
		} else {
			return currentPos;
		}
	}

	/**
	 * 检查从Text的指定偏移量开始的子串是否和Pattern匹配
	 *
	 * @param source
	 *            目标字符串
	 * @param pattern
	 *            指定字符串
	 * @param pos
	 *            起始位置
	 * @return 是否匹配
	 */
	private static boolean isMatchFromPos(String source, String pattern, int pos) {
		for (int i = 0, plen = pattern.length(); i < plen; i++) {
			if (source.charAt(pos + i) != pattern.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}
