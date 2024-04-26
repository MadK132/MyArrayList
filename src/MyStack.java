public class MyStack<T> {
    private T[] arr = (T[]) new Object[5];
    private int size;
    public MyStack(){
        size = 0;
    }
    //push() to push element in the end
    public void Push(T item){
        arr[size++] = item;
    }
    //pop() to remove the last element
    public void Pop(int index){
        size--;
    }
    //peek() to return the last element
    public T Peek(){
        return arr[size--];
    }
    public void Clear(){
        size = 0;
    }
}
