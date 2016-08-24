

package com.psybergate.implement;

import java.util.ArrayList;
import java.util.List;

import com.psybergate.sorting.Employee;
import com.psybergate.sorting.MyComparator;

public class ClientCode
	{

		public static void main ( String[] args ) {

			Employee empl1 = new Employee("Kholofelo", 5, 5562);
			Employee empl2 = new Employee("Nakampe", 1, 96985);
			Employee empl3 = new Employee("Maloma", 6, 2000);

			// SortedSet<Employee> sortedSet = new TreeSet<Employee>(new
			// MyComparator());
			List<Employee> myList = new ArrayList<Employee>(3);
			myList.add(empl1);
			myList.add(empl2);
			myList.add(empl3);

			for (Employee emp : myList)
				System.out.println(String.format("%-5s", emp.toString()));
			System.out.println();
			sort(myList, "ascending");
			for (Employee emp : myList)
				System.out.println(String.format("%-5s", emp.toString()));

			System.out.println();
			sort(myList, "descending");
			for (Employee emp : myList)
				System.out.println(String.format("%-5s", emp.toString()));
		}

		private static List<Employee> sort ( List<Employee> myList , String order ) {
			if (myList == null) return null;
			if (myList.size() == 0) return myList;

			int theOrder = order.equals("ascending") ? 0 : -1;// -1 = descending
			MyComparator myComp = new MyComparator();

			for (int i = 0; i < myList.size() ; i++) {
				Employee tempEmp = myList.get(i);

				for (int j =  i; j < myList.size(); j++) {
					Employee anotherTempEmpl = myList.get(j);
					if (theOrder < 0) {// descending
						if (myComp.compare(tempEmp, anotherTempEmpl) > 0) {
							myList.set(j, tempEmp);
							myList.set(i, anotherTempEmpl); 
						}
					}
					else {// ascending
						if (myComp.compare(anotherTempEmpl, tempEmp) > 0) {
							myList.set(i, anotherTempEmpl);
							myList.set(j, tempEmp);
						}
					}
				}
			}

			return myList;
		}

	}
