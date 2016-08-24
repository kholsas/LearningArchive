

package com.psybergste.practise.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import com.psybergste.practise.linkedlist.MyLinkedList;

/**
 * @since 19 Mar 2013
 */
public class MyLinkedListTest
	{

		private List	list;

		@Before
		public void before ( ) {
			list = new MyLinkedList();
		}

		@Test
		public void testEmptyList ( ) {
			assertListCorrect((Object[]) null);
		}

		@Test(expected = IndexOutOfBoundsException.class )
		public void testCannotAccessEmptyList ( ) {
			list.get(0);
		}

		@Test
		public void testListAddsOneElementCorrectly ( ) {
			Object[] listElements = { "abc" };
			populateList(listElements);
			assertListCorrect(listElements);
		}

		@Test
		public void testListAddsTwoElementsCorrectly ( ) {
			Object[] listElements = { "abc", "def" };
			populateList(listElements);
			assertListCorrect(listElements);
		}

		@Test
		public void testIterateHasNextFalseIfEmptyList ( ) {
			Iterator i = list.iterator();
			assertFalse(i.hasNext());
		}

		@Test(expected = NoSuchElementException.class )
		public void testIterateNextFailsIfEmptyList ( ) {
			Iterator i = list.iterator();
			i.next();
		}

		@Test
		public void testIterateThroughListWithOneElement ( ) {
			Object[] listElements = { "abc" };
			populateList(listElements);
			checkIterationThroughList(listElements);
		}

		@Test
		public void testIterateThroughListWithTwoElements ( ) {
			Object[] listElements = { "abc", "def" };
			populateList(listElements);
			checkIterationThroughList(listElements);
		}

		@Test(expected = IndexOutOfBoundsException.class )
		public void testSetElementForEmptyList ( ) {
			String element = "abc";
			list.set(0, element);
		}

		@Test(expected = IndexOutOfBoundsException.class )
		public void testSetElementPassEndOfList ( ) {
			populateList("abc", "def", "ghi");
			list.set(3, "new");
		}

		@Test
		public void testSetFirstElementForListWithOneElement ( ) {
			Object[] listElements = { "abc" };
			populateList(listElements);
			checkSetOnList(0, "new", listElements);
		}

		@Test
		public void testSetElementAtEndOfList ( ) {
			Object[] listElements = { "abc", "def", "ghi" };
			populateList(listElements);
			checkSetOnList(2, "new", listElements);
		}

		@Test
		public void testSetElementInMiddleOfList ( ) {
			Object[] listElements = { "abc", "def", "ghi", "jkl" };
			populateList(listElements);
			checkSetOnList(2, "new", listElements);
		}

		// == Other
		// ==========================================================================================================

		private void populateList ( Object ... listElements ) {
			for (int i = 0; i < listElements.length; i++) {
				list.add(listElements[i]);
			}
		}

		private void assertListCorrect ( Object ... listElements ) {
			if (listElements == null) {
				assertEquals(true, list.isEmpty());
				assertEquals(0, list.size());
			}
			else {
				assertEquals(false, list.isEmpty());
				assertEquals(listElements.length, list.size());
				for (int i = 0; i < listElements.length; i++) {
					assertEquals(listElements[i], list.get(i));
				}
			}
		}

		private void checkIterationThroughList ( Object[] listElements ) {
			int numIterations = 0;
			for (Iterator i = list.iterator(); i.hasNext();) {
				if (numIterations > listElements.length - 1) {
					fail("Iteration failed - this list has " + listElements.length
							+ " elements - should not iterate this.");
				}
				assertEquals(listElements[numIterations], i.next());
				numIterations++;
			}
		}

		private void checkSetOnList ( int index , Object newElement ,Object ... listElements ) {

			Object elementToBeReplaced = listElements[index];
			Object replacedElement = list.set(index, newElement);
			listElements[index] = newElement;
			assertListCorrect(listElements);
			checkIterationThroughList(listElements);
			assertEquals(elementToBeReplaced, replacedElement);
		}
	}
