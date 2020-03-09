package myutil;

public class MyStack<E> extends MyVector<E> implements MyInterface {

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

	public E pop() {
		if(!this.isEmpty()) {
			if(this.size() == 1){
				this.topOfStackNode = new Node<E>();
			}else{
				this.topOfStackNode = this.topOfStackNode.getNextReference();
			}
			this.changeSize(-1);
		}else {
			throw new EmptyStackException();
		}
		return this.topOfStackNode.getData();
	}
}