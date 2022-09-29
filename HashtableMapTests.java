// --== CS400 Project One File Header ==--
// Name: Kolby Boesel
// CSL Username: kolby
// Email: kboesel@wisc.edu
// Lecture #: 003
// Notes to Grader: 

import java.util.NoSuchElementException;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class HashtableMapTests {

	/*
	 * The main method runs all the test methods and outprints whether the tests
	 * were successful
	 */
	public static void main(String[] args) {
		if (test1() == true && test2() == true && test3() == true && test4() == true && test5() == true) {
			System.out.println("Tests successful");
		} else {
			System.out.println("Tests failed");
		}
	}

	/**
	 * This test test the put and get method and ensures that they function properly
	 * with basic commands
	 * 
	 * @return true if the test was successful and false otherwise
	 */
	@SuppressWarnings("rawtypes")
	public static boolean test1() {

		Boolean test1 = false;
		Boolean test2 = false;
		HashtableMap testTable = new HashtableMap();
		testTable.put(1, "red");
		testTable.put(2, "green");
		testTable.put(3, "orange");

		HashtableMap testTable1 = new HashtableMap();
		testTable1.put(6, "red");
		testTable1.put(8, "green");
		testTable1.put(9, "orange");

		try {
			testTable1.get(7);
		} catch (NoSuchElementException E) {

			test1 = true;
		}

		if (testTable.get(3).equals("orange")) {

			test2 = true;
		}

		if (test1 == true && test2 == true) {
			return true;
		}

		return false;
	}

	/**
	 * This test tests the collision handling of my hashtable
	 * 
	 * @return true if the test was successful and false otherwise
	 */
	public static boolean test2() {
		boolean check1 = false;
		boolean check2 = false;

		HashtableMap testTable = new HashtableMap(10);
		testTable.put(12, "red");
		testTable.put(13, "green");
		testTable.put(23, "blue");

		HashtableMap testTable1 = new HashtableMap(10);
		testTable1.put(17, "red");
		testTable1.put(28, "green");
		testTable1.put(77, "blue");

		if (testTable.get(13).equals("green") && testTable.get(23).equals("blue")) {
			check1 = true;
		}
		try {
			testTable1.get(27);

		} catch (NoSuchElementException E) {
			check2 = true;
		}

		if (check1 == true && check2 == true) {
			return true;
		}

		return false;

	}

	/**
	 * This test tests the rehash method
	 * 
	 * @return true if the test was successful and false otherwise
	 */
	public static boolean test3() {
		HashtableMap testTable = new HashtableMap(10);
		testTable.put(1, "red");
		testTable.put(2, "green");
		testTable.put(3, "blue");
		testTable.put(4, "orange");
		testTable.put(5, "maroon");
		testTable.put(6, "purple");
		testTable.put(7, "gray");
		testTable.put(8, "black");
		testTable.put(9, "white");
		testTable.put(10, "magenta");
		testTable.put(11, "yellow");

		if (testTable.size() == 11) {
			return true;
		}
		return false;
	}

	/**
	 * This tests the return value of put when adding unique and duplicate keys
	 * 
	 * @return true if the test was successful and false otherwise
	 */
	public static boolean test4() {
		HashtableMap testTable = new HashtableMap(10);

		if (testTable.put(1, "red") == true && testTable.put(1, "blue") == false
				&& testTable.put(1, "green") == false) {
			return true;
		}

		return false;
	}

	/**
	 * This test the remove and clear methods of the hashtableMap class
	 * 
	 * @return true if the test was successful and false otherwise
	 */
	public static boolean test5() {
		boolean test1 = false;
		boolean test2 = false;
		HashtableMap testTable = new HashtableMap(10);
		testTable.put(1, "red");
		testTable.put(2, "green");
		testTable.put(3, "blue");
		testTable.put(4, "orange");
		testTable.put(5, "maroon");
		testTable.put(6, "purple");

		if (testTable.remove(3).equals("blue") && testTable.remove(8) == null) {
			test1 = true;
		}

		testTable.clear();

		if (testTable.size() == 0) {
			test2 = true;
		}

		if (test1 == true && test2 == true) {
			return true;
		}
		return false;
	}

}