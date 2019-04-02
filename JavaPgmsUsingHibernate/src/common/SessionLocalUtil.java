package common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionLocalUtil {

	private static SessionFactory factoryMESLcl;
	private static SessionFactory factoryTMTLcl;
	private static SessionFactory factoryMEPLcl;
	private static SessionFactory factoryMMELcl;

	@SuppressWarnings("deprecation")
	public static Session getSessionLocal(String firm) {

		String CONFIG = "hibernateUSSOLCL" + firm + ".cfg.xml";

		System.out.println(CONFIG);

		Session session = null;

		if(firm.equals("20")) {
			if(factoryMESLcl==null) {
				factoryMESLcl = new Configuration().configure(CONFIG).buildSessionFactory();
			}
			session = factoryMESLcl.openSession();		
		} else if(firm.equals("21")) {
			if(factoryMMELcl==null) {
				factoryMMELcl = new Configuration().configure(CONFIG).buildSessionFactory();
			} 
			session = factoryMMELcl.openSession();
		} else if(firm.equals("24")) {
			if(factoryTMTLcl==null) {
				factoryTMTLcl = new Configuration().configure(CONFIG).buildSessionFactory();
			} 
			session = factoryTMTLcl.openSession();
		} else if(firm.equals("25")) {
			if(factoryMEPLcl==null) {
				factoryMEPLcl = new Configuration().configure(CONFIG).buildSessionFactory();
			}
			session = factoryMEPLcl.openSession();
		} 

		return session;
	}
	
	 @SuppressWarnings("deprecation")
		public static Session resetSession(String firm) {
	            
		  		Session session = null;
		  		
	            String config = "hibernateUSSOLCL" + firm + ".cfg.xml";
	            
	            if(firm.equals("20")) {
	                  factoryMESLcl = new Configuration().configure(config).buildSessionFactory();
	                  System.out.println(factoryMESLcl.toString());
	                  session = factoryMESLcl.openSession();	
	            }
	            if(firm.equals("21")) {
	                  factoryMMELcl = new Configuration().configure(config).buildSessionFactory();
	                  System.out.println(factoryMMELcl.toString());
	                  session = factoryMMELcl.openSession();	
	            }
	            if(firm.equals("24")) {
	            	System.out.println("testing kristel...");
	                  factoryTMTLcl = new Configuration().configure(config).buildSessionFactory();
	                  System.out.println(factoryTMTLcl.toString());
	                  session = factoryTMTLcl.openSession();	
	            }
	            if(firm.equals("25")) {
	                  factoryMEPLcl = new Configuration().configure(config).buildSessionFactory();
	                  System.out.println(factoryMEPLcl.toString());
	                  session = factoryMEPLcl.openSession();	
	            }
	            return session;
	      }
}
