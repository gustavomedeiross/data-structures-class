public interface LinkedList<T> {
    public void add(T t);
    public T first();
    public T last();
    public T get(int index);
    public int indexOf(T t);
    public int size();
    public boolean isEmpty();
}
