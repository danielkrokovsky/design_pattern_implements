package pattern.builder;

public interface IBuilder {

	void BuildBody();

	void InsertWheels();

	void AddHeadlights();

	Product GetVehicle();
}
