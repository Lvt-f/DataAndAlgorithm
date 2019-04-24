public interface Queue<E> {
    int getSize();//查看队列里面的元素
    boolean isEmpty();//队列是否为空
    void enqueue(E e);//向队列里面添加元素
    E dequeue();//出队
    E getFront();//看队首元素
}
