package com.dkr.cj;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * This class exhibits three methods of removing duplicates from array.
 * Method 1 - using HashSet maintaining no order of original elements. 
 * 		This is useful when execution time is more important and history of original element addition is not needed.
 * Method 2 - using LinkedHashSet maintaining order of original elements.
 * 		This is a bit slower than method 1. It is useful when original elements order is needed.
 * Method 3 - using ArrayList maintaining sorted order of unique elements.
 * 		This is the slowest of the three methods. It is useful when sorted order of distinct elements are necessary.
 */
public class DeDup {
	
	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   


	public static void main(String[] args) {
		
		DeDup deDup = new DeDup();
		// Validate input for NULL or empty
		if (deDup.randomIntegers == null || deDup.randomIntegers.length <= 1 ){
			System.out.println ("Input array not valid!");
			return;
		}

		//Method 1 : HashSet - no order
		System.out.print("Before removing : ");
		deDup.printArray(deDup.randomIntegers);
		long start1 = System.nanoTime();
		HashSet<Integer> removedElements1 = deDup.deDupNoOrder(deDup.randomIntegers);
		long end1 = System.nanoTime();
		System.out.println("Method1#1 After removing : Time took " + (end1-start1) + " nanosec : " + removedElements1.toString());
		
		//Method 2 : LinkedHashSet - original order
		long start2 = System.nanoTime();
		LinkedHashSet<Integer> removedElements2 = deDup.deDupWithOrigOrder(deDup.randomIntegers);
		long end2 = System.nanoTime();
		System.out.println("Method1#2 After removing : Time took " + (end2-start2)+ " nanosec : "+ removedElements2.toString());
			
		//Method 3 : TreeSet - newly sorted order
		long start3 = System.nanoTime();
		TreeSet<Integer> removedElements3 = deDup.deDupWithSortedOrder(deDup.randomIntegers);
		long end3 = System.nanoTime();
		System.out.println("Method1#3 After removing : Time took " + (end3 - start3) + " nanosec : "+ removedElements3.toString());
	}
	
	public void printArray (int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println ("");
	}
	
	// Method#1 : Using HashSet. No order of elements.
	// Time complexity O(n)
	// Space complexity O(n)
	
	public HashSet<Integer> deDupNoOrder (int[] arr){
		HashSet<Integer> hs = new HashSet<Integer> ();
		for (int i=0; i<arr.length; i++) {
			hs.add(arr[i]);
		}
		return hs;
	}

	// Method#2 : Using LinkedHashSet.  Original order of elements is maintained.
	// Time complexity O(n)
	// Space complexity O(n), with more space for linkedHashSet implementation.
	
	public LinkedHashSet<Integer> deDupWithOrigOrder(int[] arr) {
		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			lhs.add(arr[i]);
		}
		return lhs;
	}
	
		
	// Method#3 : Using TreeSet.  Elements are in sorted order in distinct set with search complexity of O(logN).
	// Time complexity O(n)
	// Space complexity O(n), with more space for TreeSet implementation, usually with Red-Black BST.
	
	public TreeSet<Integer> deDupWithSortedOrder(int[] arr) {
		TreeSet<Integer>ts = new TreeSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			ts.add(arr[i]);
		}
		return ts;
	}

	
}