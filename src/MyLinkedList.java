import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    private MyNode head;
    private MyNode tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    //we save other tail element, because we add element in the end by add()
    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }
    //By cycle checking on index and setting to the current element
    @Override
    public void set(int index, T item) {
        MyNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.element = item;
    }
//adding the element checking for situational processes and then adding elements
    @Override
    public void add(int index, T item) {
        if (index == size) {
            addLast(item);
        } else if (index == 0) {
            addFirst(item);
        } else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            MyNode newNode = new MyNode(item);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }
//Add element on zero position
    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    size++;
    }
//unnecessary here
    @Override
    public void addLast(T item) {
        add(item);
    }
//get the element by it index
    @Override
    public T get(int index) {
        MyNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }
//just get element in the head
    @Override
    public T getFirst() {
        return head.element;
    }
//just get element in the tail
    @Override
    public T getLast() {
        return tail.element;
    }
//remove element by situations and then by index
    @Override
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }
//removefirst() just remove header
    @Override
    public void removeFirst() {
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
//removelast() just remove tail
    @Override
    public void removeLast() {
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {

    }
//indexof() get index of first occurence of the element
    @Override
    public int indexOf(Object object) {
        int index = 0;
        MyNode current = head;
        while (current != null) {
            if (current.element.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
//get element by the last occurence of the element
    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        MyNode current = tail;
        while (current != null) {
            if (current.element.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


}