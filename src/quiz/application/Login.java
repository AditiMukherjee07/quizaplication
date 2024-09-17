
package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
        
{
    JButton rules;
    JButton back;
    JTextField box;
    public Login()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
       JLabel image=new JLabel(i1);
       image.setBounds(0,0,500,500);
       add(image);
       JLabel heading=new JLabel("Brain Test")  ;
       heading.setBounds(700,50,200,35);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,40));
       heading.setForeground(Color.green);
       add(heading);
        JLabel name=new JLabel("Enter your name:")  ;
       name.setBounds(720,100,200,35);
       name.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
       name.setForeground(Color.green);
       add(name);
        box=new JTextField();
       box.setBounds(700,200,300,30);
       box.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(box);
        rules=new JButton("Rules");
       rules.setBounds(700,250,120,25);
       rules.setBackground(Color.BLUE);
       rules.setForeground(Color.WHITE);
       rules.addActionListener(this);
       add(rules);
        back=new JButton("Back");
       back.setBounds(900,250,120,25);
       back.setBackground(Color.BLUE);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
        setSize(1200,500);
        setLocation(100,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==rules)
        {
            String name=box.getText();
            setVisible(false);
            new Rules(name);
        }
        else if(ae.getSource()==back)
        {
             setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}
