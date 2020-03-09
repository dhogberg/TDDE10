package myutil;

public class MyList<E> extends MyVector<E> implements MyInterface {

	private Node<E> firstNode;

	public void add(E element) {
		if(this.size() == 0){
			this.firstNode = new Node<E>(element);
			this.changeSize(+1);
		}else{
			Node<E> tmpNode = this.firstNode;
			this.firstNode = new Node<E>(element);
			this.firstNode.setNextReference(tmpNode);	
			this.changeSize(+1);
		}
	}

	public E getElementAt(int i) {		
		if(this.size() != 0 && i < this.size() && i >= 0) {
			Node<E> tmpNode = this.firstNode;
			for(int ii=this.size()-1;ii>i;ii--){
				tmpNode = tmpNode.getNextReference();
			}
			return tmpNode.getData();
		}else{
			throw new IndexOutofBoundsException();
		}
	}
}