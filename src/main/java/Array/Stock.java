package Array;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
public class Stock {

	public static void main(String[] args) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.println(maxProfit(prices));// brute force
		System.out.println(maxProfitV1(prices));// one passs
		System.out.println(maxProfitV2(prices));//multiple transaction
        
	}

	private static int maxProfitV2(int[] prices) {
		
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int maxProfit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			
			if(prices[i]>prices[i-1]) {
				maxProfit = maxProfit + prices[i]-prices[i-1];
			}
		}

		return maxProfit;
	}

	private static int maxProfitV1(int[] prices) {

		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {

			minPrice = Math.min(minPrice, prices[i]);

			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}

		return maxProfit;

	}

	private static int maxProfit(int[] prices) {

		if (prices.length == 0 || prices == null) {
			return 0;
		}

		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {

				maxProfit = Math.max(maxProfit, prices[j] - prices[i]);

			}
		}

		return maxProfit;
	}

}
