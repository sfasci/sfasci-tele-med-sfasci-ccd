/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter.impl;
import counter.interfaces.CountingEngineIF;
import exceptionpkg.BoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sasha
 */
public class MultiploEngine implements CountingEngineIF{

    private int c = 1;
    private int upperBound = 0;
    private boolean valueSet = false;
    
    @Override
    public Object getNext() throws BoundException{
        
        if(valueSet) { this.isOutOfBound(c*=2); }
            
        return c;   
    }

    @Override
    public String getInfo() {
        return "Questa strategia restituisce il multiplo di 2 di counter.\n";
    }

    @Override
    public void setUpperBound(int bound) {
        this.upperBound = bound;
        this.valueSet = true;
    }

    @Override
    public void isOutOfBound(int value) throws BoundException {
        
        if(value >= this.upperBound){
            throw new BoundException("Exceed the upper bound.");
        }
    }
    
}
