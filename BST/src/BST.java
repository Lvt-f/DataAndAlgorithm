/**
 * 二分搜索数，泛型需要可比较性
 * 现阶段所使用的二分搜索数不包含重复元素
 * 如果像包含重复元素的话，只需要定义：
 * 左子树小于等于节点；或者右子树大雨等于节点
 * 注意：数组和链表，可以有重复元素
 *
 * */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;//记录根节点
    private int size;//记录当前二分搜索数存储了多少个元素
    public BST(){
        root = null;
        size = 0;
    }
    /**
     * 返回二分搜索数当前存储的元素
     */
    public int size(){
        return size();
    }
    /**
     * 查看当前二分搜索数是否为空
     * */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * @param e
     * 向二分搜索树中添加新元素e(递归方式)
     * */
    public void add(E e){
        root =  add(root,e);
    }
    /**
     * @param e
     * @param node
     * 向以node为根的二分搜索树中插入元素E，递归算法
     * 返回插入新节点后二分搜索树的根
     * */
    private Node add(Node node,E e){
        //递归的终止条件
        if (node == null) {
            size++;
            return new Node(e);
        }
        //递归调用
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }
    /**
     * @param e
     * 看二分搜索树中是否包含元素e
     * */
    public boolean contains(E e){
        return contains(root,e);
    }
    /**
     * @param e
     * @param node
     * 看以node为根的二分二分搜索树中是否包含元素e，递归算法
     * */
    private boolean contains(Node node,E e){
        //递归的终止条件
        if (node == null) {
            return false;
        }
        //递归调用
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e)< 0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }










}
