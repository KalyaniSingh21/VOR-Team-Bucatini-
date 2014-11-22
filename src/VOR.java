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
	
	public int getOBS(int delta) 
	{
            desired = normalizeAngle(desired + delta);
            return desired;
        }
	
	public int getCDI() 
	{
		intercepted = radio.getRadial();
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
	
	public boolean isSignalGood() 
	{
                boolean sigQual;
		intercepted = radio.getRadial();
		arc = arc(desired, intercepted);
                
                if(radio.getQual().equalsIgnoreCase("good"))
                    sigQual = true;
                else
                    sigQual = false;
                
		return (((Math.abs(arc) - 90) > 1) && !isOverStation()) && sigQual;
	}
	
	public boolean isGoingTo() 
	{
		intercepted = radio.getRadial();
		return (arc(desired, intercepted)) > 90;
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
	
    public static void main(String[] args) throws Exception
    {
    	VOR r = new VOR();
    	
    	System.out.println(r.intercepted + ","
                + r.getOBS(45) + ","
                + r.getCDI() + ","
                + r.isGoingTo() + ","
                + r.isSignalGood());
    	
    }
    
}