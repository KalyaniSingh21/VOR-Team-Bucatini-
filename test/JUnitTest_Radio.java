import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kalyani,Pritam
 */
public class JUnitTest_Radio {
    
    public JUnitTest_Radio() {
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
     * Test of getRadial method, of class Radio.
     */
    @Test //(expected=)
    public void testGetRadial() {
        System.out.println("getRadial");
        Radio instance = new Radio(50);
        double radial;
        double expResult = 0.0;
        Random dice = new Random();
	radial = dice.nextDouble() * 3.45;
	int tick = dice.nextInt(2);
	if(tick > 0)
        {
	    expResult =  radial;
	}
	expResult = 360 - radial;
        
        double result = instance.getRadial();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Radio.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Radio instance = new Radio(70);
        int expResult = 0;
        Random rnd = new Random();
	int a = rnd.nextInt(2);
	if(a == 0)
        {
	    expResult = 70+767;
        }
	else
        {
            expResult = 70+321;
        }
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSigQual method, of class Radio.
    */ 
    @Test
    public void testGetSigQual() {
        System.out.println("getSigQual");
        Radio instance = new Radio(70);
        String expResult = "";
        int badCounter=5;
        if(badCounter <= 0)
        {
           expResult = "";
	}
	if(badCounter < 5)
        {
		badCounter--;
		//System.out.println("bad counter = " + this.badCounter);
	 	expResult = "bad";
	}
		
	Random rn4 = new Random();
	int a = rn4.nextInt(3);
	if(a == 0)
        {
	    badCounter--;
	    //System.out.println("bad counter = " + this.badCounter);
	    expResult = "bad";
	}
        else
	    expResult = "";
        
        String result = instance.getSigQual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }  
    
}
