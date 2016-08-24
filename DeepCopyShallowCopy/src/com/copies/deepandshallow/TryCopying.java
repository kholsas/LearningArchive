

package com.copies.deepandshallow;

public class TryCopying
	{

		/**
		 * @param args
		 */
		public static void main ( String[] args ) {
			Person personA = new Person("Kholofelo", "Maloma");
			System.out.println(personA.getName());

			Person personB = personA;
			personB.setName("Theophilus");
			System.out.println(personB.getName());
			System.out.println(personA.getName());
			/*
			 * Above is the glory of Java
			 * 
			 * 
			 * the equal's operator '=' makes a reference copy, but not the value copy(not
			 * the copy of the actual object in memory )... this is shallow copy ...but now, what if I wanted
			 * personB to have initial values of personA but later on change them
			 * but still not affect personB? aaaaa! we need to completely copy the
			 * object that reference personA is pointing to, in to a different memory location
			 * where reference personB can now point to....can we deep copy this? lets see... i will
			 * used slightly different reference names here.. personC instead of personB
			 */
			System.out.println();
			System.out.println("********Now making a deep copy******");

			Person personC = personA.Clone();
			System.out.println();
			System.out.println(personC.getName());
			personC.setName("John");
			System.out.println(personC.getName());
			System.out.println(personA.getName());

			/**
			 * Clone() returns a deep copy of object which personA points to...
			 * basically, before mutating the state of personC, just after Cloning
			 * personA, there were two identical object in the java heap memory;
			 * personA points to one ( same is personB ), but personC points to a
			 * different object in memory which is a complete copy of objectA
			 * (object to which PersonA points)...
			 * 
			 * now after doing a deep copy, personC can mutate its object state without affecting the state of personA's object
			 */
		}

	}
