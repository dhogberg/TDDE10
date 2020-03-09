package myutil;

public class EmptyStackException extends RuntimeException {
	public EmptyStackException() {
		super("Cannot pop empty stack!");
	}
}