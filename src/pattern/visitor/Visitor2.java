package pattern.visitor;

public class Visitor2 implements IVisitor {
	  
	  @Override
	  public void visit(MyClass myClassElement) {
	      System.out.println("Visitor2 is trying to change the integer value");
	      myClassElement.setMyInt(100);
	      System.out.println("Exiting from Visitor-visit");
	  }

}
