package counter.impl;

import counter.interfaces.CountingEngineIF;
//==============================================================================
/** Sample engine implementing a strategy 
 */
public class SampleEngine implements CountingEngineIF {
    private int counter = 0;

    //==============================
    @Override
    public Object getNext() {
        return ++counter;
    }
    
    //==============================    
}
