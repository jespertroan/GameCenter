        package Snakesandladders;

import javax.swing.*;                      //Import packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;


        public class RunGame {
    final int Maxbuttons = 35;       //Declare variables
    int value1 = 0;
    int value2 = 0;
    CompoundIcon CI = new CompoundIcon();

    //Resizes icon to fit label
    private static ImageIcon resizeIcon(ImageIcon icon, int Width, int Height) {
        Image img = icon.getImage();                                                   //Makes image object
        Image resizedIcon = img.getScaledInstance(Width, Height,  java.awt.Image.SCALE_SMOOTH);  //Scales image
        return new ImageIcon(resizedIcon);                                                      //returns resized imageobject
    }



    public void RunGame(){
        Player Player1 = new Player("Player1", "Red");      //Declare default objects
        Player Player2 = new Player("Player2", "Blue");
        Snake Snake1 = new Snake(34,20);
        Snake Snake2 = new Snake(16,2);
        Ladder Ladder1 = new Ladder(18,31);
        Ladder Ladder2 = new Ladder(7,20);

        try {
            File file = new File("State.txt");         //Create the file
            Scanner Myscanner = new Scanner(file);            //Create new scanner
            Player1.Score=Myscanner.nextInt();                     //Read from file
            Player2.Score=Myscanner.nextInt();                     //Read from file
            Myscanner.close();                              //Close file
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }

        System.out.println(Player1.Score);
        System.out.println(Player2.Score);

        ImageIcon Dice1 = new ImageIcon(this.getClass().getResource("Resources/dice1.jpg"));    //import Dice icons
        ImageIcon Dice2 = new ImageIcon(this.getClass().getResource("Resources/dice2.jpg"));
        ImageIcon Dice3 = new ImageIcon(this.getClass().getResource("Resources/dice3.jpg"));
        ImageIcon Dice4 = new ImageIcon(this.getClass().getResource("Resources/dice4.jpg"));
        ImageIcon Dice5 = new ImageIcon(this.getClass().getResource("Resources/dice5.jpg"));
        ImageIcon Dice6 = new ImageIcon(this.getClass().getResource("Resources/dice6.jpg"));
        ImageIcon Dice = new ImageIcon(this.getClass().getResource("Resources/dice.png"));




        JFrame f = new JFrame("Snakes and Ladder game");         //Initialize the main Jframe with objects
        JButton NewGame = new JButton("New game");
        NewGame.setBounds(290, 580, 120, 30);
        JButton Player1Roll = new JButton(Player1.GetName() + " - ROLL");
        Player1Roll.setBounds(65, 600, 140, 30);
        Player1Roll.setEnabled(false);
        JButton Player2Roll = new JButton(Player2.GetName() + "- ROLL");
        Player2Roll.setBounds(475, 600, 140, 30);
        Player2Roll.setEnabled(false);
        JLabel Dicevalue1 = new JLabel();
        Dicevalue1.setBounds(250, 610,40, 40);
        Dicevalue1.setIcon(resizeIcon(Dice, Dicevalue1.getWidth(), Dicevalue1.getHeight()));
        JLabel Dicevalue2 = new JLabel();
        Dicevalue2.setBounds(410, 610,40, 40);
        Dicevalue2.setIcon(resizeIcon(Dice, Dicevalue2.getWidth(), Dicevalue2.getHeight()));
        JLabel Info = new JLabel("Click start new game");
        Info.setForeground(Color.CYAN);
        Info.setFont(new Font("Calibri", Font.BOLD, 20));
        Info.setBounds(250,  5,300,30);
        JButton exit = new JButton("Exit");
        exit.setBounds(600, 10, 70, 30);
        JLabel Player1Score = new JLabel(Player1.GetName() + " score:");
        Player1Score.setBounds(20,0,120,30);
        Player1Score.setForeground(Color.CYAN);
        JLabel Player2Score = new JLabel(Player2.GetName() + " score:");
        Player2Score.setBounds(20,15,120,30);
        Player2Score.setForeground(Color.CYAN);
        JLabel Snake1Icon = new JLabel();
        Snake1Icon.setBounds(300,45,230,270);
        Snake1Icon.setIcon(resizeIcon(Snake1.icon, Snake1Icon.getWidth(), Snake1Icon.getHeight()));
        JLabel Snake2Icon = new JLabel();
        Snake2Icon.setBounds(300,305,230,270);
        Snake2Icon.setIcon(resizeIcon(Snake2.icon, Snake2Icon.getWidth(), Snake2Icon.getHeight()));
        JLabel Ladder1Icon = new JLabel();
        Ladder1Icon.setBounds(190,270,120,200);
        Ladder1Icon.setIcon(resizeIcon(Ladder1.icon, Ladder1Icon.getWidth(), Ladder1Icon.getHeight()));
        JLabel Ladder2Icon = new JLabel();
        Ladder2Icon.setBounds(95,100,120,200);
        Ladder2Icon.setIcon(resizeIcon(Ladder2.icon, Ladder2Icon.getWidth(), Ladder2Icon.getHeight()));






        Font calibri =new Font("Calibri", Font.BOLD, 15);     //Declares new font

        JFrame f2 = new JFrame("Set up game");                     //Initialize the set up game frame
        JLabel NameP1 = new JLabel("Choose name for player 1:");
        NameP1.setBounds(10,10,170,40);
        NameP1.setForeground(Color.CYAN);
        NameP1.setFont(calibri);
        JLabel NameP2 = new JLabel("Choose name for player 2:");
        NameP2.setBounds(200,10,170,40);
        NameP2.setForeground(Color.CYAN);
        NameP2.setFont(calibri);
        JTextField P1Name = new JTextField("Player1");
        P1Name.setBounds(10,40,170,30);
        P1Name.setFont(calibri);
        JTextField P2Name = new JTextField("Player2");
        P2Name.setBounds(200,40,170,30);
        P2Name.setFont(calibri);
        JLabel ColorP1 = new JLabel("Choose color for player 1:");
        ColorP1.setBounds(10,100,170,40);
        ColorP1.setForeground(Color.CYAN);
        ColorP1.setFont(calibri);
        JLabel ColorP2 = new JLabel("Choose color for player 2:");
        ColorP2.setBounds(200,100,170,40);
        ColorP2.setForeground(Color.CYAN);
        ColorP2.setFont(calibri);
        String Colours[] = { "Blue", "Yellow", "Red", "Pink", "Purple", "Green"};
        JComboBox ChooseP1 = new JComboBox(Colours);
        ChooseP1.setBounds(10,130,170,30);
        JComboBox ChooseP2 = new JComboBox(Colours);
        ChooseP2.setBounds(200,130,170,30);
        JButton OkButton = new JButton("OK");
        OkButton.setBounds(120,300,140,35);

        JFrame f3 = new JFrame("How To play");           //Make new frame
        //Make string
        String str = "Start a new game by clicking the new game button. Each player takes turn in rolling two dices." +
                " If the number on both dices is the same the player gets another turn. If a player token (piece) falls" +
                " on the first ladder step, the player token (piece) will move up the ladder to a new position ONLY" +
                " when the position it lands on is clicked. If a player token (piece) falls on the snakehead, the player’s" +
                "piece moves down to the new position ONLY when the position it lands on (i.e., snakehead block) is clicked." +
                " A player cannot move a token (piece) if the value on dice rolls is greater than the steps required to land on the " +
                "\"finish\" block. The turn is given to the other player. The player who lands on the last block wins the game." +
                " If a player wants to resign the player can click resign in the menu bar. In that case the other person will win.";

        JTextArea HowtoPlayText = new JTextArea();                 //Set variables in frame
        HowtoPlayText.setBounds(10,10,440,440);
        HowtoPlayText.setLineWrap(true);
        HowtoPlayText.setWrapStyleWord(true);
        HowtoPlayText.setEditable(false);
        HowtoPlayText.setFont(calibri);
        HowtoPlayText.setText(str);
        HowtoPlayText.setBackground(Color.DARK_GRAY);
        HowtoPlayText.setForeground(Color.CYAN);

        JButton undoMove = new JButton("Undo move");
        undoMove.setBounds(10,40,100,20);
        undoMove.setEnabled(false);

        JPanel Buttonpanel = new JPanel();                               //Initialize the board
        Buttonpanel.setLayout(new GridLayout(6,6));
        Buttonpanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JMenuBar Menubar = new JMenuBar();                              //Initialize the Menubar
        JMenu File = new JMenu("File");
        JMenu Help = new JMenu("Help");
        JMenu About = new JMenu("About");
        JMenuItem Newgame = new JMenuItem("New game");
        JMenuItem Reset = new JMenuItem("Reset");
        JMenuItem Resign = new JMenuItem("Resign");
        Resign.setEnabled(false);
        JMenuItem Exit = new JMenuItem("Exit");
        JMenuItem HowToPlay = new JMenuItem("How to play");
        JMenuItem GameVersion = new JMenuItem("Gameversion");
        JMenuItem Author = new JMenuItem("Author");




        JButton[] Buttons = new JButton[Maxbuttons+1];      //Declare array with JButtons
        for(int i = 0; i<Buttons.length;i++)                //Loop through Buttons
        {
           Buttons[i]=new JButton(String.valueOf(36-i));     //Set text so 1st gets to bottom left
           Buttonpanel.add(Buttons[i]);
            int row = (i / 6) % 2;
            if (row == 0) {                                 //Color every other row
                Buttons[i].setBackground(i % 2 == 0 ? Color.CYAN : Color.white);  //Color the evens CYAN
            }
            else {
                Buttons[i].setBackground(i % 2 == 0 ? Color.white : Color.CYAN); //Color the odds Cyan
            }
        }

        //Reverse array to get right place for right text
        for(int i=0; i<Buttons.length/2; i++) {
            JButton temp = Buttons[i];                         //Save in temp
            Buttons[i] = Buttons[Buttons.length - i - 1];     //puts last in first place and so on..
            Buttons[Buttons.length - i - 1] = temp;          //Puts first in last place and so on..
        }
        Buttons[35].setText("FINISH!");



        if(Player1.Score != 0 && Player2.Score!=0)
        {
            Buttons[Player1.Score].setIcon(Player1.icon);
            Buttons[Player2.Score].setIcon(Player2.icon);
            NewGame.setEnabled(true);
            Player1Roll.setEnabled(true);
            Player2Roll.setEnabled(false);
            Info.setText(Player1.GetName() +"s turn!");                  //Reset labels
            Reset.setEnabled(true);
            Resign.setEnabled(true);
            Player1Score.setText(Player1.GetName() + " score:" + (Player1.Score+1));
            Player2Score.setText(Player2.GetName() + " score:" + (Player2.Score+1));
        }





        OkButton.addActionListener(new ActionListener() {       //If Okbutton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                Resign.setEnabled(true);                      //Enable resign button
                Player1.name=P1Name.getText();               //Get name from input in textfields
                Player2.name=P2Name.getText();
                Player1.color=ChooseP1.getSelectedItem().toString();   //Get selected items from Jcombobox
                Player2.color=ChooseP2.getSelectedItem().toString();
                if (Player1.color==Player2.color) {                    //If selected same color
                 ColorP1.setText("Cannot choose same color!");
                 ColorP2.setText("Cannot choose same color!");
                }
                else {
                    Buttons[Player1.Score].setIcon(null);          //Reset icons
                    Buttons[Player2.Score].setIcon(null);
                    Dicevalue1.setIcon(resizeIcon(Dice, Dicevalue1.getWidth(), Dicevalue1.getHeight()));
                    Dicevalue2.setIcon(resizeIcon(Dice, Dicevalue1.getWidth(), Dicevalue1.getHeight()));
                    Player1.Score=0;                              //Reset scores
                    Player2.Score=0;
                    //Set icon to selected icon
                    Player1.icon = new ImageIcon(this.getClass().getResource("Resources/" + Player1.color + ".png"));
                    Player2.icon = new ImageIcon(this.getClass().getResource("Resources/" + Player2.color + ".png"));
                    CI = new CompoundIcon(Player1.icon,Player2.icon);
                    Info.setText(Player1.GetName() +"s turn!");                  //Reset labels
                    Player1Score.setText(Player1.GetName() + " score:");
                    Player2Score.setText(Player2.GetName() + " score:");
                    Player1Roll.setText(Player1.GetName() + " - ROLL");
                    Player2Roll.setText(Player2.GetName() + " - ROLL");
                    Buttons[0].setIcon(CI);                         //Set icons to start
                    f2.dispose();                                            //Close frame
                    Player1Roll.setEnabled(true);                           //Enable buttons
                    NewGame.setEnabled(true);
                    Reset.setEnabled(true);
                }
            }
        });

        NewGame.addActionListener(new ActionListener() {               //If Newgame button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true);                        //Enable frame2
            }
        });

        undoMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Player1Roll.isEnabled() && Player2.Score > 0){
                    undoMove.setEnabled(false);
                    Buttons[Player2.Score].setIcon(null);
                    Player2.Score = (Player2.Score - value1 - value2);
                    Buttons[Player2.Score].setIcon(Player2.icon);    //set icon and show information
                    Player2Score.setText(Player2.GetName() + " score:" + (Player2.Score+1));
                    Player2Roll.setEnabled(true);
                    Player1Roll.setEnabled(false);
                }
                else if (Player2Roll.isEnabled() && Player1.Score > 0){
                    undoMove.setEnabled(false);
                    Buttons[Player1.Score].setIcon(null);
                    Player1.Score = (Player1.Score - value1 - value2);
                    Buttons[Player1.Score].setIcon(Player1.icon);    //set icon and show information
                    Player1Score.setText(Player1.GetName() + " score:" + (Player1.Score+1));
                    Player1Roll.setEnabled(true);
                    Player2Roll.setEnabled(false);
                }
                if(Player1.Score == Player2.Score){                            //If score is same
                    Buttons[Player1.Score].setIcon(CI);                        //Set both icons to button.
                }
                if (NewGame.isEnabled()){
                    undoMove.setEnabled(false);
                }
            }
        });


        Player1Roll.addActionListener(new ActionListener() {    //If Player1Roll button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                undoMove.setEnabled(true);
                Info.setText(Player2.GetName() +"s turn!");       //Set labels
                Buttons[Player1.Score].setIcon(null);
                Buttons[Player2.Score].setIcon(Player2.icon);
                Dice d = new Dice();                             //Roll dice
                 value1 = d.roll();
                 value2 = d.roll();


                Player1.Score += value1;                        //Sum up dicevalues to score
                Player1.Score += value2;

                 switch (value1)                               //Output dicevalue1
                {
                  case 1: Dicevalue1.setIcon(resizeIcon(Dice1, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                  case 2: Dicevalue1.setIcon(resizeIcon(Dice2, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                  case 3: Dicevalue1.setIcon(resizeIcon(Dice3, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                  case 4: Dicevalue1.setIcon(resizeIcon(Dice4, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                  case 5: Dicevalue1.setIcon(resizeIcon(Dice5, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                  case 6: Dicevalue1.setIcon(resizeIcon(Dice6, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                }
                switch (value2)                           //Output dicevalue2
                {
                    case 1: Dicevalue2.setIcon(resizeIcon(Dice1, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 2: Dicevalue2.setIcon(resizeIcon(Dice2, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 3: Dicevalue2.setIcon(resizeIcon(Dice3, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 4: Dicevalue2.setIcon(resizeIcon(Dice4, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 5: Dicevalue2.setIcon(resizeIcon(Dice5, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 6: Dicevalue2.setIcon(resizeIcon(Dice6, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                }
                 Player1Roll.setEnabled(false);         //Give turn to player2
                 Player2Roll.setEnabled(true);


                 if (Player1.Score<=35)                   //If not in goal or in goal
                 {
                     Buttons[Player1.Score].setIcon(Player1.icon);    //set icon and show information
                     Player1Score.setText(Player1.GetName() + " score:" + (Player1.Score+1));
                 }
                 else if (Player1.Score>35)             //If the player gets over whats required to finish
                 {
                     undoMove.setEnabled(false);
                     Player1.Score=Player1.Score-value1-value2;        //Set score to the same as before roll
                     Buttons[Player1.Score].setIcon(Player1.icon);       //Set icon and show information
                     Player1Score.setText(Player1.GetName() + " score:" + (Player1.Score+1));
                 }
                 if(Player1.Score == 16 || Player1.Score== 34)            //If lands in snake
                 {
                     Info.setText( Player1.GetName() + " lands on a snake!");    //Set information and disable buttons
                     Player1Roll.setEnabled(false);
                     Player2Roll.setEnabled(false);
                     undoMove.setEnabled(false);
                 }
                if(Player1.Score == 7 || Player1.Score== 18)             //if lands on ladder
                {
                    Info.setText( Player1.GetName() + " lands on a Ladder!");   //Set information and disable buttons
                    Player1Roll.setEnabled(false);
                    Player2Roll.setEnabled(false);
                    undoMove.setEnabled(false);
                }
                 if (Player1.Score==35)                                 //If in goal
                 {
                     Info.setText(Player1.GetName() + " WINS!");    //Set information, disable buttons and enable newgame
                     Player1Score.setText(Player1.GetName() + " WINNER!");
                     Player1Roll.setEnabled(false);
                     Player2Roll.setEnabled(false);
                     NewGame.setEnabled(true);
                     Resign.setEnabled(false);
                     undoMove.setEnabled(false);
                 }
                else if(value1==value2) {                          //If dice values is same
                    Player1Roll.setEnabled(true);                 //Give turn to the same player
                    Player2Roll.setEnabled(false);
                    Info.setText(Player1.GetName() +" gets another turn!");   //set information
                     undoMove.setEnabled(false);
                }

                if(Player1.Score == 16 || Player1.Score== 34 && value1==value2)   //If lands on snake and dicevalues is same
                {
                    Info.setText( Player1.GetName() + " lands on a Snake!");     //Set info
                    Player1Roll.setEnabled(false);                               //disable buttons
                    Player2Roll.setEnabled(false);
                    undoMove.setEnabled(false);
                }
                if(Player1.Score == 7 || Player1.Score== 18 && value1==value2){   //If lands on ladder and dicevalues is same
                    Info.setText( Player1.GetName() + " lands on a Ladder!");     //set info
                    Player1Roll.setEnabled(false);                               //disable buttons
                    Player2Roll.setEnabled(false);
                    undoMove.setEnabled(false);
                }
                if(Player1.Score == Player2.Score){                            //If score is same
                    Buttons[Player1.Score].setIcon(CI);                        //Set both icons to button.
                }
            }
        });


        Player2Roll.addActionListener(new ActionListener() {                //If Player2Roll button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                undoMove.setEnabled(true);
                Info.setText(Player1.GetName() +"s turn!");                //Set labels
                Buttons[Player2.Score].setIcon(null);
                Buttons[Player1.Score].setIcon(Player1.icon);
                Dice d = new Dice();                                     //Roll dice
                 value1 = d.roll();
                 value2 = d.roll();

                Player2.Score += value1;                               //Sum up dicevalues to score
                Player2.Score += value2;

                switch (value1)                                      //Output dicevalue 1
                {
                    case 1: Dicevalue1.setIcon(resizeIcon(Dice1, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                    case 2: Dicevalue1.setIcon(resizeIcon(Dice2, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                    case 3: Dicevalue1.setIcon(resizeIcon(Dice3, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                    case 4: Dicevalue1.setIcon(resizeIcon(Dice4, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                    case 5: Dicevalue1.setIcon(resizeIcon(Dice5, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                    case 6: Dicevalue1.setIcon(resizeIcon(Dice6, Dicevalue1.getWidth(), Dicevalue1.getHeight())); break;
                }
                switch (value2)                                    //Output dicevalue 2
                {
                    case 1: Dicevalue2.setIcon(resizeIcon(Dice1, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 2: Dicevalue2.setIcon(resizeIcon(Dice2, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 3: Dicevalue2.setIcon(resizeIcon(Dice3, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 4: Dicevalue2.setIcon(resizeIcon(Dice4, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 5: Dicevalue2.setIcon(resizeIcon(Dice5, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                    case 6: Dicevalue2.setIcon(resizeIcon(Dice6, Dicevalue2.getWidth(), Dicevalue2.getHeight())); break;
                }
                Player2Roll.setEnabled(false);                  //Give turn to player 1
                Player1Roll.setEnabled(true);

                if (Player2.Score<=35){                         //If not in goal or in goal
                    Buttons[Player2.Score].setIcon(Player2.icon);       //Set labels
                    Player2Score.setText(Player2.GetName() + " score:" + (Player2.Score+1));
                }
                else if (Player2.Score>35)                    //If the player gets over whats required to finish
                {
                    Player2.Score=Player2.Score-value1-value2;     //Set score to the same as before roll
                    Buttons[Player2.Score].setIcon(Player2.icon);        //Set labels
                    Player2Score.setText(Player2.GetName() + " score:" + (Player2.Score+1));
                    undoMove.setEnabled(false);
                }
                if(Player2.Score == 16 || Player2.Score== 34)           //If lands on snake
                {
                    Info.setText( Player2.GetName() + " lands on a snake!");  //Set information and disable buttons
                    Player1Roll.setEnabled(false);
                    Player2Roll.setEnabled(false);
                    undoMove.setEnabled(false);
                }
                if(Player2.Score == 7 || Player2.Score== 18)                //If lands on ladder
                {
                    Info.setText( Player2.GetName() + " lands on a Ladder!");   //Set information and disable buttons
                    Player1Roll.setEnabled(false);
                    Player2Roll.setEnabled(false);
                    undoMove.setEnabled(false);
                }
                 if (Player2.Score==35)                                      //If in goal
                {
                    Info.setText(Player2.GetName() + " WINS!"); //Set information, disable buttons and enable newgame
                    Player2Score.setText(Player2.GetName() + "WINNER!");
                    Player1Roll.setEnabled(false);
                    Player2Roll.setEnabled(false);
                    NewGame.setEnabled(true);
                    Resign.setEnabled(false);
                    undoMove.setEnabled(false);
                }
                else if(value1==value2) {                            //If gets same dicevalues
                    Player2Roll.setEnabled(true);                    //Give turn to the same player
                    Player1Roll.setEnabled(false);
                    Info.setText(Player2.GetName() +" gets another turn!");
                    undoMove.setEnabled(false);
                }
                if(Player2.Score == 16 || Player2.Score== 34 && value1==value2)   //If lands on snake and dicevalues is same
                {
                    Info.setText( Player2.GetName() + " lands on a Snake!");    //Set information and disable buttons
                    Player1Roll.setEnabled(false);
                    Player2Roll.setEnabled(false);
                    undoMove.setEnabled(false);
                }
                if(Player2.Score == 7 || Player2.Score== 18 && value1==value2){   //If lands on ladder and dicevalue is same
                    Info.setText( Player2.GetName() + " lands on a Ladder!");    //Set information and disable buttons
                    Player1Roll.setEnabled(false);
                    Player2Roll.setEnabled(false);
                    undoMove.setEnabled(false);
                }
                if(Player1.Score == Player2.Score){                             //If both scores is same
                    Buttons[Player2.Score].setIcon(CI);                        //Set both icons to button
                }
            }
        });





        Buttons[16].addActionListener(new ActionListener() {         //If head of snake is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Player1.Score == 16) {                       //If player one lands on snake
                    Buttons[Player1.Score].setIcon(null);       //Remove icon
                    Player1.Score = (Player1.Score - 14);       //Subtract Player score
                    Player1Score.setText(Player1.GetName() + " score:" + (Player1.Score+1)); //Set information
                    Buttons[Player1.Score].setIcon(Player1.icon);        //Set icon to new place
                    if(value1==value2){                                //If dicevalues is same
                        Info.setText(Player1.GetName() + " gets another turn!");    //Give the same player another turn
                        Player1Roll.setEnabled(true);
                    }
                    else {                                         //If not same values give away the turn to next player
                        Info.setText(Player2.GetName() + "s turn!");
                        Player2Roll.setEnabled(true);
                    }
                } else if (Player2.Score == 16) {                   //If player two lands on snake
                    Buttons[Player2.Score].setIcon(null);           //Remove icon
                    Player2.Score = (Player2.Score - 14);            //Subtract Player score
                    Player2Score.setText(Player2.GetName() + " score:" + (Player2.Score+1)); //Set information
                    Buttons[Player2.Score].setIcon(Player2.icon);                //Set icon to new value
                    if(value1==value2){                                          //If dicevalues is same
                        Info.setText(Player2.GetName() + " gets another turn!");    //Give the same player another turn
                        Player2Roll.setEnabled(true);
                    }
                    else {                                          //If not same values give away the turn to next player
                        Info.setText(Player1.GetName() + "s turn!");
                        Player1Roll.setEnabled(true);
                    }
                }
                if(Player1.Score == Player2.Score){                  //If both scores is same
                    Buttons[Player2.Score].setIcon(CI);              //Set both icons to button
                }
            }
        });

        Buttons[34].addActionListener(new ActionListener() {        //If Head of snake is clicked
            @Override
            public void actionPerformed(ActionEvent e) {           //See Buttons[2] for comments
                if (Player1.Score == 34) {
                    Buttons[Player1.Score].setIcon(null);
                    Player1.Score = (Player1.Score - 14);
                    Player1Score.setText(Player1.GetName() + " score:" + (Player1.Score+1));
                    Buttons[Player1.Score].setIcon(Player1.icon);
                    if(value1==value2){
                        Info.setText(Player1.GetName() + " gets another turn!");
                        Player1Roll.setEnabled(true);
                    }
                    else {
                        Info.setText(Player2.GetName() + "s turn!");
                        Player2Roll.setEnabled(true);
                    }
                } else if (Player2.Score == 34) {
                    Buttons[Player2.Score].setIcon(null);
                    Player2.Score = (Player2.Score - 14);
                    Player2Score.setText(Player2.GetName() + " score:" + (Player2.Score+1));
                    Buttons[Player2.Score].setIcon(Player2.icon);
                    if(value1==value2){
                        Info.setText(Player2.GetName() + " gets another turn!");
                        Player2Roll.setEnabled(true);
                    }
                    else {
                        Info.setText(Player1.GetName() + "s turn!");
                        Player1Roll.setEnabled(true);
                    }
                }
                if(Player1.Score == Player2.Score){
                    Buttons[Player2.Score].setIcon(CI);
                }
            }
        });


        Buttons[18].addActionListener(new ActionListener() {        //If start of ladder is clicked
            @Override
            public void actionPerformed(ActionEvent e) {           //See Buttons[2] for comments
                if (Player1.Score == 18) {
                    Buttons[Player1.Score].setIcon(null);
                    Player1.Score = (Player1.Score + 13);
                    Player1Score.setText(Player1.GetName() + " score:" + (Player1.Score+1));
                    Buttons[Player1.Score].setIcon(Player1.icon);
                    if(value1==value2){
                        Info.setText(Player1.GetName() + " gets another turn!");
                        Player1Roll.setEnabled(true);
                    }
                    else {
                        Info.setText(Player2.GetName() + "s turn!");
                        Player2Roll.setEnabled(true);
                    }
                } else if (Player2.Score == 18) {
                    Buttons[Player2.Score].setIcon(null);
                    Player2.Score = (Player2.Score + 13);
                    Player2Score.setText(Player2.GetName() + " score:" + (Player2.Score+1));
                    Buttons[Player2.Score].setIcon(Player2.icon);
                    if(value1==value2){
                        Info.setText(Player2.GetName() + " gets another turn!");
                        Player2Roll.setEnabled(true);
                    }
                    else {
                        Info.setText(Player1.GetName() + "s turn!");
                        Player1Roll.setEnabled(true);
                    }
                }
                if(Player1.Score == Player2.Score){
                    Buttons[Player2.Score].setIcon(CI);
                }
            }
        });

        Buttons[7].addActionListener(new ActionListener() {       //If start of ladder is clicked
            @Override
            public void actionPerformed(ActionEvent e) {         //See Buttons[2] for comments
                if (Player1.Score == 7) {
                    Buttons[Player1.Score].setIcon(null);
                    Player1.Score = (Player1.Score + 13);
                    Player1Score.setText(Player1.GetName() + " score:" + (Player1.Score+1));
                    Buttons[Player1.Score].setIcon(Player1.icon);
                    if(value1==value2){
                        Info.setText(Player1.GetName() + " gets another turn!");
                        Player1Roll.setEnabled(true);
                    }
                    else {
                        Info.setText(Player2.GetName() + "s turn!");
                        Player2Roll.setEnabled(true);
                    }
                } else if (Player2.Score == 7) {
                    Buttons[Player2.Score].setIcon(null);
                    Player2.Score = (Player2.Score + 13);
                    Player2Score.setText(Player2.GetName() + " score:" + (Player2.Score+1));
                    Buttons[Player2.Score].setIcon(Player2.icon);
                    if(value1==value2){
                        Info.setText(Player2.GetName() + " gets another turn!");
                        Player2Roll.setEnabled(true);
                    }
                    else {
                        Info.setText(Player1.GetName() + "s turn!");
                        Player1Roll.setEnabled(true);
                    }
                }
                if(Player1.Score == Player2.Score){
                    Buttons[Player2.Score].setIcon(CI);
                }
            }
        });

        exit.addActionListener(new ActionListener() {          //If exitbutton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();                                 //Close main frame
                try {
                    File gameStateFile = new File("state.txt");
                    if (gameStateFile.createNewFile()) {
                        System.out.println("file created: " + gameStateFile.getName());
                    }
                    else {
                        System.out.println("File already exists, Writing game state to file");
                    }

                    FileWriter Mywriter = new FileWriter(gameStateFile);
                    Mywriter.write(Integer.toString(Player1.Score));          //Write to file
                    Mywriter.write("\n");
                    Mywriter.write(Integer.toString(Player2.Score));          //Write to file
                    Mywriter.close();
                }catch (IOException ioExceptione){
                    System.out.println(ioExceptione);
                }
            }
        });

        Reset.addActionListener(new ActionListener() {       //If reset is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                Buttons[Player1.Score].setIcon(null);       //Reset values and icons
                Buttons[Player2.Score].setIcon(null);
                Dicevalue1.setIcon(resizeIcon(Dice, Dicevalue1.getWidth(), Dicevalue1.getHeight()));
                Dicevalue2.setIcon(resizeIcon(Dice, Dicevalue1.getWidth(), Dicevalue1.getHeight()));
                Player1.Score=0;
                Player2.Score=0;
                NewGame.setEnabled(false);
                Player1Roll.setEnabled(true);
                Info.setText(Player1.GetName() +"s turn!");
                Player1Score.setText(Player1.GetName() + "  score:");
                Player2Score.setText(Player2.GetName() + "  score:");
                Buttons[0].setIcon(CI);
            }
        });

        Newgame.addActionListener(new ActionListener() {       //If newgame button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true);                         //Show Set up game frame
            }
        });

        Exit.addActionListener(new ActionListener() {         //If exit menuitem is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();                                 //Close frame
            }
        });

        Resign.addActionListener(new ActionListener() {       //If resing menuitem is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                Resign.setEnabled(false);                       //Set values
                Buttons[Player1.Score].setIcon(null);
                Buttons[Player2.Score].setIcon(null);
                Dicevalue1.setIcon(resizeIcon(Dice, Dicevalue1.getWidth(), Dicevalue1.getHeight()));
                Dicevalue2.setIcon(resizeIcon(Dice, Dicevalue1.getWidth(), Dicevalue1.getHeight()));
                Player1.Score=0;
                Player2.Score=0;
                Player1Score.setText(Player1.GetName() + "  score:");
                Player2Score.setText(Player2.GetName() + "  score:");
                if (Player1Roll.isEnabled()){                          //If player1 resigns
                    Info.setText(Player2.GetName() + "Wins!");         //Player2 wins
                    Player2Score.setText(Player2.GetName() + "WINNER!");
                }
                else if (Player2Roll.isEnabled()) {                   //If Player2 resigns
                    Info.setText(Player1.GetName() + "Wins!");        //Player1 wins
                    Player1Score.setText(Player1.GetName() + "WINNER!");
                }
                Player1Roll.setEnabled(false);                     //Disable roll buttons and enable Newgame
                Player2Roll.setEnabled(false);
                NewGame.setEnabled(true);
            }
        });

        Author.addMouseListener(new MouseAdapter() {           //If mouse is on menuitem Author
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Author.setText("Jesper Trøan");           //Display Author
            }
        });

        GameVersion.addMouseListener(new MouseAdapter() {      //If mouse is on menuitem Gameversion
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GameVersion.setText("1.0.0");                //Display gameversion
            }
        });

        HowToPlay.addActionListener(new ActionListener() {         //If howtoplay menuitem is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                f3.setVisible(true);                            //Set Howtoplay frame visible
            }
        });







        JLayeredPane Layeredpane = new JLayeredPane();             //Make a new layeredpane
        Layeredpane.add(Snake1Icon, JLayeredPane.POPUP_LAYER);   //Adds snakes and ladders in front of the rest in frame
        Layeredpane.add(Snake2Icon, JLayeredPane.POPUP_LAYER);
        Layeredpane.add(Ladder1Icon, JLayeredPane.POPUP_LAYER);
        Layeredpane.add(Ladder2Icon, JLayeredPane.POPUP_LAYER);





        f.getContentPane().setBackground(Color.DARK_GRAY);          //Set colors
        Buttonpanel.setBackground(Color.black);
        Layeredpane.add(NewGame, JLayeredPane.DEFAULT_LAYER);      //Adds the rest behind the snakes and ladders
        Layeredpane.add(Dicevalue1, JLayeredPane.DEFAULT_LAYER);
        Layeredpane.add(Dicevalue2, JLayeredPane.DEFAULT_LAYER);
        Layeredpane.add(Player1Roll, JLayeredPane.DEFAULT_LAYER);
        Layeredpane.add(Player2Roll, JLayeredPane.DEFAULT_LAYER);
        Layeredpane.add(Info, JLayeredPane.DEFAULT_LAYER);
        Layeredpane.add(exit, JLayeredPane.DEFAULT_LAYER);
        Layeredpane.add(Player1Score, JLayeredPane.DEFAULT_LAYER);
        Layeredpane.add(Player2Score, JLayeredPane.DEFAULT_LAYER);
        Layeredpane.add(undoMove,JLayeredPane.DEFAULT_LAYER);
        Buttonpanel.setBounds(65,60,550,520);
        Layeredpane.add(Buttonpanel, JLayeredPane.DEFAULT_LAYER);

        File.add(Newgame);                 //Add Items to menubar
        File.add(Reset);
        File.add(Resign);
        File.add(Exit);
        Help.add(HowToPlay);
        About.add(GameVersion);
        About.add(Author);
        Menubar.add(File);
        Menubar.add(Help);
        Menubar.add(About);
        f.setJMenuBar(Menubar);            //Set menu bar to main frame

        f2.add(NameP1);                  //Add items to Set up game frame
        f2.add(NameP2);
        f2.add(P1Name);
        f2.add(P2Name);
        f2.add(ColorP1);
        f2.add(ColorP2);
        f2.add(ChooseP1);
        f2.add(ChooseP2);
        f2.add(OkButton);
        f2.setLayout(null);
        f2.getContentPane().setBackground(Color.DARK_GRAY);
        f2.setSize(400, 400);

        f3.add(HowtoPlayText);                      //Add items to howtoplay frame
        f3.setLayout(null);
        f3.getContentPane().setBackground(Color.DARK_GRAY);
        f3.setSize(465, 320);

        f.add(Layeredpane);                       //Add the layeredpane to main frame
        f.setSize(700, 730);
         f.setLocationRelativeTo(null);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    File gameStateFile = new File("state.txt");
                    if (gameStateFile.createNewFile()) {
                        System.out.println("file created: " + gameStateFile.getName());
                    }
                    else {
                        System.out.println("File already exists, Writing game state to file");
                    }

                    FileWriter Mywriter = new FileWriter(gameStateFile);
                    Mywriter.write(Integer.toString(Player1.Score));          //Write to file
                    Mywriter.write("\n");
                    Mywriter.write(Integer.toString(Player2.Score));          //Write to file
                    Mywriter.close();
                }catch (IOException ioExceptione){
                    System.out.println(ioExceptione);
                }
            }
        });






    }
}
