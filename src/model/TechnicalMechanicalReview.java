package model;

public class TechnicalMechanicalReview extends Document{

    private double gasLevels;

    public TechnicalMechanicalReview(double price, int year, int[][] code, double gasLevels) {
        super(price, year, code);
        this.gasLevels = gasLevels;
    }
    
    public String toString(){

        String out;
    
        out = "Price of the technical mehcanical review is: " + super.getPrice() + "\nyear of the technical mechanical review: " + super.getYear() +
        "\nDecode of the image: ";
        
        return out;
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
