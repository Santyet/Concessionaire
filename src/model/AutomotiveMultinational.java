package model;

import java.util.ArrayList;

public class AutomotiveMultinational{

	private ArrayList<Vehicle> vehicles;

	public AutomotiveMultinational(ArrayList<Vehicle> vehicles){

		this.vehicles = vehicles;
	}

	//ADD MOTORCYCLE
	
	public String addVehicle(double basePrice, String brand, int model, int cylinderCapacity, boolean hasSoat,
	 double mileage, boolean used, String vehicleRegistration, double fuelCapacity, MotorcycleType motorcycleType,
	 double soatPrice, int soatYear, double coverageCost, double tmrPrice, int tmrYear, double tmrGasLevels, double pcPrice, int pcYear, GasType gasType){
		 
		//SOAT CREATION PART
		int[][] code = genCode();
		SOAT soat = new SOAT(soatPrice, soatYear, code, coverageCost);

		//TECHNICAL MECHANICAL REVIEW PART
		code = genCode();
		TechnicalMechanicalReview technicalMechanicalReview = new TechnicalMechanicalReview(tmrPrice, tmrYear, code, tmrGasLevels);

		//PROPERTY CARD PART (IF VEHICLE IS USED)
		Document propertyCard;
		if(used){
			code = genCode();
			propertyCard = new Document(pcPrice, pcYear, code);
		}else{
			propertyCard = new Document(0, 0, null);
			
		}

		Motorcycle moto = (new Motorcycle(basePrice, 0, brand, 0, model, cylinderCapacity, mileage, used, vehicleRegistration,
		 soat, technicalMechanicalReview, propertyCard, fuelCapacity, motorcycleType, gasType));


		double sellPrice = ((Motorcycle)(moto)).calculateSellingPrice(soatYear, tmrYear, used);
		double fuelUsage = ((Motorcycle)(moto)).calculateGasUsage();
		
		moto.setSellPrice(sellPrice);
		moto.setFuelUsage(fuelUsage);

		vehicles.add(moto);
		
		int a = vehicles.size() - 1;
		return "\nMotorcycle was added with id " + a + "\n";
	}

	//ADD GAS CAR
	public String addVehicle(double basePrice, String brand, int model, int cylinderCapacity, boolean hasSoat,
	 double mileage, boolean used, String vehicleRegistration, double fuelCapacity, GasType gasType, 
	 double soatPrice, int soatYear, double coverageCost, double tmrPrice, int tmrYear, double tmrGasLevels, double pcPrice, int pcYear,
	 int doorNum, boolean polarized, CarType carType){

		int[][] code = genCode();

		SOAT soat;
		//SOAT CREATION PART
		if(hasSoat){
			soat = new SOAT(soatPrice, soatYear, code, coverageCost);
		}else{
			soat = new SOAT(0, 0, null, 0);
		}
		

		//TECHNICAL MECHANICAL REVIEW PART
		code = genCode();
		TechnicalMechanicalReview technicalMechanicalReview = new TechnicalMechanicalReview(tmrPrice, tmrYear, code, tmrGasLevels);

		//PROPERTY CARD PART (IF VEHICLE IS USED)
		Document propertyCard;
		if(used){
			code = genCode();
			propertyCard = new Document(pcPrice, pcYear, code);
		}else{
			propertyCard = new Document(0, 0, null);
			
		}

		GasCar gascar = (new GasCar(basePrice, 0, brand, 0, model, cylinderCapacity, mileage, used, vehicleRegistration, soat, technicalMechanicalReview, propertyCard, doorNum, polarized, carType, fuelCapacity, gasType));


		double sellPrice = ((GasCar)(gascar)).calculateSellingPrice(soatYear, tmrYear, used);
		double fuelUsage = ((GasCar)(gascar)).calculateGasUsage();
		
		gascar.setSellPrice(sellPrice);
		gascar.setFuelUsage(fuelUsage);

		vehicles.add(gascar);
		
		int a = vehicles.size() - 1;
		return "\nGasoline car was added with id " + a + "\n";
	}

