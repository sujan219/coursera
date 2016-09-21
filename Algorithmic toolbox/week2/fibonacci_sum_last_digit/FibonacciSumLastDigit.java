import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum += current%10;
        }
		debug("Naive sum: " + sum);
        return sum % 10;
    }
	
	private static int getFibonacciSumFast(long n) {
		if(n<2){
			return (int)n;
		}
		
		int m = 10;
        int[] arr = new int[100];
		arr[0] = 0;
		arr[1] = 1;
		int i=2;
		for(; i<=n; ++i){
			arr[i] = (arr[i-1] + arr[i-2])%(m);
			debugInline(arr[i]+" ");
			if(arr[i] == 0 && arr[i-1] == 1){
				break;
			}
		}
		--i;
		debug();
		debug("I: " + i);
		long offset = (long)(n+1)/(i+1);
		debug("offset: " + offset);
		n = (n+1)%(i+1);
		int sum = 0;
		for(int a=0; a<=i; ++a){
			sum += ((long)arr[a]*offset)%10;
		}
		debug("Sum: " + sum);
		debug("N: " + n);
		for(int a=0; a<n; ++a){
			sum += arr[a]%10;
		}
		debug("Sum: " + sum);
		return sum%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
		
		//for(int i=0; i<300; ++i){
			//System.out.println("----Checking for" + i + "----");
			//long n = i;
			//long s = getFibonacciSumNaive(n);
			long s2 = getFibonacciSumFast(n);
			//System.out.println(s);
			System.out.println(s2);
			//if(s != s2){
				//System.out.println("WRONG");
				//break;
			//}
		//}
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

