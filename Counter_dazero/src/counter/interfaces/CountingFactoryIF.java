package counter.interfaces;

import java.util.List;
//==============================================================================
/** 
 * Interface defining the contract of a Counting Engine Factory.
 *
 * Should be improved at will to improve the functionality of a Strategy
 *  and answer the questions.
 */
public interface CountingFactoryIF {
    //==========================================================================
    /** 
     * Creates the engine supposed to implement the given (named strategy).
     * 
     * @param method The name of the strategy
     * @return The CountingEngineIF selected.
     */
    public CountingEngineIF getEngine(String method);
    //==========================================================================
    /** 
     * Returns the available stretegies registered with this factory.
     *
     * @return A List of Strings representing the strategy names.
     */
    public List<String> getStrategies();
    //==========================================================================
}
