package employee.management.system.project;
import javax.swing.*;
import java.awt.*;//bcause the color class is under this package
import java.awt.event.*;//actionlistener is under this package

public class Splash extends JFrame implements ActionListener
        /* if we have any unimplemented abstract method whenever we implement any interface
        then we have to override the unimplemented abstract method*/

{
    /*creating constructor of the class
    splash means the window will pop up for a sec and then  hide*/
        Splash()
        {
            getContentPane().setBackground(Color.WHITE);//by getcontentpane we can get the allover access of the frame 
            setLayout(null);
            JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
            heading.setBounds(90, 30, 1200, 60);
            heading.setFont(new Font("serif", Font.PLAIN,60));
            add(heading);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(50, 100, 1050, 500);
            add(image);
        
            //putting a button 
            JButton button1=new JButton("CONTINUE");
            button1.setBounds(500 , 400, 100, 50);
            button1.setBackground(Color.BLACK);
            button1.setForeground(Color.WHITE);
            //to make button workable and we are able to go to next page
            button1.addActionListener(this);
            image.add(button1);
        
            setSize(1170, 650);
            setLocation(200,50);
            setVisible(true);
            
            //for blinking the heading or dipper 
            while(true) {
            heading.setVisible(false);//initially the heading is false
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
            
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
        }
    }
//what action should be performed by cliking on the button 
//that work passes into this method
public void actionPerformed(ActionEvent ae)
{
    //first clicking the button this current window will be stoped
    setVisible(false);
    //open login frame so we have to call obbject of the login page and 
    //contructor will call all the functi ons
    new LoginPage();
}
                    
        
    public static void main(String args[])
    {
        
        
        //creating annonamous oject of the spalsh class
        new Splash();
    }
    
}
