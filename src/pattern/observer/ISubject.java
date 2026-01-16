package pattern.observer;

public interface ISubject {
	
	void register(Observer o);
	void unregister(Observer o);
	void notifyObserver(int i);

}
