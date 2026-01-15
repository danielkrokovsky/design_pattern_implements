package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{
	
	List<Observer> observerList = new ArrayList<Observer>();
	private int flag;

	@Override
	public void register(Observer o) {
		this.observerList.add(o);
	}

	@Override
	public void unregister(Observer o) {
		this.observerList.remove(o);
	}

	@Override
	public void notifyObserver(int value) {
		
		for (int i = 0; i < observerList.size(); i++) {
			observerList.get(i).update(this.getClass().getSimpleName(), value);
		    }
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
		notifyObserver(flag);
	}

	@Override
	public String toString() {
		return "Subject [observerList=" + observerList + ", flag=" + flag + "]";
	}
	
}
