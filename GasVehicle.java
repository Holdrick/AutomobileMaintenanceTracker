

public class GasVehicle extends Vehicle{
    public GasVehicle(String make, String model, int year, int odometer, String VIN){
	super(make, model, year, odometer, VIN);
	this.setEngineType("gas");
	this.addMaint("oil change");
    }
}
