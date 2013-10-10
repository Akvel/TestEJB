package pro.akvel.test.ejb.client;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import pro.akvel.test.ejb.TestSingletoneRemote;

public class TestSingleTone {
	
	
	
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
		
		 final TestSingletoneRemote foo = (TestSingletoneRemote) new InitialContext(props).lookup("java:global/TestEJB/TestSingletone!pro.akvel.test.ejb.TestSingletoneRemote");

		 
		 final TestSingletoneRemote foo1 = (TestSingletoneRemote) new InitialContext(props).lookup("java:global/TestEJB/TestSingletone!pro.akvel.test.ejb.TestSingletoneRemote");
		 

		 
		 
		 
		 new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (1 == 1){
				System.out.println("start long");
				foo.getLong();
				System.out.println("end long");
				}
				
			}
		}).start();
		 
		 
		 new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (1 == 1){
						System.out.println("TEST-1:" + foo.getShot());
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}).start();
		 
		 new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (1 == 1){
						System.out.println("TEST-2:" + foo1.getShot());
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}).start();
	}
}
