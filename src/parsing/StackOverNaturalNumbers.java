package parsing;

import java.io.*;
import java.util.*;

public class StackOverNaturalNumbers {

	private ArrayList<Integer> sonn;

	public StackOverNaturalNumbers() {
		sonn = new ArrayList<Integer>();
	}

	public int top() {
		if (!sonn.isEmpty()) {
			return (sonn.get(0)).intValue();
		}
		return -1;
	}

	public int pop() {
		if (!sonn.isEmpty()) {
			return (sonn.remove(0)).intValue();
		}
		return -1;
	}

	public void push(int item) {
		sonn.add(0, item);
	}

	public String toString() {
		StringBuffer soNNSB = new StringBuffer();
		for (int i = 0; i < sonn.size(); i++) {
			soNNSB.append(sonn.get(i) + " ");
		}
		return soNNSB.toString();
	}

	public static void main(String[] args) {
		StackOverNaturalNumbers sonn = new StackOverNaturalNumbers();
		StackOverNaturalNumbers sonn01 = new StackOverNaturalNumbers();
		sonn.push(7);
		sonn.push(120);
		sonn.push(65);
		sonn.push(10);
		sonn01.push(13);
		System.out.println(sonn.top() + " elso ");
		System.out.println(sonn.toString());
		System.out.println(sonn.top() + " masodik");
		// pop(sonn);
		// for(int i= 0; i< sonn.size(); i++){
		// System.out.println(sonn.get(i).intValue());
		// }
		System.out.println(sonn01.top());
		sonn01.pop();
		System.out.println(sonn01.top());
	}

}
