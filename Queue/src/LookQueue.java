public class LookQueue<E> implements Queue<E> {
    /**
     * 不实用size，只使用front和tail去计算出队列的长度
     * 数组扩容和缩容
     * */
    private E[] data;
    private int front ,tail;
    private int size;

    public LookQueue(int capacity)
    {
        //循环队列会浪费一个空间，所以capacity的容积是capacity+1
        data = (E[]) new Object[capacity+1];
        front = 0;
        size = 0;
        tail= 0;
    }
    public LookQueue()
    {
        this(10);
    }

    public int getCapacity()
    {
        return data.length-1;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }
    //插入元素
    @Override
    public void enqueue(E e) {
        //查看队列是否是满的
        if((tail + 1)% data.length == front)
        {
            resize(getCapacity() * 2);//扩容
        }
        data[tail] = e;
        tail = (tail + 1)%data.length;
        size++;
    }
    //删除元素
    @Override
    public E dequeue() {
        if(isEmpty())//判断是否为空
        {
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = ( front + 1 ) % data.length;
        size--;
        if(size == getCapacity() /4 && getCapacity() != 0)
        {
            resize(getCapacity()/2);//缩容操作
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())//判断是否为空
        {
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        }
        return data[front];
    }
    //扩容、缩容
    private void resize(int newCapacity)
    {
        E[]newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front)%data.length];
        }
        data= newData;
        front = 0;
        tail = size;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue:size = %d,capacity = %d\n",size,getCapacity()));
        res.append("front [");
        for (int i= front;i != tail ;i = (i + 1) % data.length){
            res.append(data[i]);
            if( (i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args)
    {
        LookQueue<Integer> queue = new LookQueue<>();
        for (int i = 0; i <10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2)
            {
                queue.dequeue();
                System.out.println(queue);
                System.out.println(queue.getFront());
                System.out.println(queue.getSize());
            }
        }
    }
}

