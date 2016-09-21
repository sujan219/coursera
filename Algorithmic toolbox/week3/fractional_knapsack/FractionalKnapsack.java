import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        while(capacity>0){
			int i = getMaxIndex(values, weights);
			if(i == -1)
				break;
			int min = Math.min(weights[i], capacity);
			capacity -= min;
			value += (double)min*values[i]/weights[i];
			weights[i] = 0;
			values[i] = 0;
		}

        return value;
    }
	
	private static int getMaxIndex(int[] values, int[] weights){
		int i=-1;
		double ratio = 0;
		for(int a=0;a<values.length; ++a){
			if(weights[a]>0 && (double)values[a]/weights[a]>ratio){
				ratio = (double)values[a]/weights[a];
				i = a;
			}
		}
		return i;
	}

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(String.format("%.4f",getOptimalValue(capacity, values, weights)));
    }
} 
