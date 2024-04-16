package sudoku;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L;  // to prevent serial warning

   // private variables
   GameBoardPanel board = new GameBoardPanel();
   BottomPanel bottomPanel = new BottomPanel();
   JButton btnNewGame = new JButton("New Game");
   MenuBar mb = new MenuBar();

   //Properties to be defined
   // Constructor
   public SudokuMain() {

      //sudoku panel
      Container cp = super.getContentPane();
      cp.setLayout(new BorderLayout());
      this.setJMenuBar(mb.menuBar);

      cp.add(board, BorderLayout.CENTER);
      cp.add(mb, BorderLayout.NORTH);

      //bottom panel
      cp.add(bottomPanel, BorderLayout.SOUTH);


      // Add a button to the south to re-start the game via board.newGame()
      cp.add(btnNewGame, BorderLayout.SOUTH);

      // Initialize the game board to start the game
      board.newGame();
      pack();     // Pack the UI components, instead of using setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
      setTitle("Sudoku");
      setVisible(true);

   }

   /** The entry main() entry method */
   public static void main(String[] args) {
      // [TODO 1] Check "Swing program template" on how to run
      //  the constructor of "SudokuMain"
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
           new SudokuMain(); // Let the constructor does the job
        }
     });
   }



   /* COMPONENT CLASS */

   /* ----------------------- MENU BAR --------------------------- */
   public class MenuBar extends JPanel {
      private static final long serialVersionUID = 1L;
      JMenuBar menuBar;
      JMenu gameMenu;
      JMenu fileMenu;
      JMenu settingMenu;
      JMenu difficultyMenu;
      JMenuItem easyItem;
      JMenuItem mediumItem;
      JMenuItem hardItem;
  
      public MenuBar(){
          this.setSize(500, 500);
          this.setLayout(new FlowLayout());
  
          menuBar = new JMenuBar();
          fileMenu =  new JMenu("File");
          gameMenu =  new JMenu("Game");
          settingMenu =  new JMenu("Setting");
          difficultyMenu =  new JMenu("Difficulty Level");
  
          easyItem = new JMenuItem("Easy");
          mediumItem = new JMenuItem("Medium");
          hardItem = new JMenuItem("Hard");
  
          easyItem.addActionListener(new DifficultyListener());
          mediumItem.addActionListener(new DifficultyListener());
          hardItem.addActionListener(new DifficultyListener());
  
          difficultyMenu.add(easyItem);
          difficultyMenu.add(mediumItem);
          difficultyMenu.add(hardItem);
          menuBar.add(fileMenu);
          menuBar.add(gameMenu);
          menuBar.add(settingMenu);
          menuBar.add(difficultyMenu);
          this.setVisible(true);
  
      }
      private class DifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            if(evt.getSource() == easyItem){
                GameBoardPanel.difficulty = GameDifficulty.EASY;
            }
            else if(evt.getSource() == mediumItem){
                GameBoardPanel.difficulty = GameDifficulty.MEDIUM;
            }
            else if(evt.getSource() == hardItem){
                GameBoardPanel.difficulty = GameDifficulty.HARD;
            }
            else{
                GameBoardPanel.difficulty = GameDifficulty.INSANE;
            }
        }
        }
  }

   /* EVENT LISTENER */
   
}