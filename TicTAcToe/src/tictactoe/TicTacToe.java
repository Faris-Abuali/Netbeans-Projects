
package tictactoe;

import java.util.Arrays;
import java.util.Scanner;


public class TicTacToe {
    
public static boolean isValidIndex(int row,int col){
    if(row>=0&&row<=2 &&col >=0&&col<=2)
        return true;
    return false;
}

public static boolean isEmpty(char[][]grid,int r,int c){
    
    if(grid[r][c]!='X'&&grid[r][c]!='O')
    return true;
    
    return false;
}

public static void printCurrentGrid(char[][]grid){
    
    System.out.println("-----------");
      for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(isEmpty(grid, i, j))
                    System.out.print("|-|"+" ");
                else System.out.print("|"+grid[i][j]+"| ");
            }
            System.out.println();
        }
      System.out.println("-----------");
}

public static boolean thereIsAWinner(char[][]grid,char[]theWinner){
    
    //compare the column
    int row=0;
    for(int j=0;j<3;j++){
        if(!isEmpty(grid, row, j) && grid[row][j]==grid[row+1][j]&&grid[row][j]==grid[row+2][j]){
            theWinner[0]=grid[row][j];
            return true;
        }
            }
    
    //compare the row
        int column=0;
    for(int i=0;i<3;i++){
        if(!isEmpty(grid,i,column) && grid[i][column]==grid[i][column+1]&&grid[i][column]==grid[row+2][column+2]){
            theWinner[0]=grid[i][column];
            return true;
        }
            }
    
    //the diagonal
    if(!isEmpty(grid,0,0)&& grid[0][0]==grid[1][1] && grid[0][0]==grid[2][2]){
        theWinner[0]=grid[0][0];
        return true;
    }
    
    //the anti diagonal
    if(!isEmpty(grid,0,2)&& grid[0][2]==grid[1][1] && grid[1][1]==grid[2][0]){
         theWinner[0]=grid[0][2];
        return true;
    }
    
    
    
    return false;
}





   
    public static void main(String[] args) {
        char[] theWinner=new char[1];
        Scanner sc=new Scanner(System.in);
        
        
        char [][]grid=new char[3][3];
        char r,c;int ctr=0;
       
        
      
        
        
        
        while(true){
            
        
        if(ctr%2==0)
        System.out.println("ok\nIt's player 1's turn.Enter the coordinates(row then column)");
        else
        System.out.println("ok\nIt's player 2's turn.Enter the coordinates(row then column)");  
        
        r=sc.next().charAt(0); int row=r-'0';       
        c=sc.next().charAt(0); int col=c-'0';
        
           // System.out.println("row="+row);
            //System.out.println("col="+col);
            
//        while(!isValidIndex(row,col)){
//            
//            if(!isValidIndex(row,col))
//        System.out.println("wrong index, please enter indices from '0' to '2' only");
//           else if(!isEmpty(grid,row,col))
//        System.out.println("this place is full, please enter again in another place from '0' to '2'");
//            
//        r=sc.next().charAt(0);  row=r-'0'; 
//        c=sc.next().charAt(0);  col=c-'0';
//        
//        while(isValidIndex(row, col) && !isEmpty(grid, row, col)){
//            System.out.println("This place is full. Please choose another place from '0' to '2'");
//             r=sc.next().charAt(0);  row=r-'0'; 
//             c=sc.next().charAt(0);  col=c-'0';
//            
//        } 
//        
//    }
//        
//            
//        
while(true){
    
    while(!isValidIndex(row,col)){
        if(row!=-9999)
          System.out.println("wrong index, please enter indices from '0' to '2' only");
        r=sc.next().charAt(0);  row=r-'0'; 
        c=sc.next().charAt(0);  col=c-'0';
    }
    
    if(isEmpty(grid, row, col))
        break;
    
    System.out.println("This place is full. Please choose another place from '0' to '2'");
    row=-9999;col=-9999;
}
     
        
        if(ctr%2==0)
        grid[row][col]='X';
        else
        grid[row][col]='O';
        
        ctr++;
        
        
       printCurrentGrid(grid);
       
       if(ctr>=5 && thereIsAWinner(grid,theWinner)) 
       {
           if(theWinner[0]=='X')
           System.out.println("player 1  won");
           else
            System.out.println("player 2  won"); 
           break;
       }
       
       if(ctr>=9){
                System.out.println("It is a tie");
       break;
       }
        
        }
        
       
        
        
      //--EndOfmain  
    }
    //--EndOfClass
}
