//组成链表节点的类
class LinkedList<E> {
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
    /**
     * 虚拟头节点
     * 就是在向链表任意一个地方添加元素的时候，在链表头添加元素和在链表的其他位置添加元素逻辑上会有差别。
     * 究其原因，是因为我们对链表添加元素的过程要找到那个待添加位置之前的一个节点，但是由于对链表头来说，它没有前一个节点，所以在逻辑上会特殊一些。
     * 不过在链表的实现中，有一个非常有用的技巧，把对链表头的特殊操作与其他操作统一起来，也就是可以自己创造一个链表头前面的节点。
     * 这个之前的节点其实不存储任一个元素，所以这个元素写成null，将这个空节点称之为dummyHead，也就是虚拟头结点。
     * 就是在向链表任意一个地方添加元素的时候，在链表头添加元素和在链表的其他位置添加元素逻辑上会有差别。
     * 究其原因，是因为我们对链表添加元素的过程要找到那个待添加位置之前的一个节点，但是由于对链表头来说，它没有前一个节点，所以在逻辑上会特殊一些。
     * 不过在链表的实现中，有一个非常有用的技巧，把对链表头的特殊操作与其他操作统一起来，也就是可以自己创造一个链表头前面的节点。
     * 这个之前的节点其实不存储任一个元素，所以这个元素写成null，将这个空节点称之为dummyHead，也就是虚拟头结点。
     * */
    private Node dummyhead;//虚拟头节点
    int size;
    public LinkedList()
    {
        dummyhead = new Node(null,null);
        size = 0;
    }
    //获取链表中的元素个数
    public int getSize()
    {
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表的index(0-based)位置添加新的元素e
    //在链表中不是一个常用的操作，练习用：
    public void add(int index ,E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add failed.Illegal index.");
        Node prev = dummyhead;
        for (int i = 0; i < index; i++) {
            prev =prev.next;
        }
        prev.next = new Node(e,prev.next);
        size++;
    }
    //在链表的末尾添加元素
    public void addLast(E e) {
        add(size,e);
    }
    //在链表头添加新元素e
    public void addFirst(E e) {
        add(0,e);
    }
    //获得链表的index(0-based)位置的元素e
    //在链表中不是一个常用的操作，练习用：
    public E get(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get failed.Illegal index.");
        Node cur = dummyhead.next;//从索引为0开始遍历
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    //获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }
    //获得链表的第一个元素
    public E getLast() {
        return get(size -1);
    }
    //修改链表的第index(0-based)位置的元素e
    //在链表中不是一个常用的操作，练习用：
    public void set(int index,E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set failed.Illegal index.");
        Node cur = dummyhead.next;//遍历链表内的每一个元素，从索引为0元素开始遍历
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    //查找链表中的元素e
    public boolean cotarins(E e) {
        Node cur = dummyhead.next;
        while(cur != null)
        {
            if(cur.e.equals(e))
            {
                return true;
            }else
            {
                cur = cur.next;
            }
        }
        return false;
    }

    //从链表中删除index(0-based)位置的元素e，返回删除的元素
    //在链表中不是一个常用的操作，练习用：
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set failed.Illegal index.");
        Node prev = dummyhead;
        for (int i = 0; i <index ; i++) {
            prev = prev.next;//等于待删除之前的节点
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }
    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }
    //从链表中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size-1);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyhead.next;
        while(cur != null)
        {
            stringBuilder.append(cur+"->");
            cur=cur.next;
        }
//        for (Node cur = dummyhead.next; cur != null; cur = cur.next)
//        {
//            stringBuilder.append(cur+"->");
//            cur=cur.next;
//        }
        stringBuilder.append("NULL");//链表最后一个元素指向NULL
        return stringBuilder.toString();
    }
}
