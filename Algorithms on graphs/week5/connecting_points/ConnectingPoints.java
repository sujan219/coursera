import java.util.*;

public class ConnectingPoints {
	
	private static class Point implements Comparable<Point>{
		int index;
		double dist;
		Point(int i, double d){
			index = i;
			dist = d;
		}
		
		public int compareTo(Point p){
			if(dist == p.dist){
				return 0;
			}else{
				return dist < p.dist ? -1 : 1;
			}
		}
	}
	
    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        boolean connected[] = new boolean[x.length];
		double[] dist = new double[x.length];
		//connected[0] = true;
		Queue<Point> queue = new PriorityQueue<Point>();
		queue.add(new Point(0,0));
		while(!queue.isEmpty()){
			Point pt = queue.remove();
			int index = pt.index;
			double dis = pt.dist;
			if(!connected[index]){
				result += dis;
				connected[index] = true;
				for(int i=0; i<x.length; ++i){
					if(!connected[i]){
						double distance = Math.sqrt(Math.pow(x[i]-x[index], 2) + Math.pow(y[i]-y[index], 2));
						Point nP = new Point(i, distance);
						queue.add(nP);
					}
				}
			}
		}
		
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }
}

