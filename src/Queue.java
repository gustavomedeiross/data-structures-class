public interface Queue<T> {
    public void enqueue(T t);
    public T dequeue();
    public T peek();
    public int size();
    public boolean isEmpty();
    public boolean isNotEmpty();
}
