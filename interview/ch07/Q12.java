package interview.ch07;

public class Q12 {
    public static void main(String[] args) {
        int[] prices = new int[]{8,1,5,3,6,4};

        Q12 q = new Q12();
        int result = q.maxProfit2(prices);
        System.out.println("result => " + result);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // 구매 시점 순회, 처음부터 끝까지 차례대로 반복한다.
        for (int i = 0; i < prices.length - 1; i++) {
            // 판매 시점 순회, 구매 다음부터 끝까지 차례대로 반복한다.
            for (int j = i+1; j < prices.length; j++) {
                // 판매 시점 가격에서 구매 시점 가격을 뺄 때 가장 높은 금액 찾기
                maxProfit  = Math.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        // 최대 이익은 0, 저점은 임시로 첫 번째 값으로 지정
        int maxProfit = 0, minPrice = prices[0];
        // 현재 값을 우측으로 차례대로 이동하면서 계산
        for (int price : prices) {
            // 지금까지 저점 계산
            minPrice = Math.min(minPrice, price);
            // 현재 값과 저점의 차이가 최대 이익인 경우 교체
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
