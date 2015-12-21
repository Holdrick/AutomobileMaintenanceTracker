import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests{
    @Test(expected=RuntimeException.class)
    public void testListRecordsException(){
	AMTracker tracker = new AMTracker();
	tracker.listRecords();
    }
    @Test(expected=RuntimeException.class)
    public void testListRecordVINException(){
	AMTracker tracker = new AMTracker();
	tracker.listRecords("4234");
    }
    @Test(expected=RuntimeException.class)
    public void testRemoveRecordException(){
	AMTracker tracker = new AMTracker();
	tracker.removeRecord(2343);
    }
    @Test(expected=RuntimeException.class)
    public void testGetRecordException(){
	AMTracker tracker = new AMTracker();
	tracker.getRecord(2343);
    }
    @Test(expected=RuntimeException.class)
    public void testUpdateRecordException(){
	AMTracker tracker = new AMTracker();
	ElectricVehicle ev = new ElectricVehicle("Tesla", "Model S", 2015, 12345, "345335653345");	
	Maintenance record = new Maintenance(ev, "tire rotation", new Date(), 324);
	tracker.updateRecord(record);
    }
    @Test(expected=RuntimeException.class)
    public void testUpdateInvalidRecordException(){
	AMTracker tracker = new AMTracker();
	ElectricVehicle ev = new ElectricVehicle("Tesla", "Model S", 2015, 12345, "345335653345");	
	
	tracker.addRecord(ev, "tire rotation", 1, new Date());

	Maintenance record = tracker.getRecord(1);
	record.setType("oil change");
	tracker.updateRecord(record);
    }    
    @Test(expected=RuntimeException.class)
    public void testAddRecordExceptions(){
	AMTracker tracker = new AMTracker();
	ElectricVehicle ev = new ElectricVehicle("Tesla", "Model S", 2015, 12345, "345335653345");
	tracker.addRecord(ev, "oil change", 1, new Date());
    }

    @Test
    public void testAddRecord(){
	AMTracker tracker = new AMTracker();
	ElectricVehicle ev = new ElectricVehicle("Tesla", "Model S", 2015, 12345, "345335653345");
	GasVehicle gv = new GasVehicle("Honda", "Civic", 2008, 193456, "15394990404");
	DieselVehicle dv = new DieselVehicle("Ford", "F350", 2012, 80001, "234209503495");
	
	int id1 = 123;
	int id2 = 234;
	int id3 = 345;
	int id4 = 124;
	int id5 = 235;
	int id6 = 346;

	tracker.addRecord(ev, "tire rotation", id1, new Date());
	tracker.addRecord(gv, "oil change", id2, new Date());
	tracker.addRecord(dv, "brake rotoring", id3, new Date());

	tracker.addRecord(ev, "brake rotoring", id4, new Date());
	tracker.addRecord(gv, "tire rotation", id5, new Date());
	tracker.addRecord(dv, "oil change", id6, new Date());
	
	assertEquals(true, tracker.containsRecord(id1));
	assertEquals(true, tracker.containsRecord(id2));
	assertEquals(true, tracker.containsRecord(id3));
	assertEquals(true, tracker.containsRecord(id4));
	assertEquals(true, tracker.containsRecord(id5));
	assertEquals(true, tracker.containsRecord(id6));
	assertEquals(false, tracker.containsRecord(1));

	System.out.println("Testing addRecord...");
	tracker.listRecords();
	tracker.listRecords(ev.getVIN());
	System.out.println("Done testing addRecord\n\n");
    }

    @Test
    public void testUpdateRecord(){
	AMTracker tracker = new AMTracker();
	ElectricVehicle ev = new ElectricVehicle("Tesla", "Model S", 2015, 12345, "345335653345");
	GasVehicle gv = new GasVehicle("Honda", "Civic", 2008, 193456, "15394990404");
	DieselVehicle dv = new DieselVehicle("Ford", "F350", 2012, 80001, "234209503495");
	
	int id1 = 123;
	int id2 = 234;
	int id3 = 345;

	System.out.println("Testing updateRecord...");
	tracker.addRecord(ev, "tire rotation", id1, new Date());
	tracker.addRecord(gv, "oil change", id2, new Date());
	tracker.addRecord(dv, "brake rotoring", id3, new Date());
	tracker.listRecords();
	
	assertEquals(true, tracker.containsRecord(id2));

	Maintenance maintenance = tracker.getRecord(id2);
	maintenance.setType("tire rotation");
	Date date = new Date();
	maintenance.setDate(date);
	tracker.updateRecord(maintenance);

	assertEquals("tire rotation", tracker.getRecord(id2).getType());
	assertEquals(date, tracker.getRecord(id2).getDate());
	
	tracker.listRecords();
	System.out.println("Done testing updateRecord\n\n");
    }

    @Test
    public void testRemoveRecord(){
	AMTracker tracker = new AMTracker();
	ElectricVehicle ev = new ElectricVehicle("Tesla", "Model S", 2015, 12345, "345335653345");
	GasVehicle gv = new GasVehicle("Honda", "Civic", 2008, 193456, "15394990404");
	
	int id1 = 123;
	int id2 = 124;
	TreeMap<Integer, Maintenance> recordMap = new TreeMap<Integer, Maintenance>();

	System.out.println("Testing removeRecord...");
	tracker.addRecord(ev, "tire rotation", id1, new Date());
	tracker.addRecord(gv, "oil change", id2, new Date());
	tracker.listRecords();
	recordMap = tracker.getMap();
	
	assertEquals(true, tracker.containsRecord(id1));
	assertEquals(2, recordMap.size());

	tracker.removeRecord(id1);
	assertEquals(1, recordMap.size());
	tracker.listRecords();

	System.out.println("Done testing removeRecord\n\n");
    }
}
