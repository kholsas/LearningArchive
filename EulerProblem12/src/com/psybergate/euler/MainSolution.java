package com.psybergate.euler;

import java.util.ArrayList;
import java.util.List;

public class MainSolution {

	public MainSolution() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long i = 3483480 *2, start = System.currentTimeMillis();
		long sum = 0;

		for (;; i++) {
			sum += i;
			long size = findFactors(sum).size();
			if (size >= 250) {
				System.out.println(sum + " " + size);
				//break;
			}
		}
		//long end = System.currentTimeMillis();
		//System.out.println((end - start) + " ms");

	}

	private static List<Integer> findFactors(long n) {
		int incr = 1;
		if (n % 2 > 0)
			incr = 2;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n / 2; i += incr) {
			if (n % i == 0)
				list.add(i);
		}
		return list;
	}

	private static List<Integer> primeFactors(int number) {
		int n = number;
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;// i don't understand the impotence of this line of code
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}

}
