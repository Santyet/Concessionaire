package model;

import java.util.Calendar;

public class Motorcycle extends Vehicle implements ICalculateGasUsage{

    private double fuelCapacity;
    private double fuelUsage;
    private MotorcycleType motorcycleType;
    private GasType gasType;

    public Motorcycle(double basePrice, double sellPrice, String brand, double fuelUsage, int model, int cylinderCapacity,
            double mileage, boolean used, String vehicleRegistration, SOAT soat, TechnicalMechanicalReview technicalMechanicalReview,
            Document propertyCard, double fuelCapacity, MotorcycleType motorcycleType, GasType gasType) {
        super(basePrice, sellPrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, soat,
                technicalMechanicalReview, propertyCard);
                this.fuelCapacity = fuelCapacity;
                this.fuelUsage = fuelUsage;
                this.motorcycleType = motorcycleType;
                this.gasType = gasType;

    }

    @Override
    public double calculateSellingPrice(int soatYear, int tmrYear, boolean used) {

        int actualYear = Calendar.getInstance().get(Calendar.YEAR);

        double totalPrice = super.getBasePrice() * 1.04;

        if(soatYear<actualYear | tmrYear<actualYear){

            totalPrice+=500000;

        }

        if(used){
            totalPrice = totalPrice-(super.getBasePrice()*0.02);
        }

    return totalPrice;
    }

    @Override
    public double calculateGasUsage() {

        return (fuelCapacity)*(super.getCylinderCapacity()/75);
    }

    public String toString() {
        String out = "\nThis is a motorcycle\n"; 
        out+= super.toString();
        out += "\nCapacity of the tank: " + fuelCapacity+ "\nFuel consumption: "+ fuelUsage;

        switch(motorcycleType){

            case STANDARD:
                out += "\nMotorcycle type: Standard\n";
            break;

            case SPORT:
                out += "\nMotorcycle type: Sport\n";
            break;

            case SCOOTER:
                out += "\nMotorcycle type: Scooter\n";
            break;

            case CROSS:
                out += "\nMotorcycle type: Cross\n";
            break;

        }
      
        return out;
    }
    

    /**
     * @return double return the fuelCapacity
     */
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * @param fuelCapacity the fuelCapacity to set
     */
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * @return double return the fuelUsage
     */
    public double getFuelUsage() {
        return fuelUsage;
    }

    /**
     * @param fuelUsage the fuelUsage to set
     */
    public void setFuelUsage(double fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    /**
     * @return MotorcycleType return the motorcycleType
     */
    public MotorcycleType getMotorcycleType() {
        return motorcycleType;
    }

    /**
     * @param motorcycleType the motorcycleType to set
     */
    public void setMotorcycleType(MotorcycleType motorcycleType) {
        this.motorcycleType = motorcycleType;
    }

    /**
     * @return GasType return the gasType
     */
    public GasType getGasType() {
        return gasType;
    }

    /**
     * @param gasType the gasType to set
     */
    public void setGasType(GasType gasType) {
        this.gasType = gasType;
    }

}
