import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackCustomizer extends JPanel {
    private JSpinner lengthSpinner;
    private JSpinner lanesSpinner;
    private JComboBox<String> shapeBox;
    private JComboBox<String> weatherBox;
    private JButton applyButton;
    private RaceGUI raceGUI;

    public TrackCustomizer(RaceGUI raceGUI) {
        this.raceGUI = raceGUI;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Customize Track");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Track Length Spinner
        add(new JLabel("Track Length:"), gbc);
        gbc.gridx = 1;
        lengthSpinner = new JSpinner(new SpinnerNumberModel(100, 50, 1000, 50)); // min: 50, max: 1000
        add(lengthSpinner, gbc);

        // Lane Count Spinner
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Number of Lanes:"), gbc);
        gbc.gridx = 1;
        lanesSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 10, 1)); // min: 1, max: 10
        add(lanesSpinner, gbc);

        // Track Shape Dropdown
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Track Shape:"), gbc);
        gbc.gridx = 1;
        shapeBox = new JComboBox<>(new String[] { "Oval", "Figure-eight" });
        add(shapeBox, gbc);

        // Weather Condition Dropdown
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Weather Condition:"), gbc);
        gbc.gridx = 1;
        weatherBox = new JComboBox<>(new String[] { "Dry", "Rainy", "Snowy", "Windy" });
        add(weatherBox, gbc);

        // Apply Button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        applyButton = new JButton("Apply Settings");
        add(applyButton, gbc);

        // Action listener
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applySettings();
            }
        });
    }

    private void applySettings() {
        int length = (Integer) lengthSpinner.getValue();
        int lanes = (Integer) lanesSpinner.getValue();
        String shape = (String) shapeBox.getSelectedItem();
        String weather = (String) weatherBox.getSelectedItem();

        raceGUI.setTrackParameters(length, lanes, shape, weather);
        JOptionPane.showMessageDialog(this, "Track settings applied successfully!");
    }
}
