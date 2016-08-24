

package com.copies.deepandshallow;

public class Person implements Cloneable
	{

		public Person  Clone ( ) {
			Person cloned = null;
			try {
				cloned = (Person) super.clone();
			}
			catch (CloneNotSupportedException e) {

				e.printStackTrace();
			}
		 
				return cloned;
	 
		}

		public String getName ( ) {
			return name;
		}

		public void setName ( String name ) {
			this.name = name;
		}

		public String getSurname ( ) {
			return surname;
		}

		public void setSurname ( String surname ) {
			this.surname = surname;
		}

		private String	name, surname;

		public Person ( String name , String surname ) {
			super();
			this.name = name;
			this.surname = surname;
		}
	}
