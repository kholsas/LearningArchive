

package com.psybergate.collections.hashset;

import java.util.HashSet;
import java.util.Set;

public class MyHashSetExample
	{
		public static void main ( String[] args ) {
			Set<String> set = new HashSet<String>();
			set.add("added first");
			set.add("added second");
			set.add("added third");
			set.add("added fourth");
			
			for (String str : set)
				System.out.println(str);
		}
	}
