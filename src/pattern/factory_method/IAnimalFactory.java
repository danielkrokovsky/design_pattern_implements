package pattern.factory_method;

public abstract class IAnimalFactory {
	public abstract IAnimal GetAnimalType(String type) throws Exception;
}
