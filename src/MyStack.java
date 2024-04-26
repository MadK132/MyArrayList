public class MyStack<T> {
    private T[] arr = (T[]) new Object[5];
    private int size;
    public MyStack(){
        size = 0;
    }
    public void Push(T item){
        arr[size++] = item;
    }
    public void Pop(int index){
        size--;
    }
    public T Peek(){
        return arr[size--];
    }
    public void Clear(){
        size = 0;
    }
}
