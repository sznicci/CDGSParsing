package parsing;

import java.util.*;

public class Parsing {

	private static CDGrammarSystem cdgs;
	private static LookupTable lkupTable;

	private int step;
	private int stepOfTopmost;
	private StackOverNuT mainStack;
	private TreeMap<Nonterminal, StackOverNaturalNumbers> stacksForN;
	private String input;
	private Nonterminal topmost;
	private ProductionQueue pQueue;
	private TreeMap<Integer, ProductionQueue> pQueuesLeft;
	private int actualI;
	private ProductionQueue actualProdQueue;
	private Production pToUse;
	private Terminal lookahead;
	private static int k;
	
	public Parsing(String inpt){
		mainStack= new StackOverNuT();
		stacksForN= new TreeMap<>();

		for(int i= 0; i< cdgs.getNonterminals().size(); i++){
			stacksForN.put(cdgs.getNonterminals().get(i), new StackOverNaturalNumbers());
		}
		
		pQueuesLeft= new TreeMap<>();
		input= inpt;
		mainStack.push(cdgs.getAxiom());
		step= 0;
		stacksForN.get(cdgs.getAxiom()).push(step);
	}
	
	public String toString(){
		return input + " " + mainStack + " " + step + " " + stacksForN.get(cdgs.getAxiom()) + " " + pQueuesLeft;
	}
	
	public String config(String x){
		return "input: "+input + " mainStack: " + mainStack + " step: "+ step + " StacksForN: " + stacksForN + " pQueuesLeft: " + pQueuesLeft;
	}
	
	public boolean ifpQ(){
		actualI= stepOfTopmost;
		Iterator<Integer> keys= pQueuesLeft.keySet().iterator();
		int min= Integer.MAX_VALUE;
		
		while(keys.hasNext()){
			Integer j= keys.next();
			Nonterminal pQLif;
			try {
				pQLif = new Nonterminal((pQueuesLeft.get(j)).first().left().charAt(0));
				
				if(j < min && topmost.equals( pQLif ) && j>=stepOfTopmost){
					min= j;
				}
			} catch (CDGSException e) { e.printStackTrace(); }
		}
		if(min < Integer.MAX_VALUE){
			actualI= min;
			actualProdQueue= pQueuesLeft.get(min);
			return true;
		}
		return false;
	}
	
	public void parsing(){
		/* konstruktor megcsinálja...
		step= 0;
		mainStack.push('S');
		stacksForN.push(step);*/
		//lkupTable.toString();
		//System.out.println("stacksforN: " + stacksForN);
		while( !mainStack.isEmpty() ){			
			if( cdgs.isTerminal( Character.toString(mainStack.top()) ) ){
				
				if( Character.toString(mainStack.top()).equals(input.substring(0, 1)) ){
					mainStack.pop();
					input= input.substring(1);
				}
				else{ 
					System.out.println("error");
					System.exit(0); 
				}
			}
			else{
				try{
					topmost= new Nonterminal(mainStack.top());
				}catch(Exception ex){ ex.printStackTrace(); }
				
				stepOfTopmost= stacksForN.get(topmost).top();
				stacksForN.get(topmost).pop();

				if( ifpQ() ){
					pQueue= actualProdQueue;
					pQueuesLeft.remove(actualI);
					pToUse= (pQueue.first());
					pQueue.butFirst();
					
					if( !pQueue.isEmpty() ){
						pQueuesLeft.put(actualI, actualProdQueue);
					}
					
					mainStack.pop();
					mainStack.push(pToUse.right());
					
					for(int j= 0; j< pToUse.right().length(); j++){
						try{
							if( cdgs.isNonterminal(pToUse.right().charAt(j)) ){
								Nonterminal x= new Nonterminal(pToUse.right().charAt(j));
								stacksForN.get(x).push(actualI);
							}
						} catch(Exception ex){ ex.printStackTrace();}
					}
				}
				else{
					step++;
					try{
						lookahead= new Terminal(input.substring(0, k));
					}catch(Exception ex){ ex.printStackTrace(); }
					System.out.println("lookahead: "+lookahead);
					
					if( lkupTable.lookupTable(topmost, lookahead) != null ){
						pQueue= (lkupTable.lookupTable(topmost, lookahead));
					}
					
					if( pQueue== null || pQueue.isEmpty() ){
						System.out.println("error");
						System.exit(0);
					}
					else{
						pToUse= (pQueue.first());
						pQueue.butFirst();

						if( !pQueue.isEmpty() ){
							pQueuesLeft.put(step, pQueue);
						}
						
						mainStack.pop();
						mainStack.push(pToUse.right());

						for(int j= 0; j< pToUse.right().length(); j++){
							try{
								if( cdgs.isNonterminal(pToUse.right().charAt(j)) ){
									Nonterminal x= new Nonterminal(pToUse.right().charAt(j));
									stacksForN.get(x).push(step);
								}
							} catch(Exception ex){ ex.printStackTrace();}
						}
					}
				}	
			}
			System.out.println("config alg: "+config(pToUse.nontermStack(cdgs).toString()));
		}

	}
	
	public static void main(String[] args) {
		if (args.length > 0){
			cdgs= CDGrammarSystem.readFile(args[0]);
			lkupTable= LookupTable.readFile(args[1]);
			Parsing pars= new Parsing(args[3]);
    		try {
        		k = Integer.parseInt(args[2]);
    		} catch (NumberFormatException e) {
        		System.err.println("Argument" + args[2] + " must be an integer.");
        		System.exit(1);
    		}
    		pars.parsing();
		}
	}

}
