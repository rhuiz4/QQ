/*
  Team Name: QQ
  Team Members: Yu Qi Wu, Ri Hui Zheng, Elaina Chung
  APCS2 pd3
  LAB02 All Hands on Deque!
 */

public interface Deque<E>{
    
    public boolean add(E e);
    
    public void addFirst(E e);
    
    public E remove();

    public E removeFirst();

    public int size();
    
}

