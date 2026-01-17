package pattern.strategy;

import java.io.IOException;
import java.util.Scanner;

public class StrategyPatternEx {

	public static void main(String[] args) throws IOException {
	    
	      System.out.println("***Strategy Pattern Demo***");
	      Scanner in = new Scanner(System.in); //To take input from user
	      IChoice ic;
	      Context cxt = new Context();
	      String input1, input2;
	      
	      //Looping twice to test two different choices
	      try {
	          for (int i = 1; i <= 2; i++) {
	              System.out.println("Enter an integer:");
	              input1 = in.nextLine();
	              System.out.println("Enter another integer:");
	              input2 = in.nextLine();
	              System.out.println("Enter ur choice(1 or 2)");
	              System.out.println("Press 1 for Concatenation, 2 for Addition");
	              String c = in .nextLine();
	  
	              if (c.equals("1")) {
	                  ic = new FirstChoice();
	              } else {
	                  ic = new SecondChoice();
	              }
	              /*Associate the Strategy with Context*/
	              cxt.SetChoice(ic);
	              cxt.ShowChoice(input1, input2);
	          }
	      } finally { in .close();
	      }
	      System.out.println("End of Strategy pattern");
	  }
}
