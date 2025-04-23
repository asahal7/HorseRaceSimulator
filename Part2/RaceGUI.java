package Part2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class RaceGUI extends JPanel {
    private List<HorseGUI> horses;

    public RaceGUI() {
        this.horses = new ArrayList<>();
        setPreferredSize(new Dimension(900, 600));
    }
    public void setTrackParameters(int length, int lanes, String shape, String weather) {
        // For now, we’ll just print or store them. Expand this later as needed.
        System.out.println("Track Length: " + length);
        System.out.println("Lanes: " + lanes);
        System.out.println("Shape: " + shape);
        System.out.println("Weather: " + weather);
        // You could add fields and logic to use these in drawing the track, etc.
    }
    
    public void addHorse(HorseGUI horse) {
        horses.add(horse);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (HorseGUI horse : horses) {
            horse.draw(g);
        }
    }

    public List<HorseGUI> getHorses() {
        return horses;
    }
}




  


