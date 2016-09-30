import java.util.*;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        int[] dist = new int[adj.length];
		Arrays.fill(dist, 1000000);
		dist[0] = 0;
		int i=0;
		for(; i<adj.length; ++i){
			boolean update = false;
			for(int j=0; j<adj.length; ++j){
				List<Integer> list = adj[j];
				List<Integer> costList = cost[j];
				for(int k=0; k<list.size(); ++k){
					//System.out.println((dist[j]+costList.get(k)) + " " + dist[list.get(k)]);
					if(dist[j]+costList.get(k) < dist[list.get(k)]){
						dist[list.get(k)] = dist[j]+costList.get(k);
						update = true;
						//System.out.println("Update");
					}else{
						//System.out.println("NotUpdate");
					}
				}
			}
			//System.out.println();
			if(!update){
				break;
			}
		}
        return i == adj.length?1:0;
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
        System.out.println(negativeCycle(adj, cost));
    }
}

