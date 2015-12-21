import java.util.ArrayList;

public class Vehicle{
    private String engineType;
    private String make;
    private String model;
    private int year;
    private int odometer;
    private String VIN;
    private ArrayList<String> availableMaint;

    public Vehicle(String make, String model, int year, int odometer, String VIN){
	this.make = make;
	this.model = model;
	this.year = year;
	this.odometer = odometer;
	this.VIN = VIN;
	availableMaint = new ArrayList<String>();
	availableMaint.add("brake rotoring");
	availableMaint.add("tire rotation");
    }

    public String getEngineType(){ return engineType; }
    public void setEngineType(String engineType){ this.engineType = engineType; }

    public String getMake(){ return make; }
    public void setMake(String make){ this.make = make; }

    public String getModel(){ return model; }
    public void setModel(String model){ this.model = model; }

    public int getYear(){ return year; }
    public void setYear(int year){ this.year = year; }

    public int getOdometer(){ return odometer; }
    public void setOdometer(int odometer){ this.odometer = odometer; }

    public String getVIN(){ return VIN; }
    public void setVIN(String VIN){ this.VIN = VIN; }

    public void addMaint(String maint){ availableMaint.add(maint); }

    public boolean needsMaint(String maint){
	return availableMaint.indexOf(maint) > -1;
    }	
}
