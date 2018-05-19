package com.desaco.Algorithm.AlgorithmDesignPattern.DynamicPlanning;

/**
 * 动态规划过程
 * 
 * http://blog.csdn.net/p10010/article/details/50196211
 * 
 * 动态规划过程是：每次决策依赖于当前状态，又随即引起状态的转移。一个决策序列就是在变化的状态中产生出来的，所以，
 * 这种多阶段最优化决策解决问题的过程就称为动态规划。
 * 
 * 基本思想与分治法类似，也是将待求解的问题分解为若干个子问题（阶段），按顺序求解子阶段，前一子问题的解，为后一子问题的求解提供了有用的信息。
 * 在求解任一子问题时，列出各种可能的局部解，通过决策保留那些有可能达到最优的局部解，丢弃其他局部解。依次解决各子问题，最后一个子问题就是初始问题的解。
 * 
 * 与分治法最大的差别是：适合于用动态规划法求解的问题，经分解后得到的子问题往往不是互相独立的（即下一个子阶段的求解是建立在上一个子阶段的解的基础上，
 * 进行进一步的求解）。
 * 
 * @author desaco
 *
 */
public class DynamicPlanningAlgorithm {
	/**
	 * 1.找零钱问题 
	 * 
	 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(
	 * 小于等于1000)代表要找的钱数，求换钱有多少种方法。
	 * 
	 * @param penny
	 * @param n
	 * @param aim
	 * @return
	 */
	public static int lookingForChange(int[] penny, int n, int aim) {
		if (n == 0 || penny == null || aim < 0) {
			return 0;
		}
		int[][] pd = new int[n][aim + 1];
		for (int i = 0; i < n; i++) {
			pd[i][0] = 1;
		}
		for (int i = 1; penny[0] * i <= aim; i++) {
			pd[0][penny[0] * i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= aim; j++) {
				if (j >= penny[i]) {
					pd[i][j] = pd[i - 1][j] + pd[i][j - penny[i]];
				} else {
					pd[i][j] = pd[i - 1][j];
				}
			}
		}
		return pd[n - 1][aim];
	}

	/**
	 * 2.走方格问题
	 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
	 * 返回所有的路径中最小的路径和。 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
	 * 
	 * @param map
	 * @param n
	 * @param m
	 * @return
	 */
	public static int minPathOfBox(int[][] map, int n, int m) {
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][0] += map[j][0];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= i; j++) {
				dp[0][i] += map[0][j];
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = min(dp[i][j - 1] + map[i][j], dp[i - 1][j] + map[i][j]);
			}
		}
		return dp[n - 1][m - 1];
	}

	public static int min(int a, int b) {
		if (a > b) {
			return b;
		} else {
			return a;
		}
	}

	/**
	 * 3. n级台阶
	 * 
	 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007 给定一个正整数int
	 * n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
	 * 
	 * @param n
	 * @return
	 */
	public static int goUpSteps(int n) {
		if (n <= 2)
			return n;
		int f = 1 % 1000000007;
		int s = 2 % 1000000007;
		int t = 0;
		for (int i = 3; i <= n; i++) {
			t = (f + s) % 1000000007;
			f = s;
			s = t;
		}
		return t;
	}

	/**
	 * 4.最长公共子序列
	 * 
	 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”
	 * 123456"或者"12C4B6"都是最长公共子序列。
	 * 
	 * @param A
	 * @param n
	 * @param B
	 * @param m
	 * @return
	 */
	public static int maxOfCommonSequences(String A, int n, String B, int m) {
		int[][] dp = new int[n][m];
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		for (int i = 0; i < n; i++) {
			if (a[i] == b[0]) {
				dp[i][0] = 1;
				for (int j = i + 1; j < n; j++) {
					dp[j][0] = 1;
				}
				break;
			}

		}
		for (int i = 0; i < m; i++) {
			if (a[0] == b[i]) {
				dp[0][i] = 1;
				for (int j = i + 1; j < m; j++) {
					dp[0][j] = 1;
				}
				break;
			}

		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (a[i] == b[j]) {
					dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1]);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}
		}

		return dp[n - 1][m - 1];
	}

	public static int max(int a, int b, int c) {
		int max = a;
		if (b > max)
			max = b;
		if (c > max)
			max = c;
		return max;
	}
	public static void main(String[] args) {
		int[] a={3,58,8,5,3,56,33,66,8,9,1,2,5,6,7,8,12,34,56,43,76,23,56,56};
		//1.找零钱问题 
		System.out.println("1.找零钱问题 ");
		System.out.println(lookingForChange(a,3,130));
		//走方格问题
		System.out.println("2.走方格问题 ");
		int[][] box = {{1,2,3},{1,1,1}};
		int min = minPathOfBox(box,2,3);
		System.out.println(min);
		//走台阶问题
		System.out.println("3.走台阶问题");
		int steps = goUpSteps(50);
		System.out.println(steps);

		//最长公共序列数  System.out.println();
		String sourceStr = "1A2C3D4B56";
		String patternStr="B1D23CA45B6A";
		 System.out.println("4.最长公共序列数");
		int lcs = maxOfCommonSequences(sourceStr,sourceStr.length(),patternStr,patternStr.length());
		 System.out.println(lcs);
		
	}
}
