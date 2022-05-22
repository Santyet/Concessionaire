package model;

import java.util.ArrayList;
import java.util.Calendar;

public class AutomotiveMultinational{

	private ArrayList<Vehicle> vehicles;
	private String[][] parking;

	public AutomotiveMultinational(ArrayList<Vehicle> vehicles){

		this.vehicles = vehicles;
		parking = new String[10][5];

		for (int i=0; i< parking.length; i++ ) { 
			for (int j = 0; j < parking[0].length; j++) { 
				
				parking[i][j] = "\t\t/";
			}
			
		}
		
	}
	
	//ADD MOTORCYCLE
	
	public String addVehicle(double basePrice, String brand, int model, int cylinderCapacity,
	 double mileage, boolean used, String vehicleRegistration, double fuelCapacity, MotorcycleType motorcycleType,
	 double soatPrice, int soatYear, double coverageCost, double tmrPrice, int tmrYear, double tmrGasLevels, double pcPrice, int pcYear, GasType gasType){
		 
		int[][] code = genCode();

		SOAT soat;
		//SOAT CREATION PART
		if(used){
			soat = new SOAT(soatPrice, soatYear, code, coverageCost);
		}else{
			soat = new SOAT(0, Calendar.getInstance().get(Calendar.YEAR), null, 0);
		}

		//TECHNICAL MECHANICAL REVIEW PART
		TechnicalMechanicalReview technicalMechanicalReview;
		code = genCode();
		if(used){
			technicalMechanicalReview = new TechnicalMechanicalReview(tmrPrice, tmrYear, code, tmrGasLevels);
		}else{
			technicalMechanicalReview = new TechnicalMechanicalReview(0, Calendar.getInstance().get(Calendar.YEAR), null, 0);
		}

		//PROPERTY CARD PART (IF VEHICLE IS USED)
		Document propertyCard;
		if(used){
			code = genCode();
			propertyCard = new Document(pcPrice, pcYear, code);
		}else{
			propertyCard = new Document(0, Calendar.getInstance().get(Calendar.YEAR), null);
			
		}

		Motorcycle moto = (new Motorcycle(basePrice, 0, brand, 0, model, cylinderCapacity, mileage, used, vehicleRegistration,
		 soat, technicalMechanicalReview, propertyCard, fuelCapacity, motorcycleType, gasType));


		double sellPrice = ((Motorcycle)(moto)).calculateSellingPrice(soatYear, tmrYear, used);
		double fuelUsage = ((Motorcycle)(moto)).calculateGasUsage();

		moto.setSellPrice(sellPrice);
		moto.setFuelUsage(fuelUsage);

		vehicles.add(moto);
		System.out.println(addIfOld(moto));
		
		int a = vehicles.size() - 1;
		return "\nMotorcycle was added with id " + a + "\n";
	}

	//ADD GAS CAR
	public String addVehicle(double basePrice, String brand, int model, int cylinderCapacity,
	 double mileage, boolean used, String vehicleRegistration, double fuelCapacity, GasType gasType, 
	 double soatPrice, int soatYear, double coverageCost, double tmrPrice, int tmrYear, double tmrGasLevels, double pcPrice, int pcYear,
	 int doorNum, boolean polarized, CarType carType){

		int[][] code = genCode();

		SOAT soat;
		//SOAT CREATION PART
		if(used){
			soat = new SOAT(soatPrice, soatYear, code, coverageCost);
		}else{
			soat = new SOAT(0, Calendar.getInstance().get(Calendar.YEAR), null, 0);
		}

		//TECHNICAL MECHANICAL REVIEW PART
		TechnicalMechanicalReview technicalMechanicalReview;
		if(used){
			code = genCode();
			technicalMechanicalReview = new TechnicalMechanicalReview(tmrPrice, tmrYear, code, tmrGasLevels);
		}else{
			technicalMechanicalReview = new TechnicalMechanicalReview(0, Calendar.getInstance().get(Calendar.YEAR), null, 0);
		}

		//PROPERTY CARD PART (IF VEHICLE IS USED)
		Document propertyCard;
		if(used){
			code = genCode();
			propertyCard = new Document(pcPrice, pcYear, code);
		}else{
			propertyCard = new Document(0, Calendar.getInstance().get(Calendar.YEAR), null);
			
		}

		GasCar gascar = (new GasCar(basePrice, 0, brand, 0, model, cylinderCapacity, mileage, used, vehicleRegistration, soat, technicalMechanicalReview, propertyCard, doorNum, polarized, carType, fuelCapacity, gasType));


		double sellPrice = ((GasCar)(gascar)).calculateSellingPrice(soatYear, tmrYear, used);
		double fuelUsage = ((GasCar)(gascar)).calculateGasUsage();
		
		gascar.setSellPrice(sellPrice);
		gascar.setFuelUsage(fuelUsage);

		vehicles.add(gascar);
		System.out.println(addIfOld(gascar));
		
		int a = vehicles.size() - 1;
		return "\nGasoline car was added with id " + a + "\n";
	}

