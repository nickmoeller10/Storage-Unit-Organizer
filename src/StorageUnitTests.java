//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Storage Unit Organizer
// Files: LinkedBoxList, LinkedBoxNode, Box, StorageUnitTests
// Course: CS 300, Spring 2019
//
// Author: Nicholas Moeller
// Email: njmoeller@wisc.edu
// Lecturer's Name: Gary Dahl
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do. If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons: (None)
// Online Sources: (None)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class StorageUnitTests {
	// Checks whether the behavior of equals method is correct
	public static boolean testBoxEquals() {
		Box boxOne = new Box(25, 20);
		Box boxTwo = new Box(25, 20);
		// Checks if both boxes are equal to each other
		if (boxOne.equals(boxTwo)) {
			System.out.println("PASSED");
			return true;
		}
		System.out.print("FAILED");
		return false;

	}

	// Checks whether the behavior of compareTo method is correctly implemented
	public static boolean testBoxCompareTo() {
		Box boxOne = new Box(20, 12);
		Box boxTwo = new Box(55, 30);
		Box boxThree = new Box(14, 12);
		int valueOne = boxOne.compareTo(boxTwo);
		int valueTwo = boxOne.compareTo(boxThree);
		// Checks if BoxOne weight is less than BoxTwo
		if (valueOne != -1) {
			System.out.print("FAILED");
			return false;
		}
		// Checks if BoxOne weight is equal to BoxThree
		if (valueTwo != 0) {
			System.out.println("FAILED");
			return false;
		}
		System.out.println("PASSED");
		return true;
	}

	// Checks whether remove method defined in your LinkedBoxList works correctly
	public static boolean testLinkedBoxListRemove() {
		int capacity = 10;
		LinkedBoxList list = new LinkedBoxList(capacity);
		int index = 3;
		// Create new boxes
		Box bx = new Box(2, 2);
		Box bx2 = new Box(4, 3);
		Box bx3 = new Box(14, 4);
		Box bx4 = new Box(16, 5);
		Box bx5 = new Box(20, 8);
		// Add boxes so size = 5
		list.add(bx);
		list.add(bx2);
		list.add(bx3);
		list.add(bx4);
		list.add(bx5);
		// Remove 2 boxes
		Box return1 = list.remove(0);
		Box return2 = list.remove(1);
		//Test 1 Checks size of list
		if(list.size() != 3) {
			System.out.println("Failed Test 1");
			return false;
		}
		//Test 2 Checks weight of returned Box
		if(return1.getWeight() != 8) {
			System.out.print("Failed Test 2 " + return1.getWeight());
			return false;
		}
		// Test 3 Checks color of returned Box
		if(return2.getColor() != 14) {
			System.out.println("Failed Test 3 " + return2.getColor() );
			return false;
		}
		
		System.out.println("Passed");
		return true;
		
	}
		
	// Checks that contains method is properly implemented
	public static boolean testLinkedBoxListContains() {
		// Create new list and add boxes
		LinkedBoxList list = new LinkedBoxList(10);
		Box box1 = new Box();
		Box box2 = new Box();
		Box box3 = new Box();
		list.add(box1);
		list.add(box2);
		list.add(box3);
		// Checks if box2 is contained within list
		if(list.contains(box2)) {
			System.out.println("Passed");
			return true;
		}
		System.out.print("Failed");
		return false;
	}

	// Checks that clear method is properly implemented
	public static boolean testLinkedBoxListClear() {
		// Creates a list and adds boxes to the list
		LinkedBoxList list = new LinkedBoxList(10);
		Box box1 = new Box();
		Box box2 = new Box();
		Box box3 = new Box();
		list.add(box1);
		list.add(box2);
		list.add(box3);
		// Checks size before clear
		if(list.size() != 3) {
			System.out.println("Failed");
			return false;
		}
		list.clear();
		// Checks size after clear
		if(list.size() != 0) {
			System.out.println("Failed");
			return false;
		}
		System.out.println("Passed");
		return true;
	}
}
