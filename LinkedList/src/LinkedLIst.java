//组成链表节点的类
public class LinkedList<E> {
    /**
     *Node 节点，设计成链表的内部类，用户不需要知道有链表的内部类存在
     *对外部用户屏蔽底层实现的细节
     * */
    private class Node
    {
        public E e;
        public Node next;
        //构造函数,用户传来e、和next
        public Node(E e,Node next)
        {
            this.e = e;
            this.next = next;
        }
        //构造函数,用户传来e
        public Node(E e)
        {
            this(e,null);
        }
        //构造函数,用户不传来任何数值
        public Node()
        {
            this(null,null);
        }

        @Override
        public String toString()
        {
            return e.toString();
        }
    }
    private Node head;
    int size;
    public LinkedList()
    {
        head = null;
        size = 0;
    }
    //获取链表中的元素个数
    public int getSize()
    {
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty()
    {
        return size == 0;
    }
    //在链表头添加新元素e
    public void addFirst(E e)
    {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e,head);
        size++;
    }
    //在链表的index(0-based)位置添加新的元素e
    //在链表中不是一个常用的操作，练习用：
    public void add(int index ,E e)
    {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add failed.Illegal index.");

        if(index == 0)
        {
            addFirst(e);
        }else
        {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev =prev.next;

                Node node = new Node(e);
                node.next = prev.next;
                prev.next = node;

//                prev.next = new Node(e,prev.next);
                size++;
            }
        }
    }
    //在链表的末尾添加元素
    public void addLast(E e)
    {
        add(size,e);
    }
}
