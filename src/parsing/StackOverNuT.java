package parsing;

import java.io.*;
import java.util.*;

public class StackOverNuT {

	private ArrayList<Character> sont;

	public StackOverNuT() {
		sont = new ArrayList<Character>();
	}

	public char top() {
		if (!sont.isEmpty()) {
			return (sont.get(0)).charValue();
		}
		return 'x';
	}

	public char pop() {
		if (!sont.isEmpty()) {
			return (sont.remove(0)).charValue();
		}
		return 'x';
	}

	public void push(String item) {
		for (int i = item.length() - 1; i >= 0; i--) {
			sont.add(0, item.charAt(i));
		}
	}

	public void push(char item) {
		sont.add(0, item);
	}

	public void push(Nonterminal item) {
		sont.add(0, item.toChar());
	}

	public boolean isEmpty() {
		return sont.isEmpty();
	}

	public String toString() {
		StringBuffer soNuTSB = new StringBuffer();
		for (int i = 0; i < sont.size(); i++) {
			soNuTSB.append(sont.get(i) + " ");
		}
		return soNuTSB + " ";
	}

	public static void main(String[] args) {
		StackOverNuT sont = new StackOverNuT();
		StackOverNuT sont01 = new StackOverNuT();
		sont.push('a');
		sont.push('V');
		sont.push('T');
		sont.push('k');
		sont01.push("asdf");
		System.out.println(sont.top() + " elso ");
		System.out.println("eloszor " + sont.toString());
		System.out.println(sont.top() + " masodik");
		System.out.println("masodszor " + sont.toString());
		System.out.println(sont.pop());
		System.out.println("harm: " + sont.toString());

		System.out.println(sont01.top());
		System.out.println("sont01 " + sont01.toString());
		// sont01.pop();
	}

}
