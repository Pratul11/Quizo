package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{
    String name;
    JButton next,back;
    
    Rules(String name){
        
        this.name = name;
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome "+name+" to QuizUp!");
        heading.setBounds(30,50,700,55);
        heading.setFont(new Font("MV Boli",Font.BOLD,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(30,110,700,350);
        rules.setFont(new Font("Mongolian Baiti",Font.PLAIN,16));
        rules.setForeground(Color.BLACK);
        rules.setText(
            "<html>"+
                "1. Answer the question by selecting one of the 4 answer choices." + "<br><br>" +
                "2. Answer the question in less than 15 seconds." + "<br><br>" +
                "3. The answer appears after clicking on next button (or after 15 seconds if no choice has been selected)." + "<br><br>" +
                "4. A complete game consists of 10 questions." + "<br><br>" +
                "5. Score can be viewed at the end of the game." + "<br><br>" +
                "6. All questions are worth 10 points." + "<br><br>" +
                "7. There are no deductions for wrong answers." + "<br><br>" +
                
            "<html>"
        );
        add(rules);
        
        next = new JButton("Next");
        next.setBounds(430,500,100,30);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        back = new JButton("Back");
        back.setBounds(220,500,100,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(800,650);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == next){
            setVisible(false);
            new Quiz(name);
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[]args){
        new Rules("User");
    }
}
