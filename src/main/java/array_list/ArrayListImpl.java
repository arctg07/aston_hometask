package array_list;

public class ArrayListImpl<T> implements ArrayList<T>{

    private static final Object[] EMPTY_ARRAY = new Object[10];

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

    public ArrayListImpl(T[] array) {
        if(array.length > 0) {
            storage = new Object[array.length];
            copyOfRange(array, storage, 0);
            size = array.length;
        } else {
            storage = EMPTY_ARRAY;
        }
    }

    private void copyOfRange(Object[] resource, Object[] target, int targetStartIndex) {
        for(int i = 0; i < resource.length; i++) {
            target[targetStartIndex + i] = resource[i];
        }
    }

    private void rebuild(int delta) {
        if(size + delta <= storage.length) {
            return;
        }

        int storageDelta = Math.max(storage.length / 2, delta);
        Object[] newStorage = new Object[storage.length + storageDelta];
        copyOfRange(storage, newStorage, 0);
        storage = newStorage;
    }
    private void checkOutOfBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public T[] toArray() {
        Object[] newArray = new Object[size];
        for(int i = 0; i < size; i++) {
            newArray[i] = storage[i];
        }
        return (T[]) newArray;
    }
    @Override
    public boolean add(T element) {
        rebuild(1);
        storage[size] = element;
        size++;

        return true;
    }

    @Override
    public boolean add(int index, T element) {
        checkOutOfBounds(index);
        rebuild(1);

        for(int i = size - 1; i >= index; i--) {
            storage[i + 1] = storage[i];
        }

        storage[index] = element;
        size++;

        return true;
    }

    @Override
    public boolean addAll(T[] array) {
        int delta = array.length;
        if(delta == 0) {
            return false;
        }

        rebuild(delta);
        copyOfRange(array, storage, delta);
        size = size + delta;
        return true;
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
        checkOutOfBounds(index);

        return (T) storage[index];
    }

    @Override
    public Integer indexOf(T element) {
        if(element == null) {
            for(int i = 0; i < size; i++) {
                if (storage[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(storage[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean removeByIndex(int index) {
        checkOutOfBounds(index);

        for(int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }

        storage[size - 1] = null;
        size--;

        return true;
    }

    @Override
    public boolean remove(T element) {
        int index = indexOf(element);
        if(index == -1) {
            return false;
        }

        return removeByIndex(index);
    }

    @Override
    public void set(int index, T element) {
        checkOutOfBounds(index);

        storage[index] = element;
    }

}
