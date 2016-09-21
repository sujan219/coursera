import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
	
	private static long getFibonacciHugeFast(long n, long m) {
        long[] arr = new long[10000000];
		arr[0] = 0;
		arr[1] = 1;
		int i=2;
		for(; i<=n; ++i){
			arr[i] = (arr[i-1] + arr[i-2])%(m*10);
			if(arr[i] == 0 && arr[i-1] == 1){
				break;
			}
		}
		n = n%i;
		return arr[(int)n]%m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}

