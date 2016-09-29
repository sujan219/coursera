import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int[] type = new int[adj.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		type[0] = 1;
		while(!queue.isEmpty()){
			int i = queue.remove();
			for(int e:adj[i]){
				if(type[e] == 0){
					type[e] = type[i]==1?2:1;
					queue.add(e);
				}else if(type[e] == type[i]){
					return 0;
				}
			}
		}
        return 1;
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
        System.out.println(bipartite(adj));
    }
}

