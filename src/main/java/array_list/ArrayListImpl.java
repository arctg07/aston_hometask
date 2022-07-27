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
            copyOfRange(o, storage, 0, o.length);
            size = o.length;
        } else {
            storage = EMPTY_ARRAY;
        }
    }

    private void copyOfRange(Object[] resource, Object[] target, int start, int end) {
        for(int i = start; i < end; i++) {
            target[i] = resource[i];
        }
    }
    private void copyOfRangeToNewArray(Object[] resource, Object[] target, int start, int end) {
        int count = 0;
        for(int i = start; i < end; i++) {
            target[count] = resource[i];
            count++;
        }
    }

    private void copyOfRangeNextValues(Object[] resource, Object[] target, int start, int end) {
        for(int i = start; i < end; i++) {
            target[i - 1] = resource[i];
        }
    }

    private void copyNextValues(Object[] resource) {
        for(int i = 0; i < resource.length; i++) {
            storage[size - resource.length + i] = resource[i];
        }
    }

    private void rebuild(int value) {
        Object[] o = new Object[storage.length + value];
        copyOfRange(storage, o, 0, storage.length);
        storage = o;
        size += value;
    }

    private void moveElementsForward(int index) {
        Object[] o = new Object[size + 1];
        copyOfRange(storage, o, 0, storage.length);
        for(int i = index; i < size; i++) {
            o[i + 1] = storage[i];
        }
        storage = o;
        size++;
    }

    @Override
    public T[] toArray() {
        return (T[]) storage;
    }

    @Override
    public boolean add(T element) {
        if(storage.length < size + 1) {
            rebuild(1);
        }
        storage[size - 1] = element;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if(index == size) {
            add(element);
        } else if(index < size) {
            moveElementsForward(index);
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

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        return (T) storage[index];
    }

    @Override
    public Integer indexOf(Object o) {
        if(o == null) {
            for(int i = 0; i < size; i++) {
                if (storage[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(storage[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean remove(int index) {
        Object[] o = new Object[size - 1];
        if(index < size - 1 && index > 0) {
            copyOfRange(storage, o, 0, index);
            copyOfRangeNextValues(storage, o, index + 1, size);
            storage = o;
        } else if(index == size - 1) {
            copyOfRange(storage, o, 0, size - 1);
            storage = o;
        } else if(index == 0) {
            copyOfRangeToNewArray(storage, o, 1, size);
            storage = o;
        }
        size -= 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int removeIndex = this.indexOf(o);
        remove(removeIndex);
        return true;
    }

    @Override
    public void set(int index, Object o) {
        storage[index] = o;
    }

    //TODO: replace method
}
