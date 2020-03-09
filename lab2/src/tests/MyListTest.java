package tests;

import myutil.*;

public class MyListTest {
	
	public static MyList<Integer> testList1;
	public static Integer testInteger1;
	public static Integer testInteger2;
	public static Integer testInteger3;
	public static Integer testInteger4;
	public static Integer testInteger5;

	public static void run(){
		testInteger1 = 12;
		testInteger2 = 34;
		testInteger3 = 56;
		testInteger4 = 78;
		testInteger5 = 90;

		System.out.print("- - Testing myutil/MyList.java - -\n\n");
		
		System.out.print("Creating a new list 'testList1'...");
		testList1 = new MyList<Integer>();
		System.out.print(" Done\n");

		System.out.printf("testList1.size() returned %s\n", testList1.size());
		System.out.printf("Check if list is empty returned %s.\n", testList1.isEmpty());

		System.out.printf("Adding integers '%s', '%s', '%s', '%s', '%s' to list.\n",testInteger1, testInteger2, testInteger3, testInteger4, testInteger5);
		testList1.add(testInteger1);
		testList1.add(testInteger2);
		testList1.add(testInteger3);
		testList1.add(testInteger4);
		testList1.add(testInteger5);

		System.out.printf("testList1.getElementAt(0).getData() returned %s.\n", testList1.getElementAt(0));
		System.out.printf("testList1.getElementAt(1).getData() returned %s.\n", testList1.getElementAt(1));
		System.out.printf("testList1.getElementAt(2).getData() returned %s.\n", testList1.getElementAt(2));
		System.out.printf("testList1.getElementAt(3).getData() returned %s.\n", testList1.getElementAt(3));
		System.out.printf("testList1.getElementAt(4).getData() returned %s.\n", testList1.getElementAt(4));

		System.out.print("Now testing testList1.getElementAt(5), this should throw IndexOutofBoundsException.\n");
		try {
			System.out.printf("testList1.getElementAt(5) returned %s\n", testList1.getElementAt(5)); // Will throw IndexOutofBoundsException
		} catch (RuntimeException IndexOutofBoundsException) {
			System.out.print("Caught IndexOutofBoundsException!\n");
		}
		
		System.out.print("Now testing testList1.getElementAt(-1), this should throw IndexOutofBoundsException.\n");
		try {
			System.out.printf("testList1.getElementAt(5) returned %s\n", testList1.getElementAt(5)); // Will throw IndexOutofBoundsException
		} catch (RuntimeException IndexOutofBoundsException) {
			System.out.print("Caught IndexOutofBoundsException!\n");
		}

		System.out.print("///////////////////////////////////////\n");
		System.out.print("Testing of myutil/MyList.java complete.\n");
		System.out.print("///////////////////////////////////////\n\n");
	}
}