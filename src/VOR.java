/*
    VOR Calculations
 */

import java.util.*;

public class VOR 
{
	private Radio radio;
	
	private int desired;

	public VOR() 
	{
		radio = new Radio(0);
		desired = 0;
	}
	
	public int getOBS(int delta) 
	{
            desired = normalizeAngle(desired + delta);
            System.out.println("OBS" + desired);
            return desired;
        }
	
	public int getCDI() 
	{
		int intercepted = radio.getRadial();
		int arc = arc(desired, intercepted);
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
		int intercepted = radio.getRadial();
		int arc = arc(desired, intercepted);
                
                if(radio.getQual().equalsIgnoreCase("good"))
                    sigQual = true;
                else
                    sigQual = false;
                
		return (((Math.abs(arc) - 90) > 1) && !isOverStation()) && sigQual;
	}
	
	public boolean isGoingTo() 
	{
		int intercepted = radio.getRadial();
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
    	
    	r.getOBS(45);
    	r.getCDI();
    	r.isGoingTo();
    	r.isSignalGood();
    	
    }
}