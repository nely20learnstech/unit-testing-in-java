package test.unit.testing;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MoneyBagTest {
    private Money f12CHF, f14CHF, f7USD, f21USD;
    private MoneyBag fMB1, fMB2;

    @Before
    public void setUp()
    {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        f21USD = new Money(21, "USD");
        fMB1 = new MoneyBag(f12CHF, f7USD);
        fMB2 = new MoneyBag(f14CHF, f21USD);

    }

    @Test 
    public void testBagEquals()
    {
        assertTrue(!fMB1.equals(null));
        assertEquals(fMB1, fMB1);
        assertTrue(!fMB1.equals(f12CHF));
        assertTrue(!f12CHF.equals(fMB1));
        assertTrue(!fMB1.equals(fMB2));
    }
    
    @Test
    public void testMixedSimpleAdd() {
    	Money bag[] = {f12CHF, f7USD};
    	MoneyBag expected = new MoneyBag(bag);
    	assertEquals(expected, f12CHF.add(f7USD));
    }
    
    
    @Test
    public void testBagSimpleAdd() {
    	Money expected[] = {f12CHF, f7USD};
    	MoneyBag expectedBag = new MoneyBag(expected);
        IMoney result = ((IMoney) fMB1).add((IMoney)f7USD);
        assertTrue(expectedBag.equals(result));
    }
    
    @Test
    public void testSimpleBagAdd() {
    	 Money[] expected = {f12CHF, f7USD, f14CHF};
         MoneyBag expectedBag = new MoneyBag(expected);
         IMoney result = f12CHF.add(fMB1);
         assertTrue(expectedBag.equals(result));
    }
    
    @Test
    public void testBagBagAdd() {
    	 Money[] expected = {f12CHF, f7USD, f14CHF, f21USD};
         MoneyBag expectedBag = new MoneyBag(expected);
         IMoney result = ((IMoney) fMB1).add((IMoney)fMB2);
         assertTrue(expectedBag.equals(result));
    }
    
    @Test
    public void testMoneyBagSimplification() {
        Money expected = new Money(26, "CHF");
        IMoney result = new MoneyBag(f12CHF, f14CHF);
        assertEquals(expected, result);
    }
    
}

