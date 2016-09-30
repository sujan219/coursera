import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
		int[] path = new int[cost.length];
		Arrays.fill(path, Integer.MAX_VALUE);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		path[s] = 0;
		while(!queue.isEmpty()){
			int no = queue.remove();
			for(int i=0; i<cost[no].size(); ++i){
				int c = cost[no].get(i);
				int a = adj[no].get(i);
				if(path[no]+c < path[a]){
					path[a] = path[no]+c;
					queue.add(a);
				}
			}
		}
        return path[t] == Integer.MAX_VALUE?-1:path[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

