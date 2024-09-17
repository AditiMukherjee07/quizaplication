
package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener
{
    String name;
    JButton back;
    JButton start;
    public Rules(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.white);
         setLayout(null);
         JLabel heading=new JLabel("Welcome "+name+" to Brain Test");
       heading.setBounds(150,20,300,20);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
       heading.setForeground(Color.green);
       add(heading);
        JLabel rules=new JLabel();
        rules.setBounds(40,30,300,400);
       rules.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
        rules.setText(
                "<html>"+
                     "1.There are 10 questions"+"<br><br>"+
                      "2.Each question carries 5 marks"+"<br><br>"+
                       "3.There is no negative marking"+"<br><br>"+
                       "4.You get 10 seconds to answer each question"+"<br><br>"+
                       "<html>"
        ) ; 
       add(rules);
       
        back=new JButton("Back");
       back.setBounds(100,300,120,25);
       back.setBackground(Color.BLUE);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
       start=new JButton("Start");
      start.setBounds(300,300,120,25);
       start.setBackground(Color.BLUE);
       start.setForeground(Color.WHITE);
       start.addActionListener(this);
       add(start);

        setSize(600,500);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource()==start)
        {
            
        }
        else if(ae.getSource()==back)
        {
             setVisible(false);
             new Login();
        }
    }
    public static void main(String[] args)
    {
        new Rules("User");
    }
    
}
