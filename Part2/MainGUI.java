import javax.swing.*;

public class MainGUI extends JFrame {
    private JTabbedPane tabbedPane;
    private RaceGUI raceGUI;
    private HorseCustomizer horseCustomizer;
    private TrackCustomizer trackCustomizer;
    private StatisticsPanel statisticsPanel;
    private BettingPanel bettingPanel;

    public MainGUI() {
        super("Horse Race Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        raceGUI = new RaceGUI();
        horseCustomizer = new HorseCustomizer(raceGUI);
        trackCustomizer = new TrackCustomizer(raceGUI);
        statisticsPanel = new StatisticsPanel();
        bettingPanel = new BettingPanel();

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Race", raceGUI);
        tabbedPane.addTab("Horse Customizer", horseCustomizer);
        tabbedPane.addTab("Track Customizer", trackCustomizer);
        tabbedPane.addTab("Statistics", statisticsPanel);
        tabbedPane.addTab("Betting", bettingPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new MainGUI().setVisible(true);
        });
    }
}