	//ADD HYBRID CAR
	public String addVehicle(double basePrice, String brand, int model, int cylinderCapacity,
	 double mileage, boolean used, String vehicleRegistration, double fuelCapacity, double batteryDuration,
	 ChargerType chargerType, GasType gasType, double soatPrice, int soatYear, double coverageCost, double tmrPrice,
	 int tmrYear, double tmrGasLevels, double pcPrice, int pcYear, int doorNum, boolean polarized, CarType carType){

		int[][] code = genCode();

		SOAT soat;
		//SOAT CREATION PART
		if(used){
			soat = new SOAT(soatPrice, soatYear, code, coverageCost);
		}else{
			soat = new SOAT(0, Calendar.getInstance().get(Calendar.YEAR), null, 0);
		}

		//TECHNICAL MECHANICAL REVIEW PART
		TechnicalMechanicalReview technicalMechanicalReview;
		if(used){
			code = genCode();
			technicalMechanicalReview = new TechnicalMechanicalReview(tmrPrice, tmrYear, code, tmrGasLevels);
		}else{
			technicalMechanicalReview = new TechnicalMechanicalReview(0, Calendar.getInstance().get(Calendar.YEAR), null, 0);
		}

		//PROPERTY CARD PART (IF VEHICLE IS USED)
		Document propertyCard;
		if(used){
			code = genCode();
			propertyCard = new Document(pcPrice, pcYear, code);
		}else{
			propertyCard = new Document(0, Calendar.getInstance().get(Calendar.YEAR), null);
			
		}

		HybridCar hyCar = (new HybridCar(basePrice, 0, brand, model, 0, 0,
		 cylinderCapacity, mileage, used, vehicleRegistration, soat, technicalMechanicalReview, propertyCard,
		  doorNum, polarized, carType, fuelCapacity, batteryDuration, gasType, chargerType));


		double sellPrice = ((HybridCar)(hyCar)).calculateSellingPrice(soatYear, tmrYear, used);
		double fuelUsage = ((HybridCar)(hyCar)).calculateGasUsage();
		double batteryUsage = ((HybridCar)(hyCar)).calculateBatteryUsage(chargerType);
		
		hyCar.setSellPrice(sellPrice);
		hyCar.setFuelUsage(fuelUsage);
		hyCar.setBatteryUsage(batteryUsage);

		vehicles.add(hyCar);
		System.out.println(addIfOld(hyCar));

		int a = vehicles.size() - 1;
		return "\nHybrid car was added with id " + a + "\n";
	}

	//ADD ELECTRIC CAR
	public String addVehicle(double basePrice, String brand, int model, int cylinderCapacity, double mileage,
	 boolean used, String vehicleRegistration, double batteryDuration, ChargerType chargerType,
	 double soatPrice, int soatYear, double coverageCost, double tmrPrice, int tmrYear, double tmrGasLevels, double pcPrice,
	 int pcYear, int doorNum, boolean polarized, CarType carType){

		int[][] code = genCode();

		SOAT soat;
		//SOAT CREATION PART
		if(used){
			soat = new SOAT(soatPrice, soatYear, code, coverageCost);
		}else{
			soat = new SOAT(0, Calendar.getInstance().get(Calendar.YEAR), null, 0);
		}

		//TECHNICAL MECHANICAL REVIEW PART
		TechnicalMechanicalReview technicalMechanicalReview;
		if(used){
			code = genCode();
			technicalMechanicalReview = new TechnicalMechanicalReview(tmrPrice, tmrYear, code, tmrGasLevels);
		}else{
			technicalMechanicalReview = new TechnicalMechanicalReview(0, Calendar.getInstance().get(Calendar.YEAR), null, 0);
		}

		//PROPERTY CARD PART (IF VEHICLE IS USED)
		Document propertyCard;
		if(used){
			code = genCode();
			propertyCard = new Document(pcPrice, pcYear, code);
		}else{
			propertyCard = new Document(0, Calendar.getInstance().get(Calendar.YEAR), null);
			
		}

		ElectricCar eCar = (new ElectricCar(basePrice, 0, brand, model,
		 cylinderCapacity, mileage, used, vehicleRegistration, soat, technicalMechanicalReview,
		  propertyCard, doorNum, polarized, carType, batteryDuration, 0, chargerType));


		double sellPrice = ((ElectricCar)(eCar)).calculateSellingPrice(soatYear, tmrYear, used);
		
		double batteryUsage = ((ElectricCar)(eCar)).calculateBatteryUsage(chargerType);
		
		eCar.setSellPrice(sellPrice);
		eCar.setBatteryUsage(batteryUsage);

		vehicles.add(eCar);
		System.out.println(addIfOld(eCar));

		int a = vehicles.size()-1;
		return "\nElectric car added with id " + a + "\n";
	}

	public int[][] genCode(){

		int[][] code = new int[5][5];

    	for (int i=0; i<5 ; i ++) {
        	for (int j=0; j<5 ; j++) {
           		int random = (int)(Math.random()*(99));
            	code[i][j]=random;
         	}
		}

		return code;
	}

	public String calculateSellingPrice(int id, int percent){

		double price = vehicles.get(id).getSellPrice();
		
		String temp = String.format("%,.2f",price);

		return "\nThe selling price of this vehicle is: " + temp + ".\n";
	}

	public String searchVehicleType(int type){

		String out = "\nVEHICLES INFO:\n\n";

		for(int i = 0; i<vehicles.size(); i++){

			switch(type){

				case 1:

				if(vehicles.get(i) instanceof Motorcycle){

					out += "Vehicle with id: " + i + "\n";
					out += ((Motorcycle)(vehicles.get(i))).toString();
					}

				break;

				case 2:

				if(vehicles.get(i) instanceof HybridCar){

					out += "Vehicle with id: " + i + "\n";
					out += ((HybridCar)(vehicles.get(i))).toString();

				}

				break;

				case 3:

				if(vehicles.get(i) instanceof GasCar){

					out += "Vehicle with id: " + i + "\n";
					out += ((GasCar)(vehicles.get(i))).toString();

				}

				break;

				case 4:

				if(vehicles.get(i) instanceof ElectricCar){

					out += "Vehicle with id: " + i + "\n";
					out += ((ElectricCar)(vehicles.get(i))).toString();
					

				}

				break;
			}

		}

		return out;

	}

