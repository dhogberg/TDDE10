package tests;

import myutil.*;

public class MyListTest {
	
	public static MyList<Integer> testList1;

	public static void run(){
		System.out.print("- - Testing myutil/MyList.java - -\n\n");
		
		System.out.print("Creating a new list 'testList1'...");
		testList1 = new MyList<Integer>();
		System.out.print(" Done\n");
		
		
	}
	
}