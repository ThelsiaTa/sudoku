package sudoku;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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

        difficultyMenu.add(easyItem);
        difficultyMenu.add(mediumItem);
        difficultyMenu.add(hardItem);
        menuBar.add(fileMenu);
        menuBar.add(gameMenu);
        menuBar.add(settingMenu);
        menuBar.add(difficultyMenu);
        this.setVisible(true);

    }
    // @Override
    // public void actionPerformed(ActionEvent evt){
        
    // }
}

