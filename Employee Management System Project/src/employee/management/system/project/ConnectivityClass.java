/*there are 5 steps to perform java connectivity
 1- register driver class
 2-creating conncetion string
 3-creating statement
 4-executing mysql queries
 5-closing connections
*/
package employee.management.system.project;
import java.sql.*;//conncetion interface is under this sql package

public class ConnectivityClass 
{
    //we have an interface of connection name 
    //by using this interface we will create a connection string
    Connection c;
    //creating statement class
    Statement s;
    public ConnectivityClass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
           //we can create conncetion string by using this drivermnager class
          //getConncetion is a static mehtod 
          c =DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeemanagementsystem", "root","khushigupta");
          //create statement using connection string
          s=c.createStatement();
        }
        catch(Exception e)
        {
                  e.printStackTrace();  
        }
    }
    
}
