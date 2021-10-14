package oops.overriding;

public class TestChild extends TestParent {
 void show(){
	 System.out.println("in Child's show");
 }
 
 void xyz(){
	 System.out.println("in Child's xyz");
	 super.show();
 }
}
