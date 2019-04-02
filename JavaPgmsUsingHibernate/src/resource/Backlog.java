package resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import backend.BacklogInfo;
import pojo.Smabp00;
import pojo.Smacp00;
import pojo.Smakp00;
import pojo.Smalp00;
import pojo.Smamp00;


@Path("/Backlog")
public class Backlog {
	

	/**
	 * This method return PO backlog Header information using Gson.
	 * @param info (firm, pcar)
	 * @return
	 */
	@GET
	@Path("/POHeader/{firm}/{pcar}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPOHeader(@PathParam("firm") String firm,
			                  @PathParam("pcar") String pcar){
					
		//Get PO backlog	
		BacklogInfo backlogInfo = new BacklogInfo();
		Smakp00 smak = backlogInfo.getPOHeader(firm, pcar);
		//System.out.println(smak.getPCARAK());
		
		// convert SMAK pojo to json
		List<Smakp00> smakArr = new ArrayList<Smakp00>(); 
		smakArr.add(smak);
		Gson gson = new Gson();
		String json = gson.toJson(smakArr);
		System.out.println(json);
		return json;
	}
		/**
		 * This method return PO backlog Detail information using Gson.
		 * @param info (firm, pcar)
		 * @return
		 */
		@GET
		@Path("/PODetail/{firm}/{pcar}/{seqn}")
		@Produces(MediaType.APPLICATION_JSON)
		public String getPODetail(@PathParam("firm") String firm,
                                  @PathParam("pcar") String pcar,
                                  @PathParam("seqn") String seqn){
		
			//Get PO backlog
			BacklogInfo backlogInfo = new BacklogInfo();
			Smalp00 smal = backlogInfo.getPODetail(firm, pcar, seqn);
			
			// convert SMAL pojo to json
			List<Smalp00> smalArr = new ArrayList<Smalp00>(); 
			smalArr.add(smal);
			Gson gson = new Gson();
			String json = gson.toJson(smalArr);
			System.out.println(json);
			return json;			
	}		
		
		/**
		 * This method return SO/PO Reference information using Gson.
		 * @param info (firm, card, srqn)
		 * @return
		 */
		@GET
		@Path("/SOPOReference/{firm}/{card}/{srqn}")
		@Produces(MediaType.APPLICATION_JSON)
		public String getSOPOReference(@PathParam("firm") String firm,
				                       @PathParam("card") String card,
				                       @PathParam("srqn") String srqn) {
		
			//Get SO/PO Reference information
			BacklogInfo backlogInfo = new BacklogInfo();	
			List<Smamp00> smam = backlogInfo.getSOPOReference(firm, card, srqn);
			
			//convert SMAM pojo to json
			Gson gson = new Gson();
			String json = gson.toJson(smam);
			System.out.println(json);
			return json;		
	}		
		
		/**
		 * This method return SO Backlog Header Information.
		 * @param info (firm, card)
		 * @return
		 */
		@GET
		@Path("/SOHeader/{firm}/{card}")
		@Produces(MediaType.APPLICATION_JSON)
		public String getSOHeader(@PathParam("firm") String firm,
				                  @PathParam("card") String card) {
					
			//Get SO Backlog Header information
			BacklogInfo backlogInfo = new BacklogInfo();	
		    List<Smabp00> smab = backlogInfo.getSOHeader(firm, card);
			
		    //convert SMAB pojo to json
			Gson gson = new Gson();
			String json = gson.toJson(smab);
			System.out.println(json);
			return json;
	}
		/**
		 * This method return SO Backlog Detail Information
		 * with ack date not equals to 99999999/0 and without picknote.
		 * @param info (firm, cust, card)
		 * @return
		 */
		@GET
		@Path("/SODetail/{firm}")
		//@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		@Produces(MediaType.APPLICATION_JSON)
		public String getSODetailA(@PathParam("firm") String firm) {
				              
					
			//Get SO Backlog Header information
			BacklogInfo backlogInfo = new BacklogInfo();	
			List<Smacp00> smac = backlogInfo.getSODetailA(firm);
			
			Gson gson = new Gson();
			String json = gson.toJson(smac);
			System.out.println(json);
			return json;
	}
}
