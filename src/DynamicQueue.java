public class DynamicQueue<T> implements Queue<T> {
    private Node<T> head;

    public void enqueue(T t) {
        Node<T> enqueable = new Node<>(t);
        if (head == null) {
            head = enqueable;
        } else {
            last(head).next = enqueable;
        }
    }

    private Node<T> last(Node<T> node) {
        if (node.next != null) {
            return last(node.next);
        }

        return node;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Node<T> dequeued = head;
        head = head.next;
        return dequeued.value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return head.value;
    }

    public int size() {
        return size(head);
    }

    private int size(Node<T> node)  {
        if (node != null) {
            return 1 + size(node.next);
        }
        return 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isNotEmpty() {
        return ! this.isEmpty();
    }

    private class Node<E> {
        Node<E> next;
        E value;

        Node(E value) {
            this.value = value;
        }
    }
}
