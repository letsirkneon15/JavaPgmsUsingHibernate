package backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.SessionUtil;
import pojo.Smabp00;
import pojo.Smacp00;
import pojo.Smakp00;
import pojo.Smalp00;
import pojo.Smamp00;


public class BacklogInfo {


	/*This method is to get the PO Backlog Header information and return as POJO*/		
	@SuppressWarnings("unused")
	public Smakp00 getPOHeader(String firm, String pcar)
	{

		Session session = SessionUtil.getSession(firm);

		Transaction tx = null;
		Smakp00 POBacklogRecGet = null;

		Smakp00 POBacklogRec = new Smakp00(firm, pcar);

		try {	
			//tx = session.beginTransaction();
			POBacklogRecGet = (Smakp00)session.get(Smakp00.class, POBacklogRec);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			//tx = session.beginTransaction();
			POBacklogRecGet = (Smakp00)session.get(Smakp00.class, POBacklogRec);

			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		//System.out.print("Result output==>" + POBacklogRecGet.getPCARAK());
		return POBacklogRecGet;
	}

	/*This method is to get the PO Backlog Detail information and return as POJO*/	

	@SuppressWarnings("unused")
	public Smalp00 getPODetail(String firm, String pcar, String seqn)
	{

		Session session = SessionUtil.getSession(firm);

		Transaction tx = null;

		Smalp00 SOBacklogRecGet = null;

		Smalp00 SOBacklogRec = new Smalp00(firm, pcar, seqn);

		try {
			//tx = session.beginTransaction();	
			SOBacklogRecGet = (Smalp00)session.get(Smalp00.class, SOBacklogRec);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			//tx = session.beginTransaction();	
			SOBacklogRecGet = (Smalp00)session.get(Smalp00.class, SOBacklogRec);

			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		//System.out.print("Result output==>" + SOBacklogRecGet.getPCARAL());
		return SOBacklogRecGet;
	}

	/*This method is to get the PO/SO Reference information and return as POJO*/	
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Smamp00> getSOPOReference(String firm, String card, String srqn)
	{
		List<Smamp00> SOPOReferenceRecGet = new ArrayList<Smamp00>();	

		Session session = SessionUtil.getSession(firm);

		SOPOReferenceRecGet = null;
		Transaction tx = null;

		Query query = null;
		String hql = "";

		hql = "FROM Smamp00 A WHERE A.FIRMAM = :firm " 
				+ "AND A.STATAM = ' ' AND A.CARDAM = :card AND A.SRQNAM = :srqn";

		try {
			query = session.createQuery(hql);
			query.setParameter("firm", firm);	
			query.setParameter("card", card);
			query.setParameter("srqn", srqn);
			SOPOReferenceRecGet = (List<Smamp00>) query.list();		
		}	
		catch (Exception e) {
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			query = session.createQuery(hql);
			query.setParameter("firm", firm);	
			query.setParameter("card", card);
			query.setParameter("srqn", srqn);
			SOPOReferenceRecGet = (List<Smamp00>) query.list();		

			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return SOPOReferenceRecGet;
	}

	/*This method is to get the SO Backlog Header Information and return as POJO*/		
	@SuppressWarnings({"unchecked", "unused" })
	public List<Smabp00> getSOHeader(String firm, String card)
	{
		List<Smabp00> SOHeaderRecGet = new ArrayList<Smabp00>();	

		Session session = SessionUtil.getSession(firm);

		SOHeaderRecGet = null;
		Transaction tx = null;
		Query query = null;

		String hql = "";
		hql = "FROM Smabp00 A WHERE A.FIRMAB = :firm " 
				+ "AND A.STOPAB = ' ' AND A.CARDAB = :card";

		try {
			query = session.createQuery(hql);
			query.setParameter("firm", firm);	
			query.setParameter("card", card);
			SOHeaderRecGet = (List<Smabp00>) query.list();		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			query = session.createQuery(hql);
			query.setParameter("firm", firm);	
			query.setParameter("card", card);
			SOHeaderRecGet = (List<Smabp00>) query.list();

			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		//System.out.print(SOHeaderRecGet);
		return SOHeaderRecGet;
	}

	/*This method is to get the SO Backlog Detail Information and return as POJO*/		
	@SuppressWarnings({ "unchecked", "unused", })
	public List<Smacp00> getSODetailA(String firm)
	{
		List<Smacp00> SODetailRecGet = new ArrayList<Smacp00>();	

		Session session = SessionUtil.getSession(firm);

		SODetailRecGet = null;
		Transaction tx = null;
		Query query = null;

		String hql = "";

		// Current date + 1day
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		dt = c.getTime();
		String charDate = format1.format(dt);		
		int dateOne = Integer.parseInt(charDate);
		System.out.println(charDate);

		hql = "FROM Smacp00 A WHERE A.FIRMAC = :firm " 
				+ "AND A.STATAC = ' ' AND A.DAKSAC <= :dateOne AND A.DAKSAC != 0 AND A.PICKAC = ' ' ";

		try {			
			query = session.createQuery(hql);
			query.setParameter("firm", firm);	
			query.setParameter("dateOne", dateOne);
			SODetailRecGet = (List<Smacp00>) query.list();		

		} catch (Exception e) {
			System.out.println(e.getMessage());
			session = SessionUtil.resetSession(firm);
			query = session.createQuery(hql);
			query.setParameter("firm", firm);	
			query.setParameter("dateOne", dateOne);
			SODetailRecGet = (List<Smacp00>) query.list();	

			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		//System.out.print(SODetailRecGet);
		return SODetailRecGet;
	}

}