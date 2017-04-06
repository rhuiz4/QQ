/*Team QQ -- Rihui Zheng, YuQi Wu, Elaina Chung
  APCS2 pd3
  Lab02 -- All Hands on Deque!
  2017-04-04
 */

public class QQ<E> implements Deque<E>{
    private DLLNode _front, _end; // front and end node
    private int _size; // size of the linked-node

    
    public void QQ(){
	_front = _end = null;
	_size = 0;
    }

    // add a variable to the end of the linked-node
    public boolean add(E e){
	if ( isEmpty() ){
	    _front = new DLLNode(e, null, _end);
	}
	else{
	    if (_end == null){
		_end = new DLLNode(e, _front, null);
		_end.setPre(_front);
		_front.setNext(_end);
	    }
	    else{
		_end.setNext(new DLLNode(e, _end, null));
		_end = _end.getNext();
	    }
	}
	_size++;

	return true;
    }

    // add a variable to the front of the linked-node
    public void addFirst(E e){
	if ( isEmpty() )
	    _front = new DLLNode(e, null, _end);
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

    // removes the first oocurence of e
    public boolean remove(E e){
        DLLNode tmp = _front;
	while(tmp.getNext() != null){
	    if(tmp.getCargo() == e){
		tmp = tmp.getNext();
		tmp.setPre(tmp.getPre().getPre());
		return true;
	    }
	}
	return false;
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

    // clear queue
    public void clear(){
	_front = null;
	_end = null;
	_size = 0;
    }

    //returns whether this deque contains the specified element
    public boolean contains(Object o){
	DLLNode tmp = _front;
	if (isEmpty())
	    return false;
	if (tmp.getCargo().equals(o))
	    return true;	
	while (tmp.getNext() != null){
	    tmp = tmp.getNext();
	    if (tmp.getCargo().equals(o))
		return true;
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

    // returns true if size==0, else false
    public boolean isEmpty(){
	return _size==0;
    }
    
    public String toString(){
	if (_size == 0)
	    return "";
	String retStr = "";
	DLLNode tmp = _front;
	retStr += tmp.getCargo() + " ";
	while (tmp.getNext() != null){
	    tmp = tmp.getNext();
	    retStr += (String)tmp.getCargo() + " ";
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

	// test contains(Object o)	
	System.out.println(test.contains("I") );
	System.out.println(test.contains("am") );
	System.out.println(test.contains("Hello,") );
	
	// test clear()
	test.clear();
	System.out.println("\ntest: " + test);
	System.out.println("size: " + test.size() );
	
	// test isEmpty()
	System.out.println("empty? " + test.isEmpty() );
    }

}
