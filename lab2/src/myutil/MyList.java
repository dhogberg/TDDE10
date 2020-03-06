package myutil;

public class MyList<E> extends ListVector<E> {

	private Node<E> firstNode;

	public void add(E element) {
		if(this.size() == 0){
			this.firstNode = new Node<E>(element);
			this.changeSize(+1);
		}else{
			this.firstNode.setNextReference(new Node<E>(element));
			this.changeSize(+1);
		}
	}

	public E getElementAt(int i) {
		Node<E> tmpNode = new Node<E>();
		if(this.size() != 0 && i < this.size()) {
			tmpNode = this.firstNode;
			for(int ii=0;ii<this.size();ii++){
				tmpNode = tmpNode.getNextReference();
			}
		}else{
			// ADD !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ADD //
			//// THROW EXCEPTION - LIST OUT OF BOUNDS ////
			// ADD !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ADD //
		}
		return tmpNode.getData();
	}
}