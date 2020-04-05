package counter.impl;

import counter.interfaces.CountingEngineIF;
import exceptionpkg.BoundException;
//==============================================================================
/** Sample engine implementing a strategy 
 */
public class SampleEngine implements CountingEngineIF {
    
    private int counter = 0;
    private boolean valueSet = false;
    private int upperBound = 0;
    
    //==============================
    @Override
    public Object getNext() throws BoundException{
        
        if(valueSet){ this.isOutOfBound(++counter); }
        
        return counter;
    }
    
    //==============================    

    @Override
    public String getInfo() {
        return "Questa strategia incrementa il counter di 1 ogni volta.\n";
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
