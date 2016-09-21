import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
	
	private static List<Integer> dpSoln(int n){
		int[] dp = new int[n+1];
		for(int i=0; i<n; ++i){
			dp[i] = i+1;
		}
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2; i<=n; ++i){
			dp[i] = dp[i-1] + 1;
			if(i%3 == 0){
				dp[i] = Math.min(dp[i/3] + 1, dp[i]);
			}else if(i%2 == 0){
				dp[i] = Math.min(dp[i/2] + 1, dp[i]);
			}
			
			//System.out.print(dp[i] + " ");
		}
		//System.out.println();
		
		
		
		List<Integer> list = new ArrayList<Integer>();
		int min = dp[n];
		list.add(n);
		for(int i=n-1; i>0; --i){
			if(dp[i]<min){
				list.add(i);
				min = dp[i];
			}
		}
		Collections.reverse(list);
		return list;
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dpSoln(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

