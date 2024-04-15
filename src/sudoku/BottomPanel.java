package sudoku;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel {
    Timer timer;
    JLabel lblTime = new JLabel("00:00");
    static int seconds = 0;
    JPanel bottomPanel = new JPanel();

    public BottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        lblTime.setFont(new Font("OCR A Extended", Font.PLAIN, 80));
        lblTime.setHorizontalAlignment(JLabel.CENTER);
        lblTime.setVerticalAlignment(JLabel.CENTER);
        timer = new Timer(1000, new TimeListener());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        bottomPanel.add(lblTime);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }


    public class TimeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            seconds++;
            int lblMinute = seconds / 60;
            int lblSecond = seconds % 60;
            lblTime.setText(String.format("%02d:%02d", lblMinute, lblSecond));
        }

    }
}

