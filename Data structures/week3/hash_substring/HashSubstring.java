import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;
	
    private static int prime = 1000000007;
    private static int multiplier = 263;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }
	
	private static int hashFunc(String s) {
        int hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = ((hash * multiplier)%prime + s.charAt(i)) % prime;
        return hash;
    }

    private static List<Integer> getOccurrences(Data input) {
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
		if(m>n){
			return new ArrayList<Integer>();
		}
		
		int patternHash = hashFunc(s);
		List<Integer> occurrences = new ArrayList<Integer>();
		int nextHash = hashFunc(t.substring(0, m));
		System.out.println(patternHash + " " + nextHash);
		if(nextHash == patternHash){
			occurrences.add(0);
		}
		for(int i=1; i<=n-m; ++i){
			nextHash = (nextHash - t.charAt(i-1))/multiplier;
			nextHash = (int)(nextHash + t.charAt(i+m-1)*Math.pow(multiplier, m-1)%prime)%prime;
			//nextHash = nextHash%(n-m+1);
			System.out.println(patternHash + " " + nextHash);
			if(nextHash == patternHash){
				occurrences.add(i);
			}
		}
		
        
        /* for (int i = 0; i + m <= n; ++i) {
			boolean equal = true;
			for (int j = 0; j < m; ++j) {
				if (s.charAt(j) != t.charAt(i + j)) {
					 equal = false;
					break;
				}
			}
			if (equal)
				occurrences.add(i);
		} */
        return occurrences;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

