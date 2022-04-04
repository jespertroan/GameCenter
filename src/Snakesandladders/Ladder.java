package Snakesandladders;

import javax.swing.*;

public class Ladder {
    public int start;
    public int end;
    public ImageIcon icon;
    public Ladder(int start, int end) {
        this.start=start;
        this.end=end;
        this.icon= new ImageIcon(this.getClass().getResource("Resources/Ladder.png"));
    }
}
