public class LinkedListImpl<T> implements LinkedList<T> {
    private Node<T> head;

    @Override
    public void add(T t) {
        Node<T> node = new Node<T>(t);
        if (isEmpty()) {
            head = node;
        } else {
            last(head).next = node;
        }
    }

    @Override
    public T first() {
        if (isNotEmpty()) {
            return head.value;
        }
        return null;
    }

    @Override
    public T last() {
        if (isNotEmpty()) {
            return last(head).value;
        }
        return null;
    }

    private Node<T> last(Node<T> node) {
        return node.next != null ? last(node.next) : node;
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        for (int i=0; i<index; i++)
            current = current.next;

        return current.value;
    }

    @Override
    public int indexOf(T t) {
        int size = size();
        Node<T> current = head;

        for(int i = 0; i<size; i++) {
            if (t.equals(current.value)) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    @Override
    public int size() {
        return size(head);
    }

    private int size(Node<T> node)  {
        if (node != null) {
            return 1 + size(node.next);
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    private boolean isNotEmpty()  {
        return ! isEmpty();
    }

    private class Node<U> {
        U value;
        Node<U> next;

        Node(U value) {
            this.value = value;
            next = null;
        }
    }
}
