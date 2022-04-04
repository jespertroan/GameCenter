package RollADice;                                //Import packages
import Clickgame.ClickGame;
import Snakesandladders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game center");                         //Create main frame
        JLabel title = new JLabel("Choose what game to play");            //Create objects
        title.setBounds(20, 10, 345, 40);
        Font font = new Font("Courier", Font.BOLD,16);
        title.setBackground(Color.white);
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setFont(font);

        JButton Clickgame = new JButton("Click game");
        Clickgame.setBounds(20,50,345,40);
        JButton Rollgame = new JButton("Roll a Dice");
        Rollgame.setBounds(20,100,345,40);
        JButton Snakegame = new JButton("Snakes and ladders");
        Snakegame.setBounds(20,150,345,40);
        JButton exit = new JButton("Exit");
        exit.setBounds(300, 300, 65, 20);

        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(Clickgame);                                     //Add objects to frame
        frame.add(Rollgame);
        frame.add(title);
        frame.add(exit);
        frame.add(Snakegame);



        Clickgame.addActionListener(new ActionListener() {                //If choosed clickgame run clickgame
            @Override
            public void actionPerformed(ActionEvent e) {
                ClickGame game = new ClickGame();
                game.ClickGame();
            }
        });
        Rollgame.addActionListener(new ActionListener() {                //If rollgame is choosed run rollgame
            @Override
            public void actionPerformed(ActionEvent e) {
                Game1 g = new Game1();
                g.Game1();
            }
        });
        exit.addActionListener(new ActionListener() {                 //If exit is choosed exit frame
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        Snakegame.addActionListener(new ActionListener() {               //If snakegame is choosed run snakegame
            @Override
            public void actionPerformed(ActionEvent e) {
                RunGame Snakegame = new RunGame();
                Snakegame.RunGame();
            }
        });


    }
}
