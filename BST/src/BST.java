import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     * 看以node为根的二分搜索树中是否包含元素e，递归算法
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
    /**
     * 二叉树的前序遍历
     * */
    public void preOrder(){
        preOrder(root);
    }
    /**
     * @param node
     * 前序遍历以node为根的二分搜索树，递归算法
     * */
    private void preOrder(Node node){
        //递归终止条件
        if (node == null) {
            return;
        }
        //递归的逻辑代码
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
//        //不遵守递归终止条件的时候
//        if(node != null){
//            System.out.println(node.e);
//            preOrder(node.left);
//            preOrder(node.right);
//        }
    }
    /**
     *二分搜索数的非递归前序遍历，模拟了系统栈
     * 经典教科书会讲解二分搜索树非递归的后续/中序遍历
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();//当前要访问的节点
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }
    /**
     * 二分搜索树的层序(广度)遍历
     * 常用于算法设计中-最短路径
     * 图中的深度优先遍历和广度优先遍历
     * */
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    /**
     * @param node
     * @param depth 深度
     * @param res 字符串
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * */
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if (node == null) {
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    //二分搜索树的中序遍历
    public void inorder(){
        inorder(root);
    }
    /**
     * @param node
     * 中序遍历以node为根的二分搜索树，递归算法
     * */
    private void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.println(node.e);
        inorder(node.right);
    }
    //二分搜索树，后续遍历
    public void postOrder(){
       postOrder(root);
    }
    /**
     * @param node
     * 后序遍历以node为根的二分搜索树，递归算法
     * 后序遍历的一个应用：二叉搜索树内存释放
     * */
    private void postOrder(Node node){
        if (node == null) {
            return;
        }
        //先处理左子树
        postOrder(node.left);
        //在处理右子树
        postOrder(node.right);
        //打印根节点
        System.out.println(node.e);
    }

    /**
     * 寻找二分搜索树的最小值
     * */
    public E minmum(){
        if(size == 0){
            throw  new IllegalArgumentException("BST is empty!");
        }
        return minmum(root).e;
    }
    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minmum(Node node){
        if (node.left == null)
            return node;
        return minmum(node.left);
    }

    /**
     * 寻找二分搜索树的最大值
     * */
    public E maxmum(){
        if(size == 0){
            throw  new IllegalArgumentException("BST is empty!");
        }
        return maxmum(root).e;
    }
    //返回以node为根的二分搜索树的最大值所在的节点
    private Node maxmum(Node node){
        if (node.right == null)
            return node;
        return maxmum(node.right);
    }
    //从二分搜索数中删除最小值所在的节点，返回最小值
    public E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }
    //删除以node为根的二分搜索数中的最小节点
    //返回删除以后新的二分搜索树的根
    private Node removeMin(Node node){
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left =removeMin(node.left);
        return node;
    }

    //从二分搜索数中删除最大值所在的节点，返回最大值
    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }
    //删除以node为根的二分搜索数中的最大节点
    //返回删除以后新的二分搜索树的根
    private Node removeMax(Node node){
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right =removeMax(node.right);
        return node;
    }
    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root,e);
    }
    //删除以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node,E e){
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right,e);
            return node;
        }else {//(e == node.e)
            //待删除的节点左子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除的节点右子树为空的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //待删除的节点左右子树都不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minmum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;

        }
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
