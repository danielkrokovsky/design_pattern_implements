package pattern.iterator;

import java.util.LinkedList;

public class Science implements ISubject {
	
	private LinkedList<String> subjects;

	public Science() {
		subjects = new LinkedList<String>();
		subjects.addLast("Maths");
		subjects.addLast("Comp. Sc.");
		subjects.addLast("Physics");
	}

	@Override
    public IIterator CreateIterator() {
        return new ScienceIterator(subjects);
    }
}