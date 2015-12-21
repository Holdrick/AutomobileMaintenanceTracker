import java.util.ArrayList;

public class DieselVehicle extends Vehicle{
    public DieselVehicle(String make, String model, int year, int odometer, String VIN){
	super(make, model, year, odometer, VIN);
	this.setEngineType("diesel");
	this.addMaint("oil change");
    }
}
