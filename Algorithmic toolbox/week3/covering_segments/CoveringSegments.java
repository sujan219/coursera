import java.util.*;

public class CoveringSegments {

    private static int[][] optimalPoints(Segment[] segments) {
        Arrays.sort(segments);
        int[][] arr = new int[segments.length][2];
		int i=0, j=0;
		while(i<segments.length){
			arr[j][0] = segments[i].start;
			arr[j][1] = segments[i].end;
			++i;
			while(i<segments.length){
				if(arr[j][1] >= segments[i].start){
					arr[j][0] = segments[i].start;
					arr[j][1] = Math.min(segments[i].end, arr[j][1]);
				}else{
					break;
				}
				++i;
			}
			++j;
		}
        return arr;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
		
		public int compareTo(Segment s){
			return this.start - s.start;
		}
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[][] arr = optimalPoints(segments);
        int count = 0;
		String str = "";
		for(int i=0; i<arr.length; ++i){
			if(arr[i][0] == 0 && arr[i][1] == 0){
				break;
			}else{
				str += arr[i][1] + " ";
				++count;
			}
		}
		System.out.println(count);
		System.out.println(str);
    }
}
 
