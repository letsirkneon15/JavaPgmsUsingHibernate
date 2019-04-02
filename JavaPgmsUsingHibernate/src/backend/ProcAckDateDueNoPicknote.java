package backend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.muratames.usso.common.JsonParserUtil;
import com.muratames.usso.common.SendEmailUtil;


public class ProcAckDateDueNoPicknote {
	
	public static void main(String[] args) throws IOException
	{
		//Variables declaration
		String webServiceURL = "";
		String firmCode  = args[0];
		String custCode  = "";
		String custName  = "";
		String clerkCode = "";
		int counter = 1;
		String factoryCode = ""; 
		String supplierCard = "";
		String soDetCard  = "";
		String soSequence = "";
		String murataType = "";
		int shipQty    = 0;
		int ackDate    = 0;
		String partNumber = "";
		String poCard     = ""; 
		String poSequence = "";
		String calString = "";
		String directShipFlag = "";
		String salesGroupCode = "";
		String consB = "S80";
		String mumuWebService = "";
	    String iSeriesOsa="";
	    String fileName="";
	    String noPicknoteFolder="";
	    String key="";
	    String program="";
	    String segment="";
	    String tokenId="";
	    String parmSubject = "";

		//Get properties value
		NoPicknoteProperties noPicknoteProp = new NoPicknoteProperties();
		try {
			noPicknoteProp.getProperties();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		webServiceURL = noPicknoteProp.getWebServiceURL();
		mumuWebService = noPicknoteProp.getMumuWebService();
		fileName = noPicknoteProp.getFileName();
		noPicknoteFolder = noPicknoteProp.getNoPicknoteFolder();
		key = noPicknoteProp.getKey();
		program = noPicknoteProp.getProgram();
		segment = noPicknoteProp.getSegment();
		tokenId = noPicknoteProp.getTokenId();
		
		if(firmCode.equals("20")){
			iSeriesOsa = noPicknoteProp.getiSeries20();
		}else if(firmCode.equals("21")){
			iSeriesOsa = noPicknoteProp.getiSeries21();
		}else if(firmCode.equals("24")){
			iSeriesOsa = noPicknoteProp.getiSeries24();
		}else if(firmCode.equals("25")){
			iSeriesOsa = noPicknoteProp.getiSeries25();
		}

		//create excel file name
		Calendar cal = Calendar.getInstance();
		cal.get(Calendar.DATE);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		calString = format1.format(cal.getTime());

		//calString = "20160609";
		//String filename = "C:/AckDate_Due_No_Picknote_" + calString + ".xls" ;
		String excelFile = iSeriesOsa + noPicknoteFolder + fileName + calString + ".xls" ;
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("FirstSheet"); 

		//create excel Column Name
		HSSFRow rowhead = sheet.createRow((short)0);
		rowhead.createCell(0).setCellValue("Sales Customer Code");
		rowhead.createCell(1).setCellValue("Customer Name");
		rowhead.createCell(2).setCellValue("Direct Shipment Flag");
		rowhead.createCell(3).setCellValue("Cust Part No.");
		rowhead.createCell(4).setCellValue("Murata Type");
		rowhead.createCell(5).setCellValue("Sales Card");
		rowhead.createCell(6).setCellValue("SO Card Sequence");
		rowhead.createCell(7).setCellValue("Purchase Card");
		rowhead.createCell(8).setCellValue("PO Card Sequence");
		rowhead.createCell(9).setCellValue("Supplier card");
		rowhead.createCell(10).setCellValue("Factory code");
		rowhead.createCell(11).setCellValue("Shipment Qty");
		rowhead.createCell(12).setCellValue("Delivery Date");
		rowhead.createCell(13).setCellValue("Clerk Code");

		//Read SO backlog (detail) to get all those with ack date <> 99999999/0 but no
		//picknote created
		String uriSODetail = webServiceURL + "Backlog/SODetail/" + firmCode;
		JsonArray soDetail = JsonParserUtil.getWebServiceData(uriSODetail);

		//System.out.println(soDetail);
		if(soDetail != null){
			for (Object soDetailRes : soDetail) {
				JsonObject soDetailjson = (JsonObject) soDetailRes;
				soDetCard  = soDetailjson.get("CARDAC").getAsString().trim(); 
				soSequence = soDetailjson.get("SRQNAC").getAsString().trim();
				murataType = soDetailjson.get("MURAAC").getAsString().trim();
				shipQty    = soDetailjson.get("CQTYAC").getAsInt();
				ackDate    = soDetailjson.get("DAKSAC").getAsInt();
				custCode   = soDetailjson.get("CUSTAC").getAsString().trim();
				directShipFlag = soDetailjson.get("DSHPAC").getAsString().trim();

				//Exclude Sales Group code = B in the process
				String uriCustStat = webServiceURL + "Customer/StatisticMaster/SalesGroupCode/" + firmCode + "/" + custCode;
				salesGroupCode = JsonParserUtil.getWebServiceDataString(uriCustStat);
				if(!salesGroupCode.equals(consB)){

					//Read SO backlog (header) to get PartNo.
					partNumber   = "";
					String uriSOHeader = webServiceURL + "Backlog/SOHeader/" + firmCode + "/" + soDetCard;
					JsonArray soHeader = JsonParserUtil.getWebServiceData(uriSOHeader);

					if(soHeader != null){
						for (Object soHeaderRes : soHeader){
							JsonObject soHeaderjson = (JsonObject) soHeaderRes;
							partNumber = soHeaderjson.get("PARTAB").getAsString().trim();

							//get all active customer code with stop code = *blanks
							String uriCustMaster = webServiceURL + "Customer/Master/ByCustCode/" + firmCode + "/" + custCode;
							JsonArray custData = JsonParserUtil.getWebServiceData(uriCustMaster);

							if(custData !=null){
								for (Object cusRes : custData) {
									JsonObject jsonObj = (JsonObject) cusRes;
									firmCode  = jsonObj.get("FIRMDA").getAsString().trim();
									custCode  = jsonObj.get("CUSTDA").getAsString().trim();
									custName  = jsonObj.get("CNMSDA").getAsString().trim();
									clerkCode = jsonObj.get("CLERDA").getAsString().trim();

									//get SO/PO reference details in order to get the PO card
									String uriSOPO = webServiceURL + "Backlog/SOPOReference/" + firmCode + "/" + soDetCard + "/" + soSequence;
									JsonArray sOPORef = JsonParserUtil.getWebServiceData(uriSOPO);

									poCard       = ""; 
									poSequence   = "";
									factoryCode  = ""; 
									supplierCard = "";

									supplierCard = "";
									if(sOPORef != null){
										for (Object sOPORefRes : sOPORef) {
											JsonObject sOPORefjson = (JsonObject) sOPORefRes;

											poCard     = sOPORefjson.get("PCARAM").getAsString().trim(); 
											poSequence = sOPORefjson.get("SEQNAM").getAsString().trim();

											if(!poSequence.equals(" ") && !poSequence.equals("") && poSequence != null){
												//get factory code from PO backlog (Header)
												String uriPOHeader = webServiceURL + "Backlog/POHeader/" + firmCode + "/" + poCard;
												JsonArray poHeader = JsonParserUtil.getWebServiceData(uriPOHeader);

												//System.out.println("PO Header " + poHeader);
												if(poHeader != null)
												{
													for (Object poHeadRes : poHeader) {
														JsonObject poHeaderjson = (JsonObject) poHeadRes; 
														factoryCode = poHeaderjson.get("SEIKAK").getAsString().trim();  

														//get factory code from PO backlog (Header)
														String uriPODetail = webServiceURL + "Backlog/PODetail/" + firmCode + "/" + poCard + "/" + poSequence;
														JsonArray poDetail = JsonParserUtil.getWebServiceData(uriPODetail);

														if(poDetail != null){

															for (Object poDetailRes : poDetail) {
																JsonObject poDetailjson = (JsonObject) poDetailRes;
																supplierCard = poDetailjson.get("SCRDAL").getAsString().trim(); 					

															}
														}
													}
												}
											}

											//create excel file and send to user
											System.out.println(counter);
											HSSFRow row = sheet.createRow((short)counter);
											row.createCell(0).setCellValue(custCode);
											row.createCell(1).setCellValue(custName);
											row.createCell(2).setCellValue(directShipFlag);
											row.createCell(3).setCellValue(partNumber);
											row.createCell(4).setCellValue(murataType);
											row.createCell(5).setCellValue(soDetCard);
											row.createCell(6).setCellValue(soSequence);
											row.createCell(7).setCellValue(poCard);
											row.createCell(8).setCellValue(poSequence);
											row.createCell(9).setCellValue(supplierCard);
											row.createCell(10).setCellValue(factoryCode);
											row.createCell(11).setCellValue(shipQty);
											row.createCell(12).setCellValue(ackDate);
											row.createCell(13).setCellValue(clerkCode);
											counter = counter + 1;		
										}
									}
								}	
							}

						}
					}
				}
			}

		}  

		if(counter>1){
			FileOutputStream fileOut = new FileOutputStream(excelFile);
			workbook.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");
			
			//Get the email recipients/email message/subject in MUMU and send the
		    //file via standalone Java email sending
			String uriMUMU = mumuWebService + "firm=" + firmCode +
					"&key=" + key.trim() + 
					"&segment=" + segment.trim() +
					"&program=" + program.trim() + 
					"&token=" + tokenId.trim();
			
			System.out.println("fileName:" + excelFile);
			System.out.println("uriMUMU" + uriMUMU);
			
			SendEmailUtil.sendEmailviaMUMU(firmCode, uriMUMU, excelFile, parmSubject);

		}else{
			System.out.println("No records found!");
		}
	}

}
