package model;

public abstract class Vehicle {

    private double basePrice;
    private double sellPrice;
    private String brand;
    private int model;
    private int cylinderCapacity;
    private double mileage;
    private boolean used;
    private String vehicleRegistration;
    private SOAT soat;
    private TechnicalMechanicalReview technicalMechanicalReview;
    private Document propertyCard;

    public Vehicle(double basePrice, double sellPrice, String brand, int model, int cylinderCapacity,
     double mileage, boolean used, String vehicleRegistration, SOAT soat, TechnicalMechanicalReview technicalMechanicalReview, Document propertyCard) {
        this.basePrice = basePrice;
        this.sellPrice = sellPrice;
        this.brand = brand;
        this.model = model;
        this.cylinderCapacity = cylinderCapacity;
        this.mileage = mileage;
        this.used = used;
        this.vehicleRegistration = vehicleRegistration;
        this.soat = soat;
        this.technicalMechanicalReview = technicalMechanicalReview;
        this.propertyCard = propertyCard;
    }

    public abstract double calculateSellingPrice(int soatYear, int tmrYear, boolean used);

    public String toString(){

        String out = "";

        out = "Vehicle brand: " + brand + "\nVehicle model: " + model + "\nVehicle cylinder capacity: " +
        cylinderCapacity + "Used: " + used + "\nVehicle mileage" + mileage + "\nVehicle registration: " + vehicleRegistration
        + "\nVehicle base Price: " + basePrice;
        return out;

    }

    /*public String decodeL(){
    
        //////RECORRIDO EN L 
        ////// Las columnas se quedan "fijas" y las filas son las que cambian 
        String dato ="";
        for(int i = 0; i<5; i++){
            dato += " "+code[i][0];
            }
          
        ////// Las filas se quedan "fijas" y las columnas son las que cambian (iniciando en 1)
        for (int i = 1; i < matriz[0].length; i++){
            dato += " "+matriz[5-1][i];           
            } 
    }
    */

    /**
     * @return double return the basePrice
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice the basePrice to set
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * @return double return the sellPrice
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * @param sellPrice the sellPrice to set
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * @return String return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return int return the model
     */
    public int getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(int model) {
        this.model = model;
    }

    /**
     * @return int return the cylinderCapacity
     */
    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    /**
     * @param cylinderCapacity the cylinderCapacity to set
     */
    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    /**
     * @return double return the mileage
     */
    public double getMileage() {
        return mileage;
    }

    /**
     * @param mileage the mileage to set
     */
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    /**
     * @return boolean return the used
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * @param used the used to set
     */
    public void setUsed(boolean used) {
        this.used = used;
    }

    /**
     * @return String return the vehicleRegistration
     */
    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    /**
     * @param vehicleRegistration the vehicleRegistration to set
     */
    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    /**
     * @return SOAT return the soat
     */
    public SOAT getSoat() {
        return soat;
    }

    /**
     * @param soat the soat to set
     */
    public void setSoat(SOAT soat) {
        this.soat = soat;
    }

    /**
     * @return TechnicalMechanicalReview return the technicalMechanicalReview
     */
    public TechnicalMechanicalReview getTechnicalMechanicalReview() {
        return technicalMechanicalReview;
    }

    /**
     * @param technicalMechanicalReview the technicalMechanicalReview to set
     */
    public void setTechnicalMechanicalReview(TechnicalMechanicalReview technicalMechanicalReview) {
        this.technicalMechanicalReview = technicalMechanicalReview;
    }

    /**
     * @return Document return the propertyCard
     */
    public Document getPropertyCard() {
        return propertyCard;
    }

    /**
     * @param propertyCard the propertyCard to set
     */
    public void setPropertyCard(Document propertyCard) {
        this.propertyCard = propertyCard;
    }

}
