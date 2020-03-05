package myutil;

public class Node<E> {
	
	private E data;
	private Node<E> nextReference;
	
	public Node() { // Without data and without reference to next
		this.nextReference = null;
	}
	public Node(E dataObject) { // With data but without reference to next
		this.data = dataObject;
		this.nextReference = null;
	}
	public Node(E dataObject, Node<E> nextReference) { // With both reference to next and data
		this.data = dataObject;
		this.nextReference = nextReference;
	}
	public void setData(E data) { // Set data of the node
		this.data = data;
	}
	public E getData() { // Get the data of the node
		return this.data;
	}
	public Node<E> getNextReference() { // Get the nextReference node
		return this.nextReference;
	}
	public void setNextReference(Node<E> nextReference) { // Set a node as nextReference
		this.nextReference = nextReference;
	}
}