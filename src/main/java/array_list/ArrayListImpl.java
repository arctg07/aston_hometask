package array_list;

public class ArrayListImpl<T> implements ArrayList<T>{

    private static final Object[] EMPTY_ARRAY = {};

    private Object[] storage;

    private int size = 0;

    public ArrayListImpl() {
        storage = EMPTY_ARRAY;
    }

    public ArrayListImpl(int capacity) {
        if(capacity > 0) {
            storage = new Object[capacity];
            size = capacity;
        } else if(capacity == 0) {
            storage = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Capacity less then zero: " + capacity);
        }
    }

    public ArrayListImpl(T[] o) {
        if(o.length > 0) {
            storage = new Object[o.length];
            copy(o, storage);
            size = o.length;
        } else {
            storage = EMPTY_ARRAY;
        }
    }

    private void copy(Object[] resource, Object[] target) {
        for(int i = 0; i < resource.length; i++) {
            target[i] = resource[i];
        }
    }

    private void copyNextValues(Object[] resource) {
        for(int i = 0; i < resource.length; i++) {
            storage[size - resource.length + i] = resource[i];
        }
    }

    private void rebuild(int value) {
        Object[] o = new Object[storage.length + value];
        copy(storage, o);
        storage = o;
        size += value;
    }

    private void move(int index) {
        Object[] expected = new Object[size + 1];
        copy(storage, expected);
        for(int i = index; i < size; i++) {
            expected[i + 1] = storage[i];
        }
        storage = expected;
        size++;
    }

    public T[] toArray() {
        return (T[]) storage;
    }

    @Override
    public boolean add(T element) {
        if(storage.length < size + 1) {
            rebuild(1);
        }
        storage[size] = element;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if(index == size) {
            add(element);
        } else if(index < size) {
            move(index);
            set(index, element);
        } else {
            throw new IllegalArgumentException("Capacity less then ArrayList size: " + index);
        }
        return true;
    }

    @Override
    public boolean addAll(T[] o) {
        if(o.length > 0) {
            rebuild(o.length);
            copyNextValues(o);
            return true;
        } else {
            throw new IllegalArgumentException("Passed array is empty: " + o);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //TODO: remove size
    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    @Override
    public T get(int index) {
        return (T) storage[index];
    }

    @Override
    public Integer indexOf(Object o) {
        return 1;
    }

    @Override
    public boolean isEmpty(Object[] array) {
        return false;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public void set(int index, Object o) {
        storage[index] = o;
    }

    //TODO: replace method
}
