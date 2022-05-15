package model;

public class TechnicalMechanicalReview extends Document{

    private double gasLevels;

    public TechnicalMechanicalReview(double price, int year, int[][] code, double gasLevels) {
        super(price, year, code);
        this.gasLevels = gasLevels;
    }
    
    public String toStringa(){

        String out;
    
        out = "Price of the technical mehcanical review is: " + super.getPrice() + "\nYear of the technical mechanical review: " + super.getYear() 
        + "\nGas levels of the vehicle: " + gasLevels + "\nDecode: " + decodeZ(super.getCode()) + "\n";
        
        return out;
    }
    
    public String decodeZ(int[][] code) {
    
       String decode ="";

       if(code!=null){
        
          for(int i = 0; i<5; i++){
            decode += " "+code[0][i];
          }
         
         int k=1;
            for(int j = 5 -2 ; j>0; j--){
               decode += " "+code[k][j];
              if(k<5-1 ){
                k++;
              }
                
            }
         for(int i = 0; i<5; i++){
            decode += " "+code[5-1][i];
          }

       }else{

        decode = "None";

       }
        
     
          return decode;
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
