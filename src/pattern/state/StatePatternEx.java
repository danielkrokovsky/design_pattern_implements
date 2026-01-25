package pattern.state;

public class StatePatternEx {

	public static void main(String[] args) {
		
		System.out.println("***State Pattern Demo***\n");
		
	    // Initially TV is Off
		RemoteControl initialState = new Off();
	    TV tv = new TV(initialState);
	    
	    // First time press
	    tv.pressButton();
	    
	    // Second time press
	    tv.pressButton();

	}

}
