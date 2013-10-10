package pro.akvel.test.ejb;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Проверяем действительно ли сингтон ждет окончания выполнения разных методов при вызове с разных потоков
 */
@Singleton
@LocalBean
public class TestSingletone implements TestSingletoneRemote {

    /**
     * Default constructor. 
     */
    public TestSingletone() {
       
    }

	@Override
	public void getLong() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getShot() {
		return new Date().toString();
	}
    
    

}
