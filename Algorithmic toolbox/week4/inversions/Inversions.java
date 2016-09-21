import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a) {
        long numberOfInversions = 0;
        if (a.length == 1) {
            return numberOfInversions;
        }
		int[] ar1 = new int[a.length/2];
		int[] ar2 = new int[a.length - a.length/2];
		int i=0;
		for(; i<ar1.length; ++i){
			ar1[i] = a[i];
		}
		
		for(int j=0; i<a.length; ++i, ++j){
			ar2[j] = a[i];
		}
		
        numberOfInversions += getNumberOfInversions(ar1);
        numberOfInversions += getNumberOfInversions(ar2);
        
		//merge
		int x = 0, y = 0;
		while(x<ar1.length && y<ar2.length){
			if(ar1[x]<=ar2[y]){
				a[x+y] = ar1[x];
				++x;
			}else{
				a[x+y] = ar2[y];
				++y;
				numberOfInversions+=ar1.length-x;
			}
		}
		while(x<ar1.length){
			a[x+y] = ar1[x++];
		}
		while(y<ar2.length){
			a[x+y] = ar2[y++];
		}
		//System.out.println("I: " + numberOfInversions + ", l: " + a.length);
		
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getNumberOfInversions(a));
		for (int i = 0; i < n; i++) {
            //System.out.print(a[i] + " ");
        }
    }
}

