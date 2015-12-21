import java.util.Date;

public class Maintenance{
    private String type;
    private Vehicle vehicle;
    private Date date;
    private int ID;
    
    public Maintenance(Vehicle vehicle, String type, Date date, int ID){
	this.vehicle = vehicle;
	this.type = type;
	this.date = date;
	this.ID = ID;
    }

    public String getType(){ return type; }
    public void setType(String type){ this.type = type; }

    public Vehicle getVehicle(){ return vehicle; }
    public void setVehicle(Vehicle vehicle){ this.vehicle = vehicle; }

    public Date getDate(){ return date; }
    public void setDate(Date date){ this.date = date; }

    public int getID(){ return ID; }
    public void setID(int ID){ this.ID = ID; }
    
    public void printMaint(){
	System.out.print("Maintenance ID: " + ID + " VIN: " + vehicle.getVIN());
	System.out.println("  Make: " + vehicle.getMake() + "  Model: " + vehicle.getModel());
	System.out.println("  Maintenance type: " + type + "  Performed on: " + date.toString());
    }
}
