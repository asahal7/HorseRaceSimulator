import java.awt.*;
import javax.swing.*;

public class TrackPanel extends JPanel {
    private int laneCount;

    public TrackPanel(int laneCount) {
        this.laneCount = laneCount;
        setBackground(Color.LIGHT_GRAY);
    }

    public void setLaneCount(int laneCount) {
        this.laneCount = laneCount;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        int laneHeight = getHeight() / (laneCount + 1);
        for (int i = 1; i <= laneCount; i++) {
            g.drawLine(0, i * laneHeight, getWidth(), i * laneHeight);
        }
    }
}
