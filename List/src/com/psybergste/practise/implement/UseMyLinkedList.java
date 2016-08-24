

package com.psybergste.practise.implement;

import java.util.Iterator;
import java.util.List;

import com.psybergste.practise.linkedlist.MyLinkedList;
import com.psybergste.practise.linkedlist.Node;

public class UseMyLinkedList
	{

		public static void main ( String[] a ) {
			MyLinkedList myList = new MyLinkedList();
			Item item1 = new Item("first item", 5);
			Item item2 = new Item("second item", 2);
			Item item3 = new Item("3rd item", 10);
			Item item4 = new Item("4th item", 42);
			int i = 0;
			while (i++ <= 1000000) {
				myList.add(new String("name " + i));
			}
			Iterator<?> iter = myList.iterator();
			System.out.println(iter.next());
			System.out.println(iter.next()); 
			System.out.println(iter.next());
			System.out.println(iter.next());
			// System.out.println(myList.size());
			// viewAll(myList);
			// myList.set (2 , item1);
			// System.out.println(myList.size());
			// viewAll(myList);

		}

		private static void viewAll ( List myList ) {
			for (int i = 0; i < myList.size(); i++)
				System.out.println(((Item) myList.get(i)).name + " "
						+ ((Item) myList.get(i)).a);
		}

	}
