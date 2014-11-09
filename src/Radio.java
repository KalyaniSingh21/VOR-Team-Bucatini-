/**
   Simulated Radio class.
**/

import java.io.*;
import java.util.*;

public class Radio 
{
	//BufferedReader buffer;
	//int seed;      This variable will be used in accord with future requirements
	double frequency;    // The frequency to which the plane is set to in the beginning(VOR station)
	//String id;           // The OBS desired radial returned by the VOR station
	double startRad = 0;
	
	// Radio constructor
	public Radio(/*int seed */){
	//	this.seed = seed;
	}
	
	// Deciding the initial radial
    public int getRadial()
    {
    	int min = 0;
    	int max = 359;
    	
    	int radial = min + (int)(Math.random() * (max - min + 1));   
    	return radial;
    }
	
	//Get Station ID
        //@SuppressWarnings("empty-statement")
       
    @SuppressWarnings("empty-statement")

    public String getMorseCode_sigQual(double frequency) throws IOException  // Initially getID
    {    
        try
        {
	   /* System.out.println("Enter the desired Frequency: ");
            BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
            frequency= Double.parseDouble(inp.readLine());
          */
	    double[] freq_arr = {115.4,113.5,114.8,113.9,116.1,117.7,
                                        115.1,112.3,113.3,116.9,112.1};
            String[] MorseCode = {"SOK","LIH","HNL","CKH","MKK","LNY",
                                         "OGG","UPP","MUE","ITO","KOA"};
                       
            for(int i=0;i<=11;i++)
            {
                if(frequency==freq_arr[i])
                   return (MorseCode[i]);
                
            }
        
        
        }
    
        catch(NumberFormatException e)
        {
            System.out.println("Number Format Exception");
        
        }
        catch(Exception e)
        {
            System.out.println("Exception");
        }
        
        
        //return MorseCode[0];
            return null;
   
    }
 
    //private String[] ret;
	
	//Checking the quality of the signal
    public String getQual()
    {
    	Random rnd = new Random();
	int n = rnd.nextInt(10);
		    	
    	if(n==1 || n == 6 || n == 8)
        {
            System.out.println("Number = " + n);
	    return "bad";
	}
		
	else
        {
            System.out.println("Number = " + n);
	    return "good";
	} 
    }
    
    
    /*
    public static void main(String[] args) throws Exception
    {
    	Radio r = new Radio();
    	System.out.print(r.getMorseCode_sigQual()+","+
    	r.getQual()+","+
    	r.getRadial());
    } */
}


