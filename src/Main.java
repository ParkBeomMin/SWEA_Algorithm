import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		String[] decoding = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };
		for (int k = 0; k < testCase; k++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			String text = "";
			String ciphers = "";
			String code = "";
			boolean isFind = false;
			int oddSum = 0;
			int evenSum = 0;
			int verificationCode = 0;

			for (int i = 0; i < n; i++) {
				text = sc.next();

				for (int j = 0; j < m && !isFind && !(text.length() == 0); j++) {
					if (text.charAt(m - j - 1) == '1') {
						isFind = true;
						ciphers = text.substring(m - j - 56, m - j);
					}
				}
			}

			for (int i = 0; i <= ciphers.length() - 7; i += 7) {
				for (int j = 0; j < decoding.length; j++) {
					if (decoding[j].equals(ciphers.substring(i, i + 7))) {
						code += j;
						break;
					}

				}
			}
			for (int i = 0; i < code.length(); i++) {
				if (i == code.length() - 1) {
					verificationCode = Integer.parseInt(String.valueOf(code.charAt(i)));
				} else if ((i + 1) % 2 == 0) {
					evenSum += Integer.parseInt(String.valueOf(code.charAt(i)));
				} else {
					oddSum += Integer.parseInt(String.valueOf(code.charAt(i)));
				}
			}
			int cal = oddSum * 3 + evenSum + verificationCode;
			if (cal % 10 == 0) {
				System.out.println("#" + (k+1) + " " + (oddSum + evenSum + verificationCode));
			} else {
				System.out.println("#" + (k+1) + " " + 0);
			}

		}

		sc.close();

	}

}
