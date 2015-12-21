import java.util.ArrayList;

public class ElectricVehicle extends Vehicle{
    public ElectricVehicle(String make, String model, int year, int odometer, String VIN){
	super(make, model, year, odometer, VIN);
	this.setEngineType("electric");
    }
}
