/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VORTest {
    private int arc;
    
    public VORTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCDI method, of class VOR.
     */
    @Test
    public void testGetCDI() {
        System.out.println("getCDI");
        VOR instance = new VOR();
        int expResult = 0;
        expResult = arc(instance.desired, instance.intercepted);
		if (arc > 90) 
		{
			arc = 180 - arc;
		} 
		else if (arc < -90) 
		{
			arc = -180 - arc;
		}
		else               
                    testClamp(arc, -10, 10);
        int result = instance.getCDI();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isSignalGood method, of class VOR.
     */
    @Test
    public void testIsSignalGood() {
        System.out.println("isSignalGood");
        boolean badQual = false;
        VOR instance = new VOR();
        String expResult = "";
        arc = arc(instance.desired, instance.intercepted);
                                
                if(!badQual && (Math.abs(Math.abs(arc) - 90) > 1 && !(instance.isOverStation())))
                    expResult= "Good";
                else
                    expResult= "Bad";
        String result = instance.isSignalGood(badQual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of isGoingTo method, of class VOR.
     */
    @Test
    public void testIsGoingTo() {
        System.out.println("isGoingTo");
        VOR instance = new VOR();
        String expResult = "";
        if(Math.abs(arc(instance.desired, instance.intercepted)) > 90)
                    expResult= "To";
                else
                    expResult= "From";
        String result = instance.isGoingTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of normalizeAngle method, of class VOR.
     */
    @Test
    public int testNormalizeAngle_int_int(int angle,int center) {
        System.out.println("normalizeAngle");
        angle = 80;
        center = 70;
        int expResult = angle - 360 * (int)Math.floor((angle + 180 - center) / 360.0);
        int result = VOR.normalizeAngle(angle, center);
        assertEquals(expResult, result);
        return expResult;
        
    }

    /**
     * Test of normalizeAngle method, of class VOR.
     */
    @Test
    public void testNormalizeAngle_int() {
        System.out.println("normalizeAngle");
        int angle = 0;
        int expResult;
        expResult = testNormalizeAngle_int_int(angle, 180);
        int result = VOR.normalizeAngle(angle);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of clamp method, of class VOR.
     */
    @Test
    public void testClamp(int val,int low,int high) {
        System.out.println("clamp");
        val = 20;
        low = 10;
        high = 30;
        int expResult = Math.max(low, Math.min(high, val));
        int result = VOR.clamp(val, low, high);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public int arc(int x, int y) 
    {
         return testNormalizeAngle_int_int(x - y, 0);
    }
    
}
