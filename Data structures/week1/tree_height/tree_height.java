import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class Tree{
		int n;
		List<Tree> children;
		public Tree(int n){
			this.n = n;
			children = new ArrayList<Tree>();
		}
	}
	
	public class TreeHeight {
		int n;
		Tree[] parent;
		Tree root;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new Tree[n];
			for (int i = 0; i < n; i++) {
				parent[i] = new Tree(i);
			}
			
			for (int i = 0; i < n; i++) {
				int no = in.nextInt();
				if(no == -1){
					root = parent[i];
				}else{
					parent[no].children.add(parent[i]);
				}
			}
		}

		int computeHeight() {
            return computeHeightHelper(root);
		}
		
		int computeHeightHelper(Tree node){
			if(node == null){
				return 0;
			}
			
			int height = 0;
			for(Tree child:node.children){
				height = Math.max(height, computeHeightHelper(child));
			}
			
			return 1+height;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
