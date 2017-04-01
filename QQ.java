/*hi
 */

public class QQ<E> implements Deque<E>{
    private DLLNode _front, _end; // front and end node
    private int _size; // size of the linked-node

    public static void main(String[] args){
	// test case
    }

    public void QQ(){
	_front = new DLLNode(null, null, _end);
	_end = new DLLNode(null, _front, null);
	_size = 0;
    }

    // add a variable to the end of the linked-node
    public boolean add(E e){
	if ( _front.getCargo() ==  null)
	    _front.setCargo(e);
	else if(_end.getCargo() == null)
	    _end.setCargo(e);
	else{
	    _end = new DLLNode(e, _end.getPre(), null);
	}
	_size++;
	return true;
    }

    // add a variable to the front of the linked-node
    public void addFirst(E e){
	if (_front.getCargo() == null)
	    _front.setCargo(e);
	else if (_end.getCargo() == null){
	    _end.setCargo( _front.getCargo() );
	    _front.setCargo(e);
	}
	else{
	    DLLNode temp = new DLLNode(e, null, _front);
	    _front = temp;
	}
	_size--;
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
}
