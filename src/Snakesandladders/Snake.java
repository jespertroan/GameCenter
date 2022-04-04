package Snakesandladders;

import javax.swing.*;

public class Snake {
    public int start;
    public int end;
    public ImageIcon icon;
    public Snake(int start, int end) {
        this.start=start;
        this.end=end;
        this.icon= new ImageIcon(this.getClass().getResource("Resources/snake.png"));
    }
}
