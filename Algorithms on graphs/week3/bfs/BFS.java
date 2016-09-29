import java.util.*;

public class BFS {
	
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] dist = new int[adj.length];
		Arrays.fill(dist, -1);
		queue.add(s);
		dist[s] = 0;
		while(!queue.isEmpty()){
			s = queue.remove();
			for(int c:adj[s]){
				if(dist[c]<0){
					queue.add(c);
					dist[c] = dist[s] + 1;
				}
			}
		}
		
        return dist[t];
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

