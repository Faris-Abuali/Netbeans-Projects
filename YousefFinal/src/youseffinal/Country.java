
package youseffinal;

/**
 *
 * @author Yousef Abuali
 */
public class Country {
    
    private int populationSize, area;
    private String name, abbreviation, capital, currency;

    static String allABBRS = "";
    
    public Country(){
        
    }
    
    public Country(String name, String capital, String curreny, int popSize, int area){
        this.name = name;
        this.abbreviation = name.substring(0,2).toUpperCase();
        this.capital = capital;
        this.currency = curreny;
        this.populationSize = popSize;
        this.area = area;  
    }
    
    
   // ========= Setters:=============
    public void setPopulationSize(int populationSize){
        this.populationSize = populationSize;
    }
    
    public void setArea(int area){
        this.area = area;
    }
    
    public void setCapital(String capital){
        this.capital = capital;
    }
    
    public void setCurrency(String currency){
        this.currency = currency;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    //============ Now Getters: =================
    
    public int getPopulationSize(){
        return this.populationSize;
    }
    
    public int getArea(){
        return this.area;
    }
    
    public String getCapital(){
        return this.capital;
    }
    
    public String getCurrency(){
        return this.currency;
    }
    
    public String getABBR(){
        return this.abbreviation;
    }
    
    
    @Override
    public String toString(){
        
        String str = "[Name = " + this.name + ", ABBR. = " + this.abbreviation + ", Capital = " + this.capital
                + ", Currency = "+ this.currency + ", PopSize = " + this.populationSize +", Area = " + this.area + "km2" + "]";
        return str;
    }
    
    
    @Override
    public boolean equals(Object obj){
        
        boolean flag = false;
        
         if (this == obj) {
            flag = true;
            return flag; // no need to continue because I am comparing the object with itself, so I am sure they are equal
        }
         
         /* Check if o is an instance of Country or not*/
        if ((obj instanceof Country) == false) {
            flag = false;
            return flag; //the 2 objects MUST be of same class to be equal
        }
        
        //Make casting to the obj in order to be able to call methods of Country class 
        Country co = (Country) obj;
         
         if((this.populationSize == co.populationSize) && (this.abbreviation == co.abbreviation)){
             flag = true;
         }
         
        return flag;
    }
    
    public void changeABBR(Country c){
        
        //In case of duplication with other country's abbr,
        //here I add the last letter of the country's name in order to make the abbreviation unique.
       String lastLetter = c.name.substring(c.name.length()-1, c.name.length());
       lastLetter = lastLetter.toUpperCase();
       
       c.abbreviation = c.abbreviation + lastLetter; 
    }   
    
}// end class
