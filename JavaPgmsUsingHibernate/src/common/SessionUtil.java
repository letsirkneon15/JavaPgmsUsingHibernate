package common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

		private static SessionFactory factoryMES;
		private static SessionFactory factoryTMT;
		private static SessionFactory factoryMEP;
		private static SessionFactory factoryMME;
		
		@SuppressWarnings("deprecation")
		public static Session getSession(String firm) {

			String CONFIG = "hibernateUSSO" + firm + ".cfg.xml";	
			
			System.out.println(CONFIG);
			Session session = null;

			if(firm.equals("20")) {
				if(factoryMES==null) {
					factoryMES = new Configuration().configure(CONFIG).buildSessionFactory();
				}
				session = factoryMES.openSession();		
			} else if(firm.equals("21")) {
				if(factoryMME==null) {
					factoryMME = new Configuration().configure(CONFIG).buildSessionFactory();
				} 
				session = factoryMME.openSession();
			} else if(firm.equals("24")) {
				if(factoryTMT==null) {
					factoryTMT = new Configuration().configure(CONFIG).buildSessionFactory();
				} 
				session = factoryTMT.openSession();
			} else if(firm.equals("25")) {
				if(factoryMEP==null) {
					factoryMEP = new Configuration().configure(CONFIG).buildSessionFactory();
				}
				session = factoryMEP.openSession();
			} 

			return session;
		}
		
		  @SuppressWarnings("deprecation")
			public static Session resetSession(String firm) {
		            
			  		Session session = null;
			  		
		            String config = "hibernateUSSO" + firm + ".cfg.xml";
		            
		            if(firm.equals("20")) {
		                  factoryMES = new Configuration().configure(config).buildSessionFactory();
		                  System.out.println(factoryMES.toString());
		                  session = factoryMES.openSession();	
		            }
		            if(firm.equals("21")) {
		                  factoryMME = new Configuration().configure(config).buildSessionFactory();
		                  System.out.println(factoryMME.toString());
		                  session = factoryMME.openSession();	
		            }
		            if(firm.equals("24")) {
		                  factoryTMT = new Configuration().configure(config).buildSessionFactory();
		                  System.out.println(factoryTMT.toString());
		                  session = factoryTMT.openSession();	
		            }
		            if(firm.equals("25")) {
		                  factoryMEP = new Configuration().configure(config).buildSessionFactory();
		                  System.out.println(factoryMEP.toString());
		                  session = factoryMEP.openSession();	
		            }
		            return session;
		      }
}
