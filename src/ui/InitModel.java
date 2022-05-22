package ui;

import model.*;
import java.util.ArrayList;

public class InitModel {

    private ArrayList<Vehicle> vehicles;
    
    public InitModel() { }

    public ArrayList<Vehicle> createVehicles(){

        int[][] code = new int [5][5];
        for(int i = 0; i<5; i++){
            for(int j = 0; i<5; i++){
                code[i][j] = i;
            }
        }

        SOAT soat = new SOAT(1345436, 1234, code, 123);
        TechnicalMechanicalReview technicalMechanicalReview = new TechnicalMechanicalReview(2, 4321, code, 321);
        Document propertyCard = new Document(3, 2314, code);

        vehicles = new ArrayList<Vehicle>();

		vehicles.add(new HybridCar(500000, 600000, "Toyota",
         2000, 450, 10, 30000, 1000, true, "ABC123",
          soat, technicalMechanicalReview, propertyCard, 2,
           true, CarType.SEDAN, 20.0, 4.0, GasType.DIESEL, ChargerType.NORMAL));


        vehicles.add(new GasCar(750000, 1000000, "Mazda",
         1990, 900, 0, 0, false, "",
          soat, technicalMechanicalReview, null, 2,
           true, CarType.PICKUP_TRUCK, 7.3,GasType.EXTRA));
           
        
        vehicles.add(new ElectricCar(1000000, 1430000, "Volvo",
         2054, 1500, 12000, true, "DEF456",
          soat, technicalMechanicalReview, propertyCard, 3,
           false, CarType.PICKUP_TRUCK, 100.1, 1, ChargerType.FAST));

        vehicles.add(new Motorcycle(250000, 400000, "Kawasaki",
         22, 2002, 100, 0, false, "",
          soat, technicalMechanicalReview, null, 20.0, MotorcycleType.CROSS, GasType.REGULAR));
		

        return vehicles;
    }
    
}
