package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
    
    Score(String name,int score){
        setBounds(340,150,750,400);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("ThankYou " + name + " for Playing QuizUp!");
        heading.setBounds(60,60,700,55);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel sc = new JLabel("Your Score is " + score);
        sc.setBounds(230,200,300,30);
        sc.setFont(new Font("Tahoma",Font.BOLD,30));
        sc.setForeground(Color.BLACK);
        add(sc);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(305,270,120,30);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[]args){
        new Score("User",0);
    }
}
