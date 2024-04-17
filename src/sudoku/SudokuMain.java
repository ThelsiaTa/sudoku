package sudoku;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
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
   JButton btnGetHint = new JButton("Get Hint");
   MenuBar mb = new MenuBar();


   //timer
   JPanel timerPanel = new JPanel();
   static JLabel lblTime = new JLabel("00:00");
   public static Timer timer;
   static int seconds = 0;

   //count hints
   JPanel hintPanel = new JPanel();
   static JLabel lblHintLeft = new JLabel("Hint Left: " + 3);
   static int hintCount = 3;

   //count mistakes
   JPanel mistakesPanel = new JPanel();
   static JLabel lblMistakes = new JLabel("Mistakes: " + 0);
   static int mistakesCount = 0;

   //music
   //URL url = this.getClass().getResource("/bg_music_sudoku.wav");
   static Clip bgMusic = null;
   AudioInputStream audioStream;


   // Constructor
   public SudokuMain() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

      //sudoku panel
      Container cp = super.getContentPane();
      cp.setLayout(new BorderLayout());
      this.setJMenuBar(mb.menuBar);

      cp.add(board, BorderLayout.CENTER);
      cp.add(mb, BorderLayout.NORTH);
      cp.add(bottomPanel, BorderLayout.SOUTH);

      //timer
      timerPanel.setLayout(new GridLayout(1, 2));
      lblTime.setFont(new Font("Serif", Font.PLAIN, 30));
      lblTime.setHorizontalAlignment(JLabel.CENTER);
      lblTime.setVerticalAlignment(JLabel.CENTER);
      timer = new Timer(1000, new TimeListener());
      timerPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
      timerPanel.add(lblTime);
      mb.add(timerPanel);


      /* BOTTOM PANEL */
      // mistakes
      //lblMistakes.add("Mistakes: " + mistakesCount);
      lblMistakes.setBorder(BorderFactory.createEmptyBorder(8, 50, 8, 50));
      mistakesPanel.add(lblMistakes);
      bottomPanel.add(mistakesPanel);

      // hintCount
      lblHintLeft.setBorder(BorderFactory.createEmptyBorder(8, 50, 8, 50));
      hintPanel.add(lblHintLeft);
      bottomPanel.add(hintPanel);

      //getHint
      mb.add(btnGetHint);
      btnGetHint.addActionListener(new hintListener());

      //music
      audioStream = AudioSystem.getAudioInputStream(new File("src/sudoku/bg_music_sudoku.wav"));
      bgMusic = AudioSystem.getClip();
      bgMusic.open(audioStream);

      // Add a button to the south to re-start the game via board.newGame()
      bottomPanel.add(btnNewGame);


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
            try {
                new SudokuMain(); // Let the constructor does the job
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
     });
   }




   /* FUNCTION */



   /* EVENT LISTENER */
   //timer
   public class TimeListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         seconds++;
         int lblMinute = seconds / 60;
         int lblSecond = seconds % 60;
         lblTime.setText(String.format("%02d:%02d", lblMinute, lblSecond));
      }
   }
   //hint
   private class hintListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         int randomRow = (int) (Math.random() * 9);
         int randomCol = (int) (Math.random() * 9);
         Cell referenceCell = board.getCell(randomRow, randomCol);

         while (referenceCell.status != CellStatus.TO_GUESS && hintCount > 0) {
            randomRow = (int) (Math.random() * 9);
            randomCol = (int) (Math.random() * 9);
            referenceCell = board.getCell(randomRow, randomCol);
         }

         hintCount--;
         if (referenceCell.status == CellStatus.TO_GUESS && hintCount >= 0) {
            lblHintLeft.setText("Hints Left: " + hintCount);
            referenceCell.setText("" + referenceCell.number);
            referenceCell.status = CellStatus.CORRECT_GUESS;
            referenceCell.paint();
         }
      }
   }

   
}