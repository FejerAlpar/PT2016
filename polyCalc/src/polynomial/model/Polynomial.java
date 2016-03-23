package polynomial.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polynomial {

	private List<Term> terms;

	public Polynomial() {
		terms = new ArrayList<Term>();
	}

	public Polynomial(Polynomial p) {
		terms = new ArrayList<Term>();
		for (Term t : p.getTerms()) {
			this.terms.add(new Term(t.getCoeff(), t.getDegree()));
		}
	}
	
	public Polynomial(String s){
		terms = new ArrayList<Term>();
		if (s.equals("Invalid"))
			terms.add(new Term(-Integer.MAX_VALUE,Integer.MAX_VALUE));
		else{
		if (s.equals("Div0"))
			this.terms.add(new Term(Integer.MAX_VALUE,Integer.MAX_VALUE));
		else if (s.equals("Zero"))
			this.terms.add(new Term(Integer.MAX_VALUE,-Integer.MAX_VALUE));
		else{ try{
			String[] s2 = s.split("\\+");
			for (int i=0; i<s2.length; i++){
				if (s2[i].contains("-")) {
					int coeff = 1;
					if (s2[i].charAt(0) == '-') coeff = -1;
					String[] s3 = s2[i].split("-");
					this.addTerm(new Term(s3[0],coeff));
					for (int j=1; j<s3.length; j++) this.addTerm(new Term(s3[j],-1));
				}
				else this.addTerm(new Term(s2[i],1));
			}
			this.sort();
		}
		catch (NumberFormatException e){
			this.terms.add(new Term(-Integer.MAX_VALUE,Integer.MAX_VALUE));
		}
		}
		}
	}
	

	public void sort(){
		Collections.sort(terms, new TermComparator());
	}
	public void addTerm(Term t) {
		boolean termExists = false;
		for (Term currentT : terms) {
			if (currentT.getDegree() == t.getDegree()) {
				double coeff = currentT.getCoeff();
				currentT.setCoeff(coeff + t.getCoeff());
				termExists = true;
				if (currentT.getCoeff() == 0) terms.remove(currentT);
				break;
			}
		}
		if (!termExists) {
			terms.add(new Term(t));
		}
	}
	
	public List<Term> getTerms() {
		return terms;
	}
	
	public Term getLead(){
		if (!terms.isEmpty()) return terms.get(0);
		return new Term(-Integer.MAX_VALUE,-Integer.MAX_VALUE);
	}

	public boolean invalid() {
		
		boolean valid = true;
		
		for (Term t : this.getTerms())
			if (t.invalid())
				valid = false;
		
		return !valid;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean b = false;
		for (Term t : terms) {
			if (t.getCoeff() != (int)t.getCoeff())
			{
				double x = (Math.floor(t.getCoeff() * 100) / 100);
				if (t.getCoeff() == Integer.MAX_VALUE && t.getDegree() == Integer.MAX_VALUE)
					sb.append("Division by 0");
				else if (t.getCoeff() == Integer.MAX_VALUE && t.getDegree() == -Integer.MAX_VALUE)
					sb.append("Zero");
				else if (t.getCoeff() == -Integer.MAX_VALUE && t.getDegree() == Integer.MAX_VALUE)
					sb.append("Error");
				else {
				if (t.getCoeff() == -Integer.MAX_VALUE && t.getDegree() == -Integer.MAX_VALUE)
					b=true;
				else
				{
					if (t.getCoeff() != 0)
					{
						if (t.getCoeff() >= 0) 
							sb.append("+");
						{
							if (t.getDegree() == 0 && t.getCoeff() != 0)
								sb.append(x);
							else 
								if (t.getCoeff() != 1)
									if (t.getCoeff() == -1 )
										sb.append('-');
									else
										sb.append(x);
							if (t.getDegree() > 1){
								sb.append("x^");
								sb.append(t.getDegree());
							}
							else if (t.getDegree() == 1)
								sb.append("x");
						}
					}
				}
			}
			}
			else 
			{
				int x = (int)t.getCoeff();
				if (t.getCoeff() == Integer.MAX_VALUE && t.getDegree() == Integer.MAX_VALUE)
					sb.append("Division by 0");
				else if (t.getCoeff() == Integer.MAX_VALUE && t.getDegree() == -Integer.MAX_VALUE)
					sb.append("Zero");
				else if (t.getCoeff() == -Integer.MAX_VALUE && t.getDegree() == Integer.MAX_VALUE)
					sb.append("Error");
				else {
				if (t.getCoeff() == -Integer.MAX_VALUE && t.getDegree() == -Integer.MAX_VALUE)
					b=true;
				else
				{
					if (t.getCoeff() != 0)
					{
						if (t.getCoeff() >= 0) 
							sb.append("+");
					
						if (t.getDegree() == 0 && t.getCoeff() != 0)
							sb.append(x);
						else 
							if (t.getCoeff() != 1)
								if (t.getCoeff() == -1 )
									sb.append('-');
								else
									sb.append(x);
							if (t.getDegree() > 1)
							{
								sb.append("x^");
								sb.append(t.getDegree());
							}
							else if (t.getDegree() == 1)
								sb.append("x");
							}
						}
					}
			}
		}
			if (sb.toString().contains("Error"))
				return "Incorrect input";
			if (sb.toString().equals("Zero"))
				return "";
			if (sb.length() == 0 && !b) sb.append(0);
			else
			{
				if (b == true) sb.append("+C");
				if (sb.charAt(0) == '+') sb.delete(0, 1);
			}
			return sb.toString();
		
		}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		
		if(!(obj instanceof Polynomial)){
			return false;
		}
		
		Polynomial that = (Polynomial)obj;
		
		return that.terms.equals(this.terms);
	}
}
