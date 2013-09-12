/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.nicanalyser.servlet;

import com.cse.nicanalyser.Exceptions.InvalidBirthDayException;
import com.cse.nicanalyser.Exceptions.InvalidInputException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;

/**
 *
 * @author dulitha
 */
public class NICCalculator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nicNumber = req.getParameter("nicNumber").trim();
        if (nicNumber == null) {
            try {
                throw new InvalidInputException("Input is not valid");
            } catch (InvalidInputException ex) {
                Logger.getLogger(NICCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String birthYear = nicNumber.substring(0, 2);
        Integer numOfDays = Integer.parseInt(nicNumber.substring(2, 5));
        int year=1900+Integer.parseInt(birthYear);


        DateTime dt = this.setDateAttributes(year, numOfDays);//getting DateTime obj of the relavent dob
        
            
       
        int dateOfMonth = dt.getDayOfMonth();
        int monthOfYear = dt.getMonthOfYear();
        String gender = this.getGender(numOfDays);
        boolean isVoter=this.isVoter(dt);


        RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
        req.setAttribute("date", dateOfMonth);
        req.setAttribute("month", monthOfYear);
        req.setAttribute("year", Integer.parseInt(birthYear));
        req.setAttribute("gender", gender);
        req.setAttribute("isVoter", isVoter);

        rd.forward(req, resp);

    }


    public DateTime setDateAttributes(int year, int numOfDays) {
        if(numOfDays>366+500){
            try {
                throw new InvalidBirthDayException("The birth day in NIC is wrong");
            } catch (InvalidBirthDayException ex) {
                Logger.getLogger(NICCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (numOfDays > 500) {
            numOfDays -= 500;
        }
        DateTime dt = new DateTime(year, 1, 1, 0, 0, 0);
        dt = dt.plusDays(numOfDays - 2);

        return dt;
    }//returns DateTime object with all parameters set
    public String getGender(int numOfDays) {
        String gender;
        if (numOfDays <= 500) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        return gender;
    }//returns gender when number of days is passes
    public boolean isVoter(DateTime bDay){
        DateTime currentDate = new DateTime();
         if (bDay.plusYears(18).compareTo(currentDate)<0){
            return true;
        }
        else{
            return false;
        }
    }
}
