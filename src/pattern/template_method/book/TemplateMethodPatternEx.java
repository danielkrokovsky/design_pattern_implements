package pattern.template_method.book;

import java.util.ArrayList;
import java.util.List;

public class TemplateMethodPatternEx {

	public static void main(String[] args) {

		List<BasicEngineering> lis = new ArrayList<BasicEngineering>();
		System.out.println("***Template Method Pattern Demo***\n");
		BasicEngineering bs1 = new ComputerScience();
		System.out.println("Computer Sc Papers:");
		bs1.Papers();
		
		
		System.out.println();
		BasicEngineering bs2 = new ComputerScience();
		bs2 = new Electronics();
		System.out.println("Electronics Papers:");
		bs2.Papers();
		
		
		lis.add(bs1);
		lis.add(bs2);
		
		lis.forEach(f -> f.SpecialPaper());
	}

}
