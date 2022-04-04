package RollADice;                           //Import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game1 {
    public int player1 = 0;                //Set variables
    public int player2 = 0;
    public int turn = 0;
    public int maxTurns = 0;
    public JFrame f = new JFrame("Start");
    public JFrame frame = new JFrame("Roll game");
    public void Game1(){
        JLabel info = new JLabel("Choose how many turns you want!");               //Declare variables
        JButton okButton = new JButton("Ok");
        info.setBounds(70,120,260,50);
        info.setFont(new Font("Calibri", Font.BOLD, 16));
        okButton.setBounds(320,300,50,50);
        JRadioButton three = new JRadioButton("3");
        JRadioButton five = new JRadioButton("5");
        JRadioButton seven = new JRadioButton("7");
        three.setBounds(120,150,50,50);
        three.setSelected(true);
        five.setBounds(170,150,50,50);
        seven.setBounds(220,150,50,50);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(three);
        buttonGroup.add(five);
        buttonGroup.add(seven);

        f.add(three);
        f.add(five);
        f.add(seven);
        f.setLayout(null);
        f.add(info);
        f.add(okButton);
        f.setVisible(true);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (three.isSelected())                        //Set maxturns from users choice
                    maxTurns= 3;
                if (five.isSelected())
                    maxTurns=5;
                if (seven.isSelected())
                    maxTurns=7;
                f.dispose();
                frame.setVisible(true);
            }
        });
        JButton b1 = new JButton("Player 1");
        b1.setBounds(50, 100, 95, 30);
        JButton b2 = new JButton("Player 2");
        b2.setBounds(250, 100, 95, 30);
        b2.setEnabled(false);
        JButton exit = new JButton("X");
        exit.setBounds(350, 10, 30, 30);
        JLabel title = new JLabel("Roll a Dice");
        title.setVerticalAlignment(SwingConstants.TOP);
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setBounds(10,10,300,300);
        JLabel Description = new JLabel("<html>Each player take three alternate turns to roll a dice." +
                "<br>The one who scores maximums after three turns wins the game!");
        Description.setBounds(10,30,400,50);
        JTextField Player1score = new JTextField();
        Player1score.setBounds(50, 200,90, 20);
        Player1score.setEnabled(false);
        JTextField Player2score = new JTextField();
        Player2score.setBounds(250, 200,90, 20);
        Player2score.setEnabled(false);
        JTextField Dice = new JTextField();
        Dice.setBounds(150, 150,90, 30);
        Dice.setEnabled(false);
        JButton again = new JButton("Play again");
        again.setBounds(150, 300, 95, 30);
        again.setEnabled(false);
        JTextField Win = new JTextField();
        Win.setBounds(150, 250, 90, 30);
        Win.setEnabled(false);

        b1.addActionListener(new ActionListener() {                //If player1 rolls
            @Override
            public void actionPerformed(ActionEvent e) {
                Dice d = new Dice();
                int value = d.roll();                         //Roll dice
                Dice.setText(String.valueOf(value));
                player1 += value;                            //Sum up value
                Player1score.setText("Score:" + String.valueOf(player1));
                b1.setEnabled(false);
                b2.setEnabled(true);
            }
        });
        b2.addActionListener(new ActionListener() {                   //If player2 rolls
            @Override
            public void actionPerformed(ActionEvent e) {
                Dice d = new Dice();
                int value2 = d.roll();                                  //Roll dice
                Dice.setText(String.valueOf(value2));
                player2+=value2;                                     //Sum up value
                Player2score.setText("Score:" + String.valueOf(player2));
                b2.setEnabled(false);
                b1.setEnabled(true);
                turn+=1;
                if(turn>=maxTurns) {                                     //If taken 3 turns
                    b1.setEnabled(false);
                    again.setEnabled(true);
                    if(player2>player1) {                      //If player2 has higher score
                        Win.setText("Player2 Wins!");
                    }
                    else if(player1==player2) {               //If player1 has higher score
                        Win.setText("Square!");
                    }
                    else Win.setText("Player1 Wins!");
                }

            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        again.addActionListener(new ActionListener() {                   //If want to run again
            @Override
            public void actionPerformed(ActionEvent e) {
                player1=0;                                         //reset scores
                player2=0;
                turn=0;
                Player1score.setText("Score:" + String.valueOf(player1));         //Set info
                Player2score.setText("Score:" + String.valueOf(player2));
                Dice.setText(String.valueOf(0));
                b1.setEnabled(true);
                again.setEnabled(false);
                Win.setText(" ");
                Win.setEnabled(false);
                f.setVisible(true);
                frame.setVisible(false);
            }
        });

        frame.add(b1);                       //Add objects to frame
        frame.add(b2);
        frame.add(exit);
        frame.add(title);
        frame.add(Description);
        frame.add(Player1score);
        frame.add(Player2score);
        frame.add(Win);
        frame.add(Dice);
        frame.add(again);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
