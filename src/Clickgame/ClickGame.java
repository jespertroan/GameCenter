package Clickgame;

import javax.swing.*;                      //Import packages
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClickGame {
    final int countDownTime = 60;                 //Set variables
    public int clicks = 0;
    public int record = 0;
    public int time = countDownTime;


    public void ClickGame(){
        JFrame frame = new JFrame("Click game");          //Initialize frame with objects
        JLabel title = new JLabel("Maximum clicks");
        title.setVerticalAlignment(SwingConstants.TOP);
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setBounds(10,10,300,300);
        JLabel Description = new JLabel("<html>See how many clicks you can do in one minute!");
        Description.setBounds(10,30,400,50);
        JButton exit = new JButton("X");
        exit.setBounds(350, 10, 30, 30);
        JLabel Record = new JLabel("Record: ");
        Record.setBounds(10,75,100,30);
        JButton Startbutton = new JButton("Start");
        Startbutton.setBounds(35,150,300,40);
        JButton Clickbutton = new JButton("Click ME!");
        Clickbutton.setEnabled(false);
        Clickbutton.setBounds(35,200,150,40);
        JTextField Counter = new JTextField("Counter:");
        Counter.setEnabled(false);
        Counter.setBounds(235,200,100,30);
        JTextField Timeleft = new JTextField("Start game to see timer");
        Timeleft.setBounds(40,300,300, 40);
        File file = new File("Record.txt");         //Create new file
        if(file.isFile()){    //Check if record exists
            int record = ReadRecord();
            Record.setText("record:" + record);
        }

        Startbutton.addActionListener(new ActionListener() {         //If game is started
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks=0;                                       //Reset clicks
                Counter.setText("Counter:");
                Startbutton.setEnabled(false);
                Clickbutton.setEnabled(true);
                time = countDownTime;                       //Make new timer
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        time = time - 1;
                        Timeleft.setText("Time left: " + String.valueOf(time));
                        if(time==0){                            //If time is up
                            timer.cancel();                    //Cancel timer
                            Timeleft.setText("DONE");
                            Startbutton.setEnabled(true);         //Enable buttons
                            Clickbutton.setEnabled(false);
                            if(clicks>ReadRecord()) {            //If record
                                WriteToFile(clicks);
                                Record.setText("record:" + clicks);
                            }
                        }
                    }
                };
                timer.schedule(task, 0, 100);         //Schedule timer

            }
        });

        Clickbutton.addActionListener(new ActionListener() {      //Count clicks
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                Counter.setText("Counter: " + clicks);
            }
        });


        exit.addActionListener(new ActionListener() {          //Close frame if exit is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        frame.add(title);                     //Add objects to frame
        frame.add(Description);
        frame.add(exit);
        frame.add(Record);
        frame.add(Startbutton);
        frame.add(Clickbutton);
        frame.add(Counter);
        frame.add(Timeleft);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public int ReadRecord(){                                   //read record from file
        int highscore = 0;
        try {
            File file = new File("Record.txt");         //Create new file
            Scanner Myscanner = new Scanner(file);            //Create new scanner
            highscore=Myscanner.nextInt();                     //Read from file
            Myscanner.close();                              //Close file
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        return highscore;                            //Return highscore
    }

    public void WriteToFile(int Record){                  //Write highscore to file
        File Recordfile = new File("Record.txt");
        try {
            Recordfile.createNewFile();                      //Create new file
            FileWriter Mywriter = new FileWriter(Recordfile);
            Mywriter.write(Integer.toString(Record));          //Write to file
            Mywriter.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
