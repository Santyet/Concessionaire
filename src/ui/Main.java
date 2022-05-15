package ui;
import java.util.Scanner; //for input reading

import model.AutomotiveMultinational;
import model.CarType;
import model.ChargerType;
import model.GasType;
import model.MotorcycleType;


public class Main{

	private AutomotiveMultinational auto;
	private Scanner sc;

	public Main(){
        InitModel init = new InitModel();
        auto = new AutomotiveMultinational(init.createVehicles());
		sc= new Scanner(System.in);
    }

	public static void main(String[] args){

			Main m = new Main();
	
			int option = 0;
			do{
				option= m.showMenu();
				m.executeOperation(option);
				
			}while (option!=0);
	
	}

	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
				System.out.println("Bye!");
			break;
		case 1:
		    	addVehicle();
			break;
		case 2:
				calculateSellingPrice();
			break;
	
		case 3:
				searchFromCriteria();
			break;

		case 4:
				searchFromid();
			break;

		case 5:
				System.out.println(auto.showParkingLot());
			break;
		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}

	public int showMenu() {
		int option=0;

		System.out.println(
				"\nPlease select an option:\n" +
				"(1) To register a vehicle.\n" +
                "(2) To calculate the selling price of a vehicle.\n" +
				"(3) To generate an inform of the vehicles with the selected criteria.\n"+
				"(4) To check the documents of a vehicle from its id.\n"+
				"(5) To generate an actual parking map.\n" + 
				"(6) To generate a parking occupation inform.\n" +  
				"(0) To exit");
		option= Integer.parseInt(sc.nextLine());
		return option;
	}

	public void addVehicle(){

		double basePrice, mileage, fuelCapacity=0, batteryDuration=0, soatPrice=0, tmrPrice=0, tmrGasLevels=0, pcPrice=0, coverageCost=0;
		String brand, vehicleRegistration;
		int cylinderCapacity, option, temp, model, soatYear = 0, tmrYear = 0, pcYear = 0, doorNum;
		boolean used, isGas = false, polarized;
		GasType gasType = null;
		ChargerType chargerType = null;
		CarType carType = null;
		MotorcycleType motorcycleType=null;

		System.out.println("Please type the base price of the vehicle: ");
		basePrice = Double.parseDouble(sc.nextLine());

		System.out.println("Please type the brand of the vehicle:");
		brand = sc.nextLine();

		System.out.println("Please type the model of the vehicle:");
		model = Integer.parseInt(sc.nextLine());
		

		System.out.println("Please type the cylinder capacity of the vehicle:");
		cylinderCapacity = Integer.parseInt(sc.nextLine());
		

		System.out.println("Is this vehicle new? (1) for yes (2) for no:");
			temp = Integer.parseInt(sc.nextLine());
			
			if(temp == 1){
				used = false;
			}else{
				used = true;
			}

			if(used){

				System.out.println("Please type the combination of the vehicle's plate:");
				vehicleRegistration = sc.nextLine();
				
				System.out.println("Please type the actual mileage of the vehicle:");
				mileage = Double.parseDouble(sc.nextLine());
				

				System.out.println("Please type the price of the property card:");
				pcPrice = Double.parseDouble(sc.nextLine());

				System.out.println("Please type the year of the property card:");
				pcYear = Integer.parseInt(sc.nextLine());

				System.out.println("Please type the price of the SOAT: ");
				soatPrice = Double.parseDouble(sc.nextLine());
				

				System.out.println("Please type the year of the SOAT:");
				soatYear = Integer.parseInt(sc.nextLine());

				System.out.println("Please type the coverage cost of the SOAT:");
				coverageCost = Double.parseDouble(sc.nextLine());
				

				System.out.println("Please type the price of the technical mechanical review:");
				tmrPrice = Double.parseDouble(sc.nextLine());
				

				System.out.println("Please type the year of the technical mechanical review:");
				tmrYear = Integer.parseInt(sc.nextLine());
				

				System.out.println("Please type the gas levels of the vehicle:");
				tmrGasLevels = Double.parseDouble(sc.nextLine());
				

			}else{

				mileage = 0;
				vehicleRegistration = "";
			}
		

		
			
		System.out.println("This vehicle uses gasoline?\n(1) For yes\n(2) For no:");
		temp = Integer.parseInt(sc.nextLine());
		
		
		if(temp == 1){
			
			System.out.println("Please type the fuel capacity of the vehicle:");
			fuelCapacity = Double.parseDouble(sc.nextLine());
			

			System.out.println("Please select the gasoline type of the vehicle:\n"
			+ "(1) For regular.\n"
			+ "(2) For extra.\n"
			+ "(3) For diesel.");
			temp = Integer.parseInt(sc.nextLine());
			switch(temp){
				case 1:
						gasType = GasType.REGULAR;
				break;

				case 2:
						gasType = GasType.EXTRA;
				break;

				case 3:
						gasType = GasType.DIESEL;
				break;

				default:
						System.out.println("Please select a valid option.\n");
				break;
			}

			isGas = true;

		}else{

			System.out.println("Please type the battery duration of the vehicle:");
			batteryDuration = Double.parseDouble(sc.nextLine());
			

			System.out.println("Please select the charger type of the vehicle:\n"
			+ "(1) For normal.\n"
			+ "(2) For fast.");
			temp = Integer.parseInt(sc.nextLine());
			switch(temp){
				case 1:
						chargerType = ChargerType.NORMAL;
				break;

				case 2:
						chargerType = ChargerType.FAST;
				break;

				default:
						System.out.println("Please select a valid option.\n");
				break;
			}
		}

		if(isGas){
			System.out.println("Please select the vehicle type that you want to add: \n"
			+"(1) For motorcycle.\n"
			+"(2) For hybrid car.\n"
			+"(3) For gasoline car.");
			option = Integer.parseInt(sc.nextLine());
		}else{
			option = 4;
		}
		
		

		switch(option){

			case 1:

				System.out.println("\nAdding motorcycle...\n");
				System.out.println("Please type the type of the motorcycle: \n"
				+"(1) For standard.\n"
				+"(2) For sport.\n"
				+"(3) For scooter.\n"
				+"(4) For cross.");
				option = Integer.parseInt(sc.nextLine());
				switch(option){
					case 1:
							motorcycleType = MotorcycleType.STANDARD;
					break;

					case 2:
							motorcycleType = MotorcycleType.SPORT;
					break;

					case 3:
							motorcycleType = MotorcycleType.SCOOTER;
					break;

					case 4:
							motorcycleType = MotorcycleType.CROSS;
					break;

					default:
							System.out.println("Please select a valid option.\n");
					break;
				}
				
				System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, fuelCapacity, motorcycleType,
				soatPrice, soatYear, coverageCost, tmrPrice, tmrYear, tmrGasLevels, pcPrice, pcYear, gasType));
				
			break;

			case 2:

				System.out.println("\nAdding Hybrid car...\n");
				System.out.println("Please type the type of the car:\n"
				+"(1) For sedan.\n"
				+"(2) For pickup.");
				temp = Integer.parseInt(sc.nextLine());
				
				switch(temp){
					case 1:
						carType = CarType.SEDAN;
					break;

					case 2:
						carType = CarType.PICKUP_TRUCK;
					break;
					
					default:
						System.out.println("Please type a valid opion.\n");
					break;
				}

				System.out.println("Please type the number of doors of the car:");
				doorNum = Integer.parseInt(sc.nextLine());
				

				System.out.println("The windows are polarized? (1) for yes (2) for no:");
				option = Integer.parseInt(sc.nextLine());
				if(option==1){
					polarized = true;
				}else{
					polarized = false;
				}				

				System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, fuelCapacity,
				batteryDuration, chargerType, gasType, soatPrice, soatYear, coverageCost, tmrPrice, tmrYear, tmrGasLevels,
				pcPrice, pcYear, doorNum, polarized, carType));
				
			break;

			case 3:

				System.out.println("\nAdding gasoline car...\n");
				System.out.println("Please type the type of the car:\n"
				+"(1) For sedan.\n"
				+"(2) For pickup.");
				temp = Integer.parseInt(sc.nextLine());
			
				switch(temp){
					case 1:
						carType = CarType.SEDAN;
					break;

					case 2:
						carType = CarType.PICKUP_TRUCK;
					break;
				
					default:
						System.out.println("Please type a valid opion.\n");
					break;
				}

				System.out.println("Please type the number of doors of the car:");
				doorNum = Integer.parseInt(sc.nextLine());
				

					System.out.println("The windows are polarized? (1) for yes (2) for no:");
					option = Integer.parseInt(sc.nextLine());
					if(option==1){
						polarized = true;
					}else{
						polarized = false;
					}
						
					System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, fuelCapacity, gasType, soatPrice, soatYear, coverageCost, tmrPrice, tmrYear, tmrGasLevels, pcPrice, pcYear, doorNum, polarized, carType));
					

			break;

			case 4:

				if(isGas){
					System.out.println("Please type a valid option.\n");
				}else{

					System.out.println("\nAdding Electric car...\n");
					System.out.println("Please type the type of the car:\n"
					+"(1) For sedan.\n"
					+"(2) For pickup.");
					temp = Integer.parseInt(sc.nextLine());
			
					switch(temp){
						case 1:
							carType = CarType.SEDAN;
						break;

						case 2:
							carType = CarType.PICKUP_TRUCK;
						break;
					
						default:
							System.out.println("Please type a valid option.\n");
						break;
					}

					System.out.println("Please type the number of doors of the car:");
					doorNum = Integer.parseInt(sc.nextLine());
					

					System.out.println("The windows are polarized? (1) for yes (2) for no:");
					option = Integer.parseInt(sc.nextLine());
					if(option==1){
						polarized = true;
					}else{
						polarized = false;
					}	
					
					System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, mileage,
					 used, vehicleRegistration, batteryDuration, chargerType, soatPrice, soatYear,
					  coverageCost, tmrPrice, tmrYear, tmrGasLevels, pcPrice, pcYear, doorNum, polarized, carType));

				}

			break;

			default:
					System.out.println("Please select a valid option.\n");
			break;
		}



	}

	public void calculateSellingPrice(){

		int id, percent;

		System.out.println("Please type the id of the vehicle to calculate the selling price:");
		id = Integer.parseInt(sc.nextLine());

		System.out.println("Type the percentage of the extra discount (0) For none:");
		percent = Integer.parseInt(sc.nextLine());

		System.out.println(auto.calculateSellingPrice(id, percent));
		
	}

	public void searchFromCriteria(){

		int option;

		System.out.println("Please select the criteria to search:"
		+ "\n(1) To vehicle type."
		+ "\n(2) To fuel type."
		+ "\n(3) To new/used.");
		option = Integer.parseInt(sc.nextLine());

		switch(option){

			case 1:
				System.out.println("Please select the type of the vehicles to search:"+
				"\n(1) For motorcycles."
				+"\n(2) For hybrid cars."
				+"\n(3) For gasoline cars."
				+"\n(4) For electric cars.");
				option = Integer.parseInt(sc.nextLine());

				System.out.println(auto.searchVehicleType(option));

			break;

			case 2:

			System.out.println("Please select the fuel type of the vehicles to search:"
			+"\n(1) For regular"
			+"\n(2) For extra"
			+"\n(3) For diesel");
			option = Integer.parseInt(sc.nextLine());
			
			System.out.println(auto.searchFuelType(option));

			break;

			case 3:

			System.out.println("Please select (1) for new or (2) for used cars:");
			option = Integer.parseInt(sc.nextLine());

			System.out.println(auto.searchNew(option));

			break;

			default:

			System.out.println("Please select a valid option.");

			break;
		}

	}

	public void searchFromid(){

		String id;
			
		System.out.println("Please type de id of the car:");
		id = sc.nextLine();

		System.out.println(auto.searchFromId(id));
	}

	public void occupationInform(){

		int option;

		System.out.println("Please select the criteria to generate an inform" +
		"(1) T");

		option = Integer.parseInt(sc.nextLine());

		switch(option){

			case 1:

			break;

			case 2:

			break;

			case 3:

			break;

			default:

			break;
		}
	}
}