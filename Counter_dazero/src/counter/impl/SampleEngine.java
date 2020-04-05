package counter.impl;

import counter.interfaces.CountingEngineIF;
import exceptionpkg.BoundException;
//==============================================================================
/** Sample engine implementing a strategy 
 */
public class SampleEngine implements CountingEngineIF {
    
    private int counter = 0;            // default
    private int increment = 1;          // by default increment by 1
    private int upperBound = 100;       // default
    
    //==============================
    @Override
    public Object getNext() throws BoundException{

        this.isOutOfBound(counter+=increment); 
        
        return counter;
    }
    
    //==============================    

    @Override
    public String getInfo() {
        return "\nHai scelto la strategia SAMPLE\n"
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
