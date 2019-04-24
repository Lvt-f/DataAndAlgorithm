/**
 * 泛型中不能使用基本数据类型eg:int、short等，可以使用其包装类
 * */

public class Array<E> {//E为一个数据类型，使用时可以重新定义

    private E[] data;
    private int size;// 在data数组中有多少有效的元素

    /**
     * @param capacity
     * 构造函数，传入数组的容量capacity构造Array
     */
    public Array(int capacity){
        //data = new E[capacity];//此处是不合法的，需要绕弯子new Object类然后强制转化
        data = (E[]) new Object[capacity];//Object 是任意类的父类
        size = 0;
    }
    /**
     * 无参数的构造函数，传入数组的容量capacity构造Array
     * */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * */
    public int getSize(){
        return size;
    }
    /**
     * 获取数量的容量
     * */
    public int getCapacity(){
        return data.length;
    }
    /**
     * 返回数组是否为空
     * */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * @param e
     * 在数组的末尾添加元素
     * */
    public void addLast(E e){
        add(size,e);
    }
    /**
     * @param e
     * 在数组的开头添加元素
     * */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在数组的删除开头的元素
     * */

    public E removeFirst(){
        return remove(0);
    }
    /**
     * 在数组中删除最后一个元素
     * */
    public E removeLast(){
        return remove(size -1);
    }

    /**
     * @param e
     * 查找数组中是否有元素e
     * */
    public boolean contains(E e){
        for(int i = 0;i<size;i++){
            if(data[i].equals(e)){//==为数值比较 equal为地址比较
                return true;
            }
        }
        return false;
    }
    /**
     * @param e
     * 查找数组中元素e所在的索引，如果不存在的元素额，则返回-1
     * */
    public int find(E e){
        for(int i = 0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    /**
     * @param e
     * 查找数组中所有元素e所在的索引，如果不存在的元素额，则返回-1
     * */
    public int findAll(E e){

        return -1;
    }


    /**
     * @param e
     * 从数组中删除元素e，只删除了一个元素
     * */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }
    /**
     * @param e
     * 从数组中所有删除元素e，
     * */
    public void removeAllElement(E e) {

    }
    /**
     * @param e
     * @param index
     * 向数组中指定位置添加元素
     * */
    public void add(int index,E e){

        if(index < 0||index > size){
            throw new IllegalArgumentException("AddLast failed.Require index<0||index>size");
        }
        if(size == data.length){
           // throw new IllegalArgumentException("AddLast failed.Array is full");
            resize(2 * data.length);//扩容数组
        }
        //从最后一个元素开始到需要插入的位置，
        for ( int i = size - 1 ; i >= index ; i-- ){
            //把后一个索引位置赋值前一个位置元素，相当于扩容了一个位置
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }
    /**
     * @param e
     * @param index
     * 修改index索引位置的元素e
     * */
    void set(int index , E e){
        if(index <0 || index >size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        data[index] = e;
    }
    /**
     * @param index
     * 获取index索引位置的元素
     * */
    public E get(int index){
        if(index <0 || index >size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }
    //获取最后一个位置的元素
    public E getLast()
    {
        return get(size - 1);
    }
    //获取第一个位置的元素
    public E getFirst()
    {
        return get(0);
    }
    /**
     * @param index
     * 从数组中删除index位置的元素，返回删除的元素
     * */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        E ret = data[index];
        for(int i = index + 1;i < size;i++){
            data[i-1]=data[i];
        }
        size --;
        data[size] = null;//loitering objects 闲散的对象 !=memory leak 内存泄漏

        if(size == data.length / 4 && data.length / 2 != 0){
         resize(data.length / 2);//数组缩减的时候可能为0
        }
        return ret;
    }

    @Override
    public String toString(){
      StringBuilder res = new StringBuilder();
      res.append(String.format("Array:size = %d,capacity = %d\n",size,data.length));
      res.append('[');
      for (int i=0;i<size;i++){
          res.append(data[i]);
          if(i!=size-1) {
              res.append(",");
          }
      }
        res.append(']');
        return res.toString();
    }
    /**
     * @param newCapacity
     * 数组的扩容
     * */
    private void resize(int newCapacity){
        E[] newData= (E[]) new Object[newCapacity];
        for (int i = 0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;//将原来的data指向新的data
    }
}
