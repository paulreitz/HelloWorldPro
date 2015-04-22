package hello.tests;

import static org.junit.Assert.*;
import hello.core.ViewList;
import hello.views.HelloView;

import org.junit.Test;

public class ViewListTest
{
	private ViewList list;
	private HelloView a;
	private HelloView b;
	private HelloView c;
	private HelloView d;
	private HelloView e;
	private HelloView f;
	
	public ViewListTest()
	{
		a = new HelloView("A");
		b = new HelloView("B");
		c = new HelloView("C");
		d = new HelloView("D");
		e = new HelloView("E");
		f = new HelloView("F");
		
		list = new ViewList();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		
	}

	@Test
	public void testSize()
	{
		assertEquals("ViewList.size() should return the correct size.", 5, list.size());
	}

	@Test
	public void testShift()
	{
		list.shift(f);
		assertEquals("ViewList.shift() should increase the size of the array", 6, list.size());
		assertTrue("ViewList.shift() should insert the item into the list", list.contains(f));
		assertTrue("ViewList.shift should put the new item at the beginning of the list", (list.get(0) == f));
	}

	@Test
	public void testUnshift()
	{
		HelloView view = (HelloView)list.unshift();
		assertEquals("ViewList.unshift() should return the first item from the list", a.getMessage(), view.getMessage());
		assertEquals("ViewList.unshift() should reduce the size of the list by 1", list.size(), 4);
		assertTrue("ViewList.unshift() should remove the first item from the list", (list.get(0) == b));
		assertFalse("The list should no longer container the first item after calling ViewList.unshift()", list.contains(a));
	}

	@Test
	public void testPop()
	{
		HelloView view = (HelloView)list.pop();
		assertEquals("ViewList.pop() should return the last item from the list", view.getMessage(), e.getMessage());
		assertEquals("ViewList.pop() should reduce the size of the list by 1", list.size(), 4);
		assertFalse("the list should no longer contain the last item after calling ViewList.pop()", list.contains(e));
	}

	@Test
	public void testAdd()
	{
		list.add(f);
		assertEquals("ViewList.add() should increase the list size by 1", list.size(), 6);
		assertTrue("The list should contain the new item after calling ViewList.add()", list.contains(f));
		assertEquals("ViewList.add() should place the item at the end of the list", list.indexOf(f), 5);
	}

	@Test
	public void testGet()
	{
		assertTrue("ViewList.get() should return the correct item at the given index (0)", (list.get(0) == a));
		assertTrue("ViewList.get() should return the correct item at the given index (1)", (list.get(1) == b));
		assertTrue("ViewList.get() should return the correct item at the given index (2)", (list.get(2) == c));
		assertTrue("ViewList.get() should return the correct item at the given index (3)", (list.get(3) == d));
		assertTrue("ViewList.get() should return the correct item at the given index (4)", (list.get(4) == e));
	}

	@Test
	public void testContains()
	{
		assertTrue("ViewList.contains() should report that it contains an item in the list (a)", list.contains(a));
		assertTrue("ViewList.contains() should report that it contains an item in the list (b)", list.contains(b));
		assertTrue("ViewList.contains() should report that it contains an item in the list (c)", list.contains(c));
		assertTrue("ViewList.contains() should report that it contains an item in the list (d)", list.contains(d));
		assertTrue("ViewList.contains() should report that it contains an item in the list (e)", list.contains(e));
		assertFalse("ViewList.contains() should return false if item isn't in the list", list.contains(f));
	}

	@Test
	public void testIndexOf()
	{
		assertEquals("ViewList.indexOf() should return the correct index of the provided item (a)", list.indexOf(a), 0);
		assertEquals("ViewList.indexOf() should return the correct index of the provided item (b)", list.indexOf(b), 1);
		assertEquals("ViewList.indexOf() should return the correct index of the provided item (c)", list.indexOf(c), 2);
		assertEquals("ViewList.indexOf() should return the correct index of the provided item (d)", list.indexOf(d), 3);
		assertEquals("ViewList.indexOf() should return the correct index of the provided item (e)", list.indexOf(e), 4);
		assertEquals("ViewList.indexOf() should return -1 of the item is not in the list", list.indexOf(f), -1);
	}

}
