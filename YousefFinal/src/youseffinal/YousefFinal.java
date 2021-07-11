package youseffinal;

import java.util.Scanner;

/**
 *
 * @author Yousef Abuali
 */
public class YousefFinal {

    
    public static void main(String[] args) {
        
       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter how many countries you want to add?");
        int size = sc.nextInt(); //size of the array of objects
        Country arr[] = new Country[size];

        
        for(int i=0; i<size;i++){
     
            int populationSize, area;
            String name, abbreviation, capital, currency;
            
            System.out.println("Country #"+i);

            System.out.println("Enter Country's Name: ");
            name = sc.next();

            System.out.println("Enter Capital: ");
            capital = sc.next();

            System.out.println("Enter Currency: ");
            currency = sc.next();

            System.out.println("Enter Number of Population: ");
            populationSize = sc.nextInt();

            System.out.println("Enter Country's Area in km2: ");
            area = sc.nextInt();


            arr[i] = new Country(name, capital, currency, populationSize, area);
        }
        
//        System.out.println(Country.allABBRS);
//        Country c = new Country("Palestine", "Jerusalem", "Shekel", 5000000, 80000);
//        System.out.println(arr[0].toString());


        for(int i=0; i<size;i++){
             
            //Display countries whose area is greater than 10000 km2.
            if(arr[i].getArea() > 10000){
                makeAbbrUnique(arr[i], arr);
                System.out.println(arr[i].toString());
            }
        }
        
}//end main
    
    
    public static void makeAbbrUnique(Country currentCountry, Country[] arr){
        
        /*
             if two countries have the same abbreviation add the
            last letter from the country name to the abbreviation of the country inserted last
        */
        
        for(int i=0;i<arr.length;i++){
            if(arr[i].getABBR().equals(currentCountry.getABBR())){
                currentCountry.changeABBR(currentCountry);
                return;
            }
        }
    }// end method
    
}// end Main class
