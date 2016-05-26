/*****************************************************
James Cao
APCS2 
HW43 -- Heap of Trouble
2016-05-23 
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    {  
		_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    { 
    	String ret = "";
		int level = 1;
		for (int i = 0; i< _heap.size(); i++){
			ret += i + "--" + _heap.get(i) + " ";
			if (i >= Math.pow (2,level) -2){
				ret += "\n";
				level++;
			}
		}
		return ret;
    }//O(?)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 
	return _heap.isEmpty(); 
    } //O(?)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    { 
    	if (_heap.size() == 0){
    		return null;
    	}
    	else{
    		return _heap.get(0);
    	}
    } //O(?)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) 
    { 
		_heap.add (addVal);
		int tempChild = _heap.size() -1;
		int parent = (tempChild -1)/2;
		
		
		while (tempChild > 0){
			parent = (tempChild -1)/2;
			
			if (_heap.get(parent) > addVal){
				swap (tempChild, parent);
				tempChild = parent;
			}
			else{
				tempChild = -1;
			}
		}
		
    } //O(?)


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() 
    {
    	if (_heap.size() == 0){
    		return -1;
    	}
		int ret = peekMin();
		int sub = _heap.get (_heap.size() -1);
		swap (0, _heap.size()-1);
		_heap.remove (_heap.size()-1);
		
		int index = 0;
		int tempChild = minChildPos (index);
		
		while (_heap.size() > index){
			if ((tempChild >= _heap.size()) || (index == -1)){
				break;
			}
			if (sub > _heap.get(tempChild)){
				swap (index, tempChild);
				index = tempChild;
			}
			else{
				index = _heap.size();
			}
		}
		return ret;
    }//O(?)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {
		int val;
		int left = pos*2 + 1;
		int right = pos*2 + 2;
		
		if (right >= _heap.size()){
			val = left;
		}
		else if ( _heap.get(right) < _heap.get(left)){
			val = right;
		}
		
		else{
			val = left;
		}
		return val;
    }//O(?)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {



	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(4);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(6);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(8);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(10);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(1);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(3);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(5);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(7);
	  System.out.println(pile);
	  System.out.println();
	  pile.add(9);
	  System.out.println(pile);
	  System.out.println();
	  
	  System.out.println (pile._heap);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	/*--V--------------MOVE ME DOWN------------------V---
	  ==|============================================|===*/

    }//end main()

}//end class ALHeap
