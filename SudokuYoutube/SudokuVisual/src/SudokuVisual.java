
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SudokuVisual extends javax.swing.JFrame {

    static long startTime = System.currentTimeMillis() / 1000;

    static DefaultListModel<String> dlm = new DefaultListModel<>();

    // Color characol = new Color(ERROR, rootPaneCheckingEnabled);
    static Color cottonCandy = new Color(255, 189, 217);
    static Color buddGreen = new Color(122, 181, 97);
    static Color amaranthRed = new Color(230, 43, 79);
    static Color antiqueWhite = new Color(250, 235, 214);
    static Color blizzardBlue = new Color(171, 230, 237);
    static Color lime = new Color(209, 255, 21);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static final int Xinitial = 60;
    static final int Yinitial = 60;

    static final int btnWidth = 40;
    static final int btnHeight = 40;
    static final int lblWidth = 15;
    static final int lblHeight = 30;

    static final int N = 9;
    static final int EMPTY = 0;

    static JButton[][] btnMatrix;
    static int[][] grid = new int[N][N];

    static int[][] theSolutionGrid = new int[N][N]; // this is how the final solution should be  

    JLabel lblSeparator;

    static boolean[][] fixedCells = new boolean[N][N];// this is not necessary, just needed this because whenever I
    // print the grid, I want the fixed numbers to be marked with red color  (AESTHETIC PURPOSES ONLY)

    /**
     * Creates new form SudokuVisual
     */
    public SudokuVisual() {
        initComponents();

        setTitle("Sudoku Puzzle     Developed By: Fares H. AbuAli  [30-Jan-2020] ");

        btnMatrix = new JButton[N][N];
        for (int i = 0; i < N; i++) {
            btnMatrix[i] = new JButton[N];
        }

        lblSeparator = new JLabel(" | ");
        lblSeparator.setFont(new Font("Thoma", 0, 18));

        drawGrid();

        list.setModel(dlm);

        progressBar.setVisible(false);
        lblWait.setVisible(false);

        //===========================================
        grid = new int[][]{
            {2, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 1, 4, 0, 0, 0, 9, 5, 0},
            {0, 0, 0, 7, 8, 1, 0, 0, 0},
            {0, 0, 7, 3, 5, 6, 8, 0, 0},
            {6, 5, 0, 0, 0, 0, 0, 4, 2},
            {0, 0, 3, 4, 2, 8, 7, 0, 0},
            {0, 0, 0, 5, 7, 9, 0, 0, 0},
            {0, 4, 2, 0, 0, 0, 6, 9, 0},
            {8, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        theSolutionGrid = new int[][]{
            {2, 8, 6, 9, 4, 5, 1, 7, 3},
            {7, 1, 4, 6, 3, 2, 9, 5, 8},
            {9, 3, 5, 7, 8, 1, 4, 2, 6},
            {4, 2, 7, 3, 5, 6, 8, 1, 9},
            {6, 5, 8, 1, 9, 7, 3, 4, 2},
            {1, 9, 3, 4, 2, 8, 7, 6, 5},
            {3, 6, 1, 5, 7, 9, 2, 8, 4},
            {5, 4, 2, 8, 1, 3, 6, 9, 7},
            {8, 7, 9, 2, 6, 4, 5, 3, 1}
        };

        markFixedCells();
        showInitiallGrid();

        //=======================================
    }// end constructor

    public void drawGrid() {

        numerateColumns();
        numerateRows();

        int x = Xinitial;
        int y = Yinitial;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                btnMatrix[i][j] = new JButton();
                btnMatrix[i][j].setBounds(x, y, btnWidth, btnHeight); // x,y,widht,height

//                btnMatrix[i][j].setEnabled(true);
//                btnMatrix[i][j].setText("");
                if ((j / 3 == 1 && i / 3 == 0) || (j / 3 == 0 && i / 3 == 1) || (j / 3 == 2 && i / 3 == 1) || (j / 3 == 1 && i / 3 == 2)) {
                    btnMatrix[i][j].setBackground(antiqueWhite);
                } else {
                    btnMatrix[i][j].setBackground(blizzardBlue);
                }

                btnMatrix[i][j].setVisible(true);
                btnMatrix[i][j].setFont(new Font("Hack", 0, 18));
                btnMatrix[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        eraseHighlighting();

                        JButton currBtn = (JButton) (evt.getSource());

                        String str = currBtn.getText();

                        int C = (currBtn.getX() - Xinitial) / btnWidth;
                        int R = (currBtn.getY() - Yinitial) / btnHeight;

                        //System.out.println(R + "  " + C);
                        int num = 1;

                        if (str.length() == 0) {
                            currBtn.setText("1");
                            grid[R][C] = 1;

                        } else {

                            num = Integer.parseInt(str);
                            num = (num + 1) % 10;

                            if (num == 0) {
                                num++;
                                str = "";
                                grid[R][C] = EMPTY;

                            } else {
                                str = num + "";
                                grid[R][C] = Integer.parseInt(str);
                            }

                            currBtn.setText(str);

                        }

                        printGrid();
                        dlm.removeAllElements();
                    }// end actionPerformed
                });
                pnlMain.add(btnMatrix[i][j]);

                x += btnWidth;
            }

            y += btnHeight;
            x = Xinitial;
        }

    }// end method

    public static void printGrid() {

        System.out.print("   ");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println("\n  +---+---+---+---+---+---+---+---+---+");

        for (int i = 0; i < N; i++) {

            System.out.print(i + " |");
            for (int j = 0; j < N; j++) {

                if (grid[i][j] == EMPTY) {
                    System.out.print("   " + ANSI_BLACK + "|");
                } else {

                    if (fixedCells[i][j] == true) {
                        System.out.print(ANSI_RED + " " + grid[i][j] + " " + ANSI_BLACK + "|");
                    } else {
                        System.out.print(ANSI_CYAN + " " + grid[i][j] + " " + ANSI_BLACK + "|");
                    }
                }

            }
            System.out.println("\n  +---+---+---+---+---+---+---+---+---+");

        }// end for outer

        System.out.println("\n");

    }// end method

    public static void redrawGrid() {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                btnMatrix[i][j].setText("");
                btnMatrix[i][j].setEnabled(true);

            }
        }
    }

    public static void showInitiallGrid() {

//        grid = new int[][]{
//            {2, 0, 0, 0, 0, 0, 0, 0, 3},
//            {0, 1, 4, 0, 0, 0, 9, 5, 0},
//            {0, 0, 0, 7, 8, 1, 0, 0, 0},
//            {0, 0, 7, 3, 5, 6, 8, 0, 0},
//            {0, 5, 0, 0, 0, 0, 0, 4, 2},
//            {0, 0, 3, 4, 2, 8, 7, 0, 0},
//            {6, 0, 0, 5, 7, 9, 0, 0, 0},
//            {0, 4, 2, 0, 0, 0, 6, 9, 0},
//            {8, 0, 0, 0, 0, 0, 0, 0, 1}
//        };
        markFixedCells();

        printGrid();

        redrawGrid();

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (fixedCells[i][j] == true) {
                    btnMatrix[i][j].setText(grid[i][j] + "");
                    //btnMatrix[i][j].setForeground(Color.red);
                    btnMatrix[i][j].setEnabled(false);
                } else {
                    btnMatrix[i][j].setText("");

                }

                if ((j / 3 == 1 && i / 3 == 0) || (j / 3 == 0 && i / 3 == 1) || (j / 3 == 2 && i / 3 == 1) || (j / 3 == 1 && i / 3 == 2)) {
                    btnMatrix[i][j].setBackground(antiqueWhite);
                } else {
                    btnMatrix[i][j].setBackground(blizzardBlue);
                }

            }
        }

    }// end method

    public static void showGrid() {

        printGrid();

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                btnMatrix[i][j].setText(grid[i][j] + "");

                if (fixedCells[i][j] == true) {
                    btnMatrix[i][j].setEnabled(false);
                }

            }
        }

    }// end method

    public static void markFixedCells() {

        fixedCells = new boolean[N][N]; // reset

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != EMPTY) {
                    fixedCells[i][j] = true;
                }
            }
        }
    }// end method

