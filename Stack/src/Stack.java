public interface Stack<E> {
    int getSize();//返回int型
    boolean isEmpty();//返回的boolean
    void push(E e);//向栈中添加元素
    E pop();//从栈中取出元素
    E peek();//看一下栈顶元素
}
