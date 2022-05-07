package model;
import java.util.Calendar;

public class ElectricCar extends Car implements ICalculateBatteryUsage{

    private double batteryDuration;
    private ChargerType chargerType;
    private double batteryUsage;

    public ElectricCar(double basePrice, double sellPrice, String brand, int model, int cylinderCapacity,
            double mileage, boolean used, String vehicleRegistration, SOAT soat, TechnicalMechanicalReview technicalMechanicalReview,
            Document propertyCard, int doorNum, boolean polarized, CarType carType, double batteryDuration, double batteryUsage, ChargerType chargerType) {
        super(basePrice, sellPrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, soat,
                technicalMechanicalReview, propertyCard, doorNum, polarized, carType);
                this.batteryDuration = batteryDuration;
                this.chargerType = chargerType;
                this.batteryUsage = batteryUsage;
    }

    @Override
    public double calculateSellingPrice(int soatYear, int tmrYear, boolean used) {
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);

        double totalPrice = super.getBasePrice() * 1.20;

        if(soatYear<actualYear | tmrYear<actualYear){

            totalPrice+=500000;

        }

        if(used){
            totalPrice = totalPrice-(super.getBasePrice()*0.1);
        }

    return totalPrice;
    }

    @Override
    public double calculateBatteryUsage(ChargerType chargerType) {
        
        double usage;

        if(chargerType == ChargerType.NORMAL){

            usage = (batteryDuration+13)*(super.getCylinderCapacity()/100);
        }else{

            usage = (batteryDuration+18)*(super.getCylinderCapacity()/100);
        }
        return usage;
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

}
