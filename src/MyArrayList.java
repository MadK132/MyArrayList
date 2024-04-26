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
        checkIndex(index);
        arr[index] = item;
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
        if (size >= arr.length) {
            increaseBuffer();
        }
        for (int i = size; i > 0; i--) {   //Shift all elements to the right
            arr[i] = arr[i - 1];
        }
        arr[0] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[size++] = item;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public T getFirst() {
        return arr[0];
    }

    @Override
    public T getLast() {
        return arr[arr.length-1];
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
        for(int i = size; i>0; i--){
            arr[i-1] = arr[i];
        }
        size--;
    }

    @Override
    public void removeLast() {
        size--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) arr[j]).compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for(int i = 0 ; i<size; i++){
            if(arr[i] == object){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int lastind = -1;
        for(int i = 0; i<size; i++){
            if(arr[i]==object){
                lastind = i;
            }
        }
        return lastind;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
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
 