/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pritam
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
	
	public void rotateOBS(int delta) 
	{
		desired = normalizeAngle(desired + delta);
	}
	
	public int getOBS() 
	{
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
		int intercepted = radio.getRadial();
		int arc = arc(desired, intercepted);
		return (Math.abs(Math.abs(arc) - 90) > 1) && isOverStation();
	}
	
	public boolean isGoingTo() 
	{
		int intercepted = radio.getRadial();
		return Math.abs(arc(desired, intercepted)) > 90;
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
    	
    	r.rotateOBS(45);
    	r.getCDI();
    	r.isGoingTo();
    	r.isSignalGood();
    	
    }
}