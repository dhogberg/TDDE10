package myutil;

public class MyStack<E> extends ListVector<E> {

	private Node<E> topOfStackNode;

	public void push(E element) {
		if(this.isEmpty()){
			this.topOfStackNode = new Node<E>(element);
			this.changeSize(+1);
		}else{
			this.topOfStackNode = new Node<E>(element, topOfStackNode);
			this.changeSize(+1);
		}
	}

	public E pop() { // Kastar exception om det ej finns något att poppa
		if(this.isEmpty()) {
			// ADD EXCEPTION
		}else {
			this.topOfStackNode = this.topOfStackNode.getNextReference();
			this.changeSize(-1);
		}
		return this.topOfStackNode.getData();
	}
}