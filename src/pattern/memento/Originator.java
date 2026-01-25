package pattern.memento;

public class Originator {

	private String state;
	private Memento m;

	public void setState(String state) {
		this.state = state;
		System.out.println("State at present : " + state);
	}

	// Creates memento
	public Memento OriginatorMemento() {
		m = new Memento(state);
		return m;
	}

	// Back to old state
	public void Revert(Memento memento) {
		System.out.println("Restoring to previous state...");
		state = memento.getState();
		System.out.println("State at present :" + state);
	}

}