	public String searchFuelType(int type){

		String out = "\nVEHICLES INFO:\n\n";

		for(int i = 0; i<vehicles.size(); i++){

			if(vehicles.get(i) instanceof Motorcycle | vehicles.get(i) instanceof GasCar | vehicles.get(i) instanceof HybridCar){
				
				switch(type){

					case 1:

					if(vehicles.get(i) instanceof Motorcycle){

						if(((Motorcycle)(vehicles.get(i))).getGasType()==GasType.REGULAR){

							out += "\nVehicle with id: " + i + "\n";
							out += ((Motorcycle)(vehicles.get(i))).toString();
						}
					}

					if(vehicles.get(i) instanceof GasCar){

						if(((GasCar)(vehicles.get(i))).getGasType()==GasType.REGULAR){

							out += "\nVehicle with id: " + i + "\n";
							out += ((GasCar)(vehicles.get(i))).toString();
						}
					}

					if(vehicles.get(i) instanceof HybridCar){

						if(((HybridCar)(vehicles.get(i))).getGasType()==GasType.REGULAR){

							out += "\nVehicle with id: " + i + "\n";
							out += ((HybridCar)(vehicles.get(i))).toString();
						}
					}

					break;

					case 2:

						if(vehicles.get(i) instanceof Motorcycle){

						if(((Motorcycle)(vehicles.get(i))).getGasType()==GasType.EXTRA){

							out += "\nVehicle with id: " + i + "\n";
							out += ((Motorcycle)(vehicles.get(i))).toString();
						}
					}

					if(vehicles.get(i) instanceof GasCar){

						if(((GasCar)(vehicles.get(i))).getGasType()==GasType.EXTRA){

							out += "\nVehicle with id: " + i + "\n";
							out += ((GasCar)(vehicles.get(i))).toString();
						}
					}

					if(vehicles.get(i) instanceof HybridCar){

						if(((HybridCar)(vehicles.get(i))).getGasType()==GasType.EXTRA){

							out += "\nVehicle with id: " + i + "\n";
							out += ((HybridCar)(vehicles.get(i))).toString();
						}
					}

					break;

					case 3:

					if(vehicles.get(i) instanceof Motorcycle){

						if(((Motorcycle)(vehicles.get(i))).getGasType()==GasType.DIESEL){

							out += "\nVehicle with id: " + i + "\n";
							out += ((Motorcycle)(vehicles.get(i))).toString();
						}
					}

					if(vehicles.get(i) instanceof GasCar){

						if(((GasCar)(vehicles.get(i))).getGasType()==GasType.DIESEL){

							out += "\nVehicle with id: " + i + "\n";
							out += ((GasCar)(vehicles.get(i))).toString();
						}
					}

					if(vehicles.get(i) instanceof HybridCar){

						if(((HybridCar)(vehicles.get(i))).getGasType()==GasType.DIESEL){

							out += "\nVehicle with id: " + i + "\n";
							out += ((HybridCar)(vehicles.get(i))).toString();
						}
					}

					break;

				}
			}

		}

		return out;

	}

	public String searchNew(int used){

		String out = "\nVEHICLES INFO:\n\n";

		for(int i = 0; i<vehicles.size(); i++){

			if(used == 2){
				if(vehicles.get(i).isUsed()==true){

					out += getVehicleInfo(i);
				}
			}else{

				if(vehicles.get(i).isUsed()==false){

					out += getVehicleInfo(i);
				}

			}

		}

		return out;
	}

	public String searchFromId(String id){

		String out = "\nVehicle doesn't exists.\n";

		if(vehicles.get(Integer.parseInt(id))!=null){
			
			out = vehicles.get(Integer.parseInt(id)).getTechnicalMechanicalReview().toStringa();

			if(vehicles.get(Integer.parseInt(id)).getSoat().getCode()!=null){

				out += "\n" + vehicles.get(Integer.parseInt(id)).getSoat().toString();

			}else{
				out += "\nThis vehicle doesn't have SOAT\n";
			}

			if(vehicles.get(Integer.parseInt(id)).getPropertyCard().getCode()!=null){
			
			out += "\n" + vehicles.get(Integer.parseInt(id)).getPropertyCard().toString();
			}else{
				out += "\nThis vehicle doesn't have property card";
			}
		}
	
		return out;
	}

	public String addIfOld(Vehicle vehicle){

		String out = "";

		boolean hasSpace = false, done = false;

		for (int i=0; i< parking.length; i++ ) { 
			for (int j = 0; j < parking[0].length; j++) { 
				if(parking[i][j].equals("\t\t/") & !done){

					done = true;
					hasSpace = true;

				}
			}
		}

		if(hasSpace){

			if(vehicle.getModel()==2014){

				if(!add2014(vehicle)){
					out = "\nThis parking column is full";
				}else{
					out = "\nVehicle added to the parking lot";
				}
			}
	
			if(vehicle.getModel()==2013){
	
				if(!add2013(vehicle)){
					out = "\nThis parking column is full";
				}else{
					out = "\nVehicle added to the parking lot";
				}
			}
	
			if(vehicle.getModel()==2012){
	
				if(!add2012(vehicle)){
					out = "\nThis parking column is full";
				}else{
					out = "\nVehicle added to the parking lot";
				}
			}
	
			if(vehicle.getModel()==2011){
	
				if(!add2011(vehicle)){
					out = "\nThis parking column is full";
				}else{
					out = "\nVehicle added to the parking lot";
				}
			}

			if(vehicle.getModel()<2011){

				if(!addLessThan2011(vehicle)){
					out = "\nThis parking column is full";
				}else{
					out = "\nVehicle added to the parking lot";
				}
			}
	
			

		}else{
			out = "\nParking lot is full";
		}
		
		if(vehicle.getModel()>2014){
			out = "";
		}
		
		return out;
	}

