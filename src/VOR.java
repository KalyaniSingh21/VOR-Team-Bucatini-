/*
    VOR Calculations
 */

import java.util.*;

public class VOR 
{
	int desired, intercepted, arc;
        
        //VOR constructor
	public VOR(int radial) 
	{
                intercepted = radial;
		desired = 0;
        }
        
        //Sets the value of desired equal to OBS
        public void setOBS(int delta) 
	{
            desired = normalizeAngle(delta);
        }
        
        //Returns the desired value of OBS
	public int getOBS() 
	{
            return desired;
        }
        
	//Gets the deflection of needle using value of arc
	public int getCDI() 
	{
		arc = arc(desired, intercepted);
		if (arc > 90) 
		{
			arc = 180 - arc;
		} 
		else if (arc < -90) 
		{
			arc = -180 - arc;
		}
		return clamp(arc, -10, 10);
	}
	
        //Signal quality based on abeam, over station and signal from radio
	public String isSignalGood(boolean badQual) 
	{
                arc = arc(desired, intercepted);
                                
                if((Math.abs(Math.abs(arc) - 90) > 1 && !isOverStation()) && !badQual)
                    return "Good";
                else
                    return "Bad";
	}
	
        //Finds whether the plane is moving to or away from the station using the value of arc
	public String isGoingTo() 
	{
                if(Math.abs(arc(desired, intercepted)) > 90)
                    return "To";
                else
                    return "From";
	}
	
	public static int normalizeAngle(int angle, int center) 
	{
		return angle - 360 * (int)Math.floor((angle + 180 - center) / 360.0);
	}
	
	public static int normalizeAngle(int angle) 
	{
		return normalizeAngle(angle, 180);
	}
	
        //Finds the deflection of needle
	public static int clamp(int val, int low, int high) 
	{
		return Math.max(low, Math.min(high, val));
	}
	
        //Finds the difference between intercepted and desired and normalizes it
	public static int arc(int x, int y) 
	{
		return normalizeAngle(x - y, 0);
	}
	
        //Generates random over station value
	private boolean isOverStation() 
	{ 
            Random rnd = new Random();
            int n = rnd.nextInt(20);
		
            if(n == 0)
    	   	return true;
            else
    		return false;
	} 
	
}