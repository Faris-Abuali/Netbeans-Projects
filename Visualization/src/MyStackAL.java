package ArrayList_based;

/**
 *
 * @author Fares Abu Ali
 */
public class MyStackAL<E> {
    
    
    
    MyArrayList<E> list; // composition relationship
    
    public MyStackAL(){
        list=new MyArrayList<>();
    }
    
    public int getSize(){
        return list.getSize();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public void push(E element){
        list.add(element);
    }
    
    public E pop(){ 
        return list.remove();
    }
    
    public E getPeek(){
        return list.get(getSize()-1);
    }
    
    public void clear() {
        list.clear();
    }
    
    @Override
      public String toString() {

        String res = null;

        StringBuilder strB = new StringBuilder("\nStack Contents:-\n----------------\n");

        strB.append(list.get(getSize()-1)+" <---peek\n");
        
      for(int i=getSize()-2;i>=0;i--){
          strB.append(list.get(i)+"\n");
      }
      
       strB.append("----------------");
       
       res=strB.toString();

        return res;

    }
      
      
      public static void main(String[] args) {
        MyStackAL<String> m =new MyStackAL<>();
        
        m.push("Fares");
        m.push("Batata");
        m.push("gagahidl");
        
        m.pop();
        
        m.push("jd");
          System.out.println(m.getSize());
          
          System.out.println(m);
          
          System.out.println(m.getPeek());
    }
    
}
