
package tmaint;


public class TMainT
{

    public static void main(String[] args) 
    {
        A a1 = new A();
        A a2 = new A();
        
        a1.start();  // there is an implicit function called start() in the class A , because A extends Thread and Thread has this function
        a2.start();
        
    }
    
}
