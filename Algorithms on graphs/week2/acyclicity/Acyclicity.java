import java.util.*;

public class Acyclicity {
	
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
	
    private static int acyclic(ArrayList<Integer>[] adj) {
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
			if(explore(graphs[i])){
				return 1;
			}
		}
		
        return 0;
    }
	
	static int postOrder;
	private static boolean explore(Graph g){
		g.visited = true;
		//pre order
		++postOrder;
		g.preOrder = postOrder;
		
		for(Graph c:g.children){
			if(c.preOrder>0 && c.postOrder == 0){
				//System.out.println("graph: " + g.val);
				return true;
			}else if(!c.visited){
				if(explore(c)){
					return true;
				}
			}
		}
		
		//postOrder
		++postOrder;
		g.postOrder = postOrder;
		return false;
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
        System.out.println(acyclic(adj));
    }
}

