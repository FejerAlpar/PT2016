package polynomial.test;

import polynomial.model.*;
import polynomial.logic.*;

public class MultiplyTest extends Test{

	private String in1,in2,out;
	
	public MultiplyTest(){
		
		in1 = "x-3";
		in2 = "x+2";
		out = "x^2-x-6";
		
		if (!out.equals(Operation.multiply(new Polynomial(in1), new Polynomial(in2)).toString()))
				pass = false;
		
	}
	
}
