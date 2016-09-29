import java.util.*;

public class Toposort {
	
	private static class Graph{
		int val;
		boolean visited;
		int preOrder, postOrder;
		List<Graph> children;
		
		Graph(int v){
			val = v;
			children = new ArrayList<Graph>();
		}
		
		void add(Graph g){
			children.add(g);
		}
	}
	
	static int postOrder;
	private static void explore(Graph g, List<Integer> orders){
		g.visited = true;
		//pre order
		++postOrder;
		g.preOrder = postOrder;
		
		for(Graph c:g.children){
			if(!c.visited){
				explore(c, orders);
			}
		}
		
		//postOrder
		++postOrder;
		g.postOrder = postOrder;
		orders.add(g.val);
	}
	
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        ArrayList<Integer> order = new ArrayList<Integer>();
        
		//initialize the graph
        Graph[] graphs = new Graph[adj.length];
		for(int i=0; i<adj.length; ++i){
			graphs[i] = new Graph(i+1);
		}
		
		//initialize the edges
		for(int i=0; i<adj.length; ++i){
			List<Integer> edges = adj[i];
			for(int edge:edges){
				graphs[i].add(graphs[edge]);
			}
		}
		
		for(int i=0; i<adj.length; ++i){
			if(!graphs[i].visited){
				explore(graphs[i], order);
			}
		}
		
        return order;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = toposort(adj);
        for (int i=order.size()-1; i>=0; --i) {
            System.out.print(order.get(i) + " ");
        }
    }
}

