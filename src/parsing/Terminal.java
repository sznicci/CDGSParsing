package parsing;

public class Terminal{

	private String terminal;
	
	public Terminal(String st) throws CDGSException{
		terminal= st;
		char[] ch= new char[st.length()];
		ch= terminal.toCharArray();
		
		for(int i= 0; i< ch.length; i++){
			if( !Character.isLowerCase(ch[i]) ){
				throw new CDGSException("NEM terminalis!");
			}
		}
	}
	
	public boolean isTerminal(){
		char[] ch= new char[terminal.length()];
		ch= terminal.toCharArray();
		
		for(int i= 0; i< ch.length; i++){
			if( Character.isLowerCase(ch[i]) ){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return terminal;
	}
	
	public boolean equals(Object o){
		if(o instanceof Terminal){
			Terminal t= (Terminal) o;
			if(terminal.equals(t.terminal)){
				return true;
			}
			else{ return false; }
		}
		return false;
	}

	public static void main(String[] args){
		try{
			Terminal t= new Terminal("D");
			System.out.println(t.toString());
		} catch(CDGSException ex){ ex.printStackTrace(); }
	}

}