	//ADD HYBRID CAR
	public String addVehicle(double basePrice, String brand, int model, int cylinderCapacity,
	 double mileage, boolean used, String vehicleRegistration, double fuelCapacity, double batteryDuration, Boolean hasSBoolean,
	 ChargerType chargerType, GasType gasType, double soatPrice, int soatYear, double coverageCost, double tmrPrice,
	 int tmrYear, double tmrGasLevels, double pcPrice, int pcYear, int doorNum, boolean polarized, CarType carType){

		//SOAT CREATION PART
		int[][] code = genCode();
		SOAT soat = new SOAT(soatPrice, soatYear, code, coverageCost);

		//TECHNICAL MECHANICAL REVIEW PART
		code = genCode();
		TechnicalMechanicalReview technicalMechanicalReview = new TechnicalMechanicalReview(tmrPrice, tmrYear, code, tmrGasLevels);

		//PROPERTY CARD PART (IF VEHICLE IS USED)
		Document propertyCard;
		if(used){
			code = genCode();
			propertyCard = new Document(pcPrice, pcYear, code);
		}else{
			propertyCard = new Document(0, 0, null);
			
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

		int a = vehicles.size() - 1;
		return "\nHybrid car was added with id " + a + "\n";
	}

	//ADD ELECTRIC CAR
	public String addVehicle(double basePrice, String brand, int model, int cylinderCapacity, double mileage,
	 boolean used, String vehicleRegistration, double batteryDuration, ChargerType chargerType, boolean hasSoat,
	 double soatPrice, int soatYear, double coverageCost, double tmrPrice, int tmrYear, double tmrGasLevels, double pcPrice,
	 int pcYear, int doorNum, boolean polarized, CarType carType){

		//SOAT CREATION PART
		int[][] code = genCode();
		SOAT soat = new SOAT(soatPrice, soatYear, code, coverageCost);

		//TECHNICAL MECHANICAL REVIEW PART
		code = genCode();
		TechnicalMechanicalReview technicalMechanicalReview = new TechnicalMechanicalReview(tmrPrice, tmrYear, code, tmrGasLevels);

		//PROPERTY CARD PART (IF VEHICLE IS USED)
		Document propertyCard;
		if(used){
			code = genCode();
			propertyCard = new Document(pcPrice, pcYear, code);
		}else{
			propertyCard = new Document(0, 0, null);
			
		}

		ElectricCar eCar = (new ElectricCar(basePrice, 0, brand, model,
		 cylinderCapacity, mileage, used, vehicleRegistration, soat, technicalMechanicalReview,
		  propertyCard, doorNum, polarized, carType, batteryDuration, 0, chargerType));


		double sellPrice = ((ElectricCar)(eCar)).calculateSellingPrice(soatYear, tmrYear, used);
		
		double batteryUsage = ((ElectricCar)(eCar)).calculateBatteryUsage(chargerType);
		
		eCar.setSellPrice(sellPrice);
		eCar.setBatteryUsage(batteryUsage);

		vehicles.add(eCar);

		int a = vehicles.size()-1;
		return "\nElectric car added with id " + a + "\n";
	}

	public int[][] genCode(){

		int[][] code = new int[5][5];

    	for (int i=0; i<5 ; i ++) {
        	for (int j=0; j<5 ; j++) {
           		int random = (int)(Math.random()*(10));
            	code[i][j]=random;
         	}
		}

		return code;
	}

	public String calculateSellingPrice(int id, int percent){

		double price = vehicles.get(id).getSellPrice();

		price = price-(price*percent);


		return "\nThe selling price of this vehicle is:" + price + ".\n";
	}

	public String searchFromCriteria(){
	
		throw new UnsupportedOperationException();
	}

	public String searchFromId(){
	
		throw new UnsupportedOperationException();
	}

	public String showParkingLot(){

		throw new UnsupportedOperationException();
	}

	public String showParkingOccupation(){

		throw new UnsupportedOperationException();
	}

	public void selectedVehicleAdd(int option){

		switch(option){

			case 1:

			break;

			case 2:

			break;

			case 3:

			break;

			case 4:

			break;

			default:

			break;
		}
		
	}


	

}