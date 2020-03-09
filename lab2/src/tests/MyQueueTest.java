package tests;

import myutil.*;

public class MyQueueTest {
	public static MyQueue<String> testQueue1;
	public static String testString1;
	public static String testString2;
	public static String testString3;
	public static String testString4;

	public static void run(){
		System.out.print("- - Testing myutil/MyQueue.java - -\n\n");

		testString1 = "ABC";
		testString2 = "DEF";
		testString3 = "GHI";
		testString4 = "JKL";

		System.out.print("Creating a queue with name 'testQueue1'.\n");
		testQueue1 = new MyQueue<String>();

		System.out.printf("Check if queue is empty returned %s.\n", testQueue1.isEmpty());
		System.out.printf("Check size of queue returned %s.\n", testQueue1.size());



		System.out.printf("Enqueueing strings '%s', '%s', '%s', '%s'. \n",testString1, testString2, testString3, testString4);
		testQueue1.enqueue(testString1);
		testQueue1.enqueue(testString2);
		testQueue1.enqueue(testString3);
		testQueue1.enqueue(testString4);
		
		System.out.printf("Check if queue is empty returned %s.\n", testQueue1.isEmpty());

		System.out.printf("testQueue1.dequeue() returned %s\n", testQueue1.dequeue());
		System.out.printf("testQueue1.dequeue() returned %s\n", testQueue1.dequeue());

		System.out.printf("Check size of queue returned %s.\n", testQueue1.size());

		System.out.printf("testQueue1.dequeue() returned %s\n", testQueue1.dequeue());
		System.out.printf("testQueue1.dequeue() returned %s\n", testQueue1.dequeue());

		System.out.printf("Check size of queue returned %s.\n", testQueue1.size());
		
		System.out.print("Now testing testQueue1.dequeue(), this should throw EmptyQueueException.\n");

		try {
			System.out.printf("testQueue1.dequeue() returned %s\n", testQueue1.dequeue()); // Will throw EmptyQueueException
		} catch (RuntimeException EmptyQueueException) {
			System.out.print("Caught EmptyQueueException!\n");
		}

		System.out.print("////////////////////////////////////////\n");
		System.out.print("Testing of myutil/MyQueue.java complete.\n");
		System.out.print("////////////////////////////////////////\n\n");
	}
}