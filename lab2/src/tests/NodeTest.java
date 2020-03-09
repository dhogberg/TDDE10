package tests;

import myutil.*;

public class NodeTest {
	public static Node<Integer> testNode1;
	public static Integer testInteger1;
	public static Integer testInteger2;
	public static Integer testInteger3;

	public NodeTest() {
		//
	}
	
	public static void run(){
		System.out.print("- - Testing myutil/Node.java - -\n\n");
		
		System.out.print("Creating a node with name 'testNode1'.\n");
		testNode1 = new Node<Integer>();

		testInteger1 = 1; // Temporary placeholder for Integer
		
		System.out.printf("Adding the data %s to the node 'testNode1'.\n", testInteger1);
		testNode1.setData(testInteger1);

		System.out.printf("The data '%s' was added to 'testNode1'.\n", testInteger1);

		System.out.printf("Reading data from 'testNode1'. Data was: %s.\n", testNode1.getData());

		testInteger2 = 3; // Temporary placeholder for Integer
		System.out.printf("Creating a new node in 'testNode1' and assigning the value %s.\n", testInteger2);
		testNode1.setNextReference(new Node<Integer>(testInteger2));

		testInteger3 = 7; // Temporary placeholder for Integer
		System.out.printf("Creating a new node in 'testNode1' and assigning the value %s.\n", testInteger3);
		testNode1.getNextReference().setNextReference(new Node<Integer>(testInteger3));

		System.out.printf("Reading node 3 from 'testNode1'. Data was: %s.\n", testNode1.getNextReference().getNextReference().getData());
		System.out.printf("Reading node 2 from 'testNode1'. Data was: %s.\n", testNode1.getNextReference().getData());
		System.out.printf("Reading node 1 from 'testNode1'. Data was: %s.\n", testNode1.getData());

		System.out.print("/////////////////////////////////////\n");
		System.out.print("Testing of myutil/Node.java complete.\n");
		System.out.print("/////////////////////////////////////\n\n");
	}
}