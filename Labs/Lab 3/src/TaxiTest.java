import static org.junit.Assert.*;

import org.junit.Test;

public class TaxiTest {

    //calculateFare() test #1
    @Test(timeout=100)
    public void testPickUpSuccess() {
        Taxi t = new Taxi(12.00, 5);
        assertTrue(t.pickUp(5));
    }
    
    //calculateFare() test #2
    @Test(timeout=100)
    public void testCalculateFare() {
        /*
         * Your test implementation goes here.
         */
    	Taxi t = new Taxi(12.00, 5);
    	assertEquals(t.calculateFare(4, 5), 15 , 0.01);
    }
    
    //pickUp() test #1
    @Test(timeout=100)
    public void testPickUpEnoughRoom() {
        /*
         * Make sure pickUp() returns true when you try to pick up some
         * number of passengers within capacity.
         */
    	Taxi t = new Taxi(12.00, 5);
    	assertTrue(t.pickUp(3));
    }
    
    
    //pickUp() test #2
    @Test(timeout=100)
    public void testPickUpNotEnoughRoom() {
        /*
         * Make sure pickUp() returns false when you try to pick up more
         * passengers than the capacity.
         */
    	Taxi t = new Taxi(12.00, 5);
    	assertFalse(t.pickUp(6));
    }
}
