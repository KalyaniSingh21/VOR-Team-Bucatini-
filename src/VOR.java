/*
    VOR Calculations
 */

import java.util.*;

public class VOR 
{
	Radio radio;
	
        int desired, intercepted, arc;
                
	public VOR() 
	{
		radio = new Radio(0);
		desired = 0;
                intercepted = radio.getRadial();
	}
	
        public void setOBS(int delta) 
	{
            desired = normalizeAngle(desired + delta);
        }
        
	public int getOBS() 
	{
            return desired;
        }
	
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
	
	public String isSignalGood() 
	{
                boolean sigQual;
		arc = arc(desired, intercepted);
                
                if(radio.getQual().equalsIgnoreCase("good"))
                    sigQual = true;
                else
                    sigQual = false;
                
                if((((Math.abs(arc) - 90) > 1) && !isOverStation()) && sigQual)
                    return "Good";
                else
                    return "Bad";
	}
	
	public String isGoingTo() 
	{
                if((arc(desired, intercepted)) > 90)
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
	
	public static int clamp(int val, int low, int high) 
	{
		return Math.max(low, Math.min(high, val));
	}
	
	public static int arc(int x, int y) 
	{
		return normalizeAngle(y - x, 0);
	}
	
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