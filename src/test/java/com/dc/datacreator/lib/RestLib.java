/*
 * @author: LAKSHMI BS 
 * Description: To interact with org through oauth interface and generate pre-requiste data
 */
package com.dc.datacreator.lib;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class RestLib 
{
	private final static String USER_AGENT = "Mozilla/5.0";
	public static String sAccessToken = null;
	public static String sObjectID = null;
	public static String sObjectName = null;
	URL uURL =null;
	HttpsURLConnection httpsUrlCon = null;
	String sURLParameters = null;
	DataOutputStream dataOpStream = null;
	int iResponseCode =0;
	BufferedReader bBufferedReader = null;
	StringBuilder sStringBuilder = null;
	String sLine=null;
	JSONObject jJson = null;
	JSONArray jarrRes = null;
	Iterator iIterator = null;
	String sSQLQuery = null;

	/*
	 * @author: LAKSHMI BS 
	 * Description: To Fetch Access Token
	 */
	public void getOauthAccessToken() throws IOException
	{
		uURL = new URL(GenericLib.getConfigValue(GenericLib.sConfigFile, "OAUTH_URL"));
		httpsUrlCon = (HttpsURLConnection) uURL.openConnection();
		httpsUrlCon.setRequestMethod("POST");
		httpsUrlCon.setRequestProperty("User-Agent", USER_AGENT);
		httpsUrlCon.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		sURLParameters = "grant_type=password"
				+ "&client_id="+GenericLib.getConfigValue(GenericLib.sConfigFile, "CONSUMER_KEY")
				+ "&client_secret="+GenericLib.getConfigValue(GenericLib.sConfigFile, "CONSUMER_SECRET")
				+ "&username="+GenericLib.getConfigValue(GenericLib.sConfigFile, "ADMIN_USN")
				+ "&password="+GenericLib.getConfigValue(GenericLib.sConfigFile, "ADMIN_PWD");
		httpsUrlCon.setDoOutput(true);

		dataOpStream = new DataOutputStream(httpsUrlCon.getOutputStream());
		dataOpStream.writeBytes(sURLParameters);
		dataOpStream.flush();
		dataOpStream.close();
		iResponseCode = httpsUrlCon.getResponseCode();
		sStringBuilder=new StringBuilder();

		try {
			bBufferedReader = new BufferedReader(new InputStreamReader(httpsUrlCon.getInputStream(),  StandardCharsets.UTF_8));
			while ((sLine =bBufferedReader.readLine())!=null){
				sStringBuilder.append(sLine);}
		}
		catch (IOException e) { e.printStackTrace();}
		finally {
			if (bBufferedReader != null) {
				try{ bBufferedReader.close();}
				catch (IOException e) {  e.printStackTrace();}
			}
		}
		jJson = new JSONObject(sStringBuilder.toString());
		sAccessToken = (String) jJson.get("access_token");
		System.out.println("AccessToken : "+sAccessToken);
		httpsUrlCon.disconnect();

	}

	/*
	 * @author: LAKSHMI BS 
	 * Description: To generate salesforce object data in the record
	 */
	public  String getObjectRecordID(String sObjectApiName,String sWOJson) throws IOException
	{	getOauthAccessToken();
		uURL = new URL(GenericLib.getConfigValue(GenericLib.sConfigFile, "OBJBASE_URL")+sObjectApiName
				+ "Username="+GenericLib.getConfigValue(GenericLib.sConfigFile, "ADMIN_USN")
				+ "&Password="+GenericLib.getConfigValue(GenericLib.sConfigFile, "ADMIN_PWD"));
		httpsUrlCon = (HttpsURLConnection) uURL.openConnection();
		httpsUrlCon.setDoOutput(true);
		httpsUrlCon.setRequestMethod("POST");
		httpsUrlCon.setRequestProperty("Content-Type", "application/json");
		httpsUrlCon.setRequestProperty("Authorization", "OAuth "+sAccessToken);

		System.out.println("httpsUrlCon = "+httpsUrlCon);
		OutputStream os = httpsUrlCon.getOutputStream();
		os.write(sWOJson.getBytes());
		os.flush();

		bBufferedReader = null;
		sStringBuilder = new StringBuilder();

		try {
			bBufferedReader = new BufferedReader(new InputStreamReader(httpsUrlCon.getInputStream()));
			while ((sLine =bBufferedReader.readLine())!=null){
				sStringBuilder.append(sLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bBufferedReader != null) {
				try {
					bBufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//System.out.println(sStringBuilder);
		jJson = new JSONObject(sStringBuilder.toString());
		System.out.println("JSON value = "+jJson);
		sObjectID= (String) jJson.get("id");
		System.out.println("Returning ID value = "+sObjectID);
		return sObjectID;
	}

	 /*
	 * @author: LAKSHMI BS 
	 * Description: To fetch the object name or id of the object created
	 */
	public String  getObjectValue(String sSQLQuery, String sFetchValue) throws IOException
	{	String sObjectApiName="User";
		sFetchValue="Id";
		//sSQLQuery = "SELECT+Name+FROM+"+sObjectApiName+"+WHERE+id+=\'"+"0051F00000249NCQAY"+"\'";
		sSQLQuery = "SELECT+Id+FROM+"+sObjectApiName+"WHERE+Name+=\'"+"Nagendra Admin"+"\'";
		//sSQLQuery = "SELECT+Id+FROM+"+sObjectApiName+"+WHERE+Name+=\'"+"Nagendra Admin"+"\'";
		
		uURL = new URL(GenericLib.getConfigValue(GenericLib.sConfigFile, "OBJQUERY_URL")+sSQLQuery);
		System.out.println(uURL);
		httpsUrlCon = (HttpsURLConnection) uURL.openConnection();
		httpsUrlCon.setDoOutput(true);
		httpsUrlCon.setRequestMethod("GET");
		httpsUrlCon.setRequestProperty("Authorization", "OAuth "+sAccessToken);
		httpsUrlCon.setRequestProperty("Username",GenericLib.getConfigValue(GenericLib.sConfigFile, "ADMIN_USN") );
		httpsUrlCon.setRequestProperty("Password", GenericLib.getConfigValue(GenericLib.sConfigFile, "ADMIN_PWD"));

		sStringBuilder = new StringBuilder();
		try {
			bBufferedReader = new BufferedReader(new InputStreamReader(httpsUrlCon.getInputStream(),StandardCharsets.UTF_8));
			while ((sLine =bBufferedReader.readLine())!=null){
				sStringBuilder.append(sLine);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bBufferedReader != null) {
				try {
					bBufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		jJson = new JSONObject(sStringBuilder.toString());
		System.out.println("*******");
		System.out.println(jJson);
		jarrRes = (JSONArray) jJson.get("records");
		System.out.println(jarrRes);
		iIterator= jarrRes.iterator();
		while (iIterator.hasNext()) {
			JSONObject value = (JSONObject) iIterator.next();
			System.out.println((String) value.get(sFetchValue));
			sObjectName=(String) value.get(sFetchValue);
		}
		return sObjectName;
	}

	/*
	 * @author: LAKSHMI BS 
	 * Description: To update the object record with necessary data 
	 */
	public  void updateObjectRecord(String sSoObjectName,String sJsonData,String RecordId) throws IOException
	{
		uURL= new URL(GenericLib.getConfigValue(GenericLib.sConfigFile, "DOMAIN_URL")+"/services/data/v42.0/sobjects/"+sSoObjectName+"/"+RecordId+"/"+"?_HttpMethod=PATCH");
		HttpsURLConnection httpsUrlCon = (HttpsURLConnection) uURL.openConnection();
		httpsUrlCon.setDoOutput(true);
		httpsUrlCon.setDoInput(true);

		httpsUrlCon.setRequestMethod("POST");
		httpsUrlCon.setRequestProperty("Content-Type", "application/json");
		httpsUrlCon.setRequestProperty("Authorization", "OAuth "+sAccessToken);
		httpsUrlCon.setRequestProperty("Username",GenericLib.getConfigValue(GenericLib.sConfigFile, "ADMIN_USN") );
		httpsUrlCon.setRequestProperty("Password", GenericLib.getConfigValue(GenericLib.sConfigFile, "ADMIN_PWD") );

		System.out.println("httpsUrlCon = "+httpsUrlCon);
		OutputStream os = httpsUrlCon.getOutputStream();
		os.write(sJsonData.getBytes());
		os.flush();

		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(httpsUrlCon.getInputStream()));
			while ((line =bufferedReader.readLine())!=null){
				stringBuilder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws IOException 
	{
		RestLib restLib = new RestLib();
		restLib.getOauthAccessToken();
		//String sWOJson = "{\"SVMXC__Order_Status__c\":\"Open\",\"SVMXC__Billing_Type__c\":\"Contract\",\"SVMXC__City__c\":\"Delhi\",\"SVMXC__Zip__c\":\"110003\",\"SVMXC__Country__c\":\"India\",\"SVMXC__State__c\":\"Haryana\"}";
		//String recordID=restLib.getObjectRecordID("SVMXC__Service_Order__c?", sWOJson);
		restLib.getObjectValue("SVMXC__Service_Order__c", "Name");
	//	System.out.println(restLib.getObjectName("SVMXC__Service_Order__c", recordID));
	}

}
