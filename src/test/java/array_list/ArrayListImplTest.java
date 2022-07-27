package array_list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListImplTest {

    @Test
    public void shouldAddNewElementToNewEmptyArrayList() {
        ArrayListImpl<Integer> arrayList = new ArrayListImpl();

        Integer element1 = 1;
        boolean result1 = arrayList.add(element1);

        assertTrue(result1);
        assertEquals(element1, arrayList.get(0));

        Integer element2 = 2;
        boolean result2 = arrayList.add(element2);

        assertTrue(result2);
        assertEquals(element2, arrayList.get(1));
    }

    @Test
    public void shouldAddNewElementToArrayList() {
        String[] array = {"1", "2", "3"};
        ArrayListImpl<String> arrayList = new ArrayListImpl(array);
        String element = "test";

        boolean result = arrayList.add(element);

        assertTrue(result);
        assertEquals(element, arrayList.get(array.length));
    }

    @Test
    public void addByIndex() {
        String[] array = {"1", "2", "3"};
        ArrayListImpl<String> arrayList = new ArrayListImpl(array);
        String element = "test";

        boolean result = arrayList.add(1, element);

        assertTrue(result);
        assertEquals(element, arrayList.get(1));
    }

    @Test
    public void addAll() {
        String[] array = {"1", "2", "3"};
        String[] test = {"4", "5", "6"};
        ArrayListImpl<String> arrayList = new ArrayListImpl(array);

        boolean result = arrayList.addAll(test);

        assertTrue(result);
        assertEquals(arrayList.size(), test.length + array.length);
    }

    @Test
    public void testSizeValue() {
        String[] array = {"1", "2", "3"};
        ArrayListImpl<String> arrayList = new ArrayListImpl(array);
        assertEquals(array.length, arrayList.size());
    }

    @Test
    public void testIsEmpty() {
        ArrayListImpl<Integer> arrayList = new ArrayListImpl();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testClear() {
        Integer[] array = {1, null, 3};
        ArrayListImpl<Integer> arrayList = new ArrayListImpl(array);

        assertArrayEquals(array, arrayList.toArray());

        arrayList.clear();

        assertArrayEquals(new Integer[] {null, null, null}, arrayList.toArray());
    }

    @Test
    public void testIndexOf() {
        Integer[] array = {1, null, 3};
        ArrayListImpl<Integer> arrayList = new ArrayListImpl(array);

        int resultOne = arrayList.indexOf(null);
        int resultTwo = arrayList.indexOf(3);

        assertEquals(1, resultOne);
        assertEquals(2, resultTwo);
    }

    @Test
    public void testRemoveByIndex() {
        Integer[] array = {1, 2, 3, 4, 5};
        ArrayListImpl<Integer> arrayList = new ArrayListImpl(array);

        boolean resultOne = arrayList.remove(4);
        assertTrue(resultOne);
        assertEquals(4, arrayList.size());

        boolean resultTwo = arrayList.remove(0);
        assertTrue(resultTwo);
        assertEquals(3, arrayList.size());

        boolean resultThree = arrayList.remove(1);
        assertTrue(resultThree);
        assertEquals(2, arrayList.size());
    }

    //TODO: solve the issue with type integer
    @Test
    public void testRemoveObject() {
        Integer[] array = {1, 2, 3, 4, 5};
        ArrayListImpl<Integer> arrayList = new ArrayListImpl(array);

        boolean resultOne = arrayList.remove((Integer) 4);
        assertTrue(resultOne);
        assertEquals(4, arrayList.size());

    }
    //TODO: include a size check in every test;
}