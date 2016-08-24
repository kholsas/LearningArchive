

package com.psybergate.sorting;

import java.text.DecimalFormat;

public class Employee
	{

		private String	name;
		private int		accountNum;
		private double salary;

		public Employee ( String name , int age , double salary) {
			super();
			this.name = name;
			this.accountNum = age;
			this.salary = salary;
		}

		public String getName ( ) {
			return name;
		}

		 
		public int getAccountNum ( ) {
			return accountNum;
		}

		 

		@Override
		public int hashCode ( ) {
			final int prime = 31;
			int result = 1;
			result = prime * result + accountNum;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public String toString ( ) {
			return  String.format("%-6s", ( getName() + "\t" + getAccountNum() +"\t" + getSalary()  ));
		}

		public double getSalary ( ) {
			return salary;
		}

	 
		@Override
		public boolean equals ( Object obj ) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			Employee other = (Employee) obj;
			if (accountNum != other.accountNum) return false;
			if (name == null) {
				if (other.name != null) return false;
			}
			else if (!name.equals(other.name)) return false;
			return true;
		}

		public int compareTo ( Employee o ) {

			return -getAccountNum() + o.getAccountNum();
		}

	}
