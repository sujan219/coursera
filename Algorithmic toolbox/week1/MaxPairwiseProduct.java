import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long)numbers[i] * numbers[j] > result) {
                    result = (long) numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }
	
	static long getMaxPairwiseProductFast(int[] numbers){
		int max1 = 0;
		int max2 = -1;
		
		for(int i=0; i<numbers.length; ++i){
			if(numbers[i]>numbers[max1]){
				max1 = i;
			}
		}
		
		for(int i=0; i<numbers.length; ++i){
			if((max2 == -1 || numbers[i]>numbers[max2]) && i != max1 ){
				max2 = i;
			}
		}
		
		//System.out.println("Max: " + max1 + " " + max2);
		
		return (long)numbers[max1]*numbers[max2];
	}

    public static void main(String[] args) {
		
		/*while(true){
			int n = 50000000;
			int[] no = new int[n];
			for(int i=0; i<n; ++i){
				no[i] = (int)(Math.random()*500000000);
			}
			
			for(int n1:no){
				System.out.print(n1 + " ");
			}
			System.out.println();
			
			if(getMaxPairwiseProduct(no) == getMaxPairwiseProductFast(no)){
				System.out.println("OK");
			}else{
				System.out.println("WRONG");
				System.out.println(getMaxPairwiseProduct(no) + " " + getMaxPairwiseProductFast(no));
				break;
			}
		}*/
		
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}