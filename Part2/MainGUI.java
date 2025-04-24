package Part2;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainGUI extends JFrame {
    private RaceGUI raceGUI;
    private JLabel countdownLabel;
    private JTextField nameField;
    private JComboBox<String> colorBox;
    private JTextArea outputArea;
    private JTextField betField;
    private String userBet;

    public MainGUI() {
        setTitle("Horse Race Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        countdownLabel = new JLabel("Countdown appears here", SwingConstants.CENTER);
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(countdownLabel, BorderLayout.NORTH);

        raceGUI = new RaceGUI(countdownLabel);
        add(raceGUI, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(2, 1));

        // Horse input panel
        JPanel inputPanel = new JPanel();
        nameField = new JTextField(10);
        colorBox = new JComboBox<>(new String[]{"Red", "Blue", "Green", "Orange", "Black"});
        JButton addHorseBtn = new JButton("Add Horse");

        addHorseBtn.addActionListener(e -> {
            String name = nameField.getText();
            Color color = switch (colorBox.getSelectedItem().toString()) {
                case "Red" -> Color.RED;
                case "Blue" -> Color.BLUE;
                case "Green" -> Color.GREEN;
                case "Orange" -> Color.ORANGE;
                case "Black" -> Color.BLACK;
                default -> Color.GRAY;
            };
            HorseGUI horse = new HorseGUI(name, color, raceGUI.getHorses().size());
            raceGUI.addHorse(horse);
            outputArea.append("Added horse: " + name + "\n");
        });

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Color:"));
        inputPanel.add(colorBox);
        inputPanel.add(addHorseBtn);

        // Race control panel
        JPanel racePanel = new JPanel();
        betField = new JTextField(10);
        JButton startRaceBtn = new JButton("Start Race");

        startRaceBtn.addActionListener(this::startRace);

        racePanel.add(new JLabel("Bet on:"));
        racePanel.add(betField);
        racePanel.add(startRaceBtn);

        controlPanel.add(inputPanel);
        controlPanel.add(racePanel);
        add(controlPanel, BorderLayout.SOUTH);

        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    private void startRace(ActionEvent e) {
        if (raceGUI.getHorses().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Add at least one horse before starting the race.");
            return;
        }

        userBet = betField.getText();
        if (userBet.isBlank()) {
            JOptionPane.showMessageDialog(this, "Place your bet before starting the race.");
            return;
        }

        new Thread(() -> {
            try {
                // Countdown
                for (int i = 3; i >= 1; i--) {
                    int finalI = i;
                    SwingUtilities.invokeLater(() -> raceGUI.updateCountdown(finalI));
                    Thread.sleep(1000);
                }
                SwingUtilities.invokeLater(raceGUI::clearCountdown);

                boolean raceOver = false;
                while (!raceOver) {
                    Thread.sleep(50);
                    for (HorseGUI horse : raceGUI.getHorses()) {
                        horse.move();
                        if (horse.getDistanceTraveled() >= raceGUI.getTrackLength()) {
                            raceOver = true;
                            declareWinner(horse);
                            break;
                        }
                    }
                    raceGUI.repaint();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void declareWinner(HorseGUI winner) {
        String message = "🏁 Winner: " + winner.getName();
        if (winner.getName().equalsIgnoreCase(userBet)) {
            message += "\n🎉 You guessed right!";
        } else {
            message += "\n❌ You guessed wrong!";
        }

        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}









