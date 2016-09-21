import java.util.*;

public class PointsAndSegments {

    private static int[] fastCountSegments(Segment[] segments, int[] points) {
        Arrays.sort(segments);
		int[] res = new int[points.length];
		for(int i=0; i<points.length; ++i){
			int counter = 0;
			//int j=search(segments, points[i]+1);
			int j=0;
			//System.out.println(j);
			while(j<segments.length && points[i]>=segments[j].x){
				if(points[i] <= segments[j].y){
					counter++;
				}
				--j;
			}
			//System.out.println(counter);
			res[i] = counter;
		}
        return res;
    }
	
	private static int search(Segment[] segments, int x){
		//System.out.println("Searching : " + x);
		int left = 0;
		int right = segments.length - 1;
		while(left<=right){
			int mid = (right+left)/2;
			if(segments[mid].x == x){
				return mid;
			}else if(segments[mid].x<x){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		
		return Math.max(0, left-1);
	}
	
	private static class Segment implements Comparable<Segment>{
		int x, y;
		/* Segment(int x, int y){
			this.x = x;
			this.y = y;
		} */
		
		public int compareTo(Segment s){
			return x-s.x;
		}
	}
	
    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        Segment[] segments = new Segment[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
			segments[i] = new Segment();
            segments[i].x = scanner.nextInt();
            segments[i].y = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(segments, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

