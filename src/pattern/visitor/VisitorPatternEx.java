package pattern.visitor;

public class VisitorPatternEx {

	public static void main(String[] args) {
		System.out.println("***Visitor Pattern Demo***\n");
	    IVisitor v = new Visitor2();
	    MyClass myClass = new MyClass();
	    myClass.accept(v);
	}
}
