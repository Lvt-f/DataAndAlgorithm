public class LinkedListSet<E> implements Set<E>{

    private LinkedList<E> list;
    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        //集合不添加重复的数据
        if(!list.cotarins(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.cotarins(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}