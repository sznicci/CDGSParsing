package parsing;

import java.util.*;
import java.io.*;

public class CDGrammarSystem {

	private ArrayList<Nonterminal> nonterminals = new ArrayList<Nonterminal>();
	private ArrayList<Terminal> terminals = new ArrayList<Terminal>();
	private Nonterminal axiom;
	private ArrayList<ProductionQueue> components = new ArrayList<ProductionQueue>();

	private CDGrammarSystem() {
	}

	public ArrayList<Nonterminal> getNonterminals() {
		return nonterminals;
	}

	public ArrayList<Terminal> getTerminals() {
		return terminals;
	}

	public Nonterminal getAxiom() {
		return axiom;
	}

	public ArrayList<ProductionQueue> getComponents() {
		return components;
	}

	public boolean isTerminal(String term) {
		for (int i = 0; i < terminals.size(); i++) {
			if (term.equals(terminals.get(i).toString())) {
				return true;
			}
		}
		return false;
	}

	public boolean isNonterminal(Character nonterm) {
		for (int i = 0; i < nonterminals.size(); i++) {
			if (nonterminals.get(i).equals(nonterm)) {
				return true;
			}
		}
		return false;
	}

	public static CDGrammarSystem readFile(String cdgsFile) {
		CDGrammarSystem cdgs = new CDGrammarSystem();

		try {
			File cdgsfile1 = new File(cdgsFile);
			FileReader fileReader = new FileReader(cdgsfile1);

			BufferedReader reader = new BufferedReader(fileReader);

			String line = null;
			ArrayList<String> lines = new ArrayList<String>();

			while ((line = reader.readLine()) != null) {
				if (line.trim().length() >= 1) {
					lines.add(line);
				}
			}

			String[] nont = lines.get(0).split(", ");
			for (int i = 0; i < nont.length; i++) {
				cdgs.nonterminals.add(new Nonterminal(nont[i].charAt(0)));
			}
			String[] t = lines.get(1).split(", ");
			for (int i = 0; i < t.length; i++) {
				cdgs.terminals.add(new Terminal(t[i]));
			}

			cdgs.axiom = new Nonterminal(lines.get(2).charAt(0));

			ArrayList<String[]> prodLine = new ArrayList<String[]>();
			for (int i = 3; i < lines.size(); i++) {
				cdgs.components.add(new ProductionQueue(lines.get(i)));
			}

			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cdgs;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Nonterminals: \n");
		for (int i = 0; i < nonterminals.size(); i++) {
			sb.append(nonterminals.get(i).toString() + "\n");
		}
		sb.append("Terminals: \n");
		for (int i = 0; i < terminals.size(); i++) {
			sb.append(terminals.get(i).toString() + "\n");
		}
		sb.append("Axiom: \n" + axiom.toString() + "\n");
		sb.append("Components: \n");
		for (int i = 0; i < components.size(); i++) {
			sb.append("P" + (i + 1) + ": \n" + components.get(i).toString() + "\n");
		}
		String lt = sb.toString();
		return lt;
	}

	public static void main(String[] args) {
		try {
			CDGrammarSystem cdgs01 = new CDGrammarSystem();
			cdgs01 = readFile("CDGS.txt");

			// System.out.println(cdgs01.toString());
			Character a = 'A';
			System.out.println("tf: " + cdgs01.isNonterminal(a));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
