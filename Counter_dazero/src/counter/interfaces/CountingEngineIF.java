package counter.interfaces;

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
     */
    public Object getNext();
    //==========================================================================
    
    /** Information about the Engine
     * @return  **/
     public String getInfo();
    //==========================================================================    
}
