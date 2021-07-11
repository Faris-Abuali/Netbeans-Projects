
package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static sudoku.CheckComputerSolution.printGrid;
import static sudoku.CheckUserSolution.repeatedIn;

/**
 *
 * @author Fares Abu Ali
 */



public class Solve {
    static int backCtr=0;
    
    public static boolean solveSudoku(int[][]grid){
        
        int row=-1,col=-1;
        
        boolean isEmpty=true;
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grid[i][j]==0){
                   
                    row=i;
                    col=j;
                    
                    isEmpty=false;
                    break;
                    
                }
                
            }
            if(isEmpty==false){
                break;
            }
            
        }
        
        if(isEmpty)// if(allCellsAreFull)
            return true;
        
        // else for each-row backtrack 
	for (int num = 1; num <= 9; num++) // row =0 col=2
	{
            if(isSafe(grid, row, col, num)){
                grid[row][col]=num;
                System.out.println("yes is safe so I will put"+num+" in row="+row+" and col="+col);
                //every time the compiler reaches here then becomes involved in a new invoke
                if(solveSudoku(grid)){
                    System.out.println("yes , solveSudoku is true");
                    return true;}
                else{
                    backCtr++;
                    System.out.println("returned false so I will put 0 in row="+row+" and col="+col);
                    grid[row][col]=0;}

                // elna hakiiii
            }
   
        } 
       return false; // if from num=1 to num=9 not of the nums were safe, the compiler will
       //reach this point and return false which means there is no sloution

        //--EndOfSolveMethod
    }

  public static boolean isSafe(int[][] grid, int row, int col,int num) {

	        //Now I will ensure that the cell is not repeated in the same row
	        //I will let the row be fixed, and move through the columns
	        for (int j = 0; j< 9; j++) {
	            if (grid[row][j]==num)    
	                return false;  
	        }

	        //Now I will ensure that the cell is not repeated in the same column
	        //I will let the column be fixed, and move through the rows
	        for (int i = 0; i < 9; i++) {
	            if ( grid[i][col] == num) 
	                return false;  
	        }

	        //Now I will compare the cell with all the other 8 cells in the same box
	        for (int i = row - (row % 3); i < row - (row% 3) + 3; i++) {
	            for (int j = col - (col% 3); j < col - (col % 3) + 3; j++) {
	               
	                if (grid[i][j] == num) 
	                    return false;
	                
	            }
	        }

	        return true;
	    }

    
    
    
  
    
    public static void main(String[] args) {
        
      
    int[][] grid = new int[9][9] ;
        
//	{ 
//			{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
//			{5, 2, 0, 0, 0, 0, 0, 0, 0}, 
//			{0, 8, 7, 0, 0, 0, 0, 3, 1}, 
//			{0, 0, 3, 0, 1, 0, 0, 8, 0}, 
//			{9, 0, 0, 8, 6, 3, 0, 0, 5}, 
//			{0, 5, 0, 0, 9, 0, 6, 0, 0}, 
//			{1, 3, 0, 0, 0, 0, 2, 5, 0}, 
//			{0, 0, 0, 0, 0, 0, 0, 7, 4}, 
//			{0, 0, 5, 2, 0, 6, 3, 0, 0} 
//	}; 

  try {
            inputFromFile(grid);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("This is the initial grid:");
        printGrid(grid);
        
        
        
        if (solveSudoku(grid)) 
	{ 
            System.out.println("yes solved");
	printGrid(grid);	 
	} 
	else
		System.out.println("No solution"); 
        
        System.out.println("the program went back "+backCtr+" times!");
	

//--EndOfmain
    }
        private static void inputFromFile(int[][] grid) throws FileNotFoundException {
        File f = new File("initial.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

        }
    }
    
    //--EndOfClass
}
