package Part2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class RaceGUI extends JPanel {
    private List<HorseGUI> horses;
    private int trackLength = 800; // Default track length
    private JLabel countdownLabel;

    public RaceGUI(JLabel countdownLabel) {
        this.countdownLabel = countdownLabel;
        this.horses = new ArrayList<>();
        setPreferredSize(new Dimension(900, 600));
        setBackground(Color.WHITE);
    }

    public void updateCountdown(int seconds) {
        countdownLabel.setText("Race starts in: " + seconds + "...");
    }

    public void clearCountdown() {
        countdownLabel.setText("");
    }

    public void setTrackParameters(int length, int lanes, String shape, String weather) {
        this.trackLength = length;
        // You can store other parameters if needed
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void addHorse(HorseGUI horse) {
        horses.add(horse);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a simple finish line
        int finishX = getWidth() - 100;
        g.setColor(Color.RED);
        g.fillRect(finishX, 0, 5, getHeight());

        for (HorseGUI horse : horses) {
            horse.draw(g);
        }
    }

    public List<HorseGUI> getHorses() {
        return horses;
    }
}








  


