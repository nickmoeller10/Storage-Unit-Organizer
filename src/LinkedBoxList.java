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

public class LinkedBoxList {

	private LinkedBoxNode head; // head of this LinkedBoxList (refers to the element
	// stored at index 0 within this list)
	private int size; // number of boxes already stored in this list
	private int capacity; // capacity of this LinkedBoxList
	// maximum number of box elements that this LinkedBoxList
	// can store

	// Creates an empty LinkedBoxList with a given initial capacity
	public LinkedBoxList(int capacity) {
		this.capacity = capacity;
	}

	// Returns the size of this list
	public int size() {
		return this.size;
	}

	// Return the capacity of this list
	public int getCapacity() {
		return this.capacity;
	}

	// Expands the capacity of this LinkedBoxList with the specified number a of
	// additional elements
	public void expandCapacity(int a) {
		this.capacity = this.capacity + a;
	}

	// Checks whether this LinkedBoxList is empty
	// returns true if this LinkedBoxList is empty, false otherwise
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	// Checks whether this LinkedBoxList is full
	// Returns true if this list is full, false otherwise
	public boolean isFull() {
		if (this.size == this.capacity) {
			return true;
		}
		return false;
	}

	// Adds a new box into this sorted list
	// Throws IllegalArgumentException if newBox is null
	// Throws IllegalStateException if this list is full
	public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
		LinkedBoxNode prevNull = null; // temp variable for previous node
		LinkedBoxNode currentNode = head; // temp variable for current node
		LinkedBoxNode nextNode = new LinkedBoxNode(newBox); // temp variable for new node created
		boolean added = false;
		if (newBox == null) { // If newBox is null, throws an exception
			throw new IllegalArgumentException("Error: Create a Box First");
		}
		if (this.isFull()) { // If storage list if full, throws and exception
			throw new IllegalStateException("Error: Storage List Full");
		}
		if (this.isEmpty()) { // If the list is empty, newBox becomes the headNode
			head = nextNode;
		} else {
			for (int i = 0; i < size; i++) { // Iterate through size of list
				// If the newBox weight is larger, it becomes the head node
				if (nextNode.getBox().compareTo(currentNode.getBox()) == 1) {
					if (i == 0) { // If current box is the first box, the newNode becomes
						// the first node
						head = nextNode;
						head.setNext(currentNode); // Current node becomes the next reference
					} else {
						prevNull.setNext(nextNode); // If it is not the first node, the previous
						// node becomes the next node
						nextNode.setNext(currentNode); // Sets the next node reference to the
						// current node
					}
					added = true;

				} else if (currentNode.getBox().compareTo(newBox) == 0) { // check if weights are
					// equal
					if (i == size - 1) { // If box is the last reference,
						// sets currentNode as nextNode
						currentNode.setNext(nextNode);
					} else {
						nextNode.setNext(currentNode.getNext()); // Else add nextNode between
						// two nodes
						currentNode.setNext(nextNode);
					}
					added = true;
				}
				prevNull = currentNode;
				if (i < size - 1) { // Increments the node as long as it is not the last node
					currentNode = currentNode.getNext();
				}
				if (added) {
					break;
				}
			}
			if (!added) { // If node was not added after iterating the list,
				// node is added at the end
				currentNode.setNext(nextNode);
			}
		}
		size++; // Increment size
	}

	// Checks if this list contains a box that matches with (equals) a specific box
	// object
	// Returns true if this list contains findBox, false otherwise
	public boolean contains(Box findBox) {
		for (int i = 0; i < size; i++) {
			// Checks that at current node, currentBox equals findBox
			if (this.head.getBox().equals(findBox)) {
				return true;
			}
			// Increments the node
			else {
				head = head.getNext();
			}
		}
		return false;
	}

	// Returns a box stored in this list given its index
	// Throws IndexOutOfBoundsException if index is out of the range 0..size-1
	public Box get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Error: index is outside the range");
		}
		LinkedBoxNode start = this.head;
		// Iterates through the list until the current node equals the index then reutrns the box
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				return start.getBox();
			}
			start = start.getNext();
		}
		return null;
	}

	// Removes a returns the box stored at index from this LinkedBoxList
	// Throws IndexOutOfBoundsException if index is out of bounds. index should be
	// in the range of [0..size()-1]
	public Box remove(int index) throws IndexOutOfBoundsException {
		LinkedBoxNode prev = null;
		LinkedBoxNode current = this.head;
		Box bx = new Box();
		// Checks that index is in proper range
		if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Error: could not find index in list");
		}
		// Iterates through Linked List
		for (int i = 0; i <= index; i++) {
			// Checks that i is on proper index
			if (i == index) {
				// If the index is at the bottom, head becomes next node
				if (index == 0) {
					head = current.getNext();
					size--;
					return current.getBox();
				}
				// If index is at the top, that box becomes null
				if (index == (size - 1)) {
					bx = current.getBox();
					current = null;
					size--;
					return bx;
				}
				// If index is in between, the previous node becomes the current node
				if (index > 0 && index < (size - 1)) {
					prev.setNext(current.getNext());
					size--;
					return current.getBox();
				}
			}
			// Moves both nodes to the next node
			prev = current;
			current = current.getNext();
		}
		return null;
	}

	// Removes all the boxes from this list
	public void clear() {
		this.head = null;
		size = 0;
	}

	// Returns a String representation of the state and content of this
	// LinkedBoxList
	// An example of source code for this method is provided you in the next
	// paragraph
	@Override

	public String toString() {
		StringBuilder result = new StringBuilder(); // creates a StringBuilder object
		String newLine = System.getProperty("line.separator");
		result.append("------------------------------------------------" + newLine);
		if (!isEmpty()) {
			LinkedBoxNode runner = head;
			int index = 0;
			// traverse the list and add a String representation for each box
			while (runner != null) {
				result.insert(0, "Box at index " + index + ": " + runner.getBox().getWeight() 
						+ " lbs" + newLine);
				runner = runner.getNext();
				index++;
			}
			result.insert(0, "Box List Content:" + newLine);
		}
		result.insert(0, "List size: " + size + " box(es)." + newLine);
		result.insert(0, "Box List is empty: " + isEmpty() + newLine);
		result.insert(0, "------------------------------------------------" + newLine);
		return result.toString();
	}
}