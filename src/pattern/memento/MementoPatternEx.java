package pattern.memento;

public class MementoPatternEx {

	public static void main(String[] args) {
		
		System.out.println("***Memento Pattern Demo***\n");
		Originator o = new Originator();
		o.setState("First state");
		
		// Holding old state
		Caretaker c = new Caretaker();
		c.SaveMemento(o.OriginatorMemento());
		
		// Changing state
		o.setState("Second state");
		
		// Restore saved state
		o.Revert(c.RetrieveMemento());
	}
}
