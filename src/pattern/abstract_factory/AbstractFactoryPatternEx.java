package pattern.abstract_factory;

public class AbstractFactoryPatternEx {

	public static void main(String[] args) {

		System.out.println("***Abstract Factory Pattern Demo***");
		ActionMovieFactory actionMovies = new ActionMovieFactory();
		ITollywoodMovie tAction = actionMovies.GetTollywoodMovie();
		IBollywoodMovie bAction = actionMovies.GetBollywoodMovie();
		
		System.out.println("\nAction movies are:");
		System.out.println(tAction.MovieName());
		System.out.println(bAction.MovieName());
		
		ComedyMovieFactory comedyMovies = new ComedyMovieFactory();
		ITollywoodMovie tComedy = comedyMovies.GetTollywoodMovie();
		IBollywoodMovie bComedy = comedyMovies.GetBollywoodMovie();
		
		System.out.println("\nComedy movies are:");
		System.out.println(tComedy.MovieName());
		System.out.println(bComedy.MovieName());

	}

}
