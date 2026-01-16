package pattern.decorator;

public class ConcreteComponent implements Component {

	@Override
	public void doJob() {
		System.out.println("I am from Concrete Component-I am closed for modification.");

	}

}
