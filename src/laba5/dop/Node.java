package laba5.dop;

public class Node<T>  {
	T element;
	Node<T>  previos;
	Node<T>  next;
	Node(T element) {
        this.element = element;
    }
	void setNext(Node<T>  next){
		this.next = next;
	}
	void setPrevios(Node<T>  previos){
		this.previos = previos;
	}
	public String toString() {
		return element.toString();
	}
}
