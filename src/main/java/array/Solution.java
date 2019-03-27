package array;

/**
 * 买股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 eg:
 输入: [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * @author Franco_Q
 * @date 2019/3/27 11:19
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length ==0) {
            return 0;
        }
        int profit = 0;
        for (int i= 1;i<prices.length;i++) {
            if (prices[i] > prices[i-1]) {
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
