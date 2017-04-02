/*Team QQ -- Rihui Zheng, YuQi Wu, Elaina Chung
  APCS2 pd3
  Lab02 -- All Hands on Deque!
  2017-04-04
 */

public class QQ<E> implements Deque<E>{
    private DLLNode _front, _end; // front and end node
    private int _size; // size of the linked-node

    
    public void QQ(){
	_front = new DLLNode(null, null, null);
	_end = new DLLNode(null, null, null);
	_size = 0;
    }

    // add a variable to the end of the linked-node
    public boolean add(E e){
	if (_size == 0){
	    _front = new DLLNode(e, null, null);
	}
	else{
	    DLLNode temp = _front;
	    for (int y = 0; y < _size - 1; y++)
		temp = temp.getNext();
	    temp.setNext(new DLLNode (e, temp, null) );
	    _end = temp.getNext();
	}
	_size++;

	return true;
    }

    // add a variable to the front of the linked-node
    public void addFirst(E e){
	if (_size == 0)
	    _front.setCargo(e);
	else{
	    DLLNode temp = new DLLNode(e, null, _front);
	    temp.setNext(_front);
	    _front = temp;
	}
	_size++;
    }

    // remove a variable at the end of the linked-node
    public E remove(){
	E ret = (E)(_end.getCargo());
	_end = _end.getPre();
	_end.setNext(null);
	_size--;
	return ret;
    }

    // add a variable to the front of the linked-node
    public E removeFirst(){
	E ret = (E)(_front.getCargo());
	_front = _front.getNext();
	_front.setPre(null);
	_size--;
	return ret;
    }

    // return the size of the linked-node
    public int size(){
	return _size;
    }

    //returns whether this deque contains the specified element
    public boolean contains(Object o){
	DLLNode tmp = _front;
	while (tmp.getNext() != null){
	    if (tmp.getCargo() == o)
		return true;
	    tmp = tmp.getNext();
	}
	return false;
    }

    //returns first element without removing
    public E getFirst(){
	return (E)_front.getCargo();
    }

    //returns last element without removing
    public E getLast(){
	return (E)_end.getCargo();
    }
    
    public String toString(){
	if (_size == 0)
	    return "";
	String retStr = "";
	DLLNode tmp = _front;
	retStr += tmp.getCargo() + " ";
	while (tmp.getNext() != null){
	    tmp = tmp.getNext();
	    retStr += tmp.getCargo() + " ";
	}
	return retStr;
    }


    public static void main(String[] args){
	// test case
	Deque<String> test = new QQ<String>();

	// test add()
	test.add("I");	
	test.add("am");	
	test.add("a");
	test.add("test");
	test.add("case");
	System.out.println(test + "\n"); // I am a test case

	// test addFirst
	test.addFirst("Hello,");
	System.out.println(test + "\n"); // Hello, I am a test case

	// test getFirst() and getLast()
	System.out.println("First: " + test.getFirst()); // Hello,
	System.out.println("Last: " + test.getLast() + "\n"); // case
	
	// test remove()
	test.remove();
	System.out.println(test); // Hello, I am a test
	test.remove();
	System.out.println(test); // Hello, I am a
	test.remove();
	System.out.println(test + "\n"); // Hello, I am
 
	// test removeFirst()
	test.removeFirst();
	System.out.println(test + "\n"); // I am

	// test size()
	System.out.println(test.size()); // 2
	
    }

}
