package employee.management.system.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage  extends JFrame implements ActionListener
{
    //we have to declare the textfield and password textfeild globally 
    //coz we want to use that tesxt area outside the unction into another function
    JTextField  userfield , passwordfield;
    LoginPage()
    {
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel username = new JLabel("USERNAME :");
        username.setBounds(40, 20, 100, 30);
        username.setFont(new Font("serif", Font.PLAIN,15));
        add(username);
        
         userfield= new JTextField();
        userfield.setBounds(150, 20, 150, 30);
        add(userfield);
        
        JLabel password = new JLabel("PASSWORD :");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("serif", Font.PLAIN,15));
        add(password);
        
         passwordfield= new JTextField();
        passwordfield.setBounds(150, 70, 150, 30);
        add(passwordfield);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image img2=img1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel img4=new JLabel(img3);
        img4.setBounds(350, 0, 200, 200);
        add(img4);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String  ut = userfield.getText();
            String  pwt = passwordfield.getText();
            //we have to create object of conncetionclass class
            //bcoz this executequery is under that statement s
            ConnectivityClass c=new ConnectivityClass();
            String query="select * from login where username = '"+ut+"' and password = '"+pwt+"'";
            //we have to store the result coming from executeQuery into Resultset
            ResultSet rs=c.s.executeQuery(query);
            //when we have any value into the resultset then show that
            if(rs.next())
            {
                setVisible(false);
                new HomeClass();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "invalid username or password");
                setVisible(false);
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    public static void main(String args[])
    {
        new LoginPage();
    }
    
}
