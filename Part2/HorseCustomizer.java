package Part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HorseCustomizer extends JPanel {
    private JTextField nameField;
    private JComboBox<String> colorBox;
    private JButton addButton;
    private RaceGUI raceGUI;
    private int laneCounter = 0;

    public HorseCustomizer(RaceGUI raceGUI) {
        this.raceGUI = raceGUI;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Add a New Horse");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Horse name input
        add(new JLabel("Horse Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(15);
        add(nameField, gbc);

        // Horse color selection
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Horse Color:"), gbc);
        gbc.gridx = 1;
        colorBox = new JComboBox<>(new String[] {"Red", "Blue", "Green", "Black", "Orange", "Pink"});
        add(colorBox, gbc);

        // Add horse button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        addButton = new JButton("Add Horse");
        add(addButton, gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHorseToRace();
            }
        });
    }

    private void addHorseToRace() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a horse name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Color color = getColorFromName((String) colorBox.getSelectedItem());

        HorseGUI horse = new HorseGUI(name, color, laneCounter);
        raceGUI.addHorse(horse); // Add to RaceGUI
        laneCounter++;

        JOptionPane.showMessageDialog(this, "Horse added successfully!");
        nameField.setText("");
        colorBox.setSelectedIndex(0);
    }

    private Color getColorFromName(String colorName) {
        return switch (colorName) {
            case "Red" -> Color.RED;
            case "Blue" -> Color.BLUE;
            case "Green" -> Color.GREEN;
            case "Black" -> Color.BLACK;
            case "Orange" -> Color.ORANGE;
            case "Pink" -> Color.PINK;
            default -> Color.GRAY;
        };
    }
}





