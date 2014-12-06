/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kalyani
 */
public class RadioTest {
    
    public RadioTest() {
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
     * Test of getMorseCode method, of class Radio.
     */
    @Test
    public void testGetMorseCode() {
        System.out.println("getMorseCode");
        Radio instance = new Radio();
        //String expResult = "";
        double expResult = 0;
        double[] freq_arr = {115.4,113.5,114.8,113.9,116.1,117.7,
                                        115.1,112.3,113.3,116.9,112.1};
        String[] MorseCode = {"SOK","LIH","HNL","CKH","MKK","LNY",
                                         "OGG","UPP","MUE","ITO","KOA"};
                       
        for(int i=0;i<11;i++)
        {
            if(expResult==freq_arr[i]);
                
        }
        
        String result = instance.getMorseCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
s