package polynomial.test;

import polynomial.model.*;

public class InputTest extends Test{

	private String in;
	private Polynomial out;
	private Term t1,t2,t3,t4,t5,t6;
	
	
	public InputTest()
	{
		in="x^2-x+5-5+14x^7+5";
		out = new Polynomial();
		t1 = new Term(1,2);
		t2 = new Term(-1,1);
		t3 = new Term(5,0);
		t4 = new Term(-5,0);
		t5 = new Term(14,7);
		t6 = new Term(5,0);
		out.addTerm(t1);
		out.addTerm(t2);
		out.addTerm(t3);
		out.addTerm(t4);
		out.addTerm(t5);
		out.addTerm(t6);
		out.sort();
		
		if (!out.equals(new Polynomial(in))) 
			pass = false;
	
		
		in="-1-x^5+800x";
		out = new Polynomial();
		t1 = new Term(-1,0);
		t2 = new Term(-1,5);
		t3 = new Term(800,1);
		out.addTerm(t1);
		out.addTerm(t2);
		out.addTerm(t3);
		out.sort();
		
		if (!out.equals(new Polynomial(in)))
			pass = false;
		
		
		in="0";
		out = new Polynomial();
		t1 = new Term(0,0);
		out.addTerm(t1);
		out.sort();
		
		if (!out.equals(new Polynomial(in)))
			pass = false;
		
	}
	
}
