


import java.awt.*;
import java.util.List;
import javax.swing.*;

public class RaceResultDialog extends JDialog {
    public RaceResultDialog(JFrame parent, List<String> results, String winner) {
        super(parent, "Race Results", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Serif", Font.PLAIN, 16));

        StringBuilder sb = new StringBuilder("Race Results:\n\n");
        for (int i = 0; i < results.size(); i++) {
            sb.append((i + 1)).append(". ").append(results.get(i)).append("\n");
        }
        sb.append("\nWinner: ").append(winner);

        resultArea.setText(sb.toString());

        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> setVisible(false));
        add(closeButton, BorderLayout.SOUTH);
    }
}
