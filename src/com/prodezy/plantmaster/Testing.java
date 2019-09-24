package com.prodezy.plantmaster;

import java.util.HashMap;

import com.prodezy.webservices.WebAPITester;

public class Testing {
	public Testing() {
	 String addEmpAPICall = "testing";
     String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
     System.out.println("testing webservice result ="+result2);
        	
        
	}
}
