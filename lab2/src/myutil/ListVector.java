package myutil;

public class ListVector<E> {
	
	private int size = 0;

	public boolean isEmpty() {
		if(this.size == 0){
			return true;
		}else{
			return false;
		}
	}

	public int size(){
		return this.size;
	}

	public void changeSize(Integer sizeChange){
		this.size = this.size + sizeChange;
	}
}