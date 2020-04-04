package counter.impl;

import counter.interfaces.CountingEngineIF;
import counter.interfaces.CountingFactoryIF;
import java.util.ArrayList;
import java.util.List;

//==============================================================================
public class CountingFactory implements CountingFactoryIF {
    
    private static List strategies = new ArrayList<String>();
    
    static {
        strategies.add("sample");
        strategies.add("power");
        strategies.add("multiplo");
    }
    //=================================================
    /** 
     * Returns the engine required.
     * 
     * @param method The name of the strategy
     */
    @Override
    public CountingEngineIF getEngine(String method) {
        switch (method) {
            case "sample":
                return new SampleEngine();
            case "power":
                return new PowerEngine();
            case "multiplo":
                return new MultiploEngine();
        }
        return null;
    }
    //=================================================
    /** 
     * Returns the Available Strategies supplied by this factory.
     * 
     * @return A List of Strings
     */
    @Override
    public List<String> getStrategies() {
        return strategies;
    }
    //=================================================    
}
