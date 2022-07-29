package array_list;

public interface ArrayList<T> {

    public int size();

    public boolean isEmpty();

    public boolean add(T t);

    public boolean add(int index, T t);

    public boolean addAll(T[] array);

    public void clear();

    public T get(int index);

    public T[] toArray();

    public Integer indexOf(T t);

    public boolean removeByIndex(int index);

    public boolean remove(T t);

    public void set(int index, T t);

// оба remove, replace
}
