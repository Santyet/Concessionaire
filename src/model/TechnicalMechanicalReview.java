package model;

public class TechnicalMechanicalReview extends Document{

    private double gasLevels;

    public TechnicalMechanicalReview(double price, int year, int[][] code, double gasLevels) {
        super(price, year, code);
        this.gasLevels = gasLevels;
    }
    
    

    /**
     * @return double return the gasLevels
     */
    public double getGasLevels() {
        return gasLevels;
    }

    /**
     * @param gasLevels the gasLevels to set
     */
    public void setGasLevels(double gasLevels) {
        this.gasLevels = gasLevels;
    }

}
