package test;

import junit_p1.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    @Before
    public void init(){
        System.out.println("applying resources, execute before all test methods.");
    }

    @After
    public void close(){
        System.out.println("releasing resources, execute after all test methods.");
    }

    Calculator c = new Calculator();

    /**
     * Test calculator
     */
    @Test
    public void testAdd(){
        int result = c.add(1,2);
        System.out.println(result);
//        System.out.println("I've been executed!");

//        assert
        Assert.assertEquals(3,result);
    }

}