	public boolean addLessThan2011(Vehicle vehicle){

		boolean done = false, hasSpace = true;
		String mark = determineVehicleType(vehicle);

		for(int i = 0;i<parking.length;i++){

			if(parking[i][4].equals("\t\t/") & !done){

				parking[i][4] = "\t\t" + (vehicles.size()-1) + mark;
				done = true;
			}
		}

		if(!done){
			hasSpace=false;
		}

		return hasSpace;
	}

	public boolean add2011(Vehicle vehicle){

		boolean done = false, hasSpace = true;
		String mark = determineVehicleType(vehicle);

		for(int i = 0;i<parking.length;i++){
			
			if(parking[i][3].equals("\t\t/") & !done){

				parking[i][3] = "\t\t" + (vehicles.size()-1) + mark;
				done = true;
			}
		}

		if(!done){
			hasSpace=false;
		}

		return hasSpace;
	}

	public boolean add2012(Vehicle vehicle){

		boolean done = false, hasSpace = true;
		String mark = determineVehicleType(vehicle);

		for(int i = 0;i<parking.length;i++){

			if(parking[i][2].equals("\t\t/") & !done){

				parking[i][2] = "\t\t" + (vehicles.size()-1) + mark;
				done = true;
			}
		}
		
		if(!done){
			hasSpace=false;
		}

		return hasSpace;
	}

	public boolean add2013(Vehicle vehicle){

		boolean done = false, hasSpace = true;
		String mark = determineVehicleType(vehicle);

		for(int i = 0;i<parking.length;i++){

			if(parking[i][1].equals("\t\t/") & !done){

				parking[i][1] = "\t\t" + (vehicles.size()-1) + mark;
				done = true;
			}

		}	
		
		if(!done){
			hasSpace=false;
		}

		return hasSpace;
	}

	public boolean add2014(Vehicle vehicle){

		boolean done = false, hasSpace = true;
		String mark = determineVehicleType(vehicle);

		for(int i = 0;i<parking.length;i++){

			if(parking[i][0].equals("\t\t/") & !done){

				parking[i][0] = "\t\t" + (vehicles.size()-1) + mark;
				done = true;
			}

		}

		if(!done){
			hasSpace=false;
		}

		return hasSpace;
	}

	public String showParkingLot(){

		String out = "\n\t\t2014\t\t2013\t\t2012\t\t2011\t\t<2011\n";

		for (int i=0; i< parking.length; i++ ) {
			for (int j = 0; j < parking[0].length; j++) {
				out += parking[i][j] + "";
			}
			out += "\n";
		}

		out += "\n\t\t\t\t#Format is vehicle id + vehicle type#\n\nM = Motorcycle\t\tG = Gasoline Car\tE = Electric Car\tH = Hybrid Car\t\t/ = Empty Space";

		return out;
	}

	public String determineVehicleType(Vehicle vehicle){

		String out = "";

		if(vehicle instanceof Motorcycle){

			out = "M";
		}

		if(vehicle instanceof GasCar){

			out = "G";
		}

		if(vehicle instanceof ElectricCar){

			out = "E";
		}

		if(vehicle instanceof HybridCar){

			out = "H";
		}

		return out;
	}

	public String getInfoFromYears(int year1, int year2){

		String out = "";
		int id;
		boolean done = false;
		boolean next = false;

		if(year1<2011){
			for(int i = 0;i<parking.length;i++){

				if(!parking[i][4].equals("\t\t/")){

					if(parking[i][4].length()>4){
						
						char temp = parking[i][4].charAt(2);
						String temp2 = String.valueOf(temp);
						temp = parking[i][4].charAt(3);
						temp2 +=temp;
						id = Integer.parseInt(temp2);
						out += getVehicleInfo(id);
						
					}else{
						id = parking[i][4].charAt(2);
						id -=48;
						out += getVehicleInfo(id);
					}
				}			
			}
			if(year2==year1){
				done=true;
			}
			if(year1<year2){
				next=true;
			}
		}
		if((year1==2011 && !done) | next){
			next=false;
			for(int i = 0;i<parking.length;i++){

				if(!parking[i][3].equals("\t\t/")){

					if(parking[i][3].length()>4){
						
						char temp = parking[i][3].charAt(2);
						String temp2 = String.valueOf(temp);
						temp = parking[i][3].charAt(3);
						temp2 +=temp;
						id = Integer.parseInt(temp2);
						out += getVehicleInfo(id);
						
					}else{
						id = parking[i][3].charAt(2);
						id -=48;
						out += getVehicleInfo(id);
						
					}		
				}	
			}		
			if(year2==year1){
				done=true;
			}
			if(year2>2011){
				next=true;
			}
		}
		if((year1==2012 && !done) | next){
			next=false;
			for(int i = 0;i<parking.length;i++){

				if(!parking[i][2].equals("\t\t/")){

				if(parking[i][2].length()>4){
					
					char temp = parking[i][2].charAt(2);
					String temp2 = String.valueOf(temp);
					temp = parking[i][2].charAt(3);
					temp2 +=temp;
					id = Integer.parseInt(temp2);
					out += getVehicleInfo(id);
					
				}else{
					id = parking[i][2].charAt(2);
					id -=48;
					out += getVehicleInfo(id);
					}		
				}
			}
			if(year2==year1){
				done=true;
			}
			if(year2>2012){
				next=true;
			}
		}
		if((year1==2013 && !done) | next){
			next=false;
			for(int i = 0;i<parking.length;i++){

				if(!parking[i][1].equals("\t\t/")){

				if(parking[i][1].length()>4){
					
					char temp = parking[i][1].charAt(2);
					String temp2 = String.valueOf(temp);
					temp = parking[i][1].charAt(3);
					temp2 +=temp;
					id = Integer.parseInt(temp2);
					out += getVehicleInfo(id);
					
				}else{
					id = parking[i][1].charAt(2);
					id -=48;
					out += getVehicleInfo(id);
					}			
				}
			}
			if(year2==year1){
				done=true;
			}
			if(year2>2013){
				next=true;
			}
		}	
		if((year1==2014 && !done) | next){
			for(int i = 0;i<parking.length;i++){

				if(!parking[i][0].equals("\t\t/")){

					if(parking[i][0].length()>4){
						
						char temp = parking[i][0].charAt(2);
						String temp2 = String.valueOf(temp);
						temp = parking[i][0].charAt(3);
						temp2 +=temp;
						id = Integer.parseInt(temp2);
						out += getVehicleInfo(id);
						
					}else{
						id = parking[i][0].charAt(2);
						id -=48;
						out += getVehicleInfo(id);
					}			
				}
			}
		}	

		return out;
	}

