package parsing;

import java.util.*;

public class ProductionQueue{

	private ArrayList<Production> pq;
	
	public ProductionQueue(){
		pq= new ArrayList<Production>();
	}
	
	/*public ProductionQueue(String ruleFile1){
		pq= Production.readFile(ruleFile1);
	}*/
	
	public ProductionQueue(String rules){
		pq= new ArrayList<Production>();
		String[] ruleS= rules.split(" ");
		for(int i= 0; i< ruleS.length; i++){
			pq.add(new Production(ruleS[i]));
		}
	}
	
	public boolean isEmpty(){
		return pq.isEmpty();
	}

	public Production first(){
		return pq.get(0);
	}
	
	public void butFirst(){
		pq.remove(pq.get(0));
	}
	
	public String toString(){
		if(pq.isEmpty()){
			return "null";
		}
		StringBuffer pqSB= new StringBuffer();
		for(int i= 0; i< pq.size(); i++){
			pqSB.append(pq.get(i));
		}
		return " " + pqSB;
	}
	
	public static void main(String[] args){
		//ProductionQueue prod8= new ProductionQueue("S->ab A->c D->ss");
		ProductionQueue prod8= new ProductionQueue();
		
		System.out.println(prod8.isEmpty());
		//prod8.butFirst();
		//System.out.println(prod8.toString());
	}

}
