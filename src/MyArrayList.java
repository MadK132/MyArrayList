import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private T[] arr = (T[]) new Object[5];
    private int size;
    public MyArrayList(){
        size = 0;
    }

    @Override
    public void add(T item) {
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[size++] = item;
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i = 0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if(size>= arr.length){
            increaseBuffer();
        }
        arr[index] = item;
    }
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("index not correct");
        }
    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index+1; i <size ; i++) {
            arr[i-1] = arr[i];
        }
        size--;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

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
        arr = (T[]) new Object[5];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
 