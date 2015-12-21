var ev = {
	engineType:"electric",
	make:"tesla",
	model:"model s",
	year:"2015",
	VIN:"1",
	odometer:"34254",
	services:["tire rotation", "brake service", "wheel alignment"]
};

var gv = {
	engineType:"gas",
	make:"honda",
	model:"civic",
	year:"2007",
	VIN:"2",
	odometer:"100000",
	services:["oil change", "tire rotation", "brake service", "wheel alignment"]
};

var dv = {
	engineType:"diesel",
	make:"ford",
	model:"f350",
	year:"2012",
	VIN:"3",
	odometer:"80000",
	services:["oil change", "tire rotation", "brake service", "wheel alignment"]
}

var records = [];
var vehicles = [ev, gv, dv];
var IDList = [];

function addRecord(type, VIN){
	var date = Date();

	var index = vehicleExists(VIN);
	if(index >= 0){
		document.getElementById("VINError").innerHTML = "";
		document.getElementById("typeError").innerHTML = "";
		if(vehicles[index].services.indexOf(type) >= 0){

			var ID = Math.floor((Math.random() * 1000000) + 1);
			while(IDList.indexOf(ID) >= 0)
				ID = Math.floor((Math.random() * 1000000) + 1);

			var record = {
				maintType:type,
				vehicle:vehicles[index],
				date:date,
				ID:ID
			};

			records.push(record);
			IDList.push(ID);
			listRecords();
		}
		else
			document.getElementById("typeError").innerHTML = "Vehicle doesn't require that kind of service";
	}
	else{
		document.getElementById("typeError").innerHTML = "";
		document.getElementById("VINError").innerHTML = "Invalid VIN";
	}
}
	
function listRecords(){
	if(records.length == 0)
		document.getElementById("recordsTable").innerHTML = "No records exist";
	else{
		var table = "<table border='1' style='width:100%'><tr>";
		table += "<th>Maintenance ID</th>";
		table += "<th>VIN</th><th>Make</th><th>Model</th><th>Year</th><th>Odometer (km)</th>";
		table += "<th>Maintenance Description</th><th>Date of Service</th></tr>";
		for(var i = 0; i < records.length; i++){
			var veh = records[i].vehicle;
			table += "<tr><td>" + records[i].ID + "</td>";
			table += "<td>" + veh.VIN + "</td>";
			table += "<td>" + veh.make + "</td>";
			table += "<td>" + veh.model + "</td>";
			table += "<td>" + veh.year + "</td>";
			table += "<td>" + veh.odometer + "</td>";
			table += "<td>" + records[i].maintType + "</td>";
			table += "<td>" + records[i].date + "</td></tr>";
		}
		table += "</table>";
		document.getElementById("recordsTable").innerHTML = table;
	}
}

function removeRecord(ID){
	var i = recordExists(ID);
	if(i >= 0){
		records.splice(i, 1);
		document.getElementById("removeError").innerHTML = "";
		listRecords();
	}
	else{
		document.getElementById("removeError").innerHTML = "No record with that ID exists";
	}
}

function updateRecord(ID, type){
	var i = recordExists(ID);
	if(i >= 0){
		var vehicle = records[i].vehicle;
		if(vehicle.services.indexOf(type) >= 0){
			document.getElementById("updateError").innerHTML = "";
			records[i].maintType = type;
			listRecords();
		}
		else
			document.getElementById("updateError").innerHTML = "Vehicle doesn't require that kind of maintenance";
	}
	else{
		document.getElementById("updateError").innerHTML = "No record with that ID exists";
	}
}

function recordExists(ID){
	for(var i = 0; i < records.length; i++){
		if(records[i].ID == ID)
			return i;
	}

	return -1;
}

function vehicleExists(VIN){
	for(var i = 0; i < vehicles.length; i++){
		if(vehicles[i]["VIN"] == VIN)
			return i;
	}	

	return -1;
}