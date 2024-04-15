package sudoku;
import java.awt.*;
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


   /* FUNCTION */



   /* EVENT LISTENER */
   
}