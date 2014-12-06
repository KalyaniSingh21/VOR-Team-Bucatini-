/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Test of getRadial method, of class Radio.
     */
    @Test
    public void testGetRadial() {
        System.out.println("getRadial");
        Radio instance = new Radio();
       // double expResult = 0.0;
        double result = instance.getRadial();
        
        if((result>=0) && (result <=360))
           System.out.print("Test Passed");  
        else
            System.out.print("Test Failed");
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    
    
    /**
     * Test of getMorseCode_sigQual method, of class Radio.
     * @param frequency
     * @throws java.lang.Exception
     */
    @Test

    public void testGetMorseCode_sigQual(double frequency) throws IOException  
    {
        System.out.println("getMorseCode_sigQual");
        Radio instance = new Radio();
        String expResult = "";
        double[] freq_arr = {115.4,113.5,114.8,113.9,116.1,117.7,
                                        115.1,112.3,113.3,116.9,112.1};
            String[] MorseCode = {"SOK","LIH","HNL","CKH","MKK","LNY",
                                         "OGG","UPP","MUE","ITO","KOA"};
                       
            for(int i=0;i<=11;i++)
            {
                if(frequency==freq_arr[i])
                   expResult = (MorseCode[i]);
                
            }
        
        String result = instance.getMorseCode_sigQual(frequency);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
 
    
    }
    

