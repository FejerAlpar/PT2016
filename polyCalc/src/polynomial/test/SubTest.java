package polynomial.test;

import polynomial.model.*;
import polynomial.logic.*;

public class SubTest extends Test{

	private String in1,in2,out;
	
	public SubTest(){
		
		in1 = "0";
		in2 = "-x^7+5";
		out = "x^7-5";
		
		if (!out.equals(Operation.sub(new Polynomial(in1), new Polynomial(in2)).toString()))
				pass = false;
		
	}
	
}
