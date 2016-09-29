import java.util.*;

public class Reachability {
	
	private static class Graph{
		boolean isVisited;
		int val;
		List<Graph> children;
		Graph(int val){
			this.val = val;
			children = new ArrayList<Graph>();
		}
		
		void add(Graph g){
			children.add(g);
		}
	}
	
    private static int reach(Graph s, Graph d) {
		s.isVisited = true;
        for(Graph c:s.children){
			if(!c.isVisited){
				if(c == d){
					return 1;
				}else{
					int temp = reach(c,d);
					if(temp == 1){
						return 1;
					}
				}
			}
		}
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Graph[] graphs = new Graph[n];
        for (int i = 0; i < n; i++) {
            graphs[i] = new Graph(i+1);
        }
		
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            graphs[x - 1].add(graphs[y - 1]);
            graphs[y - 1].add(graphs[x - 1]);
        }
		
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(graphs[x], graphs[y]));
    }
}

