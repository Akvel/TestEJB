package pro.akvel.test.ejb;

import javax.ejb.Remote;

@Remote
public interface TestSingletoneRemote {

	
	void getLong();
	String getShot();
}
