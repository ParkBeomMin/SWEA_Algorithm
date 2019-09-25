import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int n = sc.nextInt();
			int[] prices = new int[n];
			long result = 0;
			for (int i = 0; i < prices.length; i++) {
				prices[i] = sc.nextInt();
			}
			int point = prices.length - 1;
			for (int i = prices.length - 2; i >= 0; i--) {
				if (prices[i] < prices[point]) {
					result += (prices[point] - prices[i]);
				} else {
					point = i;
				}
			}
			System.out.println("#" + t + " " + result);
		}

		sc.close();

	}

}
