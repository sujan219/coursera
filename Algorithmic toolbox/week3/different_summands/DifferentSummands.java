import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int lastNum = 0;
		while(n>0){
			lastNum++;
			if(n<=lastNum*2){
				summands.add(n);
				n = 0;
			}else{
				summands.add(lastNum);
				n -= lastNum;
			}
		}
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

