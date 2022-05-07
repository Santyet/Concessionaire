package model;

import java.util.ArrayList;

public class AutomotiveMultinational{

	private ArrayList<Vehicle> vehicles;
	private Motorcycle motorcycle;
	private HybridCar hybridCar;
	private GasCar gasCar;
	private ElectricCar electricCar;

	public AutomotiveMultinational(ArrayList<Vehicle> vehicles){

		this.vehicles = new ArrayList<Vehicle>();
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

		double sellPrice = motorcycle.calculateSellingPrice(soatYear, tmrYear, used);
		double fuelUsage = motorcycle.calculateGasUsage();
		
		vehicles.add(new Motorcycle(basePrice, sellPrice, brand, fuelUsage, model, cylinderCapacity, mileage, used, vehicleRegistration,
		 soat, technicalMechanicalReview, propertyCard, fuelCapacity, motorcycleType, gasType));
		
		return "Motorcycle was added.\n";
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

		double sellPrice = gasCar.calculateSellingPrice(soatYear, tmrYear, used);
		double fuelUsage = gasCar.calculateGasUsage();
		vehicles.add(new GasCar(basePrice, sellPrice, brand, fuelUsage, model, cylinderCapacity, mileage, used, vehicleRegistration,
		soat, technicalMechanicalReview, propertyCard, doorNum, polarized, carType, fuelCapacity, gasType));
		
		return "Gasoline car was added.";
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

		double sellPrice = hybridCar.calculateSellingPrice(soatYear, tmrYear, used);
		double fuelUsage = hybridCar.calculateBatteryUsage(chargerType);
		double batteryUsage = hybridCar.calculateGasUsage();

		vehicles.add(new HybridCar(basePrice, sellPrice, brand, model, fuelUsage, batteryUsage, cylinderCapacity, mileage, used, vehicleRegistration, soat,
		 technicalMechanicalReview, propertyCard, doorNum, polarized, carType, fuelCapacity, batteryDuration, gasType, chargerType));
	
		return "Hybrid car was added.";
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

		double sellPrice= electricCar.calculateSellingPrice(soatYear, tmrYear, used);
		double batteryUsage = electricCar.calculateBatteryUsage(chargerType);
		vehicles.add(new ElectricCar(basePrice, sellPrice, brand, model, cylinderCapacity,
		mileage, used, vehicleRegistration, soat, technicalMechanicalReview, propertyCard, doorNum, polarized, carType, batteryDuration, batteryUsage, chargerType));
		
		return "Electric car added.";
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

	public String calculateSellingPrice(int id){

		vehicles.get(id);
		return "";
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