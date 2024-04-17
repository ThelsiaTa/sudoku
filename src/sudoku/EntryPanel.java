package sudoku;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EntryPanel extends JDialog {
    JLabel welcomeLabel;
    JButton startButton;
    JButton easy, medium, hard, insane;

    public EntryPanel(Frame SudokuMain) {
        super(SudokuMain, "Welcome", true);
        // Configure the dialog box
        setLayout(new BorderLayout());
        welcomeLabel = new JLabel("Welcome Sudoku", JLabel.CENTER);
        startButton = new JButton("Start Game");

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setLayout(new GridLayout(4, 1));
        
        easy = new JButton("Easy");
        medium = new JButton("Medium");
        hard = new JButton("Hard");
        insane = new JButton("Insanely Hard");
        difficultyPanel.add(easy);
        difficultyPanel.add(medium);
        difficultyPanel.add(hard);
        difficultyPanel.add(insane);
        

        // Add components
        add(welcomeLabel, BorderLayout.NORTH);
        add(difficultyPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
        
        // Add action listener to the button
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose the welcome screen and show the main Sudoku window
                setVisible(false);
                dispose();
                SudokuMain.setVisible(true);
                GameBoardPanel.newGame();;
            }
        });
        easy.addActionListener(new getDifficultyLevel());
        hard.addActionListener(new getDifficultyLevel());
        medium.addActionListener(new getDifficultyLevel());
        insane.addActionListener(new getDifficultyLevel());
        

        // Set dialog size and position
        pack(); 
        setLocationRelativeTo(SudokuMain);
    }
     public class getDifficultyLevel implements ActionListener{
        @Override
         public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == easy) {
                GameBoardPanel.difficulty = GameDifficulty.EASY;
            } else if (evt.getSource() == medium) {
                GameBoardPanel.difficulty = GameDifficulty.MEDIUM;
            } else if (evt.getSource() == hard) {
                GameBoardPanel.difficulty = GameDifficulty.HARD;
            } else if (evt.getSource() == insane) {
                GameBoardPanel.difficulty = GameDifficulty.INSANE;
            }

     }
    }
}