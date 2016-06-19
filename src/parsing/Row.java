package parsing;

import java.util.*;

public class Row{

	private Nonterminal nonterm;
	private Terminal term;
	private ProductionQueue prodQueue;
	
	public Row(Nonterminal nt, Terminal t, ProductionQueue pq){
			nonterm= nt;
			term= t;
			prodQueue= pq;
	}

	public String toString(){
		return nonterm.toString() +"\t"+ term.toString() +"\n"+ prodQueue.toString();
	}
	
	public void setNonterm(Nonterminal nt){
			nonterm= nt;
	}
	
	public void setTerm(Terminal t){
			term= t;
	}

	public void setProdQueue(ProductionQueue pq){
		prodQueue= pq;
	}
	
	public Nonterminal getNonterm(){
		return nonterm;
	}
	
	public Terminal getTerm(){
		return term;
	}
	
	public ProductionQueue getProdQueue(){
		return prodQueue;
	}
	
	public static void main(String[] args){
		
	}

}
