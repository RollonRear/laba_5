package laba5.dop;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TheBestLinkedList<T> implements List<T>{
	
	int size;
	Node<T> first;
	Node<T> last;
	
	public T getLast() {
		return last.element;
	}
	
	public TheBestLinkedList() {
		size = 0;
		last = new Node<T>(null);
		first = new Node<T>(null);
		
		first.setNext(last);
		last.setPrevios(first);
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		if (size == 0) {
			last.element = (T)e;
			first.element = (T)e;
		}else if (size == 1) {
			last.element = (T)e;
		}else {
			Node<T> lastNode = last;
			last = new Node<T>((T)e);
			lastNode.next = last;
			last.previos = lastNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		Node<T> e = first;
	     while (e != null)
	      {
		        if (o.equals(e.element))
	          {
		            removeEntry(e);
	            return true;
		           }
	         e = e.next;
		      }
	   return false;
	}
	 void removeEntry(Node<T> e)
	    {
	      size--;
	      if (size == 0)
	        first = last = null;
	      else
	        {
	          if (e == first)
	            {
	              first = e.next;
	              e.next.previos = null;
	            }
	          else if (e == last)
	            {
	              last = e.previos;
	              e.previos.next = null;
	            }
	          else
	            {
	              e.next.previos = e.previos;
	              e.previos.next = e.next;
	            }
	        }
	    }

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		last = new Node<T>(null);
		first = new Node<T>(null);
		
		first.setNext(last);
		last.setPrevios(first);
		
		size = 0;
		
	}

	@Override
	public T get(int index) {
		return getNode(index).element;
		
	}
	
	private Node<T> getNode(int index) {
		Node<T> e;
		if (index < size / 2)
		{
		e = first;
		 while (index-- > 0)
		e = e.next;
		 }    else   {
			 e = last;
			 while (++index < size)
				 e = e.previos;
			 }
		return e;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
		Node<T> e = getNode(index);
		removeEntry(e);
	   return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public T getFirst() {
		// TODO Auto-generated method stub
		return first.element;
	}


}
