package tests;

import myutil.*;

public class MyStackTest {
	public static MyStack<Integer> testStack1;
	public static Integer testInteger1;
	public static Integer testInteger2;
	public static Integer testInteger3;
	public static Integer testInteger4;

	public static void run(){
		testInteger1 = 3;
		testInteger2 = 5;
		testInteger3 = 7;
		testInteger4 = 9;

		System.out.print("- - Testing myutil/MyStack.java - -\n\n");

		System.out.print("Creating a stack with name 'testStack1'.\n");
		testStack1 = new MyStack<Integer>();

		System.out.printf("Check if stack is empty returned %s.\n", testStack1.isEmpty());

		System.out.printf("Check size of stack returned %s.\n", testStack1.size());

		System.out.print("Pushing integers to testStack1...\n");
		
		System.out.printf("Pushing %s to testStack1...", testInteger1);
		testStack1.push(testInteger1);
		System.out.print(" Done\n");

		System.out.printf("Pushing %s to testStack1...", testInteger2);
		testStack1.push(testInteger2);
		System.out.print(" Done\n");

		System.out.printf("Pushing %s to testStack1...", testInteger3);
		testStack1.push(testInteger3);
		System.out.print(" Done\n");

		System.out.printf("Pushing %s to testStack1...", testInteger4);
		testStack1.push(testInteger4);
		System.out.print(" Done\n");

		System.out.printf("Check if stack is empty returned %s.\n", testStack1.isEmpty());

		System.out.printf("Check size of stack returned %s.\n", testStack1.size());
		
		System.out.printf("testStack1.pop() returned %s\n", testStack1.pop());
		System.out.printf("testStack1.pop() returned %s\n", testStack1.pop());
		System.out.printf("testStack1.pop() returned %s\n", testStack1.pop());
		System.out.printf("testStack1.pop() returned %s\n", testStack1.pop());

		System.out.print("Now testing testStack1.pop(), this should throw EmptyStackException.\n");

		try {
			System.out.printf("testStack1.pop() returned %s\n", testStack1.pop()); // Will throw EmptyStackException
		} catch (RuntimeException EmptyStackException) {
			System.out.print("Caught EmptyStackException!\n");
		}

		System.out.printf("Check size of stack returned %s.\n", testStack1.size());
		System.out.printf("Check if stack is empty returned %s.\n", testStack1.isEmpty());

		System.out.print("////////////////////////////////////////\n");
		System.out.print("Testing of myutil/MyStack.java complete.\n");
		System.out.print("////////////////////////////////////////\n\n");
	}
}