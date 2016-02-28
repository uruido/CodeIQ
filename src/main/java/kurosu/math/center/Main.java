package kurosu.math.center;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Main calculator = new Main();
		Scanner scan = new Scanner(System.in);
		List<Integer> numList = new ArrayList<>();
		while (true) {
			try {
				numList.add(scan.nextInt());
			} catch (NoSuchElementException e) {
				break;
			}
		}
		for (int num : numList) {
			System.out.println(calculator.count(num));
		}
		scan.close();
	}

	/**
	 * Count number of "7"
	 * See http://oshiete.goo.ne.jp/qa/2747962.html
	 * @param max
	 * @return
	 */
	public int count(int max) {
		// maxの桁数
		int count = 0;
		int digit = 0;
		int last1stDigit = -1;
		int lastAdded = -1;
		for (int num = 1; num <= max; num++) {
			if(last1stDigit == 7) {
				count += lastAdded-1;
				lastAdded--;
				last1stDigit = 8;
				continue;
			} else if((0 <= last1stDigit & last1stDigit <= 5) || last1stDigit==8) {
				count += lastAdded;
				last1stDigit += 1;
				continue;
			} else if(last1stDigit == 6) {
				count += lastAdded+1;
				lastAdded++;
				last1stDigit += 1;
				continue;
			}
			
			lastAdded = 0;
			int val = num;
			int length = (int) (Math.log10(val) + 1);
			for (int index = 0; index < length; index++) {
				digit = val%10;
				if(index == 0) {
					last1stDigit = digit;
				}
				if(digit == 7) {
					count++;
					lastAdded++;
				}
				val /= 10;
			}
		}
		return count;
	}
}