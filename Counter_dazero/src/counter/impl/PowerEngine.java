/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter.impl;

import counter.interfaces.CountingEngineIF;

/**
 *
 * @author davidecolombo
 */
public class PowerEngine implements CountingEngineIF{

    private int counter = 1;
    
    @Override
    public Object getNext() {
        return counter*=2;
    }
    
}
