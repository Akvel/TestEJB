package pro.akvel.test.ejb;

import javax.ejb.Remote;

@Remote
public interface TestStateFullRemote {

	
	int getCounter();
	
	
}
