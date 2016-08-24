package com.psybergate.number;

import java.util.ArrayList;
import java.util.List;

public class Num {
	private int number;

	public static List<Node> nodes;
	static {
		nodes = new ArrayList<Node>();
		constructNodes();
	}

	private static void constructNodes() {
		nodes.add(new Node(1, "One"));
		nodes.add(new Node(2, "two"));
		nodes.add(new Node(3, "three"));
		nodes.add(new Node(4, "four"));
		nodes.add(new Node(5, "five"));
		nodes.add(new Node(6, "six"));
		nodes.add(new Node(7, "seven"));
		nodes.add(new Node(8, "eight"));
		nodes.add(new Node(9, "nine"));
		nodes.add(new Node(10, "ten"));
		nodes.add(new Node(11, "eleven"));
		nodes.add(new Node(12, "twelve"));
		nodes.add(new Node(13, "thirteen"));
		nodes.add(new Node(14, "fourteen"));
		nodes.add(new Node(15, "fifteen"));
		nodes.add(new Node(16, "sixteen"));
		nodes.add(new Node(17, "seventeen"));
		nodes.add(new Node(18, "eighteen"));
		nodes.add(new Node(19, "nineteen"));
		nodes.add(new Node(20, "twenty"));
		nodes.add(new Node(30, "thirty"));
		nodes.add(new Node(40, "forty"));
		nodes.add(new Node(50, "fifty"));
		nodes.add(new Node(60, "sixty"));
		nodes.add(new Node(70, "seventy"));
		nodes.add(new Node(80, "eighty"));
		nodes.add(new Node(90, "ninety"));
		nodes.add(new Node(-100, "hundred"));
		nodes.add(new Node(1000, "One thousand"));
		nodes.add(new Node(-1000, "thousand"));
		nodes.add(new Node(100, "One hundred"));
		nodes.add(new Node(0, "---"));

	}

	public Num(int number) {
		super();
		this.number = number;

	}

	private String getWord(int i) {
		for (Node a : nodes) {
			if (a.getNumber() == i)
				return a.getNumWord();
		}
		return null;
	}

	public String toString() {
		String word = getWord(this.number);

		if (word != null)
			return word + " ";
		else {

			if (this.number < 100) {
				return new Num((this.number / 10) * 10).toString()
						+ new Num(number % 10).toString();

			} else if (this.number < 1000) {
				return new Num(this.number / 100).toString()
						+ new Num(-100).toString()
						+ (this.number % 100 > 0 ? ("and " + new Num(
								this.number % 100).toString()) : "");
			} else if (this.number < 100000) {// max 99 000
				return new Num(this.number / 1000).toString()
						+ new Num(-1000).toString()
						+ (this.number % 1000 > 0 && this.number % 1000 < 100 ? "and "
								: "")
						+ (this.number % 1000 > 0 ? (new Num(this.number % 1000))
								: "");
			}

		}
		return null;
	}
}
