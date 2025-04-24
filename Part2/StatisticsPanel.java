package Part2;




import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class StatisticsPanel extends JPanel {
    private JTextArea statsArea;
    private Map<String, Integer> raceWins;
    private int totalRaces;

    public StatisticsPanel() {
        setLayout(new BorderLayout());

        statsArea = new JTextArea();
        statsArea.setEditable(false);
        statsArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(statsArea);

        raceWins = new HashMap<>();
        totalRaces = 0;

        add(new JLabel("Race Statistics", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateStats(String winnerName) {
        totalRaces++;
        raceWins.put(winnerName, raceWins.getOrDefault(winnerName, 0) + 1);
        refreshDisplay();
    }

    public void resetStats() {
        totalRaces = 0;
        raceWins.clear();
        refreshDisplay();
    }

    private void refreshDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total Races: ").append(totalRaces).append("\n\n");
        for (String horse : raceWins.keySet()) {
            sb.append(horse).append(": ").append(raceWins.get(horse)).append(" wins\n");
        }
        statsArea.setText(sb.toString());
    }
}
