package model;

public class Document{

   private double price;
   private int year;
   private int[][] code;

   public Document(double price, int year, int[][] code){

    this.price = price;
    this.year = year;
    this.code = code;

   }
       
    public int[][] fillMatrix(int row, int column){
        int[][] code = new int[row][column];

    for (int i=0; i<row  ; i ++) {
        for (int j=0; j<column  ; j++) {
            int random = (int)(Math.random()*(10));
            code[i][j]=random;
          }
      }
      return code;
   }

   public String toString(){

    String out;

    out = "Price of the property card is: " + price + "\nyear of the property card: " + year + "\nDecode: " + decodeO(code);
    
    return out;
   }

   public String decodeO(int[][] code) {

    String decode ="";
      for(int i = code.length-1; i>=0; i--){
        for(int j= code[0].length-1; j>=0;j--){
           if((i+j)%2==0 && (i+j)!=0){
            decode += " "+code[i][j];
            }
        }
      }
    return decode;
 
  }
    
    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return int return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return int[][] return the code
     */
    public int[][] getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int[][] code) {
        this.code = code;
    }

}


