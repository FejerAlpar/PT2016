package polynomial.test;

import polynomial.logic.Operation;
import polynomial.model.*;

public class AddTest extends Test{

	private String in1,in2,out;
	
	public AddTest(){
		
		in1 = "x+2";
		in2 = "-x+x^5-14x^3+1";
		out = "x^5-14x^3+3";
		
		if (!out.equals(Operation.add(new Polynomial(in1), new Polynomial(in2)).toString()))
			pass = false;
		
		in1 = "-x^7+14x-5";
		in2 = "x^5+5";
		out = "-x^7+x^5+14x";
		
		if (!out.equals(Operation.add(new Polynomial(in1), new Polynomial(in2)).toString()))
			pass = false;
		
	}
	
}
