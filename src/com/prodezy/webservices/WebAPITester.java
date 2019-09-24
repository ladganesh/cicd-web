package com.prodezy.webservices;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebAPITester {

	private static URL myUrl = null;
    private static HttpURLConnection connection = null;
    private static final String REQUEST_METHOD = "POST";
    private static final int READ_TIMEOUT = 60000;
    private static final int CONNECTION_TIMEOUT = 60000;

    private static String result;
    private static String inputLine;

    public static String header = "eyJpdiI6IlFZdGxQV2xtOTdQZTE2YlJnQ3dNcGc9PSIsInZhbHVlIjoiU3c3czNYNDNiNzJZRmF0SE5ldG9NcTkwVTcxY1loZ1RnYytvZ2hYaTFjNFRBNFROZEpCZHM5VVRrbW9helJcL2ppUkRjN29wcDc5TkxyQnZKczNYK2orSkp0VHRzNEJ1QVFoaFpmb3QzOGlkdjdEYlNGcXhFaUl3Y3dlQ3lWOFdQazRLaWlkT0hEdnpFYTFYU01zZDJOaGFPWmVUd1Q4OHVDTTJSaVlKdmFZWG9URGRmemtCaE04ZVhxalhkNXdMd2dsWm1hMmdRVGwwSHR4K2liRkpITUhDT2w0Y3VHYzRwa2hUQXZqSmxPdm9nOGNpcjJOV1lDaUs0VzdRUU5vYjAiLCJtYWMiOiI5YzJhNmY4ODA3OWI3NjQ5N2YyZmRlM2U5MmJmM2Q1MDk2Y2U2MGZmMzMyM2QwMDg4MTU1YzQwNTA3NzY5MGUwIn0=";
    
    public static String apiNameANDparameters = "";
    
    public static byte[] body = null;

public static String prepareWebCall ( String api) {
   // URL myUrl=null;
   // HttpURLConnection connection = null;
   // final String REQUEST_METHOD = "POST";
   // final int READ_TIMEOUT = 60000;
    //final int CONNECTION_TIMEOUT = 60000;
   // String inputLine;
    //String result;
    //String header="eyJpdiI6Ik12OEJWT05uS2J6N0VVSUtMUUdQOUE9PSIsInZhbHVlIjoibnBvOHcwRzBJazdwRm5YVldLMHZHK2tvWWhrNVRtUE43TysyeTIrUm55MUozWCsyR3RGY1wvemIwbTRIQUpxaVwvRyt3XC9vZzN4ajJ3N21ibHFmeVJzM3ZlOHZLVkh2cmRrMlJvSUpKZ0VVaHcxRStmSytlYnlRa2dpMHBZXC83ZlQxc1JKRWMwZnZMWWE0XC9keVRVdW1wNXBIbEN5YnFpZlhEbWpoYlo0dzRwT2VSU1FnYkxYZ0N2UVZIZXd1SGR2dUtkZkd3VWx5VTk2Z01GcFwvNEdWcDh0emdBdnRcLytWK0syblwvUFpSZ2k5emJxSXRUZ3N6ZGN1aXFpdGN0ZGF0MWhpIiwibWFjIjoiMTQxMTM4MTc5MmRiZjgzNzgwYWExNDU4ZjQ1MjZjNWM1NjA1MzQ3YWVlZjMxYmM0YzE3ZGQyNDRkZmMxNDM2NiJ9";
    
  String url = "http://192.168.0.125:8081/projects/erp/public/"+api;
//    System.err.println(apiNameANDparameters);
//    System.err.println(url);
   try {
       myUrl = new URL ( url );
   } catch ( MalformedURLException e1 ) {
       System.out.println ( ""+e1.getMessage () );
   }

   try {
       connection = ( HttpURLConnection ) myUrl.openConnection();
       connection.setRequestMethod ( REQUEST_METHOD );
       connection.setReadTimeout ( READ_TIMEOUT );
       connection.setConnectTimeout ( CONNECTION_TIMEOUT );
       connection.setDoInput ( true );
       connection.setDoOutput ( true );
       connection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
       
       if( !api.contains ("auth/login" )){
            connection.addRequestProperty ( "Authorization" , "encoded " +header  ); 
       }
       connection.connect ();
       
       DataOutputStream request = new DataOutputStream ( connection.getOutputStream () );
     
       
       request.flush ();
       request.close ();
       connection.connect ();

       InputStreamReader streamReader = new InputStreamReader ( connection.getInputStream () );

       BufferedReader reader = new BufferedReader ( streamReader );
       StringBuilder stringBuilder = new StringBuilder ();

       while ( ( inputLine = reader.readLine () ) != null ) {
           stringBuilder.append ( inputLine );
       }

       reader.close ();
       streamReader.close ();

       result = stringBuilder.toString ();
       return result;

   } catch ( IOException e2 ) {
       return e2.getMessage ();
   }

}
}

