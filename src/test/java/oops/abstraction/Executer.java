package oops.abstraction;

public class Executer {
	

	public static void main(String[] args){
		Child childObj = new Child();
		ParentAbs parentAbs = new Child();
		
		childObj.absMethod1();
		childObj.absMethod2();
		childObj.method3();
		
		parentAbs.absMethod1();
		parentAbs.absMethod2();
		parentAbs.method3();
	}
	

}
