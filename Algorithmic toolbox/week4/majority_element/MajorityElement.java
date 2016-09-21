import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        } else if (left + 1 == right) {
            return a[left] == a[right] ? a[left] : -1;
        }
		
		
		int mid = left + (right-left)/2;
        int m1 = getMajorityElement(a, left, mid);
		int m2 = getMajorityElement(a, mid+1, right);
		int c1 = 0;
		int c2 = 0;
		
		for(int i=left; i<=right; ++i){
			if(m1 == a[i]){
				++c1;
			}else if(m2 == a[i]){
				++c2;
			}
		}
		
		int length = right - left + 1;
		if(c1>c2 && c1>length/2){
			return m1;
		} else if (c2>c1 && c2>length/2){
			return m2;
		}else{
			return -1;
		}
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
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

