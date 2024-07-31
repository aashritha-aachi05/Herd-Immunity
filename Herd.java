/*
 * Name: Aashritha Aachi
 * Date: 04/09/24
 * File name: Herd.java
 * Description: The Herd class extends the Pad class
 * and constructs a new Herd object containing npeople Person objects
 * with disease transmission occuring when people are within
 * cutoff distance.
 */

import doodlepad.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Herd extends Pad 
{
    private int cutoff, npeople;
    private Random rand = new Random();
    private Person[] people;

    public Herd(int npeople, int cutoff) {
        super("Herd Immunity", 600, 600);
        this.cutoff = cutoff;
        people = new Person[npeople];

        for (int i = 0; i < npeople; i++) {
            double x = rand.nextDouble() * 600;
            double y = rand.nextDouble() * 600;
            people[i] = new Person(x, y, this);
        }

    }

    //Reset and protect Persons with probability prob, where prob is in [0.0, 1.0)
    public void reset (double prob)
    {
        for (int i = 0; i < people.length; i++)
        {
            people[i].reset();

            if (rand.nextDouble() < prob)
            {
                people[i].protect();
            }
        }
    }

    // Run the simulation starting with Person zero. Include this Herd method as is.
    public void simulate(Person zero) 
    {
        List<Person> infected = new ArrayList<>(); // Maintain a List of infected spreaders
        if (zero.expose()) 
        { // If person zero becomes newly infected,
            infected.add(zero); // add the person to the infected list.
        }
        while (infected.size() > 0) 
        { // While there remains any infected people,
            Person p = infected.remove(0); // remove the first person from the list.
            for (Person q : people) 
            { // Iterate over all people in the population.
                double dist = p.distance(q); // Compute distance between the two people.
                if (dist < this.cutoff) 
                { // If that distance is within the cutoff,
                    // expose that person to the disease.
                    if (q.expose()) 
                    { // If that person becomes newly infected,
                        infected.add(q); // add that person to the infected list.
                    }
                }
            }
        }
    }
}