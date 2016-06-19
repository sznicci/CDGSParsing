package parsing;

import java.io.*;
import java.util.*;

public class Production{

	public String[] production;
	public String productionS;
	
	public Production(String rule){
		production= rule.split("-?>");
	}

	public String left(){
		return production[0];
	}
	
	public String right(){
		return production[1];
	}
	
	public ArrayList<Character> nontermStack(CDGrammarSystem cdgs){	
		ArrayList<Character> stacksArray= new ArrayList<>();
		
		try{
			for(int i= 0; i< production[1].length(); i++){
				Character nonterm= new Character(production[1].charAt(i));
				if( !( stacksArray.contains(nonterm) ) && cdgs.isNonterminal( nonterm ) ){
					stacksArray.add( nonterm );
				}
			}
		}catch(Exception ex){ ex.printStackTrace(); }
		
		return stacksArray;

	}
	
	public static ArrayList<Production> readFile(String ruleFile1){
		ArrayList<Production> prod= new ArrayList<Production>();
		
		try{
			File ruleFile= new File(ruleFile1);
			FileReader fileReader= new FileReader(ruleFile);
			
			BufferedReader reader= new BufferedReader(fileReader);

			String line= null;

			while( (line= reader.readLine()) != null ){
				if(line.trim().length()>=1){
					prod.add(new Production(line));
				}
			}
			
			reader.close();
		}catch(Exception ex){ ex.printStackTrace(); }
		
		return prod;
	}
	
	public String toString(){
		return "  " + this.left() + "->"+ this.right();
	}
	
	public static void main(String[] args){
		/*ArrayList<Production> prod7= readFile("ruleFile.txt");
		for(int i= 0; i< prod7.size(); i++){
			System.out.println(prod7.get(i).toString());
		}
		*/
	}

}
