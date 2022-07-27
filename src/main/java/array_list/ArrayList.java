package array_list;

public interface ArrayList<T> {

    public int size();

    public boolean isEmpty();

    public boolean add(T t);

    public boolean add(int index, T t);

    public boolean addAll(T[] array);

    public void clear();

    public T get(int index);

    public Integer indexOf(T t);

    public boolean isEmpty(T[] array);

    public void remove(int index);

    public void remove(T t);

    public void set(int index, T t);

// оба remove, replace
}
