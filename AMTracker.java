import java.util.*;

public class AMTracker{
    private TreeMap<Integer, Maintenance> recordMap;

    public AMTracker(){
	recordMap = new TreeMap<Integer, Maintenance>();
    }

    public TreeMap<Integer, Maintenance> getMap(){ return recordMap; }
    
    public void addRecord(Vehicle vehicle, String type, int ID, Date currentDate) throws RuntimeException{
	if(!vehicle.needsMaint(type))
	    throw new RuntimeException("Vehicle " + vehicle.getVIN() + " doesn't require that type of maintenance");
	
	Maintenance record = new Maintenance(vehicle, type, currentDate, ID);
	recordMap.put(ID, record);
    }

    public List<Maintenance> listRecords() throws RuntimeException{
	if(recordMap.size() == 0)
	    throw new RuntimeException("No maintenance records found");

	ArrayList<Maintenance> recordList = new ArrayList<Maintenance>();
	
	System.out.println("=== Printing Maintenance Records ===");
	for(Map.Entry<Integer, Maintenance> entry : recordMap.entrySet()){
	    Maintenance record = entry.getValue();
	    record.printMaint();
	    recordList.add(record);
	    System.out.println("");
	}
	
	return recordList;
    }

    public List<Maintenance> listRecords(String VIN) throws RuntimeException{
	if(recordMap.size() == 0)
	    throw new RuntimeException("No maintenance records found");

	ArrayList<Maintenance> recordList = new ArrayList<Maintenance>();
	
	System.out.println("=== Printing Maintenance Records for VIN " + VIN + " ===");
	for(Map.Entry<Integer, Maintenance> entry : recordMap.entrySet()){
	    Maintenance record = entry.getValue();
	    Vehicle vehicle = record.getVehicle();
	    
	    if(vehicle.getVIN().equals(VIN)){
		record.printMaint();
		recordList.add(record);
		System.out.println("");
	    }
	}

	if(recordList.size() == 0)
	    throw new RuntimeException("No maintenance records for vehicle with VIN " + VIN + " found");
	
	return recordList;
    }

    public void removeRecord(int ID) throws RuntimeException{
	if(recordMap.remove(ID) == null)
	    throw new RuntimeException("Maintenance record with ID " + ID + " doesn't exist");
    }

    public void updateRecord(Maintenance record) throws RuntimeException{
	removeRecord(record.getID());
	addRecord(record.getVehicle(), record.getType(), record.getID(), record.getDate());
    }

    public Maintenance getRecord(int ID) throws RuntimeException{
	if(!recordMap.containsKey(ID))
	    throw new RuntimeException("Maintenance record with ID " + ID + " doesn't exist");

	return recordMap.get(ID);
    }

    public boolean containsRecord(int ID){
	return recordMap.containsKey(ID);
    }
}
