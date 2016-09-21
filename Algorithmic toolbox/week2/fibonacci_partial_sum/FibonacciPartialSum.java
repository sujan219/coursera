import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
	
	private static int getFibonacciPartialSumFast(long m, long n) {
		if(n<2){
			return (int)n;
		}
		
		int mm = 10;
        int[] arr = new int[100];
		arr[0] = 0;
		arr[1] = 1;
		int i=2;
		for(; i<=100; ++i){
			arr[i] = (arr[i-1] + arr[i-2])%(mm);
			debugInline(arr[i]+" ");
			if(arr[i] == 0 && arr[i-1] == 1){
				break;
			}
		}
		--i;
		debug();
		debug("I: " + i);
		
		long offset = (long)(n-m+1)/(i+1);
		debug("offset: " + offset);
		//n = (n-m+1)%(i+1);
		int sum = 0;
		for(int a=0; a<=i; ++a){
			sum += ((long)arr[a]*offset)%10;
		}
		debug("Sum: " + sum);
		n -= (i+1)*offset;
		debug("M: " + m + " N: " + n);
		for(long a=m; a<=n; ++a){
			sum += arr[(int)(a%(i+1))];
		}
		debug("Sum: " + sum);
		return sum%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
	
	
	private static void debug(String s){
		//System.out.println(s);
	}
	
	private static void debugInline(String s){
		//System.out.print(s);
	}
	
	private static void debug(){
		debug("");
	}
}

