package Part2;

import java.awt.*;
import java.util.Random;

public class HorseGUI {
    private String name;
    private Color color;
    private int lane;
    private int distanceTraveled;
    private boolean finished;
    private int speed;
    private String emoji;

    private static final int HORSE_WIDTH = 40;
    private static final int HORSE_HEIGHT = 20;

    private static final String[] EMOJIS = { "🐎", "🐴", "🏇", "🐎💨", "🦄", "🐐" };
    private static int emojiIndex = 0;

    public HorseGUI(String name, Color color, int lane) {
        this.name = name;
        this.color = color;
        this.lane = lane;
        this.distanceTraveled = 0;
        this.finished = false;

        this.speed = new Random().nextInt(3) + 4; // Random speed between 4 and 6
        this.emoji = getNextEmoji();
    }

    // Assigns a different emoji to each horse
    private static String getNextEmoji() {
        String e = EMOJIS[emojiIndex % EMOJIS.length];
        emojiIndex++;
        return e;
    }

    // Draws the horse as an emoji and shows name
    public void draw(Graphics g) {
        int x = 50 + distanceTraveled;
        int y = (lane + 1) * 100;

        g.setColor(color);
        g.setFont(new Font("SansSerif", Font.BOLD, 18));
        g.drawString(emoji, x, y); // Emoji at position
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString(name, x, y - 10); // Name slightly above emoji
    }

    // Moves horse forward based on its individual speed
    public void move() {
        if (!finished) {
            distanceTraveled += speed;
            if (distanceTraveled >= 800) {
                distanceTraveled = 800;
                finished = true;
            }
        }
    }

    public void reset() {
        distanceTraveled = 0;
        finished = false;
    }

    public boolean hasFinished() {
        return finished;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getLane() {
        return lane;
    }

    public int getSpeed() {
        return speed;
    }
}





