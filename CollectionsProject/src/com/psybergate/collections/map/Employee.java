

package com.psybergate.collections.map;

public class Employee
	{

		private String	name;
		private int		empNum;

		public Employee ( int empNUm , String name ) {
			setEmpNum(empNUm);
			setName(name); 
		}

		public void setEmpNum ( int empNum ) {
			this.empNum = empNum;
		}

		public String getName ( ) {
			return name;
		}

		public void setName ( String name ) {
			this.name = name;
		}

		public int getEmpNum ( ) {
			return empNum;
		}
	}
