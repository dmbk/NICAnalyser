/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.nicanalyser;

import com.cse.nicanalyser.Exceptions.InvalidBirthDayException;
import com.cse.nicanalyser.servlet.NICCalculator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 *
 * @author dulitha
 */
public class NICCalcTest {

    NICCalculator nicCalc;

    @BeforeClass
    public void setUp() {
        nicCalc = new NICCalculator();
    }

    @Test
    public void testCalcBDay() {
        int year = 1991;
        int numOfDays = 359;
        DateTime expectedResult = new DateTime(1991, 12, 24, 0, 0);
        DateTime dt = nicCalc.setDateAttributes(year, numOfDays);
//DateTime result=new DateTime(dt.getYear(),dt.getMonthOfYear(),dt.getDayOfMonth(),0,0);
        assertEquals(expectedResult, dt);

    }

    @Test
    public void testCalcGender() {
        int numOfDays = 359;
        String expectedVal = "Male";
        String result = this.nicCalc.getGender(numOfDays);
        assertEquals(expectedVal, result);

    }

    @Test
    public void testCalcVoter() {
        DateTime bDay = new DateTime(1999, 12, 24, 0, 0);
        boolean expAns = false;
        boolean result = this.nicCalc.isVoter(bDay);
        assertEquals(expAns, result);
    }

    /*@Test(expectedExceptions=InvalidBirthDayException.class)
    public void testCalcInvalidBirthDayEx1() {
        try {
            this.nicCalc.setDateAttributes(1991, 999);
        } catch (InvalidBirthDayException ex) {
            Logger.getLogger(NICCalcTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
