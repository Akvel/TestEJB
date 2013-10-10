package pro.akvel.test.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import org.glassfish.config.support.Create;

/**
 * Session Bean implementation class TestStateFull
 */
@Stateful
@LocalBean
public class TestStateFull implements TestStateFullRemote {

	private static int cc = 0;
	private static int cc1 = 0;
	
	private final int counter;
	private int counter1;
    /**
     * Default constructor. 
     */
    public TestStateFull() {
    	
    	System.out.println(System.currentTimeMillis() + " Init " + cc);
    	counter = cc++;
    }
    
    
    @PostConstruct
    public void init(){
    	System.out.println(System.currentTimeMillis() + " Init cc1  " + cc);
    	counter1 = cc1++;
    }

	@Override
	public String getCounters() {
		return counter + " " + counter1;
	}

}
