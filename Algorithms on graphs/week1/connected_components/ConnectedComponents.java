import java.util.*;

public class ConnectedComponents {
	
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
	
    private static int numberOfComponents(Graph[] graphs) {
		int counter = 0;
        for(Graph g:graphs){
			if(!g.isVisited){
				++counter;
				traverse(g);
			}
		}
        return counter;
    }
	
	private static void traverse(Graph g){
		g.isVisited = true;
		for(Graph c:g.children){
			if(!c.isVisited){
				traverse(c);
			}
		}
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
        System.out.println(numberOfComponents(graphs));
    }
}

