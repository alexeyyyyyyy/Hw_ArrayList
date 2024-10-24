package telran.list.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import telran.list.interfaces.Ilist;
import telran.list.model.MyArrayList;

class ListTest<E> {
	
	@Test
	void test() {
		Ilist<Integer> list = new MyArrayList<>();
		System.out.println(list.size());
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(3);
		list.add(7);
		list.add(null);
		list.add(9);
		System.out.println(list.size());
		System.out.println(list.get(2));
		System.out.println(list.get(5));
		System.out.println(list.indexOf(3));
		System.out.println(list.lastIndexOf(3));
		System.out.println(list.contains(11));
		System.out.println(list.isEmpty());
		System.out.println(list.remove(2));
		System.out.println(list.size());
		System.out.println(list.set(0, 11));
		System.out.println(list.size());
		System.out.println(list.get(0));
		list.clear();
		System.out.println(list.size());
		list.add(0, 11);
		System.out.println(list.size());
		System.out.println(list.get(0));
	}
	
	@Test
	public void testEmptyArrayList() {
		MyArrayList<Integer> emptyList = new MyArrayList<>();
		
		Iterator<Integer> iterator = emptyList.iterator();
		
		assertFalse(iterator.hasNext());
		
		
	}
	@Test
    public void testAddAndIterate() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);

        Iterator<Integer> iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertFalse(iterator.hasNext());
    }

}
