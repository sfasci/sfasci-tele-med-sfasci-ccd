/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionpkg;

/**
 *
 * @author davidecolombo
 */
public class BoundException extends Exception {

    /**
     * Creates a new instance of <code>BoundException</code> without detail
     * message.
     */
    public BoundException() {
    }

    /**
     * Constructs an instance of <code>BoundException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BoundException(String msg) {
        super(msg);
    }
}
