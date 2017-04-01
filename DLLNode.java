/*
  Yu Qi Wu
  APCS2 pd3
  HW18a On the DLL
  2017-03-15
 */
/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode<T>
{

    private T _cargo;    //cargo may only be of type T
    private DLLNode _nextNode; //pointer to previous DLLNode
    private DLLNode _preNode; //pointer to previous DLLNode

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode pre, DLLNode next ) 
    {
	_cargo = value;
	_nextNode = next;
	_preNode = pre;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }
    public DLLNode getNext() { return _nextNode;}
    public DLLNode getPre() { return _preNode; }
    //--------------^  ACCESSORS  ^--------------
    

    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) 
    {
	_cargo = newCargo;
	return _cargo;
    }

    public DLLNode setPre( DLLNode newPre)
    {
	_preNode = newPre;
	return _preNode;
    }
    
    public DLLNode setNext( DLLNode newNext)
    {
	_nextNode = newNext;
	return _nextNode;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args ) 
    {

	
	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode last = new DLLNode( "cat", null, null );
	
	
	//Create a new node after the first
	last.setPre( new DLLNode( "dog", null,  last ) );
	
	//Create a third node after the second
	last.getPre().setPre( new DLLNode( "cow", null, last.getPre() ) );
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


        for (int i = 0; i < 2; i++) {
	    System.out.println( last );
	    last = last.getPre();
	}
	System.out.println( last );
	last = last.getNext();
	while( last != null){
	    System.out.println( last );
	    last = last.getNext();
	}
	/* A naive list traversal:
	*/

	//Q: When head ptr moves to next node in list,
	//   what happens to the node it just left?


    }//end main

}//end class LLNode
