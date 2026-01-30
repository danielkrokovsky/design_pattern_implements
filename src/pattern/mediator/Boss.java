package pattern.mediator;

public class Boss extends Friend {

	// Constructor
	public Boss(Mediator mediator, String name) {
		super(mediator);
		this.name = name;
	}

	public void Send(String msg) {
		mediator.Send(this, msg);
	}

	public void Notify(String msg) {
		System.out.println("\nBoss sees message: " + msg);
		System.out.println("");
	}
}