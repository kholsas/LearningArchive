package com.psybergate.number;

public class Node {
	
	private int number, length;
	private String numWord;
	
	
	public Node(int number, String numWord) {
		super();
		this.number = number;
		this.length = numWord.length(); 
		this.numWord = numWord;
	}

	public int getNumber() {
		return number;
	}

	public int getLength() {
		return length;
	}

	public String getNumWord() {
		return numWord;
	}
		

}
