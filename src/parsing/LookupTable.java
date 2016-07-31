package parsing;

import java.util.*;
import java.io.*;

public class LookupTable {

	private ArrayList<Row> lkupTable = new ArrayList<Row>();

	private LookupTable() {
	}

	public void addRow(Nonterminal nt, Terminal t, ProductionQueue pq) {
		Row newRow = new Row(nt, t, pq);
		lkupTable.add(newRow);
	}

	public Row getRow() {
		return lkupTable.get(0);
	}

	public ProductionQueue lookupTable(Nonterminal nonterm, Terminal lookahead) {
		for (int i = 0; i < lkupTable.size(); i++) {
			if (lkupTable.get(i).getNonterm().equals(nonterm) && lkupTable.get(i).getTerm().equals(lookahead)) {
				return lkupTable.get(i).getProdQueue();
			}

		}
		return null;
	}

	public static LookupTable readFile(String lookupT) {
		LookupTable lt = new LookupTable();

		try {
			File lookupTable1 = new File(lookupT);
			FileReader fileReader = new FileReader(lookupTable1);
			String[] rowLine = new String[3];

			BufferedReader reader = new BufferedReader(fileReader);

			String line = null;
			int stam = 0;
			while ((line = reader.readLine()) != null) {
				stam++;
				if (line.trim().length() >= 1) {
					for (int i = 0; i < rowLine.length; i++) {
						rowLine[i] = line;
						line = reader.readLine();
					}
					Nonterminal nt = new Nonterminal(rowLine[0].charAt(0));
					Terminal t = new Terminal(rowLine[1]);
					ProductionQueue pq = new ProductionQueue(rowLine[2]);

					lt.addRow(nt, t, pq);
				}
			}

			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lt;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < lkupTable.size(); i++) {
			sb.append(lkupTable.get(i) + "\n");
		}
		String lt = sb.toString();
		return lt;
	}

	public static void main(String[] args) {
		try {
			/*
			 * LookupTable loot= new LookupTable(); Nonterminal ntS= new
			 * Nonterminal('S'); Nonterminal ntA1= new Nonterminal('A');
			 * Nonterminal ntA2= new Nonterminal('B'); Terminal tA= new
			 * Terminal("a"); Terminal tB= new Terminal("b"); ProductionQueue
			 * pqP1a= new ProductionQueue("S->A1A2A1A3 A2->b A3->A4");
			 * ProductionQueue pqP1b= new ProductionQueue(
			 * "S->bA1A2A1A3 A2->b A3->A4"); ProductionQueue pqP2= new
			 * ProductionQueue("A1->aA2 A1->aA2 A4->A5"); ProductionQueue pqP3=
			 * new ProductionQueue("A2->a A2->a A5->b"); loot.addRow(ntS, tA,
			 * pqP1a); loot.addRow(ntA1, tA, pqP2); loot.addRow(ntA2, tA, pqP3);
			 * loot.addRow(ntS, tB, pqP1b);
			 */
			Nonterminal ntS = new Nonterminal('S');
			Terminal tA = new Terminal("a");
			LookupTable lkupTab = LookupTable.readFile("lookupTab.txt");
			// System.out.print(" getro\n"+lkupTab.getRow());
			lkupTab.lookupTable(ntS, tA);
			// loot= readFile("lookupTab.txt");
			// System.out.println(loot.lookupTable(ntA1, tA));
			// System.out.println(loot.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
