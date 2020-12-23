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

public class LinkedBoxNode {
	private Box box; // box that represents the data for this Linked node
	private LinkedBoxNode next; // reference to the next Linked Box Node

	// constructors
	public LinkedBoxNode(Box box) {
		this.box = box;
	} // creates a new LinkedBoxNode object with a given
	// box and without referring to any next LinkedBoxNode

	public LinkedBoxNode(Box box, LinkedBoxNode next) {
		this.box = box;
		this.next = next;
	} // creates a new LinkedBoxNode
	// object and sets its instance fields box and next to the specified ones

	// getters and setters methods
	public LinkedBoxNode getNext() {
		return this.next;
	}

	// Sets linkedBoxNode
	public void setNext(LinkedBoxNode next) {
		this.next = next;
	}

	// Retrieves box
	public Box getBox() {
		return this.box;
	}

	// Sets Box
	public void setBox(Box box) {
		this.box = box;
	}
}
