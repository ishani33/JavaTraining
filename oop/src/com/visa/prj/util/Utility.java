package com.visa.prj.util;

public class Utility {
	//OCP principle - since this code is closed for change
	public static void sort(Comparable[] elems) { //this function suggests that as long as an array has comparable capability, this code will work
	//the object's class to be compared should implement the interface Comparable
		for(int i=0;i<elems.length;i++) {
			for (int j=i+1; j<elems.length;j++) {
				if(elems[i].compareTo(elems[j])>0) {
					Comparable temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
			}
		}
	}
}
