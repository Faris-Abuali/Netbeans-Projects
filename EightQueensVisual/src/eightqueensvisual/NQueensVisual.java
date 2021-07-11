package eightqueensvisual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class NQueensVisual extends javax.swing.JFrame {

    DefaultListModel<String> dlm = new DefaultListModel<>();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static int N = 8;
    static JButton[][] board;
    static final int initialX = 60;
    static final int initialY = 60;
    static final int btnWidth = 52;
    static final int btnHeight = 44;

    static final String iconPath = "C:\\Users\\Fares Abu Ali\\Documents\\NetBeansProjects\\EightQueensVisual\\Q24.png";

    //------------------------------------
    static String[][] m;

    static Map<Integer, Integer> queensMap = new HashMap<>();  // key is the row and value is the column

    /**
     * Creates new form NQueensVisual
     */
    public NQueensVisual() {
        this(8);
    }

    public NQueensVisual(int N) {

        this.N=N;
        
        initComponents();

        board = new JButton[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = new JButton[N];
        }
        m = new String[N][N];

        showChessBoard();

        resetMatrix(m);

        list.setModel(dlm);
        dlm.addElement("Possible Solutions: ");
        
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        setTitle("The "+N+" Queens Buzzle");
        //setResizable(false);

    }

    public void numerateColumns() {

        int X = initialX + btnWidth / 2 - 5;
        int Y = initialY - 40;

        JLabel[] arCols = new JLabel[N];
        for (int i = 0; i < N; i++) {
            arCols[i] = new JLabel(i + "");
            arCols[i].setBounds(X, Y, btnWidth, btnHeight);  // x,y,width,height
            arCols[i].setFont(new Font("Thoma", 0, 14));
            pnlMain.add(arCols[i]);
            arCols[i].setVisible(true);

            X += btnWidth;
        }

    }

    public void numerateRows() {

        int X = initialX - 25;
        int Y = initialY;

        JLabel[] arCols = new JLabel[N];
        for (int i = 0; i < N; i++) {
            arCols[i] = new JLabel(i + "");
            arCols[i].setBounds(X, Y, btnWidth, btnHeight);  // x,y,width,height
            arCols[i].setFont(new Font("Thoma", 0, 14));
            pnlMain.add(arCols[i]);
            arCols[i].setVisible(true);

            Y += btnHeight;
        }

    }

    public void showChessBoard() {

        numerateColumns();
        numerateRows();

        int X = initialX;
        int Y = initialY;

        for (int i = 0; i < N; i++) {

            X = initialX;

            for (int j = 0; j < N; j++) {

                board[i][j] = new JButton();
                board[i][j].setSize(btnWidth, btnHeight);
                board[i][j].setBounds(X, Y, btnWidth, btnHeight);  // x,y,width,height
                //-----------------------------------------------------------------------------

                board[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JButton currBtn = (JButton) (e.getSource());

                        int col = (currBtn.getX() - initialX) / currBtn.getWidth();  // this is the column in which this btn is located
                        int row = (currBtn.getY() - initialY) / currBtn.getHeight();

                        //System.out.println("[" + row + ", " + col + "]");
                        if (currBtn.getIcon() == null) {
                            // currBtn.setIcon(new ImageIcon(iconPath)); // will be added in the method putNewQueen()

                            putNewQueenAndMarkProhibitedPlaces(row, col, m);
                            printMatrix(m);

                        } else {
                            //currBtn.setIcon(null); // icon will be deleted in method removeQueen()

                            removeQueen(row, col, m);
                        }
                        
                    }
                });

                //-----------------------------------------------------------------------------
                pnlMain.add(board[i][j]);
                board[i][j].setVisible(true);

                X += btnWidth;
            }

            Y += btnHeight;
        }

        Y = initialY;
    }// end method

    //----------------------------------------------------------------------------------------------------
    public static void resetMatrix(String[][] m) {
        // please NOTICE: this method (invoked in removeQueen())
        //just resets the shape of the matrix but does not clear the queensMap, because we still need the queensMap

        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[i].length; j++) {

                m[i][j] = "T";
                board[i][j].setEnabled(true);
                board[i][j].setBackground(new Color(214, 217, 223));
                board[i][j].setIcon(null);
            }

        }

    }// end method

    public static void getReadyForNewGame(String[][] m) {

        //resetMatrixAndClearQueensMap
        resetMatrix(m);
        queensMap.clear();

    }// end method

    public static void printMatrix(String[][] m) {

        System.out.print("   ");
        for (int i = 0; i < m.length; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println("\n  +---+---+---+---+---+---+---+---+");

        for (int i = 0; i < m.length; i++) {

            System.out.print(i + " |");
            for (int j = 0; j < m[i].length; j++) {

                if (m[i][j].equals("T")) {
                    System.out.print(ANSI_GREEN + " X " + ANSI_BLACK + "|" + ANSI_RESET);
                } else if (m[i][j].equals("X")) {
                    System.out.print(ANSI_RED + " X " + ANSI_BLACK + "|" + ANSI_RESET);
                } else {
                    System.out.print(ANSI_CYAN + " Q " + ANSI_BLACK + "|" + ANSI_RESET);
                }
            }

            System.out.println("\n  +---+---+---+---+---+---+---+---+");

        }

        System.out.println("\n");

    }// end method

    public static void putNewQueenAndMarkProhibitedPlaces(int r, int c, String[][] m) {

        queensMap.put(r, c);

        for (int row = 0; row < m.length; row++) {

            for (int col = 0; col < m[row].length; col++) {

                if (row == r || col == c || (row - col) == (r - c) || row + col == r + c) {

                    m[row][col] = "X";
                    //board[row][col].setBackground(Color.red);
                    board[row][col].setEnabled(false);

                }
            }

        }

        board[r][c].setBackground(new Color(214, 217, 223));
        board[r][c].setEnabled(true);
        board[r][c].setIcon(new ImageIcon(iconPath));
        //place the new queen
        m[r][c] = "Q";   //\u265B

    }// end method

    public static void removeQueen(int r, int c, String[][] m) {

        System.out.println("remove the queen in row = " + r + ", col = " + c + " :");

        queensMap.remove(r, c);   //remove(key,value)

        resetMatrix(m);

        //Now: after removing the queen, you need to updateProhibitedPlaces
        for (int currKey : queensMap.keySet()) {

            putNewQueenAndMarkProhibitedPlaces(currKey, queensMap.get(currKey), m);
        }

        printMatrix(m);
    }// end method

    //==================================================================================================================
    public static boolean solveStartingFromAnyRow$AnyColumn(int row, int col, String[][] m) {

        return solveRecStartingFromAnyRow$AnyColumn(row, m, 1, col);
    }

    private static boolean solveRecStartingFromAnyRow$AnyColumn(int row, String[][] m, int queensCtr, int startColumn) {

        //queensCtr counts the number of queens inserted to the chessBoard
        if (queensCtr > N) {
            return true;
        }

        int columnsDiscovered = 0;

        for (int col = startColumn; columnsDiscovered < N; col = (col + 1) % N) {

            if (m[row][col].charAt(0) == 'T') {

                putNewQueenAndMarkProhibitedPlaces(row, col, m);

                System.out.println("place a queen in row = " + row + ", col = " + col + " :");
                printMatrix(m);
                boolean flag = solveRecStartingFromAnyRow$AnyColumn((row + 1) % N, m, queensCtr + 1, 0); // move to the next row

                if (flag == false) { // then we need to backtrack
                    removeQueen(row, col, m);// printMatrix(m) will be invoked 
                } else {
                    return true;
                }
            }

            columnsDiscovered++;

        }// end for col

        return false;

    }// end method

    //==================================================================================================================
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btnSolve = new javax.swing.JButton();
        btnClearBoard = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(153, 255, 255));
        pnlMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        pnlMain.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSolve.setBackground(new java.awt.Color(0, 0, 0));
        btnSolve.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSolve.setForeground(new java.awt.Color(255, 255, 255));
        btnSolve.setText("Show possible solution");
        btnSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolveActionPerformed(evt);
            }
        });

        btnClearBoard.setBackground(new java.awt.Color(0, 0, 0));
        btnClearBoard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClearBoard.setForeground(new java.awt.Color(255, 255, 255));
        btnClearBoard.setText("Clear Chessboard");
        btnClearBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearBoardActionPerformed(evt);
            }
        });

        list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        list.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(573, 573, 573)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSolve)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(btnSolve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearBoard)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolveActionPerformed

        getReadyForNewGame(m); // this method resets the matrix and THE MOST IMPORTANT THING IT DOES IS CLEAR THE queensMap

        int row = (int) (Math.random() * N);
        int col = (int) (Math.random() * N);

        System.out.println("random row: " + row);
        System.out.println("random col: " + col);

        solveStartingFromAnyRow$AnyColumn(row, col, m);

        dlm.addElement(storeSolutionInArrayList());

    }//GEN-LAST:event_btnSolveActionPerformed

    public String storeSolutionInArrayList() {

        ArrayList<Integer> onePossibleSolutionList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int col = 0; col < N; col++) {
                if (m[i][col].equals("Q")) {
                    onePossibleSolutionList.add(col);
                }
            }
        }

        //System.out.println(onePossibleSolutionList);
        return onePossibleSolutionList.toString();
    }
    private void btnClearBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearBoardActionPerformed
        getReadyForNewGame(m);
        printMatrix(m);
    }//GEN-LAST:event_btnClearBoardActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked

        String str = list.getSelectedValue();

