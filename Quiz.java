package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Quiz extends JFrame implements ActionListener{
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String user_ans[][] = new String[10][1];
    JLabel qno,ques;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton next,submit;
    ButtonGroup groupoptions;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name){
        this.name = name;
        
        
        setBounds(50,100,1250,560);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setVisible(true);
        
        qno = new JLabel();
        qno.setBounds(100,150,50,30);
        qno.setFont(new Font("Tahoma",Font.BOLD,22));
        add(qno);
        
        ques = new JLabel();
        ques.setBounds(150,150,800,30);
        ques.setFont(new Font("Tahoma",Font.BOLD,22));
        add(ques);
        
        questions[0][0] = "How many elements are in the periodic table? ";
        questions[0][1] = "118";
        questions[0][2] = "116";
        questions[0][3] = "102";
        questions[0][4] = "108";

        questions[1][0] = "How many stars are on the Chinese flag?";
        questions[1][1] = "3";
        questions[1][2] = "4";
        questions[1][3] = "5";
        questions[1][4] = "6";

        questions[2][0] = "What color are Mickey Mouse's shoes? ";
        questions[2][1] = "Red";
        questions[2][2] = "Black";
        questions[2][3] = "Blue";
        questions[2][4] = "Yellow";

        questions[3][0] = "Which bank is called bankers bank of India?";
        questions[3][1] = "Reserve Bank of India";
        questions[3][2] = "Punjab National Bank";
        questions[3][3] = "State Bank of India";
        questions[3][4] = "HDFC Bank";

        questions[4][0] = "Which is largest island in the world?";
        questions[4][1] = "New Guinea";
        questions[4][2] = "Andaman Nicobar";
        questions[4][3] = "Greenland";
        questions[4][4] = "Hawaii";

        questions[5][0] = "Tsunami is a word in which language?";
        questions[5][1] = "Hindi";
        questions[5][2] = "Urdu";
        questions[5][3] = "Japanese";
        questions[5][4] = "Chinese";

        questions[6][0] = "Which state has the longest coastal line in India?";
        questions[6][1] = "Gujarat";
        questions[6][2] = "Kerala";
        questions[6][3] = "Karnataka";
        questions[6][4] = "West Bengal";

        questions[7][0] = "Which is the smallest country in the world?";
        questions[7][1] = "Vatican City";
        questions[7][2] = "Bhutan";
        questions[7][3] = "Nepal";
        questions[7][4] = "Shri Lanka";

        questions[8][0] = "Which is the highest dam of India?";
        questions[8][1] = "Rihand Dam";
        questions[8][2] = "Tehri Dam";
        questions[8][3] = "Mettur Dam";
        questions[8][4] = "Sardar Sarovar Dam";

        questions[9][0] = "Who was India’s first President?";
        questions[9][1] = "Dr. Rajendra Prasad";
        questions[9][2] = "Sarvepalli Radhakrishnan";
        questions[9][3] = "Jawaharlal Nehru";
        questions[9][4] = "Motilal Nehru";
        
        answers[0][1] = "118";
        answers[1][1] = "5";
        answers[2][1] = "Yellow";
        answers[3][1] = "Reserve Bank of India";
        answers[4][1] = "Greenland";
        answers[5][1] = "Japanese";
        answers[6][1] = "Gujarat";
        answers[7][1] = "Vatican City";
        answers[8][1] = "Tehri Dam";
        answers[9][1] = "Dr. Rajendra Prasad";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170,220,700,30);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        opt1.setBackground(Color.LIGHT_GRAY);
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170,260,700,30);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        opt2.setBackground(Color.LIGHT_GRAY);
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170,300,700,30);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        opt3.setBackground(Color.LIGHT_GRAY);
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170,340,700,30);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        opt4.setBackground(Color.LIGHT_GRAY);
        add(opt4);
        
        
        // groupoptions to select only one option 
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(980,260,140,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        
        submit = new JButton("Submit");
        submit.setBounds(980,320,140,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            
            // user's ans stored in another array
            ans_given = 1;
            if(groupoptions.getSelection()==null){
                user_ans[count][0] = "";
            }
            else{
                user_ans[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            //submit button will enabled at the last question
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        }
        else if(ae.getSource() == submit){
            
            ans_given = 1;
            
            if(groupoptions.getSelection()==null){
                user_ans[count][0] = "";
            }
            else{
                user_ans[count][0] = groupoptions.getSelection().getActionCommand(); 
            }
                
            
            //checking the total score 
            for(int i=0;i<user_ans.length;i++){
                if(user_ans[i][0].equals(answers[i][1])){
                   score +=10;
                }
            }
            setVisible(false);
            new Score(name,score);
        }
    }
    
    // timer function
    public void paint(Graphics g){
        super.paint(g);
        
        String time = "Time left: " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,18));
        
        if(timer>0){
            g.drawString(time, 970, 220);
        }
        else{
            g.drawString("Times Up!!!",970,220);
        }
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given == 1){
            ans_given = 0;
            timer = 15;
        }
        else if(timer < 0){
            timer = 15;
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
                if(groupoptions.getSelection()==null){
                    user_ans[count][0] = "";
                }
                else{
                    user_ans[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for(int i=0;i<user_ans.length;i++){
                    if(user_ans[i][0].equals(answers[i][1])){
                        score +=10;
                    }
                }
                setVisible(false);
                new Score(name,score);
            }
            else{
                
                if(groupoptions.getSelection()==null){
                    user_ans[count][0] = "";
                }
                else{
                    user_ans[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
        
    }
    
    public void start(int count){
        qno.setText(""+(count+1)+".");
        ques.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args){
        new Quiz("User");
    }
}
