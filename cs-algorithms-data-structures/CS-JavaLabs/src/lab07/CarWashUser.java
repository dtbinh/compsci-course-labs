package lab07;

/** results were very similar to system tests 1 & 2 in prog project 8.1 description
 * 
 * @author Allen Jagoda
 * 
 */

import java.util.*;

public class CarWashUser
{
    public static void main (String[] args)
    {
        new CarWashUser().run();
    } // method main
    
    
    /**
     *  Reads in all of the arrival times, runs the simulation, and calculates the average 
     *  waiting time.
     *
     */ 
    public void run()
    {        
    	final String IN_MeanArrival = "\nPlease enter the mean arrival time: ";
        final String IN_MeanService = "\nPlease enter the mean service time: ";
        final String IN_MaxArrivalTime = "\nPlease enter the maximum arrival time: ";

        final String OUT_OF_RANGE = "The input must consist of a non-" +
                                    "negative integer less than the sentinel.";
        
        CarWash carWash = new CarWash();
     
        Scanner sc = new Scanner (System.in);
          
        int meanArrivalTime;
        int meanServiceTime;
        int maxArrivalTime;
        //int nextArrivalTime = 0;  //variable to store nextArrivalTime
        
        System.out.print (IN_MeanArrival);
        meanArrivalTime = sc.nextInt();
        
        System.out.print (IN_MeanService);
        meanServiceTime = sc.nextInt();
        
        System.out.print (IN_MaxArrivalTime);
        maxArrivalTime = sc.nextInt();


        try
        {   if (meanArrivalTime < 0 || meanServiceTime < 0 || maxArrivalTime < 0)
            	throw new NumberFormatException (OUT_OF_RANGE);
	        do{
	        	carWash.calcNextArrivalTime(meanArrivalTime);
	        	carWash.calcWashTime(meanServiceTime);
	        	carWash.processMaxArrival(maxArrivalTime);
	        	carWash.process (meanArrivalTime, meanServiceTime);
	        }while (carWash.nextDepartureTime< maxArrivalTime);

        } // try
        catch (Exception e)
        {
            System.out.println(e);
            sc.nextLine();
        } // catch                               
        
        carWash.finishUp();
        printResults (carWash);
    } // method run

    
    /**
     *  Prints the results of the simulation.
     *
     */
    public void printResults (CarWash carWash)
    {
        final String RESULTS_HEADING =
            "\nHere are the results of the simulation:\n";

        LinkedList<String> results = carWash.getResults();
        System.out.println (RESULTS_HEADING);
        for (String s : results)
            System.out.print (s);
    } // method printResults

} // class CarWashUser
