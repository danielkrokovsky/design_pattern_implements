package pattern.abstract_factory;

public interface IMovieFactory {
	ITollywoodMovie GetTollywoodMovie();
	IBollywoodMovie GetBollywoodMovie();
}
