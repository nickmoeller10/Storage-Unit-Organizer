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
import java.util.Random;

public class Box implements Comparable<Box> {

	private static Random randGen = new Random(); // generator of random numbers
	private int color; // color of this box
	private int weight; // weight of this box in lbs between 1 inclusive and 31 exclusive

	// Creates a new Box and initializes its instance fields color and weight to
	// random values
	public Box() {
		color = randGen.nextInt();
		weight = randGen.nextInt((31 - 1) + 1) + 1;

	}

	// Creates a new Box and initializes its instance fields color and weight to the
	// specified values
	// Throws IllegalArgumentException if the provided weight value is out of the
	// range of [1..30]
	public Box(int color, int weight) {
		if (weight < 1 || weight > 30) {
			throw new IllegalArgumentException("Error: weight value is out of range");
		} else {
			this.color = color;
			this.weight = weight;
		}
	}

	// Checks if object other is a current box and if they have same color and weight
	@Override
	public boolean equals(Object other) {
		if (other instanceof Box) {
			if (((Box) other).color == this.color) {
				if (((Box) other).weight == this.weight) {
					return true;
				}
			}
		}
		return false;
	} // equals method defined in Object class

	// Compares weights to determine if otherBox is heavier, lighter, or equal to this box
	@Override
	public int compareTo(Box otherBox) {
		if (this.weight < otherBox.weight) {
			return -1;
		} else if (this.weight > otherBox.weight) {
			return 1;
		} else {
			return 0;
		}
	} // compareTo method defined in Comparable<Box>
		// interface

	public int getColor() {
		return this.color;
	} // Getter for the instance field color of this box

	public int getWeight() {
		return this.weight;
	} // Getter for the instance field weight of this box
}
