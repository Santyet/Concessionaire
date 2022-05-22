package model;
import java.util.Calendar;

public class HybridCar extends Car implements ICalculateBatteryUsage,ICalculateGasUsage{

    private double fuelCapacity;
    private double fuelUsage;
    private double batteryDuration;
    private double batteryUsage;
    private GasType gasType;
    private ChargerType chargerType;

    public HybridCar(double basePrice, double sellPrice, String brand, int model, double fuelUsage, double batteryUsage, int cylinderCapacity,
            double mileage, boolean used, String vehicleRegistration, SOAT soat, TechnicalMechanicalReview technicalMechanicalReview,
            Document propertyCard, int doorNum, boolean polarized, CarType carType, double fuelCapacity,
            double batteryDuration, GasType gasType, ChargerType chargerType) {
        super(basePrice, sellPrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, soat,
                technicalMechanicalReview, propertyCard, doorNum, polarized, carType);
                this.fuelCapacity = fuelCapacity;
                this.fuelUsage = fuelUsage;
                this.batteryDuration = batteryDuration;
                this.batteryUsage = batteryUsage;
                this.gasType = gasType;
                this.chargerType = chargerType;

    }


	@Override
    public double calculateSellingPrice(int soatYear, int tmrYear, boolean used) {
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);

        double totalPrice = super.getBasePrice() * 1.15;

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
   
        return (fuelCapacity)*(super.getCylinderCapacity()/180.0);
    }


    @Override
    public double calculateBatteryUsage(ChargerType chargerType) {
        double usage;

        if(chargerType == ChargerType.NORMAL){

            usage = batteryDuration*(super.getCylinderCapacity()/200);
        }else{
            usage = (batteryDuration+7)*(super.getCylinderCapacity()/200);
        }
        return usage;
    }
    
    public String toString() {
        String out = "\nThis is a hybrid car\n";
        out += super.toString();

        out += "\nCapacity of the tank: " + fuelCapacity+
         "\nFuel consumption: "+ fuelUsage +
          "\nBattery duration: " +batteryDuration +
            "\nBattery consumption: "+ batteryUsage + 
            "\nCharger type: " + chargerType +
            "\nGasoline type: " + gasType;

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
     * @return double return the batteryDuration
     */
    public double getBatteryDuration() {
        return batteryDuration;
    }

    /**
     * @param batteryDuration the batteryDuration to set
     */
    public void setBatteryDuration(double batteryDuration) {
        this.batteryDuration = batteryDuration;
    }

    /**
     * @return double return the batteryUsage
     */
    public double getBatteryUsage() {
        return batteryUsage;
    }

    /**
     * @param batteryUsage the batteryUsage to set
     */
    public void setBatteryUsage(double batteryUsage) {
        this.batteryUsage = batteryUsage;
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

    /**
     * @return ChargerType return the chargerType
     */
    public ChargerType getChargerType() {
        return chargerType;
    }

    /**
     * @param chargerType the chargerType to set
     */
    public void setChargerType(ChargerType chargerType) {
        this.chargerType = chargerType;
    }

}
