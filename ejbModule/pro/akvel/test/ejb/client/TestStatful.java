package pro.akvel.test.ejb.client;

import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import pro.akvel.test.ejb.TestStateFullRemote;

/**
 * Сколько на самом деле создатся Statefull ejb при remote вызове 
 * 
 * @author akv
 *
 */
public class TestStatful {
	public static void main(String[] args) throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

		// optional.  Defaults to localhost.  Only needed if web server is running
		// on a different host than the appserver   
		props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
		// optional.  Defaults to 3700.  Only needed if target orb port is not 3700.
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		
		 TestStateFullRemote foo = (TestStateFullRemote) new InitialContext(props).lookup("java:global/TestEJB/TestStateFull!pro.akvel.test.ejb.TestStateFullRemote");
	
		 System.out.println(System.currentTimeMillis() + " " + foo.getCounter());
		 
		 TestStateFullRemote foo1 = (TestStateFullRemote) new InitialContext(props).lookup("java:global/TestEJB/TestStateFull!pro.akvel.test.ejb.TestStateFullRemote");
		 
		 System.out.println(System.currentTimeMillis() + " " + foo1.getCounter());
	}
}
