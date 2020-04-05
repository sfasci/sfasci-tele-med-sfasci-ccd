package counter.interfaces;

import exceptionpkg.BoundException;

//==============================================================================
/** 
 * Interface defining the contract of a Counting Engine (Strategy).
 * 
 * Should be improved at will to improve the functionality of a Strategy
 *  and answer the questions.
 */
public interface CountingEngineIF {

    //============================================
    /**
     * The basic method of a Counting Engine for returning the next item.
     * 
     * @return The next counting object.
     * @throws exceptionpkg.BoundException
     */
    public Object getNext() throws BoundException;
    //==========================================================================
    
    /** Information about the Engine
     * @return  **/
     public String getInfo();
    //==========================================================================  
     
    /** Setting the upper bound
     * @param bound **/
     public void setUpperBound(int bound);
    //==========================================================================
     
     
     public void isOutOfBound(int value) throws BoundException;
    //==========================================================================
     
    /**
     * Setting the initial value given from user.
     * @param value **/
    public void setInitialValue(int value);
    //==========================================================================
    
    /**
     * Setting the increment value givem from user.
     * @param value **/
    public void setIncrementValue(int value);
    //==========================================================================

     
}
