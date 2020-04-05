package counter;
import counter.interfaces.CountingFactoryIF;
import counter.interfaces.CountingEngineIF;
import exceptionpkg.BoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

//==============================================================================
public class Counter {
    
    //==========================================================================
    //==========================================================================
    /** 
     * The main method of this application.
     * 
     * @param args 
     */
    public static void main(String[] args) {
                
        Counter counter = new Counter();
        counter.doCount();
    }
    //==========================================================================
    //==========================================================================
    /** The main logger for this application. **/
    private Logger logger; 
    //==========================================================================
    /**
     * The Constructor.
     * 
     */
    private Counter() {
        // Configures the logger
        this.logger = Logger.getLogger("Counter App");
        this.logger.setLevel(Level.INFO);
    }
    //==========================================================================
    /** 
     * Start up counting
     * 
     * @param args 
     */
    private void doCount () {
        // Instantiate the Factory
        CountingFactoryIF factory = resolveFactory();
        if (factory == null) System.exit(1);
        
        // Getting strategy from user input
        String[] strategies = getChoosedStrategy();
        
        // Creates the Engine
        CountingEngineIF engine = instantiateEngine(strategies, factory);
        if (engine == null) System.exit(1);
        
        // Setting strategy
        personalizedStrategy(engine);
        
        cycle(engine);
    }    

    //==========================================================================
    /** 
     * Resolves the factory provided on the command line (as a property) and returns it.
     * 
     * @return The CountingFacrotyIF of null (if none found)
     */
    private CountingFactoryIF resolveFactory () {
        // First check for the supposed name of the Factory passed on the Command Line
        String facname = System.getProperty("factory");
        CountingFactoryIF factory = null;
        if (facname == null) {
            logger.log(Level.SEVERE, "No factory passed: use -Dfactory=<factory>");
            return null;
        }
        // Then try to resolve the Factory given instantiating the class
        try {
            factory = (CountingFactoryIF) Class.forName(facname).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException ex) {
            String message = new String ("Problems instantiating Factory: " + facname);
            logger.log(Level.SEVERE, message, ex);
            return null;
        }
        // Returns the factory
        return factory;
    }
    
    //==========================================================================
    private CountingEngineIF instantiateEngine(String[] strategies, CountingFactoryIF factory) {
        // Check if a counting strategy has been properly passed
        if (strategies.length != 1) {
            this.logger.log(Level.SEVERE, "No counting strategy given");
            return null;
        }
        
        // Check if the strategy is really available
        CountingEngineIF engine = factory.getEngine(strategies[0]);
        
        // If the strategy has not been recognized inform the user
        if (engine == null) {
            StringBuilder builder = new StringBuilder();
            builder.append("Unable to implement strategy: ").append(strategies[0]).append("\n");            
            builder.append("Available strategies are: ").append("\n");
            for (String s: factory.getStrategies()) builder.append("    ").append(s).append("\n");
            logger.log(Level.SEVERE, builder.toString());
        }
        return engine;  // May be null or Engine
    }
        
    //==========================================================================
    private void cycle (CountingEngineIF engine) {
        
        System.out.println(engine.getInfo());
        
        BufferedReader reader = null;
        
        // Start the Cycle counting forever
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            
            for (;;) {
                System.out.print("Print Next (Y/N)? ");
                String input = reader.readLine();
                if (input.length() > 0 && (input.charAt(0)=='y' || input.charAt(0) == 'Y')) {
                    System.out.println("Next value is:" + engine.getNext());
                    continue;
                }
                else if (input.length() == 0) { // Spurious newliney
                    continue;
                }
                else
                    break;
            }
        }catch (IOException ex) {
            logger.log(Level.SEVERE, "Standard Input failure ?!?");
        } catch (BoundException ex) {
            logger.log(Level.SEVERE, "Exceed the upper bound!");
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
   
    //==========================================================================
    private String[] getChoosedStrategy(){
        System.out.println("Insert your strategy: ");
        // Interact with the user from Standard Input (keyboard)
        BufferedReader br = null;
        String[] strategies = null;
        // Chiedo all'utente di inserire la strategia fino a quando non c'è una 
        // keyword corretta.
        
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            strategies = br.readLine().split("\\s");
        } catch (IOException ex) {
            Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * 
        finally{
            if(br != null){
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        * 
        * 
        * ============================= ATTENZIONE =============================
        * 
        * Non posso chiudere lo stream se poi lo devo utilizzare di nuovo!!!
        * Successivamente il programma chiede all'utente di inserire nuovamente
        * da tastiera Y/N per incrementare il counter.
        * 
        * Se chiudessi lo stream provocherei una IOException = Stream closed
        * poichè quando chiudo uno stream non posso più riaprirlo!
        * 
        **/
        
        return strategies;
    }
    
    
    private void personalizedStrategy(CountingEngineIF engine){
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lineParam;
        String lineValue;
        int param;
        int value;
        
        loop: while(true){
            
            try{
                System.out.println("Inserisci un valore intero tra 1, 2 e 3 per configurare la strategia. Scrivi 'STOP' quando hai configurato il counter!");
                // Reading the upperBound value from command line
                lineParam = reader.readLine();
                
                if(lineParam.equals("STOP") || lineParam.equals("stop")){
                   break loop;
                }else{
                    // Parsing the value
                    param = Integer.parseInt(lineParam);                    
// =============================================================================
                    switch(param){
                        /* UPPER BOUND */
                        case 1: 
                            System.out.println("Insert the upper bound for this strategy: ");
                            lineValue = reader.readLine();
                            value = Integer.parseInt(lineValue);
                            // Setting upper bound
                            engine.setUpperBound(value);
                            continue;

                        /* INITIAL VALUE */
                        case 2:
                            System.out.println("Insert the initial value for this strategy: ");
                            lineValue = reader.readLine();
                            value = Integer.parseInt(lineValue);
                            engine.setInitialValue(value);
                            /** 
                             * Qui continue è importante perchè forza il ciclo
                             * a terminare e ad iniziarne uno nuovo!! 
                             * 
                             * Se non lo mettessi mi chiederebbe in cascata di 
                             * inserire tutti i valori personalizzabili possibili.
                             */
                            continue;
                            
                        /* INCREMENT */    
                        case 3:
                            System.out.println("Insert the increment value for this strategy: ");
                            lineValue = reader.readLine();
                            value = Integer.parseInt(lineValue);
                            if(value < 0){
                                System.err.println("Only positive value for this parameter!");
                                continue;
                            }else{
                                // Setting the increment
                                engine.setIncrementValue(value);
                                continue;
                            }
                            
                    }
// ============================================================================= 
                }
                    
                    
                    

            }catch(NumberFormatException ex){
                System.err.println("Format error! Please insert a positive integer!");
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Standard input failure.");
                break;
            }
        }
        
    }
    
            
}
