package pattern.strategy;

public class SecondChoice implements IChoice {

	@Override
	public void myChoice(String str1, String str2) {
		 System.out.println("You wanted to add the numbers.");
	      int int1, int2, sum;
	      int1 = Integer.parseInt(str1);
	      int2 = Integer.parseInt(str2);
	      sum = int1 + int2;
	      System.out.println(" The result of the addition is:" + sum);
	      System.out.println("***End of the strategy***");

	}

}
