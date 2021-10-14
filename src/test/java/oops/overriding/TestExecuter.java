package oops.overriding;

public class TestExecuter {
	public static void main(String[] args){
		TestParent tpc = new TestChild();
		tpc.show(); // will print Child class show
		// tpc.xyz(); will give error as TestParent class do not have xyz method
		
		TestChild tc = new TestChild();
		tc.xyz(); // will print Child class xyz
		tc.show(); // will print Child class show
		tc.abc(); // will print parent class abs
		
		TestParent tp = new TestParent();
		tp.show(); // will print Parent class show
		
	}
}
