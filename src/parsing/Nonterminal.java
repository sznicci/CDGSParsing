package parsing;

public class Nonterminal implements Comparable {

	private Character nonterminal;

	public Nonterminal(Character ch) throws CDGSException {
		nonterminal = ch;

		if (!Character.isUpperCase(nonterminal)) {
			throw new CDGSException("NEM nemterminalis!");
		}
	}

	public boolean isNonterminal() {
		if (Character.isUpperCase(nonterminal)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return Character.toString((char) nonterminal);
	}

	public char toChar() {
		return (char) nonterminal;
	}

	public boolean equals(Object o) {
		if (o instanceof Nonterminal) {
			Nonterminal n = (Nonterminal) o;
			if (nonterminal.equals(n.nonterminal)) {
				return true;
			} else {
				return false;
			}
		} else if (o instanceof Character) {
			Character c = (Character) o;
			if (nonterminal.equals(c)) {
				return true;
			}
		} else if (o instanceof String) {
			String c = (String) o;
			if (nonterminal.equals(c)) {
				return true;
			}
		}
		return false;
	}

	public int hashCode() {
		return nonterminal.hashCode();
	}

	public int compareTo(Object o) {
		if (o instanceof Nonterminal) {
			Nonterminal n = (Nonterminal) o;
			if (nonterminal.hashCode() < (n.nonterminal).hashCode()) {
				return -1;
			} else if (nonterminal.hashCode() > (n.nonterminal).hashCode()) {
				return 1;
			} else {
				return 0;
			}
		}
		return -2;
	}

	public static void main(String[] args) {
		try {
			Nonterminal nt = new Nonterminal('A');
			Character a = 'A';
			System.out.println(nt.equals(a));
		} catch (CDGSException ex) {
			ex.printStackTrace();
		}
	}

}
