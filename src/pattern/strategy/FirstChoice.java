package pattern.strategy;

public class FirstChoice implements IChoice {

	@Override
	public void myChoice(String str1, String str2) {
		System.out.println("You wanted to concatenate the numbers.");
	      System.out.println(" The result of the addition is:" + str1 + str2);
	      System.out.println("***End of the strategy***");
	}

}
