/*
 * Name: Aashritha Aachi
 * Date: 04/09/24
 * File Name: project3.java
 * Description: This class is a driver class containing only the main method to test
 * other classes. 
 */

import javax.swing.SwingUtilities;
public class herdImmunity
{
     public static void main(String[] args) 
     {
        Herd herd = new Herd(2500, 25);
        herd.reset(0.5); 
        
        // Increase this value closer to 1.0 to find the minimum
        // population fraction required to achieve herd immunity.
        //SwingUtilities.invokeLater(new Runnable() 
       // {
          //  public void run() 
           // {
             //   herd.redraw(); // Ensure interface is redrawn only after setup is complete.
            // }
        //});
    }       
 }