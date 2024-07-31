/*
 * Name: Aashritha Aachi
 * Date: 04/09/24
 * File name: Person.java
 * Description: This class extends Oval and set dimensions to 10X10 pixels. it also tracks individual status
 * using an instance varible of type int (ex: 0 = susceptible, 1 = infected, 2 - protected)
 * and maintain a second instance variable that references a Herd object that
    aggregates Person objects. The x,y coordinates of the inherited Oval will represent the location of the Person within
    the Herd, and its fill color will reflect a Person object’s status (for example, green=protected, white=susceptible,
    red=infected). The Person constructor must invoke the superclass constructor, save the provided Herd object reference,
    and initialize Person status to susceptible.
 */

import doodlepad.*;

//extends the oval class
public class Person extends Oval
{
    private int status;
    private Herd herd;

    //constructs a new person object at (x, y) as part of a herd population
    public Person(double x, double y, Herd herd)
    {
        super(x, y, 10, 10);
        this.status = 0;
        this.herd = herd;
    }

    //Reset Person status. Set status to susceptible (e.g. 0) and fill color (e.g. white).
    public void reset()
    {
        status = 0;
        this.setFillColor(255,255,255);
    }

    //Protect Person. Set status to protected (e.g. 2) and fill color (e.g. green)
    public void protect()
    {
        status = 2;
        this.setFillColor(0, 255, 0);
    }

    //Expose a Person to the disease and infect only if susceptible.
    //If susceptible, set new status to infected, set fill color (e.g. red), and return true
    //Otherwise (if not susceptible), return false.
    public boolean expose()
    {
        if (status == 0)
        {
            status = 1;
            this.setFillColor(255, 0 , 0);
            return true;
        }
        else
        {
            return false;
        }
    }

    //Compute and return distance between this Person and the Person other (in pixels).
    public double distance(Person other)
    {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    //Return true if this person is infected. Return false if not infected.
    public boolean isInfected()
    {
        if (status == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Override Oval event handler method and start Herd simulation with this Person.
    @Override
    public void onMousePressed(double x, double y, int button) 
    {
        super.onMousePressed(x, y, button);
        herd.simulate(this); // herd variable references the saved Herd object
    }

}
