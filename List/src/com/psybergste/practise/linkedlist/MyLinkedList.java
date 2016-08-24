

package com.psybergste.practise.linkedlist;

import java.util.*;

public class MyLinkedList<T> implements List , Iterable
	{

		private Node	head;
		private int		index;

		/**
		 * default constructor
		 */

		public MyLinkedList ( ) {
			this.head = null;
			this.index = 0;
		}

		// this method is a general addition method for diff opperations
		private void addToIndex ( int i , Object e ) {

			if (head == null) {

				head = new Node(e);
				head.prev = null;
				head.next = null;

			}
			else if (i > -1)// if position has been specified
			{
				int j = 0;
				Node position = head;
				while (position != null) {

					if (j == i) {
						Node<T> temp = new Node(e);
						temp.prev = position;
						position.next = temp;
					}
					position = position.next;
					j++;
				}

			}

		}

		/**
		 * @param e
		 *           - type : Object this adds a given object value onto the list
		 *           from the back of the list.
		 **/
		public boolean add ( Object e ) {

			if (head == null) {

				head = new Node(e);
				head.prev = null;
				head.next = null;

			}
			else {
				Node position = head;
				while (position.next != null) {

					position = position.next;
				}
				// next is null... so this obj has to be the next one
				Node<T> temp = new Node(e);
				// temp.prev = position;// the previous node to a new obj is this
				// position
				// then the next value to position is this obj
				position.next = temp;
			}

			return true;

		}

		public void add ( int index , Object element ) {
			addToIndex(index, element);

		}

		public boolean addAll ( Collection c ) {
			// take all objects in collection and add them to the list
			for (Object obj : c) {
				add(obj);
			}

			return true;
		}

		public boolean addAll ( int index , Collection c ) {

			for (Object obj : c) {
				addToIndex(index++, obj);
			}
			return true;
		}

		public void clear ( ) {

			head = null;
		}

		public boolean contains ( Object o ) {
			Node position = head;

			while (position != null) {
				if (o.equals(position.obj)) return true;
				position = position.next;
			}
			return false;
		}

		public boolean containsAll ( Collection c ) {// I have to review this
																	// method
			int size = c.size();
			int i = 0;
			Iterator iter = iterator();

			while (iter.hasNext()) {
				for (Object obj : c) {
					if (obj == ((Node) iter.next()).obj) i++;

				}

			}
			return size - 1 == i;
		}

		public Object get ( int index ) {
			Object theObj = null;
			int i = 0;
			if (isEmpty()) { throw new IndexOutOfBoundsException(); }

			Node position = head;
			while (position != null) {

				if (i == index) return position.obj;

				position = position.next;
				i++;
			}

			return null;
		}

		public int indexOf ( Object o ) {

			int i = 0;
			Iterator iter = iterator();
			while (iter.hasNext()) {
				if (((Node) iter.next()).obj == o) return i;

				i++;
			}

			return -1;
		}

		public boolean isEmpty ( ) {

			return head == null;
		}

		/**
		 * finds the last index of a given search item. if not found -1 is
		 * returned
		 **/
		public int lastIndexOf ( Object o ) {
			int i = 0 , found = -1;
			Iterator iter = iterator();

			while (iter.hasNext()) {
				if (((Node) iter.next()).obj == o) {
					found = i;
				}
				i++;

			}

			return found;
		}

		public Iterator iterator ( ) {

			return new MyIterator(head, this);
		}

		public ListIterator listIterator ( ) {

			return null;
		}

		public ListIterator listIterator ( int index ) {

			return null;
		}

		public boolean remove ( Object o ) {

			Iterator iter = iterator();
			boolean removed = false;

			while (iter.hasNext()) {
				if (((Node) iter.next()).obj == o) {
					iter.remove();
					removed = true;
				}
			}

			return removed;
		}

		public Object remove ( int index ) {

			Object removed = null;
			Iterator iter = iterator();
			int i = 0;

			while (iter.hasNext()) {
				Node temp = (Node) iter.next();
				if (i == index) {
					removed = temp.obj;
					iter.remove();
				}
				i++;
			}

			return removed;
		}

		public boolean removeAll ( Collection c ) {

			if (c == null || c.size() == 0) return false;

			Iterator iter = iterator();
			while (iter.hasNext()) {
				for (Object obj : c) {
					if (obj == ((Node) iter.next()).obj) {

						iter.remove();
					}
				}
			}
			return true;
		}

		public boolean retainAll ( Collection c ) {

			return false;
		}

		public Object set ( int index , Object element ) {
			Object obj = element;// whats the point anyway?
			if (isEmpty()) { throw new IndexOutOfBoundsException(); }
			if (index > size() - 1) { throw new IndexOutOfBoundsException(); }
			
			Node position = head;
			int i = 0;
			while (position != null) {
				if (index == i) {
				obj = position.obj;
					position.obj = element;
				}
				position = position.next;
				i++;
			}

			return obj;
		}

		public int size ( ) {

			int count = 0;

			Node position = head;
			while (position != null) {
				count++;
				position = position.next;
			}
			return count;
		}

		public List subList ( int fromIndex , int toIndex ) {
			List subList = new MyLinkedList();
			int i = 0;
			Node position = head;
			while (position != null) {
				if (i >= fromIndex && i <= toIndex) {
					subList.add(position.obj);
				}

				i++;
				position = position.next;
			}
			return subList;
		}

		private void rehash ( Object[] arr ) {// resizes the arr size
			Object[] temp = new Object[arr.length * 2];

			for (int i = 0; i < arr.length; i++)
				temp[i] = arr[i];
			arr = temp;
		}

		public Object[] toArray ( ) {
			Object[] arr = new Object[10];

			if (isEmpty()) return null;
			Iterator iter = iterator();
			int i = 0;
			while (iter.hasNext()) {
				if (i == arr.length - 1) rehash(arr);
				else arr[i++] = ((Node) iter.next()).obj;

			}
			return arr;
		}

		public Object[] toArray ( Object[] a ) {

			return a = toArray();
		}

	}
