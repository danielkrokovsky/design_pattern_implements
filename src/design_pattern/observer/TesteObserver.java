package design_pattern.observer;


public class TesteObserver {

	public static void main(String[] args) {
		
/*		System.out.println("***Observer Pattern Demo***\n");
		Observer o1 = new Observer();
		Subject sub1 = new Subject();
		sub1.register(o1);
		System.out.println("Setting Flag = 5 ");
		sub1.setFlag(5);
		System.out.println("Setting Flag = 25 ");
		sub1.setFlag(25);
		sub1.unregister(o1);
		// No notification this time to o1 .Since it is unregistered.
		System.out.println("Setting Flag = 50 ");
		sub1.setFlag(50);*/
	
	
	
	System.out.println("*** Observer Pattern Demo3***\n");
	Subject sub1 = new Subject();
	Subject sub2 = new Subject();
	Observer ob1 = new Observer();
	Observer ob2 = new Observer();
	Observer ob3 = new Observer();
	// Observer1 and Observer2 registers to //Subject 1
	sub1.register(ob1);
	sub1.register(ob2);
	// Observer2 and Observer3 registers to //Subject 2
	sub2.register(ob2);
	sub2.register(ob3);
	// Set new value to Subject 1
	// Observer1 and Observer2 get //notification
	sub1.setFlag(50);
	System.out.println();
	// Set new value to Subject 2
	// Observer2 and Observer3 get //notification
	sub2.setFlag(250);
	System.out.println();
	// unregister Observer2 from Subject 1
	sub1.unregister(ob2);
	// Set new value to Subject & only //Observer1 is notified
	sub1.setFlag(550);
	System.out.println();
	// ob2 can still notice change in //Subject 2
	sub2.setFlag(750);
	}
}
