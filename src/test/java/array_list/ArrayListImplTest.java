package array_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListImplTest {

    @Test
    void shouldAddNewElementToNewEmptyArrayList() {
        ArrayListImpl<Integer> arrayList = new ArrayListImpl();

        boolean result1 = arrayList.add(1);

        assertTrue(result1);
        assertArrayEquals(new Integer[]{1}, arrayList.toArray());
        assertEquals(1, arrayList.size());

        boolean result2 = arrayList.add(2);

        assertTrue(result2);
        assertArrayEquals(new Integer[]{1, 2}, arrayList.toArray());
        assertEquals(2, arrayList.size());
    }

    @Test
    void addByIndex() {
        String[] array = {"1", "2", "3"};
        ArrayListImpl<String> arrayList = new ArrayListImpl(array);

        boolean result = arrayList.add(1, "4");

        assertTrue(result);
        assertArrayEquals(new String[]{"1", "4", "2", "3"}, arrayList.toArray());
        assertEquals(4, arrayList.size());
    }

    @Test
    void addAll() {
        String[] array = {"1", "2", "3"};

        ArrayListImpl<String> arrayList = new ArrayListImpl(array);

        boolean result = arrayList.addAll(new String[]{"4", "5", "6"});

        assertTrue(result);
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, arrayList.toArray());
        assertEquals(6, arrayList.size());
    }

    @Test
    void testSizeValue() {
        ArrayListImpl<String> arrayList = new ArrayListImpl(new String[]{"1", "2", "3"});

        assertEquals(3, arrayList.size());
    }

    @Test
    void testIsEmpty() {
        ArrayListImpl<Integer> arrayList = new ArrayListImpl();

        assertTrue(arrayList.isEmpty());

        arrayList.add(1);

        assertFalse(arrayList.isEmpty());
    }

    @Test
    void testClear() {
        Integer[] array = {1, null, 3};
        ArrayListImpl<Integer> arrayList = new ArrayListImpl(array);

        assertArrayEquals(array, arrayList.toArray());
        assertEquals(3, arrayList.size());

        arrayList.clear();

        assertArrayEquals(new Integer[] {}, arrayList.toArray());
        assertEquals(0, arrayList.size());
    }

    @Test
    void testIndexOf() {
        Integer[] array = {1, null, 3, 1};
        ArrayListImpl<Integer> arrayList = new ArrayListImpl(array);

        assertEquals(1, arrayList.indexOf(null));
        assertEquals(2, arrayList.indexOf(3));
        assertEquals(-1, arrayList.indexOf(2));
    }

    @Test
    void testRemoveByIndex() {
        Integer[] array = {1, 2, 3, 4, 5};
        ArrayListImpl<Integer> arrayList = new ArrayListImpl(array);

        boolean result1 = arrayList.removeByIndex(4);
        assertTrue(result1);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, arrayList.toArray());
        assertEquals(4, arrayList.size());

        boolean result2 = arrayList.removeByIndex(0);
        assertTrue(result2);
        assertArrayEquals(new Integer[]{2, 3 , 4}, arrayList.toArray());
        assertEquals(3, arrayList.size());

        boolean result3 = arrayList.removeByIndex(1);
        assertTrue(result3);
        assertArrayEquals(new Integer[]{2, 4}, arrayList.toArray());
        assertEquals(2, arrayList.size());
    }

    @Test
    void testRemoveObject() {
        Integer[] array = {1, 2, 3, 4, 5, 2};
        ArrayListImpl<Integer> arrayList = new ArrayListImpl(array);

        boolean result1 = arrayList.remove(2);
        assertTrue(result1);
        assertArrayEquals(new Integer[]{1, 3, 4, 5, 2}, arrayList.toArray());
        assertEquals(5, arrayList.size());

        boolean result2 = arrayList.remove(6);
        assertFalse(result2);
        assertArrayEquals(new Integer[]{1, 3, 4, 5, 2}, arrayList.toArray());
        assertEquals(5, arrayList.size());
    }
}
