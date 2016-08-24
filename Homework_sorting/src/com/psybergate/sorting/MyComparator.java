

package com.psybergate.sorting;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee>
	{

		@Override
		public int compare ( Employee emp1 , Employee empl2 ) {

			return empl2.getAccountNum() - emp1.getAccountNum();
		}

	}
