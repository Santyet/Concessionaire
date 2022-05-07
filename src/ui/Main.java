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
		
			break;

		case 5:
		
			break;
		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}

	public int showMenu() {
		int option=0;

		System.out.println(
				"Please select an option:\n" +
				"(1) To register a vehicle.\n" +
                "(2) To calculate the selling price of a vehicle.\n" +
				"(3) To generate an inform of the vehicles with the selected criteria.\n"+
				"(4) To check the documents of a vehicle from its id.\n"+
				"(5) To generate an actual parking map.\n" + 
				"(6) To generate a parking occupation inform.\n" +  
				"(0) To exit");
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

	public void addVehicle(){

		double basePrice, mileage, fuelCapacity=0, batteryDuration, soatPrice=0, tmrPrice=0, tmrGasLevels=0, pcPrice=0, coverageCost=0;
		String brand, vehicleRegistration;
		int cylinderCapacity, option, temp, model, soatYear = 0, tmrYear = 0, pcYear = 0, doorNum;
		boolean used, isGas = false, polarized, hasSoat;
		GasType gasType = null;
		ChargerType chargerType = null;
		CarType carType = null;
		MotorcycleType motorcycleType=null;

		System.out.println("Please type the base price of the vehicle: ");
		basePrice = Double.parseDouble(sc.nextLine());

		System.out.println("Please type the brand of the vehicle:");
		brand = sc.nextLine();

		System.out.println("Please type the model of the vehicle:");
		model = sc.nextInt();
		sc.nextLine();

		System.out.println("Please type the cylinder capacity of the vehicle:");
		cylinderCapacity = sc.nextInt();
		sc.nextLine();

		System.out.println("Is this vehicle new? (1) for yes (2) for no:");
			temp = sc.nextInt();
			sc.nextLine();
			if(temp == 1){
				used = false;
			}else{
				used = true;
			}

			if(used){

				System.out.println("Please type the combination of the vehicle's plate:");
				vehicleRegistration = sc.nextLine();
				
				System.out.println("Please type the actual mileage of the vehicle:");
				mileage = sc.nextDouble();
				sc.nextLine();

				System.out.println("Please type the price of the property card:");
				pcPrice = sc.nextDouble();

				System.out.println("Please type the year of the property card:");
				pcYear = sc.nextInt();

				System.out.println("Please type the price of the SOAT: ");
				soatPrice = sc.nextDouble();
				sc.nextLine();

				System.out.println("Please type the year of the SOAT:");
				soatYear = sc.nextInt();
				sc.nextLine();

			}else{

				mileage = 0;
				vehicleRegistration = "";
			}
		
		System.out.println("The vehicle has SOAT? (1) For yes (2) for no:");
		temp = sc.nextInt();
		if(temp==1){

			

			hasSoat = true;
			
		}else{
			hasSoat = false;
		}

		

		System.out.println("Please type the price of the technical mechanical review:");
		tmrPrice = sc.nextDouble();
		sc.nextLine();

		System.out.println("Please type the year of the technical mechanical review:");
		tmrYear = sc.nextInt();
		sc.nextLine();

		System.out.println("Please type the gas levels of the vehicle:");
		tmrGasLevels = sc.nextDouble();
		sc.nextLine();
			
		System.out.println("This vehicle uses gasoline?\n(1) for yes\n(2) for no:");
		temp = sc.nextInt();
		sc.nextLine();
		
		if(temp == 1){
			
			System.out.println("Please type the fuel capacity of the vehicle:");
			fuelCapacity = sc.nextDouble();
			sc.nextLine();

			System.out.println("Please select the gasoline type of the vehicle:\n"
			+ "(1) For regular.\n"
			+ "(2) For extra.\n"
			+ "(3) For diesel.");
			temp = sc.nextInt();
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
			batteryDuration = sc.nextDouble();
			sc.nextLine();

			System.out.println("Please select the charger type of the vehicle:\n"
			+ "(1) For normal.\n"
			+ "(2) For fast.");
			temp = sc.nextInt();
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
			option = sc.nextInt();
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
				option = sc.nextInt();
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
				
				System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, hasSoat, mileage, used, vehicleRegistration, fuelCapacity, motorcycleType,
				soatPrice, soatYear, coverageCost, tmrPrice, tmrYear, tmrGasLevels, pcPrice, pcYear, gasType));
				
			break;

			case 2:

				System.out.println("\nAdding Hybrid car...\n");
				System.out.println("Please type the type of the car:\n"
				+"(1) For sedan.\n"
				+"(2) For pickup.");
				temp = sc.nextInt();
				
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

				System.out.println("Please type the battery duration of the vehicle:");
				batteryDuration = sc.nextDouble();
				sc.nextLine();

				System.out.println("Please select the charger type of the vehicle:\n"
				+ "(1) For normal.\n"
				+ "(2) For fast.");
				temp = sc.nextInt();
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

				System.out.println("Please type the number of doors of the car:");
				doorNum = sc.nextInt();
				sc.nextLine();

				System.out.println("The windows are polarized? (1) for yes (2) for no:");
				option = sc.nextInt();
				if(option==1){
					polarized = true;
				}else{
					polarized = false;
				}				

				System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, fuelCapacity,
				batteryDuration, hasSoat, chargerType, gasType, soatPrice, soatYear, coverageCost, tmrPrice, tmrYear, tmrGasLevels,
				pcPrice, hasSoat, pcYear, doorNum, polarized, carType));
				
			break;

			case 3:

				System.out.println("\nAdding gasoline car...\n");
				System.out.println("Please type the type of the car:\n"
				+"(1) For sedan.\n"
				+"(2) For pickup.");
				temp = sc.nextInt();
			
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
				doorNum = sc.nextInt();
				sc.nextLine();

					System.out.println("The windows are polarized? (1) for yes (2) for no:");
					option = sc.nextInt();
					if(option==1){
						polarized = true;
					}else{
						polarized = false;
					}
						
					System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, hasSoat, mileage, used, vehicleRegistration, fuelCapacity, gasType, soatPrice, soatYear, coverageCost, tmrPrice, tmrYear, tmrGasLevels, pcPrice, pcYear, doorNum, polarized, carType));
					

			break;

			case 4:

				if(isGas){
					System.out.println("Please type a valid option.\n");
				}else{

					System.out.println("\nAdding Electric car...\n");
					System.out.println("Please type the type of the car:\n"
					+"(1) For sedan.\n"
					+"(2) For pickup.");
					temp = sc.nextInt();
			
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

					System.out.println("Please type the battery duration of the vehicle:");
					batteryDuration = sc.nextDouble();
					sc.nextLine();

					System.out.println("Please select the charger type of the vehicle:\n"
					+ "(1) For normal.\n"
					+ "(2) For fast.");
					temp = sc.nextInt();
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

					System.out.println("Please type the number of doors of the car:");
					doorNum = sc.nextInt();
					sc.nextLine();

					System.out.println("The windows are polarized? (1) for yes (2) for no:");
					option = sc.nextInt();
					if(option==1){
						polarized = true;
					}else{
						polarized = false;
					}	
					
					System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, batteryDuration, chargerType, hasSoat, soatPrice, soatYear, coverageCost, tmrPrice, tmrYear, tmrGasLevels, pcPrice, pcYear, doorNum, polarized, carType));

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
}