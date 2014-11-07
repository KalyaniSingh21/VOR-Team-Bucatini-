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
    @Test
    public void testGetRadial() {
        System.out.println("getRadial");
        Radio instance = null;
        double expResult = 0.0;
        double result = instance.getRadial();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Radio.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Radio instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSigQual method, of class Radio.
     */
    @Test
    public void testGetSigQual() {
        System.out.println("getSigQual");
        Radio instance = null;
        String expResult = "";
        String result = instance.getSigQual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