	public String getVehicleInfo(int id){

		String out = "";
		if(vehicles.get(id) instanceof Motorcycle){

			out += "\nVehicle with id: " + id + "\n";
			out += ((Motorcycle)(vehicles.get(id))).toString();
		
		}

		if(vehicles.get(id) instanceof GasCar){

				out += "\nVehicle with id: " + id + "\n";
				out += ((GasCar)(vehicles.get(id))).toString();
			
		}

		if(vehicles.get(id) instanceof HybridCar){

				out += "\nVehicle with id: " + id + "\n";
				out += ((HybridCar)(vehicles.get(id))).toString();
			
		}

		if(vehicles.get(id) instanceof ElectricCar){

			out += "\nVehicle with id: " + id + "\n";
			out += ((ElectricCar)(vehicles.get(id))).toString();
		
		}

		return out;
	}

	public String getOlderAndNewerVehicle(){

	String out = "";
	String out2 = "";
	int idNewer = -1, idOlder = -1;
	boolean done = false;

	for(int i = 0; i<parking[0].length;i++){
		for(int j = 0; j<parking.length; j++){

			if(!parking[j][i].equals("\t\t/")){

				if(parking[j][i].length()>4){
				
					char temp = parking[j][i].charAt(2);
					String temp2 = String.valueOf(temp);
					temp = parking[j][i].charAt(3);
					temp2 +=temp;
					idOlder = Integer.parseInt(temp2);
					out = getVehicleInfo(idOlder);
					
				}else{
					idOlder = parking[j][i].charAt(2);
					idOlder -=48;
					out = getVehicleInfo(idOlder);
				}

			}
		}
	}

	for(int i = 0; i<parking[0].length; i++){
		for(int j = 0; j<parking.length; j++){

			if(!parking[j][i].equals("\t\t/") && !done){

				if(parking[j][i].length()>4){
				
					char temp = parking[j][i].charAt(2);
					String temp2 = String.valueOf(temp);
					temp = parking[j][i].charAt(3);
					temp2 +=temp;
					idNewer = Integer.parseInt(temp2);
					out2 = getVehicleInfo(idNewer);
					done = true;
					
				}else{
					idNewer = parking[j][i].charAt(2);
					idNewer -=48;
					out2 = getVehicleInfo(idNewer);
					done = true;
				}

			}
		}
	}

	System.out.println(out2);
	return "\nOLDEST VEHICLE\n" + out +"\nNEWEST VEHICLE:\n" + out2;
	}

	public double getOccupationPercentage(){

		int count = 0;
        
		for(int i = 0; i<parking.length;i++){

			for(int j = 0; j<parking[0].length;j++){

				if(!parking[i][j].equals("\t\t/")){

					count++;
				}
			}
		}
        return (count*2);
    }

	public boolean checkFor12(int opt){

        boolean ok = false;
        do{
        if(opt!=2 & opt!=1){
            System.out.println("Enter a valid option.");
            break;
            }else{
                ok = true;
            }
        }while(opt!=2 & opt!=1);

        return ok;
    }

	public boolean checkFor123(int opt){

        boolean ok = false;
        do{
        if(opt!=2 & opt!=1 & opt!=3){
            System.out.println("Enter a valid option.");
            break;
            }else{
                ok = true;
            }
        }while(opt!=2 & opt!=1 & opt!=3);

        return ok;
    }

	public boolean checkFor1234(int opt){

        boolean ok = false;
        do{
        if(opt!=2 & opt!=1 & opt!=3 & opt!=4){
            System.out.println("Enter a valid option.");
            break;
            }else{
                ok = true;
            }
        }while(opt!=2 & opt!=1 & opt!=3 & opt!=4);

        return ok;
    }
	
    /**
     * @return ArrayList<Vehicle> return the vehicles
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * @return String[][] return the parking
     */
    public String[][] getParking() {
        return parking;
    }

