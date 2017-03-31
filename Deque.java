/*
  Team Name: QQ
  Team Members: Yu Qi Wu, Ri Hui Zheng, Elaina Chung
  APCS2 pd3
  LAB02 All Hands on Deque!
 */

public interface Deque<E>{
    public boolean add(E e);
    
    public void addFirst(E e);
    
    public void addLast(E e);

    public E peek();
    
    public E peekFirst();
    
    public E peekLast();
    
    public E pop();
    
    public E remove();

    public e removeFirst();

    public e removeLast();

    public int size();
}
