package Part2;

import javax.swing.*;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Horse Race Simulator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);

            RaceGUI raceGUI = new RaceGUI();
            HorseCustomizer customizer = new HorseCustomizer(raceGUI);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, customizer, raceGUI);
            splitPane.setDividerLocation(300);
            frame.add(splitPane);

            frame.setVisible(true);
        });
    }
}


