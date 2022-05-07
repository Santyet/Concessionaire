package model;

public abstract class Car extends Vehicle {

    private int doorNum;
    private boolean polarized;
    private CarType carType;

    public Car(double basePrice, double sellPrice, String brand, int model, int cylinderCapacity, double mileage,
            boolean used, String vehicleRegistration, SOAT soat, TechnicalMechanicalReview technicalMechanicalReview, Document propertyCard,
            int doorNum, boolean polarized, CarType carType){
        super(basePrice, sellPrice, brand, model, cylinderCapacity, mileage, used, vehicleRegistration, soat,
                technicalMechanicalReview, propertyCard);
                this.doorNum = doorNum;
                this.polarized = polarized;
                this.carType = carType;
    }
    

    /**
     * @return int return the doorNum
     */
    public int getDoorNum() {
        return doorNum;
    }

    /**
     * @param doorNum the doorNum to set
     */
    public void setDoorNum(int doorNum) {
        this.doorNum = doorNum;
    }

    /**
     * @return boolean return the polarized
     */
    public boolean isPolarized() {
        return polarized;
    }

    /**
     * @param polarized the polarized to set
     */
    public void setPolarized(boolean polarized) {
        this.polarized = polarized;
    }

    /**
     * @return CarType return the carType
     */
    public CarType getCarType() {
        return carType;
    }

    /**
     * @param carType the carType to set
     */
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

}
