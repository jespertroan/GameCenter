package Snakesandladders;

import javax.swing.*;
import java.awt.*;

public class Player {
    public String name;
    public int Score;
    public String color;
    public ImageIcon icon;

    public Player( String name, String color) {
        this.name=name;
        this.color = color;
        this.icon= new ImageIcon(this.getClass().getResource("Resources/" + color + ".png"));
    }
    public String GetName(){
        return  name;
    }
}
