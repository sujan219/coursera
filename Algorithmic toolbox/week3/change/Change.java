import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int change = m/10;
		m = m%10;
		change += m/5;
		change += m%5;
        return change;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

