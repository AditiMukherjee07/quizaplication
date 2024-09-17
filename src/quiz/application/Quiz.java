
package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Quiz extends JFrame implements ActionListener
{
    String questions[][]=new String[5][5];
    String answers[][]=new String[5][2];
    String useranswers[][]=new String[10][1];
    JLabel qno;
    JLabel question;
    JButton next;
    JButton lifeline;
    JButton submit;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup groupoptions;
    public static int ans_given=0;
    public static int timer=10;
    public static int count=0;
    public static int score=0;
    public Quiz()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
       
        setVisible(true);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
       JLabel image=new JLabel(i1);
       image.setBounds(0,0,1000,300);
       add(image);
        setSize(1000,700);
        setLocation(100,50);
        qno=new JLabel();
       qno.setBounds(70,400,500,30);
       qno.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
       add(qno);
        question=new JLabel();
       question.setBounds(100,400,500,30);
       question.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
       add(question);
       questions[0][0]="What is OOPS?";
       questions[0][1]="java";
       questions[0][2]="C";
       questions[0][3]="Object Oriented Programming";
       questions[0][4]="Python";
       
       questions[1][0]="What is OOPS?";
       questions[1][1]="java";
       questions[1][2]="C";
       questions[1][3]="Object Oriented Programming";
       questions[1][4]="Python";
       
       questions[2][0]="What is used to find and fix bugs in Java program?";
       questions[2][1]="JDK";
       questions[2][2]="JRE";
       questions[2][3]="JVM";
       questions[2][4]="JDO";
       
       questions[3][0]="What is OOPS?";
       questions[3][1]="java";
       questions[3][2]="C";
       questions[3][3]="Object Oriented Programming";
       questions[3][4]="Python";
       
       questions[4][0]="What is OOPS?";
       questions[4][1]="java";
       questions[4][2]="C";
       questions[4][3]="Object Oriented Programming";
       questions[4][4]="Python";
       
       answers[0][1]="Object Oriented Programming";
        answers[1][1]="Object Oriented Programming";
        answers[2][1]="JDO";
        answers[3][1]="Object Oriented Programming";
        answers[4][1]="Object Oriented Programming";
        
        opt1=new JRadioButton();
       opt1.setBounds(100,500,500,30);
       opt1.setBackground(Color.WHITE);
       opt1.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
       add(opt1);
       
        opt2=new JRadioButton();
       opt2.setBounds(100,530,500,30);
       opt2.setBackground(Color.WHITE);
       opt2.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
       add(opt2);
       
        opt3=new JRadioButton();
       opt3.setBounds(100,560,500,30);
       opt3.setBackground(Color.WHITE);
       opt3.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
       add(opt3);
       
       opt4=new JRadioButton();
       opt4.setBounds(100,590,500,30);
       opt4.setBackground(Color.WHITE);
       opt4.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
       add(opt4);
        groupoptions=new ButtonGroup();
       groupoptions.add(opt1);
       groupoptions.add(opt2);
       groupoptions.add(opt3);
       groupoptions.add(opt4);
        next=new JButton("Next");
       next.setBounds(500,530,200,20);
       next.setBackground(Color.BLUE);
       next.addActionListener(this);
       add(next);
       lifeline=new JButton("50 50 lifeline");
       lifeline.setBounds(500,570,200,20);
       lifeline.setBackground(Color.BLUE);
       lifeline.addActionListener(this);
       add(lifeline);
       submit=new JButton("submit");
       submit.setBounds(500,610,200,20);
       submit.setBackground(Color.BLUE);
       submit.addActionListener(this);
       submit.setEnabled(false);
       add(submit);
       start(count);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            repaint();
            opt1.setEnabled(true);
              opt2.setEnabled(true);
               opt3.setEnabled(true);
                opt4.setEnabled(true);
            ans_given=1;
            if(groupoptions.getSelection()==null)
            {
                useranswers[count][0]="";
            }
            else
            {
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }
            if(count==3)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
                
            count++;
            start(count);
        }
        else if(ae.getSource()==lifeline)
        {
            if(count==2 || count==4)
            {
                opt2.setEnabled(false);
                 opt3.setEnabled(false);
            }
            else
            {
                 opt1.setEnabled(false);
                  opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
        else
        {
            if(groupoptions.getSelection()==null)
            {
                useranswers[count][0]="";
            }
            else
            {
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }
                    for(int i=0;i<useranswers.length;i++)
                    {
                        if(useranswers[i][0].equals(answers[i][1]))
                            score+=5;
                    }
                    setVisible(false);
                
        }
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        String time="Time left:"+timer+" seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman",Font.BOLD,20));
        if(timer>0)
        {
            g.drawString(time, 700, 400);
        }
        else
        {
            g.drawString("Time's up!", 700, 400);
        }
        timer--;
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(ans_given==1)
        {
            ans_given=0;
            timer=10;
        }
        else if(timer<0)
        {
            timer=10;
             opt1.setEnabled(true);
              opt2.setEnabled(true);
               opt3.setEnabled(true);
                opt4.setEnabled(true);
                if(count==3)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
                if(count==9)
                {
                    if(groupoptions.getSelection()==null)
            {
                useranswers[count][0]="";
            }
            else
            {
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }
                    for(int i=0;i<useranswers.length;i++)
                    {
                        if(useranswers[i][0].equals(answers[i][1]))
                            score+=5;
                    }
                    setVisible(false);
                }
                
                
                else{
                    
                
            if(groupoptions.getSelection()==null)
            {
                useranswers[count][0]="";
            }
            else
            {
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }
                }
            count++;
            start(count);
        }
    }
    public void start(int count)
    {
        qno.setText(""+(count+1)+".");
        question.setText(questions[count][0]);
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
    public static void main(String[] args)
    {
      new Quiz();
    }
}
