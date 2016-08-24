

package com.psybergste.practise.linkedlist;

import java.util.*;

/**
 * This class iterates back and forth through the given Node list
 ***/
public class MyIterator implements Iterator
	{
		private Node			list;
		private MyLinkedList	client;

		/**
		 * @param a
		 *           list of type Node
		 ***/
		public MyIterator ( Node list , MyLinkedList client ) {
			this.list = list;
			this.client = client;
		}

		/**
		 * checks if there is another node after the one at current location
		 * 
		 * @return boolean
		 */
		public boolean hasNext ( ) {
			//if (this.list == null) return false;
			return list != null;
			
		}

		/**
		 * Checks if, given current position, we can navigate to one node behind
		 * 
		 * @return boolean
		 ***/
		public boolean hasPrevious ( ) {
			if (this.list == null) return false;
			return list.prev != null;
		}

		/**
		 * navigates forward through the list
		 * 
		 * @return Node t
		 **/
		public Object next ( ) {// returns the next
			Node temp = null;
			if (list == null) throw new NoSuchElementException();
			
			if (hasNext())
			{
				temp = list;
				list = list.next;
				//list = temp;
			}

			return temp.obj;
		}

		/**
		 * navigates backward through the list
		 * 
		 * @return Node list
		 */
		public Node previous ( ) {// reeturns the previous node
			Node temp = null;
			if (hasPrevious()) {
				temp = list.prev;
				list = temp;
			}
			// client.setHead( this.list );
			return temp;
		}

		/**
		 * removes the current node
		 * 
		 * @return void
		 **/
		public void remove ( ) {
			if (this.list != null) {
				this.list.prev.next = this.list.next.prev;
			}
		}

		/**
		 * inserts at current position return boolean
		 **/
		public boolean insert ( Object element ) {
			if (this.list == null) return false;
			else {
				list.obj = element;
				// client.setHead( this.list );
				return true;
			}
		}

	}
