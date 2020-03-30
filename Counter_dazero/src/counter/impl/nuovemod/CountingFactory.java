/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter.impl.nuovemod;
import counter.impl.SampleEngine;
import counter.interfaces.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sasha
 */
public class CountingFactory implements CountingFactoryIF {
    private static List strategies = new ArrayList<String>() ;
    static {
        strategies.add("sample");
        strategies.add("multiplo");
    }
     
   
    @Override
    public CountingEngineIF getEngine(String method) {
        switch (method) {
            case "sample":
                return new SampleEngine();
            case "multiplo":
                return new MultiploEngine();
        }
        return null;
    }


    @Override
    public List<String> getStrategies() {
        return strategies;
    }
  
    
}
