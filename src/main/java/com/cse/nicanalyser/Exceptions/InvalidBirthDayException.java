/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cse.nicanalyser.Exceptions;

/**
 *
 * @author dulitha
 */
public class InvalidBirthDayException extends Exception {

    /**
     * Creates a new instance of <code>InvalidBirthDayException</code> without detail message.
     */
    public InvalidBirthDayException() {
    }


    /**
     * Constructs an instance of <code>InvalidBirthDayException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InvalidBirthDayException(String msg) {
        super(msg);
    }
}
