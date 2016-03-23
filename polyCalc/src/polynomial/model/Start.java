package polynomial.model;

//import javax.management.openmbean.OpenDataException;
import polynomial.gui.*;
import polynomial.test.*;
public class Start {

	@SuppressWarnings("unused")
	private static Gui myGui;
	private static Test test1,test2,test3,test4,test5,test6,test7,test8;
	
	public static void main(String[] args){
	
		test1 = new InputTest();
		if (test1.passed()){
			test2 = new OutputTest();
			if (test2.passed()){
				test3 = new AddTest();
				if (test3.passed()){
					test4 = new SubTest();
					if (test4.passed()){
						test5 = new MultiplyTest();
						if (test5.passed()){
							test6 = new DivisionTest();
							if (test6.passed()){
								test7 = new DerivateTest();
								if (test7.passed()){
									test8 = new IntegrateTest();
									if (test8.passed())
										myGui = new Gui();
								}
							}			
						}
					}
				}
			}
		}
	}
}
