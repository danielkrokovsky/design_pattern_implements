package design_pattern.observer;

public class Observer implements IObserver{
	
	@Override
	public void update(String s, int i) {
		System.out.println("Observer: myValue in " + s + " is now: " + i);
	}

}