//    public void drawSeaparator() {
//
//        lblSeparator = new JLabel("|");
//        lblSeparator.setFont(new Font("Thoma", 0, 18));
//        lblSeparator.setBounds(x, y, lblWidth, lblHeight);
//        lblSeparator.setVisible(true);
//        pnlMain.add(lblSeparator);
//
//        x += lblWidth;
//    }
    public void numerateColumns() {

        int X = Xinitial + btnWidth / 2 - 5;
        int Y = Yinitial - 40;

        JLabel[] arCols = new JLabel[N];
        for (int i = 0; i < N; i++) {
            arCols[i] = new JLabel((char)('A'+i) + "");
            arCols[i].setBounds(X, Y, btnWidth, btnHeight);  // x,y,width,height
            arCols[i].setFont(new Font("Hack", 0, 14));
            pnlMain.add(arCols[i]);
            arCols[i].setVisible(true);

            X += btnWidth;
        }

    }

    public void numerateRows() {

        int X = Xinitial - 25;
        int Y = Yinitial;

        JLabel[] arCols = new JLabel[N];
        for (int i = 0; i < N; i++) {
            arCols[i] = new JLabel((char)('A'+i) + "");
            arCols[i].setBounds(X, Y, btnWidth, btnHeight);  // x,y,width,height
            arCols[i].setFont(new Font("Hack", 0, 14));
            pnlMain.add(arCols[i]);
            arCols[i].setVisible(true);

            Y += btnHeight;
        }

    }

    public static boolean howAmIDoing() {

        boolean flag = true;

        for (int r = 0; r < N; r++) {
            flag = checkRow(r);

            if (flag == false) {
                return false;
            }
        }

        for (int c = 0; c < N; c++) {
            flag = checkColumn(c);

            if (flag == false) {
                return false;
            }
        }

        flag = checkBoxes();

        return flag;

    }// end method

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btnCheckSolution = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnSolve = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        lblWait = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(255, 189, 217));
        pnlMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pnlMain.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCheckSolution.setBackground(new java.awt.Color(0, 0, 0));
        btnCheckSolution.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCheckSolution.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckSolution.setText("How am I doing?");
        btnCheckSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckSolutionActionPerformed(evt);
            }
        });

        btnGenerate.setBackground(new java.awt.Color(0, 0, 0));
        btnGenerate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGenerate.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate.setText("Generate random puzzle");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear Grid");
        btnClear.setToolTipText("");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        list.setFont(new java.awt.Font("Hack", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(list);

        btnSolve.setBackground(new java.awt.Color(0, 0, 0));
        btnSolve.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSolve.setForeground(new java.awt.Color(255, 255, 255));
        btnSolve.setText("Solve");
        btnSolve.setToolTipText("");
        btnSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolveActionPerformed(evt);
            }
        });

        progressBar.setBackground(new java.awt.Color(102, 102, 102));
        progressBar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblWait.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblWait.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWait.setText("Solving...");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGenerate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSolve, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblWait, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlMainLayout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(btnCheckSolution)))
                            .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGenerate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSolve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWait, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(btnCheckSolution)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnCheckSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckSolutionActionPerformed

        eraseHighlighting();

        boolean ok = howAmIDoing();

        if (ok) {

            if (isCompleted()) {
                highlightGridWithGreen();

                long endTime = System.currentTimeMillis() / 1000;

                long minutes = (endTime - startTime) / 60;
                long seconds = (endTime - startTime) % 60;

                JOptionPane.showMessageDialog(rootPane, "CONGRATS! YOU HAVE COMPLETED THIS SUDOKU WITHIN " + minutes + " minutes and " + seconds + " seconds");
            } else {

                int n = numberOfEmptyCellsRemaining();
                dlm.addElement("Everything is ok so far :) You still have " + n + " cells to fill");

            }
        }

        System.out.println(ok);
        //highlightRow(2);

    }//GEN-LAST:event_btnCheckSolutionActionPerformed

    public static boolean isCompleted() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (theSolutionGrid[i][j] != grid[i][j]) {
                    return false;
                }
            }
        }
        //============ if the program reaches here, then the soduko is completed 100%
        return true;

    }// end method

    public static void highlightGridWithGreen() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                btnMatrix[i][j].setEnabled(true);
                btnMatrix[i][j].setText(grid[i][j] + "");

                if (fixedCells[i][j] == true) {
                    btnMatrix[i][j].setForeground(Color.gray);
                    btnMatrix[i][j].setFont(new Font("Hack", 1, 18));
                } else {
                    btnMatrix[i][j].setForeground(Color.black);
                    btnMatrix[i][j].setFont(new Font("Hack", 1, 18));
                }

                btnMatrix[i][j].setBackground(lime);

            }
        }
    }// end method

    public int numberOfEmptyCellsRemaining() {

        int ctr = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (grid[i][j] == EMPTY) {
                    ctr++;
                }
            }
        }

        return ctr;
    }
    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed

        dlm.removeAllElements();

        int flag = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to generate a new puzzle?");

        if (flag == 0) {

            //generateRandomPuzzle();
            Integer[][] gridLocal = new Integer[N][N];

            gridLocal = PuzzleGenerator.fillGrid(gridLocal);
            //==============================================================================   
            theSolutionGrid = unboxTheIntegerMatrix(gridLocal); // save the solution 

            //==============================================================================
            gridLocal = PuzzleGenerator.removeEntriesRandomlyFromEachBox(gridLocal);

            this.grid = unboxTheIntegerMatrix(gridLocal);
            markFixedCells();

        }

        showInitiallGrid();

    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        dlm.removeAllElements();

        int flag = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to clear the current grid? ");

        if (flag == 0) {
            eraseUserInputs();
        }

        printGrid();

    }//GEN-LAST:event_btnClearActionPerformed

    public void eraseUserInputs() {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (fixedCells[i][j] == false) {
                    btnMatrix[i][j].setText("");
                    grid[i][j] = EMPTY;
                }

                //-------------------remove highlighting----------------------------
                if ((j / 3 == 1 && i / 3 == 0) || (j / 3 == 0 && i / 3 == 1) || (j / 3 == 2 && i / 3 == 1) || (j / 3 == 1 && i / 3 == 2)) {
                    btnMatrix[i][j].setBackground(antiqueWhite); // antique white
                } else {
                    btnMatrix[i][j].setBackground(blizzardBlue); //Blizzard blue
                }
                //=======================================================

            }
        }

    }// end method
    private void btnSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolveActionPerformed

        int flag = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to see the solution ?");

        if (flag == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please wait... the program will try to solve the puzzle. This will "
                    + "take 15 seconds approximately...");

            printGrid();

            eraseUserInputs();
            solve();
        }
