package model;

public class SOAT extends Document{

    private double coverageCost;

    public SOAT(double price, int year, int[][] code, double coverageCost) {
        super(price, year, code);
        this.coverageCost = coverageCost;
    }
    
    public String toString(){

        String out;
    
        out = "Price of the SOAT is: " + super.getPrice() + "\nyear of the SOAT: " + super.getYear() 
        + "\nSOAT coverage cost: " + coverageCost  + "\nDecode: " + decodeL(super.getCode()) + "\n";
        
        return out;
    }

    public String decodeL(int[][] code) {
     
        String decode = "";
  
          for(int i = 0; i<code.length; i++){
            decode += " "+code[i][0];
          }
    
          for (int i = 1; i < code[0].length; i++){
            decode += " "+code[code.length-1][i];
          } 
      
      return decode;
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
