package pattern.template_method.book;

public abstract class BasicEngineering {

	public final void Papers() {
		Math();
		SoftSkills();
		SpecialPaper();
	}

	private void Math() {
		System.out.println("Mathematics");
	}

	private void SoftSkills() {
		System.out.println("SoftSkills");
	}

	// Método abstrato SpecialPaper() deve ser implementado nas classes derivadas
	public abstract void SpecialPaper();
}