//        lblWait.setVisible(true);
//        progressBar.setVisible(true);
//        progressBar.setValue(22);
//        try {
//
//            Thread.sleep(500);
//        } catch (InterruptedException ex) {
//
//        }


    }//GEN-LAST:event_btnSolveActionPerformed

    public void eraseHighlighting() {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                btnMatrix[i][j].setFont(new Font("Hack", 0, 18));
                btnMatrix[i][j].setForeground(Color.black);
                
                if(fixedCells[i][j]==true){
                    btnMatrix[i][j].setEnabled(false);
                }
                
                if ((j / 3 == 1 && i / 3 == 0) || (j / 3 == 0 && i / 3 == 1) || (j / 3 == 2 && i / 3 == 1) || (j / 3 == 1 && i / 3 == 2)) {
                    btnMatrix[i][j].setBackground(antiqueWhite); // antique white
                } else {
                    btnMatrix[i][j].setBackground(blizzardBlue); //Black Shadows
                }
            }// inner for

        }// outer for

    }// end method

    public int[][] unboxTheIntegerMatrix(Integer[][] grid) {

        int[][] m = new int[grid.length][grid.length];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m[i][j] = grid[i][j];
            }
        }

        return m;

    }// end method

    public static boolean checkRow(int r) {

        int[] occurences = new int[N];// store how many times each number from 1 to 9 has appeared int this row
        // if there's a number who has appeared more than once, then there's a problem

        for (int c = 0; c < N; c++) {

            if (grid[r][c] != EMPTY) {
                occurences[grid[r][c] - 1]++; // store 1's in ar[0], 2's in ar[1], ..... 9's in ar[8] 

                if (occurences[grid[r][c] - 1] > 1) {
                    //JOptionPane.showMessageDialog(null, "You have made some mistakes in row " + r + ";  [" + (grid[r][c]) + "] appeard more than once");
                    highlightRow(r);
                    dlm.addElement("You have made some mistakes in row " + (char)('A'+r) + ";  [" + (grid[r][c]) + "] appeard more than once");
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkColumn(int c) {

        int[] occurences = new int[N];// store how many times each number from 1 to 9 has appeared int this row
        // if there's a number who has appeared more than once, then there's a problem

        for (int r = 0; r < N; r++) {

            if (grid[r][c] != EMPTY) {
                occurences[grid[r][c] - 1]++; // store 1's in ar[0], 2's in ar[1], ..... 9's in ar[8] 

                if (occurences[grid[r][c] - 1] > 1) {
                    // JOptionPane.showMessageDialog(null, "You have made some mistakes in column " + c + ";  [" + (grid[r][c]) + "] appeard more than once");
                    highlightColumn(c);
                    dlm.addElement("You have made some mistakes in column " + (char)('A'+c) + ";  [" + (grid[r][c]) + "] appeard more than once");
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkBoxes() {

        int c = 0;
        int r = 0;

        while (r < N) {

            c = 0;

            while (c < N) {

                //--- START NEW BOX ---
                int[] occurences = new int[N];// store how many times each number from 1 to 9 has appeared int this row
                // if there's a number who has appeared more than once, then there's a problem
                for (int i = r; i < (r + 3); i++) {

                    for (int j = c; j < (c + 3); j++) {

                        if (grid[i][j] != EMPTY) {

                            occurences[grid[i][j] - 1]++;// store 1's in ar[0], 2's in ar[1], ..... 9's in ar[8] 

                            if (occurences[grid[i][j] - 1] > 1) {
                                //JOptionPane.showMessageDialog(null, "You have made some mistakes in Box of row " + i + " and column " + j + "  [" + (grid[i][j]) + "] appeard more than once");
                                highlightBox(i, j);
                                dlm.addElement("You have made some mistakes in Box of row " + (char)('A'+i) + " and column " + (char)('A'+j) + "  [" + (grid[i][j]) + "] appeard more than once");

                                return false;
                            }

                        }
                    }
                }

                c += 3;
            }

            r += 3;
        }

        return true;

    }// end method

    public static void highlightRow(int r) {

        for (int c = 0; c < N; c++) {

            btnMatrix[r][c].setBackground(new Color(230, 43, 79));
        }
    }// end method

    public static void highlightColumn(int c) {

        for (int r = 0; r < N; r++) {

            btnMatrix[r][c].setBackground(new Color(230, 43, 79));
        }
    }// end method

    public static void highlightBox(int r, int c) {

        int R = (r / 3) * 3;
        int C = (c / 3) * 3;

        for (int i = R; i < (R + 3); i++) {

            for (int j = C; j < (C + 3); j++) {

                btnMatrix[i][j].setBackground(new Color(230, 43, 79));
            }
        }
    }// end method

//    public static void generateRandomPuzzle() {
//
//        int totalFixedNums = 0;
//
//        grid = new int[N][N]; // reset
//        fixedCells = new boolean[N][N]; //reset
//
//        int c = 0;
//        int r = 0;
//
//        while (r < N) {
//
//            c = 0;
//
//            while (c < N) {
//
//                //--- START NEW BOX ---
//                int numOfFixedNumbers = (int) (Math.random() * 4 + 2);  //  2 3 4 5
//                totalFixedNums += numOfFixedNumbers;
//
//                while (numOfFixedNumbers > 0) {
//
//                    int R = (int) (Math.random() * 3 + r);
//                    int C = (int) (Math.random() * 3 + c);
//
//                    while (grid[R][C] != EMPTY) {
//                        R = (int) (Math.random() * 3 + r);
//                        C = (int) (Math.random() * 3 + c);
//                    }
//
//                    Set<Integer> setProhibitedNumbers = getProhibitedNumbers(R, C);
//                    Set<Integer> setAllowedNumbers = new HashSet<>();
//
//                    for (int i = 1; i <= N; i++) {
//                        setAllowedNumbers.add(i);
//                    }
//
//                    for (int i = 1; i <= N; i++) {
//
//                        setAllowedNumbers.removeAll(setProhibitedNumbers);
////                        if (!setProhibitedNumbers.contains(i)) {
////                            setAllowedNumbers.add(i);
////                        }
//                    }
//
//                    if (!setAllowedNumbers.isEmpty()) {
//                        int randomIndex = (int) (Math.random() * setAllowedNumbers.size());
//                        ArrayList<Integer> list = new ArrayList(setAllowedNumbers);
//                        int num = list.get(randomIndex);
//
//                        grid[R][C] = num;
//                        fixedCells[R][C] = true;
//
//                        numOfFixedNumbers--;
//                    } else {
//
//                        generateRandomPuzzle(); // try again from the beginning
//
////                        if(c>0){
////                           grid[r][c-1]=EMPTY; 
////                           c--;
////                        }
////                       
//                    }
//
//                }
//
//                c += 3;
//            }
//
//            r += 3;
//        }
//
//        markFixedCells();
//        printGrid();
//        System.out.println("Total Fixed Numbers: " + totalFixedNums);
//
//    }// end method
    public static Set<Integer> getProhibitedNumbers(int row, int col) {

        // this method returns a set of the numbers that are in the same row,col and nonet(box) with grid[row][col]
        Set<Integer> set = new HashSet<>();

        //----------------------- SEARCH THE BOX in which grid[row][col] is located ---------------------
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = r; i < (r + 3); i++) {
            for (int j = c; j < (c + 3); j++) {

                if (grid[i][j] != EMPTY) {
                    set.add(grid[i][j]);
                }
            }
        }

        //----------------------- NOW SEARCH THE ROW in which grid[row][col] is located ------------------------
        for (int j = 0; j < N; j++) {

            if (grid[row][j] != EMPTY) {
                set.add(grid[row][j]);
            }
        }
        //----------------------- NOW SEARCH THE COLUMN in which grid[row][col] is located ---------------------

        for (int j = 0; j < N; j++) {

            if (grid[j][col] != EMPTY) {
                set.add(grid[j][col]);
            }
        }

        return set;

    }// end method

    public void generate() {

        LinkedList<Integer> lin = new LinkedList<>();

        lin.add(1);
        lin.add(2);
        lin.add(3);
        lin.add(4);
        lin.add(5);
        lin.add(6);
        lin.add(7);
        lin.add(8);
        lin.add(9);

        Collections.shuffle(lin);

        System.out.println(lin);

    }// end method

    /**
     * @param args the command line arguments
     */
    //=========================================================================================================
    public static void solve() {

        //progressBar.setValue(22);
        dlm.removeAllElements();
        list.setForeground(Color.black);
        dlm.addElement("Computer Solver: ");

        long startTime = System.currentTimeMillis();

        boolean flag = solveRec();

        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;

        if (flag) {
            highlightGridWithGreen();

            System.out.println(ANSI_CYAN + "Congrats! The Sudoku Has Been Solved Successfully! " + ANSI_RESET);
            JOptionPane.showMessageDialog(null, "Congrats! The Sudoku Has Been Solved Successfully within " + (duration / 1000) + " seconds !");

        } else {
            System.out.println(ANSI_RED + "This Sudoku seems to be IMPROPER!!! No Solution Was Found :( " + ANSI_RESET);
            JOptionPane.showMessageDialog(null, "This Sudoku seems to be IMPROPER!!! No Solution Was Found :( ");
            showGrid();

        }

        printGrid();

        progressBar.setValue(100);

    }// end method

    public static boolean solveRec() {

//        if (gridIsFull()) {// then we have completed the sudoku
//            return true;
//        }
        for (int row = 0; row < N; row++) {

            if (row >= 4) {
                progressBar.setValue(66);
            }

            for (int col = 0; col < N; col++) {

                if (grid[row][col] == EMPTY) {

                    Set<Integer> set = getProhibitedNumbers(row, col);

                    for (int num = 1; num <= N; num++) {

                        if (!set.contains(num)) {// if this num is unique (did not appear in the same row,col or box), then try it 

                            grid[row][col] = num;
                            System.out.println("put [" + num + "] in the cell of row: " + row + ", col: " + col);
                            dlm.addElement(dlm.size()+".put [" + num + "] in the cell of row: " + (char)('A'+row) + ", col: " + (char)('A'+col));
                            printGrid();

                            //===================================
                            boolean flag = solveRec(); // invoke the function for the next cell
                            //===================================

                            if (flag == false) { // then we have to change the number in this cell (grid[row][col])
                                grid[row][col] = EMPTY;// erase the current number 
                                System.out.println("erase [" + num + "] from the cell of row: " + row + ", col: " + col);
                                dlm.addElement(dlm.size()+".erase [" + num + "] from the cell of row: " + (char)('A'+row) + ", col: " + (char)('A'+col));
                                printGrid();
                            } else {
                                return true;
                            }

                        }// end if 

                    }// end for num

                    /*
                    if the method reaches here, this means that we have tried all possible numbers from 1 to 9 and
                    no number is vailid to be filled in this cell, so we have to "backtrack" (return to the preceding cell
                    and try to fill it with another number)
                     */
                    return false;

                }

            }// end for cols
        }// end for rows

        return true;// if the program reaches here, this means that that all cells have been filled. CONGRATS!

    }// end method

    //===============================================================================================================
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
            java.util.logging.Logger.getLogger(SudokuVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SudokuVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SudokuVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SudokuVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudokuVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckSolution;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnSolve;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWait;
    private static javax.swing.JList<String> list;
    private static javax.swing.JPanel pnlMain;
    private static javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
