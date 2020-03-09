package myutil;

public class MyQueue<E> extends MyVector<E> implements MyInterface {

	private Node<E> topOfStackNode;
	
	public void enqueue(E element) {
		if(this.isEmpty()){
			this.topOfStackNode = new Node<E>(element);
			this.changeSize(+1);
		}else{
			this.topOfStackNode = new Node<E>(element, topOfStackNode);
			this.changeSize(+1);
		}
	}

	public E dequeue() {
		if(!this.isEmpty()) {
			if(this.size() == 1){
				this.topOfStackNode = new Node<E>();
			}else{
				this.topOfStackNode = this.topOfStackNode.getNextReference();
			}
			this.changeSize(-1);
		}else {
			throw new EmptyQueueException();
		}
		return this.topOfStackNode.getData();
	}
}