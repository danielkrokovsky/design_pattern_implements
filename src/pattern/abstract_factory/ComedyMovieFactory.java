package pattern.abstract_factory;

public class ComedyMovieFactory implements IMovieFactory {

	public ITollywoodMovie GetTollywoodMovie() {
		return new TollywoodComedyMovie();
	}

	public IBollywoodMovie GetBollywoodMovie() {
		return new BollywoodComedyMovie();
	}

}