//        String[] ar = sol.split("[ \n\t\r.,;:!?]");
//
//        ArrayList<Integer> colNumbers = new ArrayList<>();
//
//        for (int i = 0; i < ar.length; i++) {
//            if (!ar[i].equals("[") && !ar[i].equals("]")) {
//                colNumbers.add(Integer.parseInt(ar[i]));
//            }
//        }
//        
//        
//        System.out.println(colNumbers);
        ArrayList<Integer> colNumbers = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))) {
                colNumbers.add(Integer.parseInt(str.charAt(i) + ""));
            }
        }

        getReadyForNewGame(m);
        for (int r = 0; r < N; r++) {
            putNewQueenAndMarkProhibitedPlaces(r, colNumbers.get(r), m);
        }

    }//GEN-LAST:event_listMouseClicked

    public void displayTheCurrentShapeOfTheBoard() {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (m[i][j].equals("X")) {
                    board[i][j].setIcon(null);
                    board[i][j].setEnabled(false);
                } else if (m[i][j].equals("Q")) {
                    board[i][j].setBackground(new Color(214, 217, 223));
                    board[i][j].setIcon(new ImageIcon(iconPath));
                }
            }

        }
    }// end mehtod

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NQueensVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NQueensVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NQueensVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NQueensVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NQueensVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearBoard;
    private javax.swing.JButton btnSolve;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
