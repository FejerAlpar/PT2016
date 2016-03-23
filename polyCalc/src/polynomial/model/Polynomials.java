package polynomial.model;


public class Polynomials extends Polynomial{
	private Polynomial p1,p2;
	
	public Polynomials(Polynomial p1, Polynomial p2){
		this.p1=p1;
		this.p2=p2;
	}
	public Polynomial getPol(int i){
		if (i == 1) return this.p1;
		else return this.p2;
	}
	
	@Override
	public void sort(){
		this.p1.sort();
		this.p2.sort();
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.p1.toString());
		sb.append("\n");
		sb.append(this.p2.toString());
		return sb.toString();
	}
}
