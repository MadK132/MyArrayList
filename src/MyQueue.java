public class MyQueue<T> {
    private T[] arr = (T[]) new Object[5];
    private int size;
    public MyQueue(){
        size = 0;
    }
    //to add element in last position
    public void enqueue(T item){
        arr[size++] = item;
    }
    //to remove the first element
    public void dequeue(){
        for(int i = size; i>0; i--){
            arr[i-1] = arr[i];
        }
        size--;
    }
    public void clear(){
        size = 0;
    }
}
