package com.psybergate.run;

import java.util.List;

import com.psybergate.number.Node;
import com.psybergate.number.Num;

public class DrivingClass {
	public static List<Node> nodes;

	/**
	 * @author kholofelo Maloma time : ~25 minutes .... execution time +/- 64 ms
	 *         (recursion is too slow...)
	 * @since 16 03 2013
	 */

	 
	public static void main(String[] args) {
		int i = 200, length = 0;
		long start = System.currentTimeMillis();

		for (i = 1; i <= 1000; i++) {
			length += new Num(i).toString().replaceAll(" ", "").length();
		}

		long end = System.currentTimeMillis();
		System.out.println("total : " + new Num(length).toString() + ". time: "
				+ new Num((int) (end - start)).toString() + " ms");
	}

}
