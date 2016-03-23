package polynomial.test;

import polynomial.model.*;
import polynomial.logic.*;

public class IntegrateTest extends Test {

	private String in,out;
	
	public IntegrateTest(){
		
		in = "-6x^2+x+7";
		out = "-2x^3+0.5x^2+7x+C";
		
		if (!out.equals(Operation.integrate(new Polynomial(in)).toString()))
			pass = false;
		
	}
	
}
