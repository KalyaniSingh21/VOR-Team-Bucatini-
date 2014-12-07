/**
   Simulated Radio class.
**/

import java.io.*;
import java.util.*;

public class Radio 
{
    int seed;          
    double frequency;
    int radial;	
    
    // Radio constructor
    public Radio(int seed)
    {
	this.seed = seed;
    
    }
	
    // Deciding the initial radial
    public int getRadial()
    {
    	radial = (int)(Math.random() * 360);   
    	return radial;
    
    }
	
    //Sets the frequency
    public void setFrequency(double frequency)
    {
        this.frequency = frequency;
    
    }
    
    //Returns Morsecode (Staion ID) corresponding to the frequency    
    public String getMorseCode()
    {    
        double[] freq_arr = {115.4,113.5,114.8,113.9,116.1,117.7,
                                        115.1,112.3,113.3,116.9,112.1};
        String[] MorseCode = {"SOK","LIH","HNL","CKH","MKK","LNY",
                                         "OGG","UPP","MUE","ITO","KOA"};
                       
        for(int i=0;i<11;i++)
        {
            if(frequency==freq_arr[i])
                return MorseCode[i];
                
        }
        
        //return MorseCode[0];
        return null;
   
    }
 
    
    //Checking the quality of the signal
    public boolean badSigQual()
    {
    	Random rnd = new Random();
	int n = rnd.nextInt(10);
		    	
    	if(n==1 || n == 6 || n == 8)
        {
    	    return true;

        }
		
	else
        {
    	    return false;
	
        } 
    }
}