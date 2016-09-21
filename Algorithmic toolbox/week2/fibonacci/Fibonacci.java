import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }
  
  private static long calc_fib_fast(int n){
	if(n<=1){
		return n;
	}
	long[] arr = new long[n+1];
	arr[0] = 0;
	arr[1] = 1;
	for(int i=2; i<=n; ++i){
		arr[i] = arr[i-1] + arr[i-2];
	}
	return arr[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_fast(n));
  }
}
