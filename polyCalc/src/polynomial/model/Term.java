package polynomial.model;

public class Term {
	private double coeff;
	private int degree;

	public Term(double coeff, int degree) {
		super();
		this.coeff = coeff;
		this.degree = degree;
	}
	
	public Term(Term t) {
		super();
		this.coeff = t.coeff;
		this.degree = t.degree;
	}
	
	public boolean invalid(){
		
		return (this.coeff == -Integer.MAX_VALUE && this.degree == Integer.MAX_VALUE);
		
	}
	
	public Term(String s, int coeff){
		if (s.contains("^-"))
			throw new NumberFormatException();
		else{
		if (s.contains("x^")) {
			String[] s2 = s.split("x");
			if (s2[0].equals("")) this.coeff = coeff;
			else this.coeff = coeff*Integer.parseInt(s2[0]);
			s2[1]=s2[1].substring(1,s2[1].length());
			this.degree = Integer.parseInt(s2[1]);	
		}
		else if (s.contains("x")){
			String[] s2 = s.split("x");
			if (s2.length==0) this.coeff =(double) coeff;
			else this.coeff = coeff*Integer.parseInt(s2[0]);
			this.degree = 1;
		}
		else if (!s.isEmpty()){
			this.coeff=coeff*Integer.parseInt(s);
			this.degree=0;
		}
		}
	}
	
	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Term)){
			return false;
		}
		
		Term that = (Term)obj;
		
		return that.coeff == this.coeff && that.degree == this.degree;
	}

}
