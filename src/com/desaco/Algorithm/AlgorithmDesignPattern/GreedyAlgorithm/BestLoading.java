package com.desaco.Algorithm.AlgorithmDesignPattern.GreedyAlgorithm;

/**
 * 【贪心算法】背包问题,最优装载问题
 * 
 * 一个贪心算法里面就隐含了这么多不同的场景实现，每个场景下的算法就有多种不同的实现，个人写法不一也成就了各种不同的漂亮算法，看了这些实现，也让我开拓了思维，
 * 这个世界的方案永远没有最完美的只有最合适的～ ！
 * 
 * http://blog.csdn.net/lican19911221/article/details/24701525
 * 
 * @author desaco
 *
 */
public class BestLoading {
	public float loading(float c, float[] w, int[] x) {
		int n = w.length;
		Element[] d = new Element[n];
		for (int i = 0; i < n; i++) {
			d[i] = new Element(w[i], i);
		}
		java.util.Arrays.sort(d);
		for (int i = 0; i < n; i++)
			x[i] = 0;
		float op = 0;
		for (int i = 0; i < n && d[i].w <= c; i++) {
			op += d[i].w;
			c -= d[i].w;
			x[d[i].i] = 1;
		}
		return op;
	}

	static class Element implements Comparable {
		float w;
		int i;

		public Element(float ww, int ii) {
			w = ww;
			i = ii;
		}

		@Override
		public int compareTo(Object x) {// 按每个重量从小到大排列
			float xx = ((Element) x).w;
			if (this.w < xx)
				return -1;
			if (this.w == xx)
				return 0;
			return 1;
		}

	}

	public static void main(String[] args) {
		float w[] = { 20, 10, 26, 15 };// 下标从0开始
		float c = 70;
		int[] x = new int[w.length];
		BestLoading be = new BestLoading();
		System.out.println("最优得到装载重量为：" + be.loading(c, w, x));
		System.out.println("被装载的集装箱序号为(下标从0开始)：");
		for (int i = 0; i < w.length; i++) {
			if (x[i] == 1)
				System.out.print(i + " ");
		}
	}
}
