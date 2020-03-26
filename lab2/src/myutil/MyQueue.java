package myutil;

public class MyQueue<E> extends MyVector<E> implements MyInterface {

	private Node<E> first, last;
	
	public void enqueue(E element) {
		Node<E> tmpNode = new Node<E>(element);
		if(this.isEmpty()){
			this.first = tmpNode;
		}else{
			this.last.setNextReference(tmpNode);
		}
		this.last = tmpNode;
		this.changeSize(+1);
	}

	public E dequeue() {
		if(!this.isEmpty()) {
			Node<E> tmpReturnNode = first;
			if(this.size() == 1){
				this.first = new Node<E>();
			}else{
				this.first = this.first.getNextReference();
			}
			this.changeSize(-1);
			return tmpReturnNode.getData();
		}else {
			throw new EmptyQueueException();
		}
	}
}