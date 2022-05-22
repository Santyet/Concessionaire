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

		case 6:
				occupationInform();
			break;
		
		default:
				System.out.println("\nType a valid option\n");
			break;
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

		do{
		System.out.println("Please type the base price of the vehicle: ");
		basePrice = Double.parseDouble(sc.nextLine());
		if(basePrice<0){
			System.out.println("\ntype a valid price\n");
		}
		}while(basePrice<0);

		System.out.println("Please type the brand of the vehicle:");
		brand = sc.nextLine();

		do{
		System.out.println("Please type the model of the vehicle:");
		model = Integer.parseInt(sc.nextLine());
		if(model<0){
			System.out.println("\nType a valid model\n");
		}
		}while(model<0);

		do{
		System.out.println("Please type the cylinder capacity of the vehicle:");
		cylinderCapacity = Integer.parseInt(sc.nextLine());
		if(cylinderCapacity<0){
			System.out.println("\nType a valid cylinder capacity\n");
		}
		}while(cylinderCapacity<0);

		do{
		System.out.println("Is this vehicle new? (1) for yes (2) for no:");
			temp = Integer.parseInt(sc.nextLine());
		}while(!auto.checkFor12(temp));

			if(temp == 1){
				used = false;
			}else{
				used = true;
			}
		

			if(used){

				System.out.println("Please type the combination of the vehicle's plate:");
				vehicleRegistration = sc.nextLine();
				
				do{
				System.out.println("Please type the actual mileage of the vehicle:");
				mileage = Double.parseDouble(sc.nextLine());
				
				if(mileage<0){
					System.out.println("\nType a valid mileage\n");
				}
				}while(mileage<0);
				
				do{
				System.out.println("Please type the price of the property card:");
				pcPrice = Double.parseDouble(sc.nextLine());
				if(pcPrice<0){
					System.out.println("\nType a valid price\n");
				}
				}while(pcPrice<0);

				do{
				System.out.println("Please type the year of the property card:");
				pcYear = Integer.parseInt(sc.nextLine());
				if(pcYear<0){
					System.out.println("\nType a valid year\n");
				}
				}while(pcYear<0);

				do{
				System.out.println("Please type the price of the SOAT: ");
				soatPrice = Double.parseDouble(sc.nextLine());
				if(soatPrice<0){
					System.out.println("\nType a valid price\n");
				}
				}while(soatPrice<0);
				
				do{
				System.out.println("Please type the year of the SOAT:");
				soatYear = Integer.parseInt(sc.nextLine());
				if(soatYear<0){
					System.out.println("\nType a valid year\n");
				}
				}while(soatYear<0);

				do{
				System.out.println("Please type the coverage cost of the SOAT:");
				coverageCost = Double.parseDouble(sc.nextLine());
				if(coverageCost<0){
					System.out.println("\nType a valid cost\n");
				}
				}while(coverageCost<0);
				
				do{
				System.out.println("Please type the price of the technical mechanical review:");
				tmrPrice = Double.parseDouble(sc.nextLine());
				if(tmrPrice<0){
					System.out.println("\nType a valid price\n");
				}
				}while(tmrPrice<0);

				do{
				System.out.println("Please type the year of the technical mechanical review:");
				tmrYear = Integer.parseInt(sc.nextLine());
				if(tmrYear<0){
					System.out.println("\nType a valid year\n");
				}
				}while(tmrYear<0);

				do{
				System.out.println("Please type the gas levels of the vehicle:");
				tmrGasLevels = Double.parseDouble(sc.nextLine());
				if(tmrGasLevels<0){
					System.out.println("\nType valid gas levels\n");
				}
				}while(tmrGasLevels<0);

			}else{

				mileage = 0;
				vehicleRegistration = "";
			}
		

		
		do{
		System.out.println("This vehicle uses gasoline?\n(1) For yes\n(2) For no:");
		temp = Integer.parseInt(sc.nextLine());
		}while(!auto.checkFor12(temp));
		
		
		if(temp == 1){
			
			do{
			System.out.println("Please type the fuel capacity of the vehicle:");
			fuelCapacity = Double.parseDouble(sc.nextLine());
			if(fuelCapacity<0){
				System.out.println("\nType a valid capacity\n");
			}
			}while(fuelCapacity<0);
			
			do{
			System.out.println("Please select the gasoline type of the vehicle:\n"
			+ "(1) For regular.\n"
			+ "(2) For extra.\n"
			+ "(3) For diesel.");
			temp = Integer.parseInt(sc.nextLine());
			}while(!auto.checkFor123(temp));

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
			}

			isGas = true;

		}else{

			do{
			System.out.println("Please type the battery duration of the vehicle:");
			batteryDuration = Double.parseDouble(sc.nextLine());
			if(batteryDuration<0){
				System.out.println("\nType a valid duration\n");
			}
			}while(batteryDuration<0);
			
			do{
			System.out.println("Please select the charger type of the vehicle:\n"
			+ "(1) For normal.\n"
			+ "(2) For fast.");
			temp = Integer.parseInt(sc.nextLine());
			}while(!auto.checkFor12(temp));

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
			do{
			System.out.println("Please select the vehicle type that you want to add: \n"
			+"(1) For motorcycle.\n"
			+"(2) For hybrid car.\n"
			+"(3) For gasoline car.");
			option = Integer.parseInt(sc.nextLine());
			}while(!auto.checkFor123(option));

		}else{
			option = 4;
		}
		
		

		switch(option){

			case 1:

				System.out.println("\nAdding motorcycle...\n");
				do{
				System.out.println("Please type the type of the motorcycle: \n"
				+"(1) For standard.\n"
				+"(2) For sport.\n"
				+"(3) For scooter.\n"
				+"(4) For cross.");
				option = Integer.parseInt(sc.nextLine());
				}while(!auto.checkFor1234(option));
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
				}
				
				System.out.println(auto.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, fuelCapacity, motorcycleType,
				soatPrice, soatYear, coverageCost, tmrPrice, tmrYear, tmrGasLevels, pcPrice, pcYear, gasType));
				
			break;

			case 2:

			do{
				
				System.out.println("Please type the battery duration of the vehicle:");
				batteryDuration = Double.parseDouble(sc.nextLine());
				if(batteryDuration<0){
					System.out.println("\nType a valid duration\n");
				}
				}while(batteryDuration<0);
				
				do{
				System.out.println("Please select the charger type of the vehicle:\n"
				+ "(1) For normal.\n"
				+ "(2) For fast.");
				temp = Integer.parseInt(sc.nextLine());
				}while(!auto.checkFor12(temp));
	
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

				System.out.println("\nAdding Hybrid car...\n");
				do{
				System.out.println("Please type the type of the car:\n"
				+"(1) For sedan.\n"
				+"(2) For pickup.");
				temp = Integer.parseInt(sc.nextLine());
				}while(!auto.checkFor12(temp));
				
				switch(temp){
					case 1:
						carType = CarType.SEDAN;
					break;

					case 2:
						carType = CarType.PICKUP_TRUCK;
					break;
				}

				do{
				System.out.println("Please type the number of doors of the car:");
				doorNum = Integer.parseInt(sc.nextLine());
				if(doorNum<0){
					System.out.println("\nType a valid number of doors\n");
				}
				}while(!auto.checkFor12(doorNum));
				
				do{
				System.out.println("The windows are polarized? (1) for yes (2) for no:");
				option = Integer.parseInt(sc.nextLine());
				}while(!auto.checkFor12(option));

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

		System.out.printf(auto.calculateSellingPrice(id, percent));
		
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
		int year1, year2;

		System.out.println("Please select the criteria to generate an inform" +
		"\n(1) To get all car info from a range of years" +
		"\n(2) To get the info of the newest and the oldest car" +
		"\n(3) To get the occupation percentage of the parking lot");

		option = Integer.parseInt(sc.nextLine());

		switch(option){

			case 1:

				System.out.println("Please type the range of years starting from the oldest" +
				"\nType the starting year:");
				year1 = Integer.parseInt(sc.nextLine());

				System.out.println("Type the finishing year:");
				year2 = Integer.parseInt(sc.nextLine());

				System.out.println(auto.getInfoFromYears(year1, year2));

			break;

			case 2:
				System.out.println(auto.getOlderAndNewerVehicle() + "\n");
			break;

			case 3:
				System.out.println("\nThe actual occpation percentage of the parking lot is: " + auto.getOccupationPercentage() + "%\n");
			break;

			default:
				System.out.println("Please select a valid option\n");
			break;
		}
	}
}

