import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int dp[][] = new int[w.length+1][W+1];
		for(int a=w.length;a>0; --a){
			int itemIndex = w.length-a+1;
			int item = w[a-1];
			//System.out.println("ItenIndex: " + itemIndex + " " + item+": ");
			for(int i=1; i<=W; ++i){
				dp[itemIndex][i] = dp[itemIndex][i-1];
				if(item<=i){
					int remainingWeight = i - item;
					if(dp[itemIndex-1][remainingWeight] + item <= i){
						dp[itemIndex][i] = dp[itemIndex-1][remainingWeight] + item;
					}
				}
				dp[itemIndex][i] = Math.max(dp[itemIndex][i], dp[itemIndex-1][i]);
				//System.out.print(dp[itemIndex][i] + " ");
			}
			//System.out.println();
		}
		
		return dp[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

