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
     * Test of rotateOBS method, of class VOR.
     */
    @Test
    public void testRotateOBS() {
        System.out.println("rotateOBS");
        int delta = 40;
        VOR instance = new VOR();
        int expected_result = instance.normalizeAngle(delta);
        int actual_desired = instance.rotateOBS(delta);
        assertEquals(expected_result, actual_desired);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    @Test
    public void testGetCDI() {
        System.out.println("getCDI");
        VOR instance = new VOR();
        int expResult = 0;
        int desired = 0;
        Radio radio=new Radio();
        int intercepted = radio.getRadial();
		int arc = instance.arc(desired, intercepted);
		if (arc > 90) 
		{
			arc = 180 - arc;
		} 
		else if (arc < -90) 
		{
			arc = -180 - arc;
		}
                expResult=instance.clamp(arc, -10, 10);
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
        VOR instance = new VOR();
         int desired = 0;
        Radio radio=new Radio();
        boolean expResult = false;
        int intercepted = radio.getRadial();
	int arc = instance.arc(desired, intercepted);
	expResult= (instance.isOverStation() && (Math.abs(Math.abs(arc) - 90) > 1));
        String result = instance.isSignalGood();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isGoingTo method, of class VOR.
     */
    @Test
    public void testIsGoingTo() {
        System.out.println("isGoingTo");
        VOR instance = new VOR();
         int desired = 0;
        Radio radio=new Radio();
        boolean expResult = false;
        
		int intercepted = radio.getRadial();
		 expResult=Math.abs(instance.arc(desired, intercepted)) > 90;
        String result = instance.isGoingTo();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of normalizeAngle method, of class VOR.
     */
    @Test
    public void testNormalizeAngle_int_int() {
        System.out.println("normalizeAngle");
        int angle = 0;
        int center = 0;
        int expResult = 0;
         int desired = 0;
        Radio radio=new Radio();
        expResult= angle - 360 * (int)Math.floor((angle + 180 - center) / 360.0);
        int result = VOR.normalizeAngle(angle, center);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of normalizeAngle method, of class VOR.
     */
    @Test
    public void testNormalizeAngle_int() {
        System.out.println("normalizeAngle");
        int angle = 0;
        int expResult = 0;
        expResult= VOR.normalizeAngle(angle, 180);
        int result = VOR.normalizeAngle(angle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of clamp method, of class VOR.
     */
    @Test
    public void testClamp() {
        System.out.println("clamp");
        int val = 0;
        int low = 0;
        int high = 0;
        int expResult = 0;
        expResult= Math.max(low, Math.min(high, val));
        int result = VOR.clamp(val, low, high);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of arc method, of class VOR.
     */
    @Test
    public void testArc() {
        System.out.println("arc");
        int x = 0;
        int y = 0;
        int expResult = 0;
        expResult= VOR.normalizeAngle(y - x, 0);
        int result = VOR.arc(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
