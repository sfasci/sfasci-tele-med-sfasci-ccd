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

    private int counter = 1;
    private int upperBound = 0;
    private boolean valueSet = false;
    
    @Override
    public Object getNext() throws BoundException{
        
        if(valueSet){ this.isOutOfBound(counter*=2); }
        
        return counter;
    }

    @Override
    public String getInfo() {
        return "Questa strategia moltiplica il counter per 2 ogni volta.\n";
    }

    @Override
    public void setUpperBound(int bound) {
        this.upperBound = bound;
        this.valueSet = true;
    }

    @Override
    public void isOutOfBound(int value) throws BoundException {
        if(value > this.upperBound){
            throw new BoundException("Exceed the upper bound.");
        }
    }
    
}
