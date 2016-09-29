import java.util.*;

public class StronglyConnected {
	
	private static class Graph{
		int val;
		boolean visited;
		int preOrder, postOrder;
		List<Graph> children;
		List<Graph> rChildren;
		
		Graph(int v){
			val = v;
			children = new ArrayList<Graph>();
			rChildren = new ArrayList<Graph>();
		}
		
		void add(Graph g){
			children.add(g);
		}
		
		void addR(Graph g){
			rChildren.add(g);
		}
	}
	
	static int postOrder;
	private static void explore(Graph g, List<Graph> orders){
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
		orders.add(g);
	}
	
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
		
		List<Graph> order = new ArrayList<Graph>();
		
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
				graphs[edge].addR(graphs[i]);
			}
		}
		
		for(int i=0; i<adj.length; ++i){
			if(!graphs[i].visited){
				explore(graphs[i], order);
			}
		}
		
		for(int i=0; i<adj.length; ++i){
			graphs[i].visited = false;
		}
		
		int count = 0;
		for(int i=order.size()-1; i>=0; --i){
			Graph g = order.get(i);
			if(!g.visited){
				exploreR(g);
				count++;
			}
		}
		
        return count;
    }
	
	private static void exploreR(Graph g){
		g.visited = true;
		for(Graph c:g.rChildren){
			if(!c.visited){
				exploreR(c);
			}
		}
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

