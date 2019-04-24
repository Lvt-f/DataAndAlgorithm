public class ArrayStack<E> implements Stack<E> {
    Array<E> array;
    //知道需要创建多大的容器,构造函数
    public ArrayStack(int capacity)
    {
        array = new Array<>(capacity);
    }
    //不知道需要创建多大的容器,构造函数
    public ArrayStack()
    {
        array = new Array<>();
    }
    //返回int型
    @Override
    public int getSize() {
        return array.getSize();
    }
    //返回的boolean
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    /**
     * 获取数量的容量
     * */
    public int getCapacity()
    {
        return array.getCapacity();
    }
    //向栈中添加元素
    @Override
    public void push(E e) {
        array.addLast(e);
    }
    //从栈中取出元素
    @Override
    public E pop() {
        return array.removeLast();
    }
    //看一下栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i = 0; i <array.getSize(); i++)
        {
            res.append(array.get(i));
            if(i != array.getSize() - 1)
            {
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
