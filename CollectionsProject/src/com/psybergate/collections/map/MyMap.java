

package com.psybergate.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyMap
	{

		/**
		 * @param args
		 */
		public static void main ( String[] args ) {

			SortedMap<Integer, Employee> myMap = new TreeMap<Integer, Employee>();

			Employee emp1 = new Employee(5622, "Kholofelo");
			Employee emp2 = new Employee(895, "Iralia");
			Employee emp3 = new Employee(656, "Theo");
			myMap.put(emp1.getEmpNum(), emp1);
			myMap.put(emp2.getEmpNum(), emp2);
			myMap.put(emp3.getEmpNum(), emp3);

			System.out.println(myMap.size());

			for (Integer key : myMap.keySet()) {
				System.out.println(myMap.get(key).getName());
			}
			System.out.println();
			for (Employee key : myMap.values())
				System.out.println(key.getName());
		}

	}
