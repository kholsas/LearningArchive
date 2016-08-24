

package com.psybergate.sorting.stringsort;

import java.util.ArrayList;
import java.util.List;

public class StringSorting
	{

		/**
		 * @param args
		 */
		public static void main ( String[] args ) {
			List<String> list = new ArrayList<String>();
			list.add("eerw");
			list.add("eersds");
			list.add("bbbbawes");
			
			list = sort(list);

			for(String str : list)
				System.out.println( str );
		}

		private static List<String> sort ( List<String> list ) {
			for (int i = 0; i < list.size() -1; i++) {
				String tempA = list.get(i);
				String parten = list.get(i + 1);
				int j = 0;
				 while ( parten.charAt(j) == tempA.charAt(j))
				 {
					 j++;
				 }
				 if( parten.charAt(j) > tempA.charAt(j))
				 {
					 list.set(i, parten);
					 list.set(i + 1, tempA);
				 }
			}
			return list;
		}
	}
