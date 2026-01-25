package pattern.iterator;

import java.util.List;

public class ScienceIterator implements IIterator {

	private List<String> subjects;
	private int position;

	public ScienceIterator(List<String> subjects) {
		this.subjects = subjects;
		position = 0;
	}

	public void First() {
		position = 0;
	}

	public String Next() {
		return subjects.get(position++);
	}

	public Boolean IsDone() {
		return position >= subjects.size();
	}

	public String CurrentItem() {
		return subjects.get(position);
	}

}