//.(((#((//((((//(((////////////((((((((((((((((((((((((/((((((((((((((((((((((((((((((((#########(###((((###((#(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((#((####(####((((((##/
//.((/(/////////(////((//////////(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((/*.*(//((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((#((#(#########((((((/
//.,,,,......,,,*//(//((((((((((((((((((((((((((((((((/*,*((((((((((((((((((((((((((((((((((((((((/((//*. ./((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((#/*/((((((###(((((#((((/
//.(////(/(((((/((((((((((((/(((((((((((((((///((/*,..*(((((((((((((((((((((((((((((((((((((((((((/,.  ./(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((/,..*((((((((((((((##/
//.((((((/(((((((((((((((((((((((((((/(((((((/*,  ,/((((((((((((((((((((((((((((((((((((((((//,.   ,/###((((((((((#(((((#((((((((((/*.  ,/((((((((((((((((((((((((((((((((((((((((/*. *(,.  ,*/((((((((((/
//.((((((((((((((((((((((((((/((((((((((/*,  .,((/,.  ,**/(((((((((((((((((((((((((/**,.       ,(((###((((((((((((###((((####((*.   .,//. .*(((((((((((((((((((((###(####((((/*.  .,((((((((/,.    .*///(*
//.(/((/(//((((/((((((((((//((/(((/,.   .*/((((((((((((/*.      ...,,,,,,....        .,*/(((((((,  .,*/(((((((((##(##(((/,.     */((((((((,  ..,*/((((((((((((((##(((((/*,    .*((((#(((((((((((((/*.     
//,*,.  .,**///((((((((///*,.   .,*/(((/((((((((((((((((((((((((#(/////*/////((((((((((#########((##(*,.                .***(##(((((((((((//((/*.         ...           .,/(((((((((((((##(((((((((((((((/
//.((((((((((////*,.,*/////((((((((((((((((((((((((((((######(##(((((((((((((((((((((##(((##(##((((((((#####(((((((#####((((((((((((((((((((((/((((((/(//////////(((((((((((((((/((((((((((((#(((((((((((*
//,((((((((((((((((((((((((((//((((((((((((((((((((((((((((((((((((((**(#(((((((((##(####(((((((((((((((#####((((((###((##((((((((((((((((((((((((((((((((((((((((((((/,,/(((((((((((((((###(***/((((((((*
//.((((((((((((((((((((((((((* /(((((((((((((########(###(((((((((((##/..,/#%%%#%##############((*,  ./##(#%%#((##(((((((((((((((((((/((((((((((((((((((((((((((((/*  .*(((((((((((((#(((((#((##//**,,.,..
//,##(((#(((((((((((((((((((((* ,((((((((((((((((((#((((((((((((((####(,. .,  .,*/(####(((/*.   .*/((*  .(#######(((((((((((((((/((///(((((((((((###(########(/,.  .*(((((((((((((((((##(#(((((((((((((((*
//,##((((((((((((((((((((((((((/, .*(((((((((((((((#((#########%%#/.   ./%&%&&&%#(///**///(#%&&&&&&%%#((/.  .,/(((((((((((((///*,.     ,*//((#(((((#(#(/*.     ,(#%##%#(((#(((((((((((((*,/(((((((((((###/
//,#(######((((((((/((#(((#%%###%(,.  ./%%%#(########(#%%##(*.   . .(%%%%&&&&&&&%&&&&&&&&&%%%&%%%&&%%%%%#((((,.        ..        */*///*.              .,/((((%*   /##%###(((((((((((/,      .*((((#%##%%(
//,#########(##%%#*    .,/(((###(/*. ,/   .                 .,/#%%&%%%%%%%%%%%%%%%%&&&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%%%#######*//////////((////(((((((//((((((/,#%&&#(,     .,////*,    ./((((//*,       ,,.
//,%##%%%%%%%#/.   *###%#/,,,,,*(#%%&&%&%%%##((((((##%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&%%%%%%%%%%%%%%%%%&&&&&&&&&&&&&&%#*/(((*,**,,,,,,,,,,,,,,.,*(**(((,.#&&&&&&&&&&&%#(#(((##(#%%##(#%&&%&&&&&&%%%%(
//.*.         .*(#(##%%&%%%%%%%%%%&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&%&%%%%%%%%%%&&&&&&&&&&&&&&&&&&&&%%#,/(((*/(((/(((((((((//(((//*,/((,.(#%&&&&&&&&&&&&&&&&&&%%&&&%&%&&&&&&&&&&&%&&#
//,&&&&&&&&&&%%%%##%%#%%%%%%%%%%%%%%%#%%%%%%%%%%%%%%%%%%%%%%%%%%#######((((//////****/%&%%%%%%%%&%%&&&&&&&&&&&&&&&&&&&&&&&%#,((((**(((/(/((//((((//((((*,/((* (%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#
//*&&&%%%&&%%%%%%%%%%%%%%%%%%%%%%(*****,,,,*,.....     .. ......,,,,,,**////(/,      .#&&&%%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#,/(((**(((((((*//((///((/((*,((((.*%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#
//*&%%%%%%%%%%&%%%%%%%%%%%%%%%%&#,,/((/(((((((((/(//(/((///(/////((((((///((//,      .#&%%%%%&&&&%%%%%%%%%%&&&&&&&&&&&&&&&%#,/((/,*/(/((/*/(///*/((((((,,((((.*%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#
//*&&%%%%%%%%%%%%%%%%%%%%%%&%%&&(.(#((((//////////////////////////////////(///,      .(%%%%%%&&&&&&&&&&&%%&&&&&&&&&&&&&&&%##,*((/,*//((/*/(//(*/(((((((,,(((/.*%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#
//*&&%%%%%%%%%%%%%%%%%%%%%%%%%%%/./((/(((/////////////////////////////////(///,      .(%%&%%%&&&%%%%%%%%%%%%%%%%&&&&&&&&&%%#,,((/,*/(//*/////,////(//(/,*(((/.*%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#
//*&%%%%%%%%%%%%%%%%%%%%%%%%%%%%/ *///(///////////////////////////////////(///,      .#%%%%%&&&&&%%&%%%%%%%%%%%%%%%&&&&&&%%#,.///.*(////(///,/(////(((/.,(((/.*%&&%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#
//*&%%%%%%%%%%%/,%&%%%%%%%%%%%%%/ *////////////(//((///(///////((((((/(((((#((,  .   .(%%%%%%&&&&&&%%%%%%%%&&&&&&&&&&&&&%%%#*./(/,*////////*////*//*/(/.,(((/ *#%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#
//*&%%%%%%%%%%%*..(%%%%%%%%%%%%#/ */////////(((((((/**///((((((///((((/((/,,.,.  .   .#&&&&&&&&%&&%%&%%&&&&&&&&&&&&&&&%%%%##/./(/,,/(/////*/(//*//*/(//,,(((/./%&%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#
//*&%%%%%%%&%%#,%%,#%%%%%%%%%%%%/ ,(////((((((((*,*/.*(/////(((((/(/(//,./######/,   ,#&&&%&&&&&%%&&%%&&&&&&&&&&&&&&%&&&&&#(/./(/,,//((//*//(/*//*/**(/,,((((.*%&&&&&&&&&&&&&&&&&&&&&&&&&&/ ,#&&&&&&&&&&&#
//*&%%%%%%%%%%*/&@(,#%%%%%%%%%%#/..//(//#(###(.(###*,((((/((/(((#(((//.,###########/.*%&%((#%&&&&%%%&&&&&&&&&&&&&&&&&&&&&%%#/./((*./(/(/*/(//*//(/*//(/,,(((/./%&&&&&&&&&&&&&&&&&&&&&&&&&&/ .. /&&&&&&&&&#
//*&%%%%%%%%%/*%@&&/*%&%%%%%%%%&/.,(//((###/(%#%%%#.,(((//(((#,.(#(((* *######(/*.     ./%%/.(&&&&&&&&&&&&&&&&&&&&&&&&&&%%((/ *((*.//(/((/((/(/((//((((,,(((/./%&&&&&&&&&&&&&&&&&&&&&&&&&&/ ,#%, #&&&&&&&#
//*%%%%%%%&%/*%&&&&(*(%&%%%%%%%%(..((/(##*(%%%%%%%#,/#((((/((*,(*(####,,#(*.         ,(###%#.(%%&&&&&&&&%&%%&&&&&&&&&&&&&%#((.,((/,.,,,*/////**//***,. .*((((./%&&&&&&&&&&&&&&&&&&&&&&&&&&. ,#%%/.#&&&&&&#
//*%%%%%%%%*(&&&&&&%*/%&%%%%%%%%#,,(((#//#%%%%%%%%%,/((((//(**###//###(,          ./(#####*.***,  .,(%&&&&&&&&&&&&&&&&&&&&%%#.,(((((((((///////((/(((((((((((./%&&&&&&&&&&&&&&&&&&&&&&&&&%  *%%#%*.#&&&&&#
//*%%%%%%#,#&&&&&&&#*/%&%%%%%%%%#,.(#(*#%%%%/(*%%%%,*((((/(**#%%%%/, ,,*///////(#######/.,(########(*.,(%%&&&&&&&&&&&&&&&&&%#/ /(((((((((((///(((((((((/((//(,/%&&&&&&&&&&&&&&&&&&&&&&&%%( .(%%%%%.*%&&&&(
//*%%%%%#,%&&&&&&@&%*/%%%%%%%%%%%*,#((%%%%((%&,%%%%*,##(((*.(#%%%%%.*###########(/*,..,/##(#######(###(,,#%&&&&&&&&&&&&&&&&%%#/,.                          .,#&&&%&&&&&&&&&&&&&&&&&&&&&%%, ,#%%%%%*.#&&%*.
//,%%%%#.#&&&&&&&&&%*/%%%%%%%%%%%*,((%#%((%%%%*#%%%#**##(**##%*/&&%#(*..... ..,*/(#####(########(#######/.(%&&&&%%&&&&&&&&&&&&%%&&%%&&&&%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%#. /%%%%%%#./%/.%#
// ,#&%*/&&&&&&&&&&#*/%%%%%%%%%%&/.*#%%/#%%%%%#/%%%%#/,(**(#%#(##%(#*#((#(,/%#################((((#* ,(%%%/../%&&&&&&&&&&&&&&&%%&&&&&%&&&&&&&&&&&&&&&&%&&&&&&/#&&&&&&&&&&&&&&&&&&&&&&&%%/ .#%%%%%%%/  *%&#
//*#,#%,(&&&&&&&&&&(*(%%%%%%%%%%%/.#%%/#&%%%%%%*#%%%%%(.,#%#%/##(##%(*(((,*############%%##(#####/.#@@@@/. .  ,%&&%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%. *%&&&&&&&&&&&&&&&&&&&&&&&#. #%&%(#%%#. /%&%#
//*&%/..(&&&&&&&&&%*/#%%%%%%%%%%&(*#%(%%%%%%%%%%/#%%%%%%%%%%((&#((#%#(**  /######/*/%&&%%(**(##%/.%@@@#..  .   ,%&%%&&%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%&&%(.,.*%&&&&&&&&&&&&&&&&&&&&%%%,,#%%%(.*%%%##%%&%#
///&&&&##&&&(*%&&&#*/%&%%%%%%%%&%(,(#%%%%&&%%&%&#(#%%%%%%%%/(%%#/###/.    /####(/&@%.....(@@(*##.*&@@%,   . ... %@&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%&&/.(/ *&&&&&&&&&&&&&&&&&&&&&&#,,#%%%#//*%%%%%%%%%#
//*&&&&&&&%(((%&&&(*(%%%%%%%%%%%&#,/#%%%%%%%%%&%&%(#%%%%%#/#%%%%%#*. ..   ,###((&@( ..... ,&&/*#/ #@@%, .  .   ,@@&%%&%%%((///((%&&&&&&&&&&&&&&&&&%&&&&%*,(#*./&&&&&&&&&&&&&&&&&&&&&#,*%%%&#/#%*%%%%%%%%#*
//*&&&&&&%,%#/%&&%*/%&&%%%%%/.*%%%,/#%%%%%%%%%%%%%%%/(%%#(#%%%%#,    ..    (##/(@# .  .. . (@/,(#/.%@@#, .  ...,***//.      ..  . ,#&&%&&&&&&&&&&&&&&%(,/%%%/ /&&&&&&&&&&&&&&&&&&&%/,#%%%%#*#%#.(%%%&%%/##
///&&&&%(,&%((&&&(*/%&%%%&%%(/#./%*/%%%%%%%%%%&&&%%%%%(*/#%%%#*    .  ..   /(#((@# ..     .&&//####/..**,#((#((##(#/.             . (&%&&&&&&&&&&&&&(./%%%%%/ /&&&&&&&&&&&&&&&&&&&,/%%&%&(,&%%%,(&%%%(/%%#
//*&&&%//%&%/(&&&//(&%&&%%&%((%&( ./&&%%%%%%%%%&&&&%%%%%%%%%#. .   ...     ,###*#@( ... .(@&//%###(*,/#############/.           .  *%&&&&&&&&&&&&%*.#&&%/,#%%,.#&&&&&&&&&&&&&&&&#.##%%%%((%%%%&(*%%%/#%&%#
///&&&//%&&#/#&&%//%&&&&%%%%((&&&%**%&&&%%%%%%&&&&&%%%%%%%&( ........      (####,(@@@@@@@&*.%######################%#*           .,%&&&&&&&&&&&%,*#%%%#/#//%#&(.(&&&&&&&&&&&&&&#/%%&%%%(#&%%%%%%,#%(#%&&%#
//*&&(*%&%%((&&&#//%&&&&%&&%(#&&&&&(*%&&&&&&&&&&&&&&%&&%%%( .. .. ..      .#######(/*,*/(#########((####(/#%%##############(###%#*(&&&&&&&&&&%**#&%%&(/%%##((%%#######%%&&&@&&%/#%&%%#(%%&%%%%%&#,,%%&&&%#
///%(//%%&%((&&&#/(&&&&%&&&(#&@&&&&&(*%&&%&&&&&&&&&&&%%%%%*.  . . ...    .##########################(*,, ,/#%%%#%%####%%%%%#%#*,,%@&&&&&&&&%*,#%&&%(*%%/,/(((########(((* ,&&&(#%%%%%#%&%%%%%&&%&%%%&&&&&#
//*&%%%&&%%(#&&&#*(&&&&&&&##&&&&&&&&&(*%&&&&&&&&&&&&&%&%#/. . .   .. .  ,(#%#############################(,,,.,/((((((((/*,.,/&&@@&/#&&&&&/,#&&&&//%%&%*   .        .*/#%,/%###%%%%%%#%&%%%%%%%&&&&&&%&&&#
///&&%%&%&%(#&&&#,%&&&&%@##&&&&&&&&&&%//&&&&&&&&&&&&&&*.#&&(..    .   .(#######%#########################(.#&&&&%#((((#%&&&&@@@@&/  (&&&%*/%&&%(*%&&&%#,/&%#%%%&&&&&&&&&(.#&&&&%(*#&&&%%%%%%%&&&&&%&&%&&&#
///&&%%&%&&((&&&%*%&&&@&##&&&&&#&&&&&&(/#&&&&&&&&&&&&(./%%&#%#,...  /%%####%#%##%#%%#####################(.(%&&&&&&&&&&&&&&@&&@&/./,/%%#,*%%%%*#&&&&&&%*/%&&&&&&&&&&&&&&/,%(*#&&&&,(&&&%&%&&&&&&&&&&&&&@@%
///&&%%&%&&#/%&&&((&@@&#%&&&&&#(%&&&&&%*(&&&&&&&&&&&&/ #%%##%(*###/ *%######%%(/(########################(,,%&&&&&&&&&&&&&&&&@@(./&/.#%/,%&%&,%&&&&&&%%*/%&&&&&&&&&&&&@&//(/(/(&&&*.,*.  .. .......     . 
///&&%%&&&&%(%&&&%/&@&%&&&@&&&/##&&&&&&//#&&&&&&&&&&%..#%%###(,###, /%####/(##**#########################%/./&&&&&&&&&&&&&&&@&%*.&&#..%*,%&&#&&&&&%%##/*(&&&&&&&&&&&&&&%****/%&&&//&&&%%%%%%%%%%%%%####%&%
///&&%%&&&&%/(&&&&#(%%&&&&&&&##&##&&&&&//%&&&&&&&&&&%,.###%##/*##(. ######,(%#**#%%#####################%%#,.#&&&&&&&&&&&&&&&&# ,&&&%. .,%&&&%*.,/#%&&%/(&&&&&&&&&&&&&&#/%&&&&&(*#&%%%%%%%%%%%%%%%%%%%%%%#
///&&%%&&&%%((&&&&&#(&&&&&&&#%&&%(%&&&&/(%&&&&&&&&&&%*.######/.##(, /%####*/##*,(%####################%%%%%*.(&&&&&&&&&&&&&&&&# ,&&&%&%#%%*,/#%&%%&&%&%/(&&&&&&&&&&&&&&#(%&%%#%&%%%%%&&%%%%%%%%%%%%%%%%##(
//*&&&&&&%%&%/#@@&&&%%&&&&&##&&&%(%&&&&//%&&&&&&&&&&&/.######*.###* *#####(.(#(.,(######################%%%(./&&&&&&&&&&&&&&&&# .%%/,*#&(,#&%%%%%%%%%%&#/#%%%%%####%###/(%&&&&%%%&%%%%%%%%%%%%%%%%%%%%%%%#
//*&&&&&&&&%%#/%&&&&&&&&&&##&&&&%(&&&&&/(&&&&&&&&&&&&( /%####/,##((. (#####(./#(,,#((#((((((((###########%%/./&&&&&&&&&&&&&&&&%..#%(/%%/*.,*(#%%%%%&&%%%%%%&%%%%%%%%#%%%&%%%%%%%%&%%%%%%%%%%%%%%%%%%%%%%%#
//*&&&&&&%&%%&#(&&&&&@&&&(%&&&&&##&&&&%*(&&&&&&&&&&&&%,,####(/,(###( .(#####(*,(#/.,((((((((((((((((#####%(,.(&&&&&&&&&&&&&&&&&/.(&#.#%%(/%%&%(/*,*/###%&&&%%%%&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#
//*&&&&&&&%&%%&%/(&&&&&%(%&&&&&&(%&&&&#/(&&&&&&&&&&&&%,.(##(((**((###*./%###(#(,*##/  ,/(#((((##((((((####,    ,/&&&&&&&&&&&&&&( *%%*(%&#*#%%%%%%##%%&#####((*,..,,*///(#%&%&&%%%%%%%%%%%&&&&%%%&&%%%%&&&%
//*&&&&&&%%&&%%%%%/#&&&(#&&&&&&#(&&&&&(/#&&&&&&&&&&&&&#./###(((/**,..*, ,(##(###(/,.,*/,  .........,/##/   ,(###(.(&&&&&&&&&&&&#.*%%#,%%%//&&&%#####%%##%%%%%#######%%%%%%####%#((/(//*****////((####%&%&#
//*&&&&&&&&%%&&&&&&#((%/%&&&&&&((&&&&&(/%&&&&&&&&&&&&%#(,....,,,.,(#((##/. .,/(((((////((((((##(((((* ,/(#%#**((#,*%&&%%%&&&&&%(.*%%#,%%%%#/***((#####(###########(#############%%%%%%%%%##%%%%%%%%#%%#(#/
//*&%&&&&&&&&&&&&&&&&%((%&&%%&%/%&&&&%//%@&&%%%%%#%#####%%&&%%%,,(((((((((((/*,..          .,,.*(((((,*#((##*,(#(*.,*/((/,*%&&%*.(%%#,%%%%%%&&%%#((//*****////(((((#####(#(########################%%#%%%#
//*&%&&&&&&&&&&&&&&&&&&&&&&&&&#(&&&&&%//%@&&&%%%##(((((((((((##,./#(((((((((((((((((((((((#((((.,((((,*#(//(*./((((((((((/,#&%#,,#%%//%%##&&%%%&%%%%%%/,,,*,**/#(//////***/////////((################%%#,.
//*&%%&&&&&&&&&&&&&&&&&&&%&%&%/%&&&&&%//%&%%%#(((**////*/((#(((, ....,,,*////((((((((((#((((##(,.((((*.,/((, ,(((((((((/,*%&&%*.#%##/%%%#%&%#&&&&&&%%%/*/((%%(*%%#%#%%#//*%&&&%%%%###(//*********//***,/%%
//*&%%&&&&&&&&&&%%%&%%%%&%&%&%/%&&&&&%//&%##(##(*.*(((((((((((#####%&&#*((## */.      ,/.    .  .((((((((((*     *//(#%@@&&&&/,#%%#(#%%#%&&&&%%&&&&%%%/*#####/*#%%&&&#/%#*%&%%%%&&%%%%%#************#&@&&%
//*&%%&&&&&&&&&%%%%%%%%%&&&%%%/%&&&&&%//%&##%#%,(//&&(****/((/((/(%(#%(*(##(.#%/      **           .,,.          (%%#%%%&%%%(/%%%##%%%#%&&&&%##&&&&%%%/*(##%%(*#&%&%/(&&%*#&%%%%%&&&&%%(******///%&&&&&&&%
//*&%&%%&&&%%%&&%&&&%%%%%&%%%%*%&&&&&&//#&&&&#/%&#*#&%#%(////*//*/((((,,(((/.(##(((#&&&#.      /((((*.**/*.    * /(#%%###%%/(%%####%%&&&%(/#%#(&%%&&%%(*(####/*#&&(*#&&&&//%&%%&&#%&&%%#/**/*/#&&@&&&&&&&*
//*&%&%%&%%%&&%%%%%%%%%%%%%%%%*#&&&&&&%*(&&&((&&&%/(&&&#(((((///////((,,(((*,##((((#&##(.      /##((*,(#((*   ,( /((##(##/(#&@&#####(/(#%%%%(#%%%%%%%%(*(#%%%(*#(*#&&&&&&/*%%%%%%(%&%%%%(**#&&&&&&&&&&%,(#
//*&&&%%&&&&&%&&%%%%%%%%%%&%&%/#&&&&&&&//%&(#&&&&&(*%%##(/(((((////(((,,(((/,##((((/((#(.      *#(((*./(((,  ./* ((((#(//(%%##/***/(###%##((##((((((%%#*#%%%%(*(%&&&&&&&&/*#%%%%(%%%%%(*/%&&&&&&@&&&%/(%&#
//*&%%%%%&&%%%%&%%%%%%%%#%%%%%(/&&&&&&&&/(((&&&&&&#*#&&%(((((////(((((,,(((*,##(((//(((/. .    ,#(((*,(((/,  ,(/ (((((((((((((((((((((((/*/((###(//(#%(*#%(*/#&&&&&&&&&&&#*(%%#((#%#/*(&&&&&&&&&&@&#/%&&&#
//*&%%%%%%%%%%%%%%%%%%%%##%%%%#*%&&&&&&&%/*(&&&%&&&//&&%(//((/*/((((((,,(((*.(#(/*,**/((.    . ,((((*,(((/. .*(/ /((((((((((((((((((((((((#(((((((((#%%/,/%&&&&&&&&&&&&&&%,(%%###(*/#&&&&&&&&&&&&%/#&&&&&#
//*&%%%%%&%%%##%%%%%%%%&##%%%%&((&&&&&&&&&/(&&(((&&#*#&&#%%(,,,*(###((,,(((*.#((/**,,**/.       /(((*,/((/. ./(/ /(((((((((((((((((((((((((((((((####*/#&@&&&&&&%&&&&&&&&%,/%%%(**%&&&&&&&&&&&&&//&&%&&&&#
//*&%%%%%%%%%%(%%%%%%%%%%(%%%%&%/#&&&&@@&@&&&/#&(%&&#*#@@&/(&(.(&%#(%#,,(((*,((((((/((((.       /(((*,((((. ,((/ /((((((((/(((((((((((((((((((##(/**#&&&&&&&&#/(*#&&&&&&&&,/%%*/%&&&&&&&&&&&&&#/%&&%&&%&&#
//*%%%%%%%%%%%/#%&%%#%%&%%(%%%&%%//&&&&&&&&%/#&&(#&&&#*#&((&&(,(&%#(##*,(((*.((((((((((#*     ,./((/,/((((, ./(/ /#((((((((((((((((((((((((###(**#&&&&&&&&&((%&%/#&&&&&&&&**//%&&&&&&&&&&&&&#/#&%&&&&%&&&#
//*%%%%%%%(%%%(#%%%%##%%%%#(%%%%&&#/(%&&&&(/%&&&##&&&@%/*/%&@%*#&%###(/,/((/,##((((((((#(    ./,/#((,/#((#* .(## /#((((((##((((((/////(((#%&#//%&&&&@&&&&#(&%&%&%*%&&&&&&&**(%&&&&&&&&&&&&(/%&&&&&&&&&&&&#
//*%%%%%%%##%%#(%%%%%##%%%%##%&&%&%%#**#(/#%%&%&&#%&&@&&##&&&&/*#%###((,,**,*(((((((((((###(##(,,%%#,/##(#(*,... /###((((#((((##((((((#####//%@&&&&&&&&%#&&&%&%%&%*#&&&&&&#(%&&&&&&&&&%(/%&&&&%&&&&&&&&&%#
//*%%%%%#%%(%%%(%&%%%%#%%%%%##%%%%%%%%&%%%%%%%%&&%(%&&&&&&&&&@%//##(((###(((((/((((/((((//(((#%#*/(#%##((((((((((((((/((/(/(((/(((((#####(/%&@&&&&&&&&(#&&&&&%&&&%&((&&&&&&&&&&&&&&&#/#&&&%&&&&&&&&&&&&&&#
//*%%%%%(#%##%%##&%%%%%(#%%%%%%%%%%%%%%%%%%%%%%%&&&##&@&&&&&&@&&%###(((((///////////(((((///(((#%#((((((((((((((((((((((((((#(((((((((##*/&&&@&&&&&&##&&&&&&&&&&&&&&%(/(&&&&&&@@@&(*%&&&&&&&&&&&&&&&&&&&&#
//*%%%%%%*#%#%%#(%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&@&&&&&&%(%&&#(((((((((((((((///(((((((((((((((((((((((((/***/((((((#(((((((((##(#/,(&&&@&&&&&&(#&&&&&&&&&&&&&&&&&&&%,,#&&&&&.%&&&&%&&&&&&&&&&&&&&&&&#
//*%%%%%%%(%%%%%#(%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&%#(*,,/#&&%(((////(((/(//////(//(((((//((((((((((((((((((((((((((((/////(((((#((((*,#&&&&&&&&&%(%%&&&&&&&&&&&&&&&%&%%%&&%(*,**%&&%&%%%%&&&&&&&&&&&&%&&#
//,%%%%%%%%%%%%%%%%&%%%%%%%%%%%%%%%%%%%%%%%%#(/,.*/(((/#//((////////////((((((((///((((((((((((((((((((((((((((((((((#((((((((((((##*.#&&&&&&&@&%(%&%%%%%%&%%%%%%%&%%%%%%%%%&&&%%&%%%%%%%&&&&&&&&&&&&&&&&#