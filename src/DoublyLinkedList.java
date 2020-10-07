public class DoublyLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T t) {
        Node<T> node = new Node<T>(t);
        if (isEmpty()) {
            head = node;
            tail = head;
            node.previous = null;
        } else {
            Node<T> last = last(head);
            last.next = node;
            node.previous = last;
            tail = node;
        }
    }

    @Override
    public void put(T t, int index) {
        Node<T> newNode = new Node<T>(t);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node<T> current = getNodeByIndex(index-1);
        newNode.next = current.next;
        current.next = newNode;

        if (index == size() - 1) {
            tail = newNode;
        }
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            Node<T> right = head.next;
            head = right;
            right.previous = head;
            return;
        }

        Node<T> left = getNodeByIndex(index - 1);
        Node<T> middle = left.next;
        Node<T> right = middle.next;
        left.next = right;

        if (right != null)
            right.previous = left;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = head;
        for (int i=0; i<index; i++)
            current = current.next;
        return current;
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
        return tail;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).value;
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
        Node<U> previous;
        Node<U> next;

        Node(U value) {
            this.value = value;
            this.previous = null;
            next = null;
        }
    }
}
