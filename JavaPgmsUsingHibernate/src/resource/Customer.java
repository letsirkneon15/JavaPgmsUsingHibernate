package resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import backend.CustomerInfo;
import pojo.Smdap00;


@Path("/Customer")
public class Customer {

	/**
	 * This method return Customer Master Information.
	 * @param info (firm)
	 * @param info (cust)
	 * @return
	 */
	@GET
	@Path("/Master/ByCustCode/{firm}/{cust}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustMaster(@PathParam("firm") String firm, 
			@PathParam("cust") String cust) {

		//Get Customer Master
		CustomerInfo custMaster = new CustomerInfo();	
		List<Smdap00> smda = custMaster.getCustMaster(firm, cust);
		//System.out.println(firm);

		Gson gson = new Gson();
		String json = gson.toJson(smda);
		System.out.println(json);
		return json;

	}

	/**
	 * This method return Customer Master Information using stock cust code.
	 * @param info (firm)
	 * @param info (stockCustCode)
	 * @return
	 */
	@GET
	@Path("/Master/ByStockCustCode/{firm}/{stockCustCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustMasterByStock(@PathParam("firm") String firm, 
			@PathParam("stockCustCode") String stockCustCode) {

		//Get Customer Master
		CustomerInfo custMaster = new CustomerInfo();	
		List<Smdap00> smda = custMaster.getCustMasterByStockCustCode(firm, stockCustCode);
		//System.out.println(firm);

		Gson gson = new Gson();
		String json = gson.toJson(smda);
		System.out.println(json);
		return json;

	}
	
	/**
	 * This method return the Sales Group code from Customer Statistic Master
	 * @param info (firm)
	 * @param info (custCode)
	 * @return
	 */
	@GET
	@Path("/StatisticMaster/SalesGroupCode/{firm}/{custCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSalesGroupCode(@PathParam("firm") String firm, 
			                        @PathParam("custCode") String custCode) {

		//Get Customer Master
		CustomerInfo custMaster = new CustomerInfo();	
		return custMaster.getSalesGroupCode(firm, custCode);

	}
	
	/**
	 * This method return the Sales Manager code from Customer Statistic Master
	 * @param info (firm)
	 * @param info (custCode)
	 * @return
	 */
	@GET
	@Path("/StatisticMaster/SalesManagerCode/{firm}/{custCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSalesManagerCode(@PathParam("firm") String firm, 
			                        @PathParam("custCode") String custCode) {

		//Get Customer Master
		CustomerInfo custMaster = new CustomerInfo();	
		return custMaster.getSalesManagerCode(firm, custCode);

	}
}