    /**
     * @param parking the parking to set.
     */
    public void setParking(String[][] parking) {
        this.parking = parking;
    }

}

	//#################################%%###########%%%%%###%%%####((((((################((((((((((((((((((((((((((((((((/////////////////////////((#%%%%%%%%%%%%%%%%%%%###################((((((((((((((((((#
	//#################################%%###########%%%%%%%######((((((##################(((((((((((((((((((((((((((((((/////////////////////////////(#%%%%%%%%#################(###(((((((((((###############
	//#################################%%##########%%%%%#########((######################(((((((((((((((((((((((((((((((///////////////////////**///////(##%%#################################(##((((((((####%
	//#################################%%#####%###%%%%#####################################(((((((((((((((((((((((((//////////*///////***********///*/////((########(((((((###(######((((((####%%%%%&&&&&&&&%%
	//#################################%%####%%%%###################%%#####################(((((((((((//////////(//////////////////*/*********************///(#####((((((/(((###%%%%&&&&@@@@&&&%#((#((((//////
	//#################################%%%%%%%%%%%#########################################((((((((//////////////////////////////***************************///#%%&%%####%%&@@@@@&&&%###(((//////***//##%%%&&@
	//#####################################%%%%%#############################################(((((((///////////////////////////////***************************//#&@@&&&%%##((((///////(((#%%&&&&&%%&&@@@@@@&&&
	//###############################%%%%%#%%%###############################################((((((((///////////////////////***********************************/**/((((((((##%%&&&&@@@@@@@@@@@@&&&&&%%%%#####%
	//#############################%%%%%%%%%%%################################################(((((((//////////////////******************************************/*/%@@@@@@@@@@@@@&&%%&&&@@@@&&&&&&&&&&&&&&&&&
	//#############################%%########################################################((((((//////////////////***********************************************/#%%######%%&&@@@@@@@@@@@@@&&&&&&&&&&&&&&&
	//########################################################################################(((((/////////////////**************************************************(&@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&
	//########################################################################################((((////////////////*****************************************************(&@@@@@@@@@@@@@&@@@@@&&&&&&&&&&&&&&&&&&
	//#######################(((((((((((((((##################################################(((((((/////////////*****************************************************/(&@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&@
	//#######((((((((((((((((((((((((((((((##################################################(((((((((((///////////************************************************,****/#&@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&&@
	//((((((((((((((((((((((((((((((((((((####################################(#########%####((((((((((((((((///////*****************************************************(&@@@@@@@@@@@@@&&&&&&&&&&&&&&@@@@&&&@
	//(((((((((((((((((((((##########(((#####################################(###############((((((((((///////((/////*****************************************************(&@@@@@@@@@&&&&&&&&&&&&&&&&&@@@&&&&@
	/////((((((((####((((/////******//((#########%%%%%%%%%%###################################((////////**/////((//////**********************************************,****/%@@@@@@@@&&&&&&&&&&&&&&&&&&@@@@&&&@
	//(//////#(*******//(##%%%&&&@@@&%#########%%%%%%%%%%%##%##############################((//////////////////////////**///***********************************************#@@@@@&&&&&&&&&&&&&&&&&&&&&@@@@@&&@
	///////(#%&%%%%&&&&@@@@@@@@@@@@@%######%%%%%%%%%%%%%%%%#############################(((///(((///*******************//////**********************************************/%@@@@&&&&&&&&&&&&&@&&&&&&@@@@@@&&@
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%#####%%%%%%%%%%%%%%%%%###########################((((((((///****************,,,,*,*****************************************************(&@&&&&&&&&&&&&&&@@&&&&&&@@@@@@&&@
	//&@&@@@@@@@@@@@@@@@@@@@@&@@@@&%####%%%%%%%%%%%%%%%%%%%%%%%#####################(((((((((/////////////////***,,,,,,,,,,,************************************************/%@&&&&&&&&&&&&@@@&&&&&&&@@@@@@@&@
	//&&&&&&&@@@@@@@@@@@@@@@@@@@@@%#####%%%%%%%%%%%%%%%%%%%%%%%%########################((((((((((((/////////////***,,,,,,,,,,,****************************************,,****#&@&&&&&&&&&&@@@@&&&&&&&@@@@@@@&@
	//&@&@@@@@@@@@@@@&%%###%&@@@@&(/(##%%%%%%%%%%%%%%%%%%%%%%%%%%%##############%%#######(((((((((///////////*///////***,,,,,,,,,,,,***********************************,,,***#&&&&&&&&&&&&@@@@@&&&&&&@@@@@@@@@
	//&@@@@@@@@@@@@&##(####(/(#&&#/*/(##%%%%%%%%%%%%%%%%%%%%%%%%%############%%%%%%%%##((((((((/////***********/////////***,,,,,,,,,,,**********,******************,,,****,,*#&&&&&&&&&&&@@@@@&&&&&&&@@@@@@@@@
	//&@@@@@@@@@@@%((((#####((/((/*//##%%%%%%%%%%%%%%%%%%%%%%%%%%############%%%%%%%##((//////**************,,****//////////**,,..,,,,,,,,,,,,,,,,,*************,,,,,,,,,,***#&@&&&&&&&&&&@@@@&&&&&&&@@@@@@@@@
	//&&@@@@@&@@@&#/*/#%#####(((////(###%%%%%%%%%%%%%%%%%%%%%%%%%#######%%%%%%%%%####(///*******************,,,,,...,,*****////**,,,,,,,,,,,,,,,,,***,,,,***,,,,,,,,,,,,,,,,/%&&&&&&&&&&&&@@@&&&&&&&&@@@@@@@@@
	//&@@@@@@&@@@%(***/#%%%%%##(((((##%%%%%%%%%%%%%%%%%%%%%%%%%%######%%%%###%%%##(((/****,,,,**///(((((((///***,...........,,*/***,,,,,,,,,,,,,,***,,,,,,,,,,,,,,,,,,,,,,,*(&&&&&&&&&&&@@&&&&&&&&&&&&@@@@@@@@
	//&@@@&@@@@@&#/****(%%%&%%%%%#######%%%%%%%%%%%%%%%%%%%%%%%##%####%%%#######((///*******/((######((((///****,,,,............,*/**,,,,,,,,,,*///*,,,,,,,,,,,,,,,,,,,,,,,*(&&&&&&&&&&&@@&&&&&&&&&&&&@@@@@@@@
	//&@@@&&@@@@&#/**,/#%%###(##%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%##%%%%%%%%####(((////***,**/((((//**,,,,....,,***,*,,......... ...,***,*,,,,,,*/((/*,,,,,,,,,,,,,,,,,,,,,,,,*(&&&&&&&&&&&@@&&&&&&&&&&&&&@@@@@@@
	//&&@@&&&&&@&#/**/#%%%###((%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%####((((////*******///*(%%#*...... ...,,..,........  ......,*/********/(((/*,,....,,,,,,,***,,,,,,,,,/%&&&&&&&&&&&&&&&&&&&&&&&&&@@@@@@@
	//&&@@&&&@@@&#/**(%%%%%%##(#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######((((////********/((//(%&#(#*.. ..   .,,..................,*////**//((((/*,..........,,,,,,,,,,,,,,,/%&&&&&&&&&&@@&&&&&&&&&&&&&@@@@@@@
	//&&@@&&&@&@&#//####(((((/**(#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######((((//////////*///(##((/(#/,....  . ..,,*,,...............,*/(((((((#((/**,..          .......,,...,/%&&&&&&&&&&@@@&&&&&&&&&&&&@@@@@@@
	//&@&&@@@@&@&%#(((//******,,/###%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######((((/////////////((#%%%(///**,,..,,,,,,,,,................,*((#####(((/**,..                ......,.*%@&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%%
	//&@@&@@@@@@@&%#//*,,,,,,,,*#%%#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######(((((/////////(((((((((////****,,,,,,,,,,,..............,,*/(######((/***,.                    .....,/((##((((((((((((((((((((((((((((
	//&@@&@@@@@@@&%(/**,,,,,,,*#%%##%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######((((((///////////((((//////*****,,,,,,,,,,,.........,,,,,*/(((######((//**,.                   .....,,*/*******,,**,,,,,...............
	//&@@&@@@@@@@&%(//***,,,,/(%%###%%%%%%%%%%%%%%%%%%%%%%%%%%%######(((((((((/////////(((((/////******,,,,,,,,..,,,,,,,,,,,***//((((######(((//*,.               ..........                                  
	//@@@@@@@@@@@@&%#####(/////#%#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#####((((((((((((((//(((////((/////******,,,,,,,,,,,,,,,,****///((############((//*,.                ......                                    
	//@@@@@@@@@@&&&%%%&%%%#(////%%%%%%%%%%%%%%%%%%%#####%%%%%######(((((((////////////////////////********,,,,,,,,***//////(((((((############((//*,.                   .                                     
	//@@@@@&&&&&&%%###%%%%%#((//#&&%%%%%%%%%%%%%%%%#####%%%%%%%####((((((///////////////////////*********,,,******//((((((((((((((############((//*,.......                                                   
	//((##((((((((((##%%%%&&%%%%%%%%%%%%%%%%%%%%%%######%%%%%%%%%##(((((//////////////***********************///((((((//((((((((((############((//**,................                                         
	//,,,..........*(%%%&&%%%%####%%%%%%%%%%%%%%%%######%%%%%%%%%###(((//////////***********************/////((((((((((/((((((((((#############(//**,,.............,,.                                        
			//.    .,(%%%%%%%##%%%##%%%%%%%%%%%%%%######%%%%%%%%%%%#((//////***************************///////////((((((/(((((((##############(((/**,,,,,......,,,,,,.                                        
				//..../%%%&%%%%%%(/(#%%%%%%%%%%%%%######%%%%%%%%%%%#((////***************************//////////////((((((((((########%%%######(((//***,,,,,,,,,,,,,,,.                                        
		//*(%&&#((/**/#%%%&&%#(//(%%%%%%%%%%%%%%%%######%%%%%%%##(((//////**********************////////***/////((((((((###%%%%%%%%%%%%#####((///***,,,,,,,,,,,,,,,,.                                       
		//*(&@@%#(///*,,*(#####((#%%%%%%%%%%%%%%%%##############((((/////************////***//////////*****////(((((#####%%%%%%%%%%%%%%#####((///***,,,,,,,,,,,,,,,,.                                       
		//*(%@@%%##/***.,###%###%%%%%%%%%%%%%%%%%%%%%%##########((((/////***********//////////////////****/////((((###%%%%%%%%%%%%%%%%%#####((////**,,,,,,,,,,,,,,,,.                                       
		//,**#%/**(%/*/,/###%%###%%%%%%%%%%%%%%%%%%%%%%%%%#####((((/////***********//////////////////******////(((##%%###########%%%%%######((///****,,,,,,,,,......                                        
		//.*,(&(*,/%/*/*(#%%%%#######%%%%%%%%%%%%%%%%%%%%%%####(((((////*******///////////////////////*****/////((#######((((((((##%%%######((////***,,,,,..........                                        
		//.,**&#*,*%(,//(%%%%%#########%%%%%%%%%%%%%%%%%%%%%###(((((/////*****////////((/////(((///////////////((#####%####((#(((##%%%######((/////***,,,,.........                                         
		//.,,*%#***#(,/(#%%%%%########%%%%%%%%%%%%%%%%%%%%%%#####((((////////*///////((((((((((((((///////////((###%%%%#############%####(((((/////*///*,,........                                          
		//,,*#%/**##*/(#%%%%%#########%%%%%%%%%%%%%%%%%%%%%%#####(((((((/////////((((((((((((((((((((((//////(##%%%%%%####((((((######((((///***********,,.....                                            
		//.**(%(*,/%**(#%%%%%#########%%%%%%%%%%%%%%%%%%%%%%%#####(((((((((((((((((((#############(((((((////(#%%%%%#((((///((((((##((((//****,,,,,,,,,,,,....                                             
		//.*,(%(*,/%**(#%%%%%#########%%%%%%%%%%%%%%%%%%%%%%#########(####(((((((((###################(((/////#%%#((/**,..... .,*(##((((/***,,,,,,,,,.......                                               
		//	,*/%#//(#/*(#%%%%%#########%%%%%%%%%%%%%%%%%%%%%%%#############################%%%%%%%#####((((/////(((/*,,......,,**,,*/(((//**,,,.............                                                
		//.(%#&&##(/,*##%%%%###########%%%%%%%%%%%%%%%%%%%%%%#######(###%###########%%%%%%%%%%%%%%######(((///******,,,,,*/((##((((((#(/**,,...    .......                                                 
			//(&(##*..,,/##%%%%###########%%%%%%%%%%%%%%%%%%%%%%#######(#%%%%%%%%#######%%%%%%%%%%%######((((((///***,,,,,,***///(/*,,,***,,........,,,,,...                                                  
			///%(/#*.,,,/###%%%############%%%%%%%%%%%%%%%%%%%%%######((#%%%%%%%%%#####%%%%%%%%%%#######((((((///////****,,*********,,............,,,,,,...                                                   
			//*&#/(*...,/###%%%############%%%%%%%%%%%%%%%%%%%########(#%%%%%%%%%####%%%%%&%%%%%%#####((((((////////******,,,,,,***,,.............,,,**,.                                                     
			//,%#/(/..,,/##%%%%%############%%%%%%%%%%%%%%%%%##########%%%%%%%%%###%%%&&&&%%%%%%#####(((((((//////********,,,,,,**,,..............,,,,,..                                                     
	//..  ..,,,##/##/*//(#%%%%%%%%###########%%%%%%%%%%%%%%%%##########%%%%%%%%%%%%%&&%%&&%%%%%%###((((((((//////*********,,,,,,,,,,...............,,,,.                                                      
	///////((/(#%(#%((//(#%%%%%%%%##########%%%%%%%%%%%&%%%%%#########%%%%%%&%%%%%%%&&%%%%%%%%%%##((((((((//////**********,,,,,**,,.................,,..                                                      
	//////////*/#%##%%###%%%%%%%#############%%%%%%%%%%%%%%%%########%%%&&%&&&&&&&&&&&%%%%%%%%###(((////////////******************,,,...................                                                      
	//*//((#########(((##%%%%%%################%%%%%%%%%%%%%########%%%%&&&&&%&&&&%%%%%%%%%%%##((///*****/////**********,,,,,,,,,,,,,,,,..............                                                        
	//###########(((#####%%%%%##################%%%%%%%%%%%#########%%&&&&&&&&&&&&&%%#####(((///***,,,,,,,,,,,,,,,,,,,,,,,......,,,,........   ......                                                         
	//##########((#######%%%%#######################%%%%%%#########%%%%%%%&&&&&&&&%%#((((//////***,,,,,......,,,,,,...................          . .,*.                                                        
	//#########((#########%%##########################%%###########%%%%%%%%%%&&%%%#((////////**//////*****,,,,,,,,,,,,........ ..........     ....,(/.                                                        
	//%%%%%%#(###########%%%############((((############%%%%%%%####%%%%%%%%%%%%%%#((////*/////////////////*********,,,,,,,,......................,/(/, .                                                      
	//%&&%%##############%%#############(((((#################%###%%%%%%%%%%%%%%%#(////**/////((((((((////*/////********,,,,,,,,,,,.............,/(((*.                                                       
	//&%%##############%%%%############(((((((((((################%%%%%%%%%%%%%%#((//////////((((((((//**********/******,,,,,,,,,............../%%#((*.                                                       
	//###############%%%%%%##########((((((((((((((######(((######%%%%%%%%%%%%%#(((/////////((((#((((//*****,****,,,,,........ ...............,(#((((/. .                                                     
	//#############%%%%%%%%#########(((((((((((((((((##############%%%%%%%%%%%##(((//////////(((#(((//*********,,,,........       ............*((/****,...                                                    
	//###########%%%%%%%%##########((((((((((((((((((((((((((((((#####%%%%%%%##((((///////////((((///**********,,,..........................,,,,*/(/********,.                                                
	//###########%%%##%%%##########((((((((((((((((((((((((((((((((#########%###((((//////////((((///*****////***,,,,,,,....................,,,*,*/((*****//****,,..                                          
	//##((((#####%####%%%##########((((((((((((((((((((/((///////((((((###########((((///////(((((((///////////*****,,,,,,,,,,,,,,..........,,,,,,,*/(/*****/********,.                                       
	//((((((###########%#############((((((((((((((((/////////////(((((((((########((((((((((((((((((((((//////******,,,,,,,,,,,,,,...............,,,/(**,**************,,.                                   
	//((((((##########################((((((((((((((///////**////((((((((((((#########((((((((((((((#(((//////********,,,,,,,,,,,....................,(/,,,,***************,.                                 
	//////((###########################((((((((/(((///////****/*/(((((((((((((((########((((((((((((#((/////*******,,,,,,,,,,,......................../(*,,***//**,,*******,**,..                             
	///////((#########################((((((((((//////////*****//(((((((((((/((((((((###(((((((((((((((///*******,,,,,,,,,,...........................*#/*,***//**,,*************,.                           
	//***///(((((((###################(((((((((////*************//((((((/////**///((((((((((/////////////******,,,,,,.................................,((/*,***/*,,,*,,,,,************,,,...                  
	//****///(((((((((################((((((((//////************//((((/////*****,,,.,,*//(//////////////******,,,,,,..................,................/(#/******,,,*,,,,,************,**,,*****,.            