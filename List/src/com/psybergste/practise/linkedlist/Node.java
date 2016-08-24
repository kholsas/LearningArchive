

package com.psybergste.practise.linkedlist;

public class Node<T>
	{
		public Node<T>	next, prev;
		public T			obj;

		public Node ( T obj ) {
			this.obj = obj;
		}

		public Node ( T obj , Node prev , Node next ) {
			this.next = next;
			this.prev = prev;
			this.obj = obj;
		}
	}
