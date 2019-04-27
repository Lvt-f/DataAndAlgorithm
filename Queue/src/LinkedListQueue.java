public class LinkedListQueue<E> implements Queue<E> {
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
    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;//队首
        tail = null;//队尾
        size = 0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override//入队
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override//出队
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue.");
        }
        return head.e;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
    public static void main(String[] args)
    {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i <10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
//                System.out.println(queue.getFront());
//                System.out.println(queue.getSize());
            }
        }
    }
}
