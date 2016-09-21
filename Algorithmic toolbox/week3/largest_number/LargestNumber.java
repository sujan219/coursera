import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        String max = null;
		String result = "";
		while((max = getMaximum(a)) != null){
			result += max;
		}
        return result;
    }
	
	private static String getMaximum(String[] a){
		String max = null;
		int maxIndex = -1;
		for(int i=0; i<a.length; ++i){
			String each = a[i];
			if(each != null){
				if(max == null){
					max = each;
					maxIndex = i;
				}else if(Long.parseLong(each+max)>Long.parseLong(max+each)){
					max = each;
					maxIndex = i;
				}
			}
		}
		
		if(maxIndex > -1)
			a[maxIndex] = null;
		
		return max;
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

