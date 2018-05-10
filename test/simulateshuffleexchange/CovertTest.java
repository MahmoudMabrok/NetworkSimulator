/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulateshuffleexchange;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author motamed
 */
public class CovertTest {
    
    public CovertTest() {
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
     * Test of main method, of class Covert.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Covert.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exchange method, of class Covert.
     */
    @Test
    public void testExchange() {
        System.out.println("exchange");
        int value = 0;
        int suffixE = 0;
        int expResult = 0;
        int result = Covert.exchange(value, suffixE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffle method, of class Covert.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        int value = 0;
        int expResult = 0;
        int result = Covert.shuffle(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
