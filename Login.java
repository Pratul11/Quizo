package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    JButton next,exit;
    JTextField tfname;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hell.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image); 
        
        JLabel heading = new JLabel("QuizUp - A Quiz Application! ");
        heading.setBounds(650,60,500,55);
        heading.setFont(new Font("MV Boli",Font.BOLD,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel name = new JLabel("Enter Your Name ");
        name.setBounds(800,170,500,55);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,22));
        name.setForeground(Color.BLACK);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(740,220,300,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);
        
        next = new JButton("Next");
        next.setBounds(750,280,100,30);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        exit = new JButton("Exit");
        exit.setBounds(930,280,100,30);
        exit.setBackground(Color.BLUE);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        setSize(1200,500);
        setLocation(100,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == next){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        }else if(ae.getSource() == exit){
            setVisible(false);
        }
    }
    
    
    public static void main(String args[]){
        new Login();
    }
}
