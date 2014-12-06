/*
    VOR Calculations
 */

import java.util.*;

public class VOR 
{
	int desired, intercepted, arc;
                
	public VOR(int radial) 
	{
                intercepted = radial;
		desired = 0;
        }
        	
        public void setOBS(int delta) 
	{
            desired = normalizeAngle(delta);
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
	
	public String isSignalGood(boolean badQual) 
	{
                arc = arc(desired, intercepted);
                                
                if((Math.abs(Math.abs(arc) - 90) > 1 && !isOverStation()) && !badQual)
                    return "Good";
                else
                    return "Bad";
	}
	
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
	
	public static int clamp(int val, int low, int high) 
	{
		return Math.max(low, Math.min(high, val));
	}
	
	public static int arc(int x, int y) 
	{
		return normalizeAngle(x - y, 0);
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