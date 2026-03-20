package garage;

public class Vehicle {

	private String plate;
	private String model;
	private String color;

	public String getPlate() {
		return plate;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public Vehicle(String plate, String model, String color) {
		this.plate = plate;
		this.model = model;
		this.color = color;
	}

}
