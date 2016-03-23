package polynomial.test;

import polynomial.model.*;

public class OutputTest extends Test{

	private String out;
	private Polynomial in;
	private Term t1,t2,t3,t4,t5;
	
	public OutputTest(){
		
		in = new Polynomial();
		t1 = new Term(-1,2);
		t2 = new Term(-7,14);
		t3 = new Term(1,0);
		t4 = new Term(-5,0);
		t5 = new Term(14,3);
		
		in.addTerm(t1);
		in.addTerm(t2);
		in.addTerm(t3);
		in.addTerm(t4);
		in.addTerm(t5);
		in.sort();
		out = "-7x^14+14x^3-x^2-4";
		
		if (!in.toString().equals(out))
			pass = false;
		
	}
	
}
