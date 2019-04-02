package backend;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.SessionUtil;
import pojo.Smdap00;
import pojo.Smdep00;


public class CustomerInfo {
	

	//ACCESSING CUSTOMER MASTER BY FIRM CODE and CUSTOMER CODE (CUSTDA)
	/*This method is to get the Customer Master Information and return as POJO*/		
	@SuppressWarnings({"unused", "unchecked" })
	public List<Smdap00> getCustMaster(String firm, String cust)
	{
		List<Smdap00> custMasterRecGet = new ArrayList<Smdap00>();	

		Session session = SessionUtil.getSession(firm);

		custMasterRecGet = null;
		Transaction tx = null;
		
		Query query = null;
		String hql = "";

		hql = "FROM Smdap00 A WHERE A.FIRMDA = :firm " 
				+ "AND STATDA = ' ' AND STOPDA = ' ' AND CUSTDA = :cust";
	
		try {		
			query = session.createQuery(hql);
			query.setParameter("firm", firm);
			query.setParameter("cust", cust);
			custMasterRecGet = (List<Smdap00>) query.list();		

		} catch (Exception e) {
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			query = session.createQuery(hql);
			query.setParameter("firm", firm);
			query.setParameter("cust", cust);
			custMasterRecGet = (List<Smdap00>) query.list();	
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.print(custMasterRecGet);
		return custMasterRecGet;
	}

	//ACCESSING CUSTOMER MASTER BY FIRM CODE and STOCK CUST CODE (STKCDA)
	/*This method is to get the Customer Master Information and return as POJO*/		
	@SuppressWarnings({ "unchecked", "unused"})
	public List<Smdap00> getCustMasterByStockCustCode(String firm, String stockCustCode)
	{
		List<Smdap00> custMasterRecGet = new ArrayList<Smdap00>();	
		
		Session session = SessionUtil.getSession(firm);

		custMasterRecGet = null;
		Transaction tx = null;
		
		Query query = null;
		String hql = "";

		hql = "FROM Smdap00 A WHERE A.FIRMDA = :firm " 
				+ "AND STATDA = ' ' AND STOPDA = ' ' AND STKCDA = :stockCustCode";
		
		try {
			query = session.createQuery(hql);
			query.setParameter("firm", firm);
			query.setParameter("stockCustCode", stockCustCode);
			custMasterRecGet = (List<Smdap00>) query.list();		

		} catch (Exception e) {
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			query = session.createQuery(hql);
			query.setParameter("firm", firm);
			query.setParameter("stockCustCode", stockCustCode);
			custMasterRecGet = (List<Smdap00>) query.list();	
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.print(custMasterRecGet);
		return custMasterRecGet;
	}

	//ACCESSING CUSTOMER STATISTIC MASTER BY FIRM CODE and CUST CODE (CUSTDE)
	/*This method is to get sales Group Code*/		
	public String getSalesGroupCode(String firm, String custCode)
	{
		String salesGroupCode = "";
		Smdep00 custStatisticMasterRec = new Smdep00();	
		
		Session session = SessionUtil.getSession(firm);

		custStatisticMasterRec = null;
		Transaction tx = null;
		
		Smdep00 custStatisticMaster = new Smdep00(firm, custCode);
		
		try {
			tx = session.beginTransaction();		
			custStatisticMasterRec = (Smdep00)session.get(Smdep00.class, custStatisticMaster);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			tx = session.beginTransaction();		
			custStatisticMasterRec = (Smdep00)session.get(Smdep00.class, custStatisticMaster);
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		salesGroupCode = custStatisticMasterRec.getSGRPDE();
		return salesGroupCode;
	}

	//ACCESSING CUSTOMER STATISTIC MASTER BY FIRM CODE and CUST CODE (CUSTDE)
	/*This method is to get sales Manager Code*/		
	public String getSalesManagerCode(String firm, String custCode)
	{
		String salesManagerCode = "";
		Smdep00 custStatisticMasterRec = new Smdep00();	
		
		Session session = SessionUtil.getSession(firm);

		custStatisticMasterRec = null;
		Transaction tx = null;
		
		Smdep00 custStatisticMaster = new Smdep00(firm, custCode);

		try {
			tx = session.beginTransaction();	
			custStatisticMasterRec = (Smdep00)session.get(Smdep00.class, custStatisticMaster);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			tx = session.beginTransaction();	
			custStatisticMasterRec = (Smdep00)session.get(Smdep00.class, custStatisticMaster);
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		salesManagerCode = custStatisticMasterRec.getSMNGDE();
		return salesManagerCode;
	}

	

}
