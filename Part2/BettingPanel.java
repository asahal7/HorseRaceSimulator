package Part2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class BettingPanel extends JPanel {
    private JComboBox<String> horseDropdown;
    private JTextField betAmountField;
    private JTextArea betDisplay;
    private JButton placeBetButton;
    private List<String> bets;

    public BettingPanel() {
        setLayout(new BorderLayout());
        bets = new ArrayList<>();

        JPanel betForm = new JPanel(new FlowLayout());
        horseDropdown = new JComboBox<>(new String[] { "Horse 1", "Horse 2", "Horse 3", "Horse 4", "Horse 5" });
        betAmountField = new JTextField(5);
        placeBetButton = new JButton("Place Bet");

        betForm.add(new JLabel("Select Horse:"));
        betForm.add(horseDropdown);
        betForm.add(new JLabel("Bet Amount:"));
        betForm.add(betAmountField);
        betForm.add(placeBetButton);

        betDisplay = new JTextArea(10, 30);
        betDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(betDisplay);

        placeBetButton.addActionListener(this::handlePlaceBet);

        add(betForm, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void handlePlaceBet(ActionEvent e) {
        String selectedHorse = (String) horseDropdown.getSelectedItem();
        String amount = betAmountField.getText().trim();

        if (amount.matches("\\d+")) {
            String bet = "Bet £" + amount + " on " + selectedHorse;
            bets.add(bet);
            betDisplay.append(bet + "\n");
            betAmountField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the bet.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
}
