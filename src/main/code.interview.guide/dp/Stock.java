package dp;

public class Stock {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int profit = 0;
        int minvalue = prices[0];
        for(int i = 1; i < prices.length; i++){
            if (prices[i] < minvalue){
                minvalue = prices[i];
            }
            if (prices[i] > minvalue) {
                profit = Math.max(prices[i] - minvalue,profit);
            }
        }
        return profit;
    }

    /** 两次买卖
     *  每天都有四个状态，第一个买入，卖出收益；第二次买入，卖出；
     * */
    public int maxProfit2(int[] prices) {
        int fstbuy = Integer.MIN_VALUE,fstsell = 0;
        int secbuy = Integer.MIN_VALUE,secsell = 0;
        for(int p:prices){
            fstbuy = Math.max(fstbuy,-p);
            fstsell = Math.min(secsell,p-fstbuy);
            secbuy = Math.max(secbuy,fstsell-p);
            secsell = Math.max(secsell,p-secbuy);
        }
        return secsell;
    }
}
