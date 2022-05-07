package model;

public class SOAT extends Document{

    private double coverageCost;

    public SOAT(double price, int year, int[][] code, double coverageCost) {
        super(price, year, code);
        this.coverageCost = coverageCost;
    }
    

    /**
     * @return double return the coverageCost
     */
    public double getCoverageCost() {
        return coverageCost;
    }

    /**
     * @param coverageCost the coverageCost to set
     */
    public void setCoverageCost(double coverageCost) {
        this.coverageCost = coverageCost;
    }

}
