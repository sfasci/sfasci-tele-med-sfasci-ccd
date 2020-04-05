/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter.impl;

import counter.interfaces.CountingEngineIF;
import exceptionpkg.BoundException;

/**
 *
 * @author davidecolombo
 */
public class PowerEngine implements CountingEngineIF{

    private int counter    = 2;         // default
    private int upperBound = 100000;    // default
    private int increment  = 2;         // by default compute the square

    
    @Override
    public Object getNext() throws BoundException{
        
        counter = (int) Math.pow(counter, increment);
        
        this.isOutOfBound(counter);
        
        return counter;
    }

    @Override
    public String getInfo() {
        return "\nHai scelto la strategia POWER\n"
                + "Questo counter inizia a contare da " + this.counter 
                + ", termina a " + this.upperBound
                + " e incrementa di " + this.increment;
    }

    @Override
    public void setUpperBound(int bound) {
        this.upperBound = bound;
    }

    @Override
    public void isOutOfBound(int value) throws BoundException {
        if(Math.abs(value) >= Math.abs(this.upperBound)){
            throw new BoundException("Exceed the upper bound.");
        }
    }

    @Override
    public void setInitialValue(int value) {
        this.counter = value;
    }

    @Override
    public void setIncrementValue(int value) {
        this.increment = value;
    }
    
}
