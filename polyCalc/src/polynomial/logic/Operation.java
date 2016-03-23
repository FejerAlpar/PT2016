package polynomial.logic;

import polynomial.model.Polynomial;
import polynomial.model.Polynomials;
import polynomial.model.Term;

public class Operation {

	public static Polynomial add(Polynomial p1, Polynomial p2) {
		if (p1.invalid() || p2.invalid())
			return new Polynomial("Invalid");
		Polynomial result = new Polynomial(p1);
		for (Term term : p2.getTerms()) {
			result.addTerm(term);
		}
		result.sort();
		return result;
	}
	
	public static Polynomial sub(Polynomial p1, Polynomial p2) {
		if (p1.invalid() || p2.invalid())
			return new Polynomial("Invalid");
		Polynomial result = new Polynomial(p1);
		for (Term term : p2.getTerms()) {
			double coeff = term.getCoeff();
			term.setCoeff((-1)*coeff);
			if (term.getCoeff()!=0) 
			result.addTerm(term);
		}
		result.sort();
		return result;
	}
	
	public static Polynomial multiply(Polynomial p1, Polynomial p2){
		if (p1.invalid() || p2.invalid())
			return new Polynomial("Invalid");
		Polynomial result = new Polynomial();
		for (Term term1 : p1.getTerms())
			for (Term term2 : p2.getTerms())
			{
				int degree = term1.getDegree() + term2.getDegree();
				double coeff = term1.getCoeff() * term2.getCoeff();
				Term term = new Term(coeff,degree);
				result.addTerm(term);
			}
		result.sort();
		return result;
	}
	public static Polynomial derive(Polynomial p){
		if (p.invalid())
			return new Polynomial("Invalid");
		Polynomial result = new Polynomial();
		for (Term term : p.getTerms()){
			if (term.getDegree() != 0) {
				Term myTerm = new Term(term.getCoeff()*term.getDegree(),term.getDegree()-1);
				result.addTerm(myTerm);
			}
		}	
		result.sort();
		return result;
	}
	public static Polynomial integrate(Polynomial p){
		if (p.invalid())
			return new Polynomial("Invalid");
		Polynomial result = new Polynomial();
		for (Term term : p.getTerms()){
			Term myTerm = new Term(term.getCoeff()/(term.getDegree()+1),term.getDegree()+1);
			result.addTerm(myTerm);
		}
		Term k = new Term(-Integer.MAX_VALUE,-Integer.MAX_VALUE);
		result.addTerm(k);
		result.sort();
		return result;
	}
	public static Polynomials divide(Polynomial p1, Polynomial p2){
		if (p1.invalid() || p2.invalid())
			return new Polynomials(new Polynomial("Invalid"),new Polynomial("Zero"));
		Polynomial p3 = new Polynomial(p1);
		Polynomial p5 = new Polynomial();
		Polynomials result;
		if ((p1.getLead().getCoeff() == -Integer.MAX_VALUE && p1.getLead().getDegree() == Integer.MAX_VALUE) || 
				(p2.getLead().getCoeff() == -Integer.MAX_VALUE && p2.getLead().getDegree() == Integer.MAX_VALUE))
			return new Polynomials(new Polynomial("dasd"),new Polynomial("Zero"));
		if (p2.equals(new Polynomial(""))){
			return new Polynomials(new Polynomial("Div0"),new Polynomial("Zero"));
		}
		while (p3.getLead().getDegree() >= p2.getLead().getDegree()){
			result = Operation.divi(p3, p2);
			p3 = result.getPol(1);
			p5.addTerm(result.getPol(2).getLead());
		}
		result = new Polynomials(p5,p3);
		result.sort();
		return result;
	}
	
	private static Polynomials divi(Polynomial p6, Polynomial p7){
		int degree = p6.getLead().getDegree()-p7.getLead().getDegree();
		double coeff = p6.getLead().getCoeff() / p7.getLead().getCoeff();
		Term term = new Term(coeff,degree);
		Polynomial fac = new Polynomial();
		fac.addTerm(term);
		Polynomial fac2 = Operation.multiply(fac, p7);
		Polynomial rem = Operation.sub(p6,fac2);
		Polynomials result = new Polynomials(rem,fac);
		return result;
	}
}