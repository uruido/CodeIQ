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

	public int count(int max) {
		int count = 0;
		for (int n = 1; n <= max; n++) {
			int num = n;
			int length = String.valueOf(num).length();
			int d = (int)Math.pow(10, length - 1);
			for(int i = 0; i < length; i++) {
				if(num/d == 7) {
					count++;
				}
				num %= d;
				d /= 10;
			}
		}
		return count;
	}

}