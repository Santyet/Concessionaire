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

   /* String[][] matriz = rellenandoLaMatriz(4,4);
    
       
    public static String[][] rellenandoLaMatriz(int fila, int columna){
        String[][] code = new String[fila][columna];

    for (int i=0; i<fila  ; i ++) {
        for (int j=0; j<columna  ; j++) {
            int random = (int)(Math.random()*(10));
            matriz[i][j]=""+random;
        }
    }

    for (int i=0; i<fila  ; i ++) {
        for (int j=0; j<columna  ; j++) {
            System.out.print(matriz[i][j]);
        }
      System.out.println();
    }
    
    return matriz;
    }    
    
     public static void recorridoEnL(String[][] matriz) {
    
      //////RECORRIDO EN L 
        ////// Las columnas se quedan "fijas" y las filas son las que cambian 
        String dato ="";
          for(int i = 0; i<matriz.length; i++){
            dato += " "+matriz[i][0];
          }
    
        ////// Las filas se quedan "fijas" y las columnas son las que cambian (iniciando en 1)
          for (int i = 1; i < matriz[0].length; i++){
            dato += " "+matriz[matriz.length-1][i];
          } 
      System.out.println("Recorrido en l "+dato);
      }
    
    
       public static void recorridoEnZ(String[][] matriz) {
    
        //////RECORRIDO EN Z
        ////// Primer paso -> Recorremos la primera fila
       /////// Las columnas cambian y la fila se queda "fija"
        String dato ="";
          for(int i = 0; i<matriz[0].length; i++){
            dato += " "+matriz[0][i];
          }
         
        ////// Segundo paso -> Recorremos la primera fila
        ////// Las filas se quedan "fijas" y las columnas son las que cambian (iniciando en 1)
         int k=1;
            for(int j = matriz[0].length -2 ; j>0; j--){ //// COLUMNAS
               dato += " "+matriz[k][j];
              if(k<matriz.length -1 ){
                k++;
              }
                
            }
         for(int i = 0; i<matriz[0].length; i++){
            dato += " "+matriz[matriz.length-1][i];
          }
      System.out.println("Recorrido en z"+dato);
      }
      public static void recorridoRaro(String[][] matriz) {
        //////RECORRIDO EN L 
        ////// Las columnas se quedan "fijas" y las filas son las que cambian 
        String dato ="";
          for(int i = matriz.length-1; i>=0; i--){
            for(int j= matriz[0].length-1; j>=0;j--){
               if((i+j)%2==0 && (i+j)!=0){
                dato += " "+matriz[i][j];
                }
            }
          }
          System.out.println("Recorrido raro"+dato);
     
      }
    */
    
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


