package model;
import java.util.Calendar;

public class GasCar extends Car implements ICalculateGasUsage{

    private double fuelCapacity;
    private double fuelUsage;
    private GasType gasType;

    public GasCar(double basePrice, double sellPrice, String brand, double fuelUsage, int model, int cylinderCapacity,
            double mileage, boolean used, String vehicleRegistration, SOAT soat, TechnicalMechanicalReview technicalMechanicalReview,
            Document propertyCard, int doorNum, boolean polarized, CarType carType, double fuelCapacity, GasType gasType) {
        super(basePrice, sellPrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, soat,
                technicalMechanicalReview, propertyCard, doorNum, polarized, carType);
                this.fuelCapacity = fuelCapacity;
                this.fuelUsage = fuelUsage;
                this.gasType = gasType;
        
    }

    @Override
    public double calculateSellingPrice(int soatYear, int tmrYear, boolean used) {
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);

        double totalPrice = super.getBasePrice();

        if(used & (soatYear<actualYear | tmrYear<actualYear)){

            totalPrice+=500000;

        }

        if(used){
            totalPrice = totalPrice-(super.getBasePrice()*0.1);
        }

    return totalPrice;

    }

    @Override
    public double calculateGasUsage() {

        return (fuelCapacity)*(super.getCylinderCapacity()/150.0);
    }

    public String toString() {
        String out = "\nThis is a gasoline car\n";
        out+= super.toString();
        out += "\nCapacity of the tank: " + fuelCapacity+ 
        "\nFuel consumption: "+ fuelUsage;

        switch(gasType){

            case EXTRA:
                out += "\nGasoline type: Extra\n";
                break;

            case DIESEL:
                out += "\nGasoline type: Regular\n";
                break;

            case REGULAR:
                out += "\nGasoline type: Diesel\n ";
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
