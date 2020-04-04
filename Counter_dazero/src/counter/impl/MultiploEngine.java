/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter.impl;
import counter.interfaces.CountingEngineIF;
/**
 *
 * @author Sasha
 */
public class MultiploEngine implements CountingEngineIF{

    private int c = 1;
    
    @Override
    public Object getNext() {
        return c*=2;     
    }

    @Override
    public String getInfo() {
        return "Questa strategia restituisce il multiplo di 2 di counter.\n";
    }
    
}
