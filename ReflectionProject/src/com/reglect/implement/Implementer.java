

package com.reglect.implement;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.reglect.kholofelo.Student;

public class Implementer
	{

		public static void main ( String ... a ) throws ClassNotFoundException {
			Class myClassA = Class.forName("com.reglect.kholofelo.Student");
			Class myClassB = Student.class;

			System.out.println( "myClassA == myClassB = "+ (myClassA == myClassB));
			System.out.println("myClassA.equals(myClassB) = " + (myClassA.equals(myClassB)));
			
			System.out.println("\nGet Declared Constructors \n");
			for(Constructor field : myClassA.getDeclaredConstructors())
				System.out.println(field.toString());
			
			for(Method method : myClassA.getDeclaredMethods())
				System.out.println(method.toString());
			
		}

	}
