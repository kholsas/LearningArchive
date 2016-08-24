

package com.psybergate.collections.treeset;

import java.util.*;

public class MyTreeSetExample
	{
		public static void main ( String[] args ) {

			SortedSet<String> sortedSet = new TreeSet<String>();
			sortedSet.add("b");
			sortedSet.add("c");
			sortedSet.add("d");
			sortedSet.add("a");

			for (String col : sortedSet) {
				System.out.println(col);
			}
		}

	}
