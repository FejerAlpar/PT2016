package polynomial.test;

import polynomial.model.*;
import polynomial.logic.*;

public class DerivateTest extends Test {

	private String in,out;
	
	public DerivateTest(){
		
		in = "-2x^7+5x+3";
		out = "-14x^6+5";
		
		if (!out.equals(Operation.derive(new Polynomial(in)).toString()))
			pass = false;
		
	}
	
}
