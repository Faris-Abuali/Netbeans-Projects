
package separatethenumbers;

import java.util.ArrayList;
import java.util.Scanner;

public class SeparateTheNumbers 
{
    static Scanner in = new Scanner(System.in);
   
    
    public static long first$secondDigit(long TheRest)  // a recursive function 
    {
        if(TheRest/10<10)
            return TheRest;
        return first$secondDigit(TheRest/10);
        
    }
    
    public static void main(String[] args) 
    {
        int q; // number of strings 
        q=in.nextInt();
        
       ArrayList <String> arr=new ArrayList<String>(q); // create a vector(or arraylist) I will store the outputs in it
          
       for(int Q=0;Q<q;Q++)
       {
        boolean FailedInTheFirstTest=false,FailedInTheSecondTest=false,IEnteredTheSecondTest=false,susbect=false;
             
       long first=0,TheRest; /**/
       int SubStringSize=1;
       
        String s;
        s=in.next();
        
        
     
        int iterations = s.length()/2;
        boolean TryNextSize=false;
        int i;
if(s.charAt(0)=='0')
{iterations=0;}
else
{
        while(iterations>0)
        {
            
             TryNextSize = false;
             FailedInTheFirstTest=false;
             FailedInTheSecondTest=false;
             
            for(i=0 ; i< s.length() / SubStringSize - 1/**/&& (i*SubStringSize+2*SubStringSize)<=s.length() ; i++)
            {
               first = Long.valueOf(s.substring( i * SubStringSize , i * SubStringSize + SubStringSize));
               TheRest = Long.valueOf(s.substring( i*SubStringSize+SubStringSize , i*SubStringSize+2*SubStringSize));
                
                
//               System.out.println("first = "+first+" TheRest = "+TheRest);
//                 System.out.println("Now i = "+i+" and size = "+s.length()+" and SubSize = "+SubStringSize);
                 
                int Ihteyat = i*SubStringSize+SubStringSize;
               //Now The First Test
                    if(TheRest-first!=1)
                    {
                        if( i!=0/*s.length() / SubStringSize - 1-1*/ && TheRest-first==0)                      
                       iterations=0;
                  
                        SubStringSize++;
                        TryNextSize = true;
                        FailedInTheFirstTest=true;

                        
                    }
                   
             //And Now The Second Test
                    if(first%10==9  &&  first$secondDigit(TheRest)==10 || first==9 && first$secondDigit(TheRest)==1)
                    { IEnteredTheSecondTest=true;
                        TryNextSize=false;
                        
                        TheRest*=10;
                        
                        
                        for(int k=0;k<s.length() / SubStringSize - 1 && (Ihteyat+2*SubStringSize + k*SubStringSize)<=s.length()/**/ ; k++)
                        {
                            
                            first=TheRest;
                            TheRest=Long.valueOf(s.substring(Ihteyat+SubStringSize + k*SubStringSize ,Ihteyat+2*SubStringSize + k*SubStringSize));
         
                            
                            if(TheRest-first!=1)
                            {
                                FailedInTheSecondTest=true;
                               iterations=0;
                                break;
                            }
                            
                            
                        }
                        
                    }

                   
                    
                    if(TryNextSize==true || IEnteredTheSecondTest==true) 
                    {break;}
                        
            }
            
            if(s.length()%SubStringSize!=0 && i>= s.length() / SubStringSize - 1 && IEnteredTheSecondTest==false  )// fired from the FOR LOOP
            {
             iterations=0;
              break;
           }
                
            if(TryNextSize==false && FailedInTheFirstTest==false)
            { first = Long.valueOf(s.substring(0,SubStringSize));
                break; // break from the while loop because I am sure that the string is BEAUTIFUL
            } 
            if(TryNextSize==false && FailedInTheFirstTest==true)
            {
                 first = Long.valueOf(s.substring(0,SubStringSize - 1));
                 break;
            }
            
            iterations--;
        }
}

        if(iterations<=0 ) 
            arr.add("NO");   //System.out.println("NO") NOT NOW THE PRINT ;
            
        else
            arr.add("YES "+first);   //System.out.println("YES "+first);
        
            
        
       }
       
       for(int F=0;F<arr.size();F++)
            System.out.println(arr.get(F));
   
 }

   
}


