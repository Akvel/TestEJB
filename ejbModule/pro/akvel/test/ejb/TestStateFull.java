package pro.akvel.test.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class TestStateFull
 */
@Stateful
@LocalBean
public class TestStateFull implements TestStateFullRemote {

	private static int cc = 0;
	
	private final int counter;
    /**
     * Default constructor. 
     */
    public TestStateFull() {
    	
    	System.out.println(System.currentTimeMillis() + " Init " + cc);
    	counter = cc++;
    }

	@Override
	public int getCounter() {
		return counter;
	}

}
