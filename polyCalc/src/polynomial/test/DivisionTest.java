package polynomial.test;

import polynomial.logic.Operation;
import polynomial.model.Polynomial;

public class DivisionTest extends Test {

	private String in1,in2,out;
	
	public DivisionTest(){
		
		in1 = "x^2-9x-10";
		in2 = "x+1";
		out = "x-10\n0";
		
		if (!out.equals(Operation.divide(new Polynomial(in1), new Polynomial(in2)).toString()))
			pass = false;
		
		in1 = "x^4+4";
		in2 = "x^2-5";
		out = "x^2+5\n29";
		
		if (!out.equals(Operation.divide(new Polynomial(in1), new Polynomial(in2)).toString()))
			pass = false;
		
		}
		
}
