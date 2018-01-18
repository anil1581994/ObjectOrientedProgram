package com.bridgelabz.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockReport {
public static void main(String[] args) throws ParseException {
	JSONParser parser=new JSONParser();

    try {

        Object obj = parser.parse(new FileReader("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedPgm/src/files/stockDetails.json"));

        JSONObject jsonObject = (JSONObject) obj;
       // System.out.println(jsonObjSystem.out.println("Total Inventary cost......." +totalAmount)ect);

        //Reading the String
        String stockName= null ;
        double amount=0.0 ,totalStockValue=0.0;
       // int price_per_kg = 0;
      
       JSONArray jsonArray = (JSONArray)jsonObject.get("stockDetails");
     //Printing all the values
       Iterator<?> iterator =jsonArray.iterator();
       
       while (iterator.hasNext()) 
       {
    	   JSONObject jSonObject=(JSONObject) iterator.next();
    	   String stockName1 = jSonObject.get("stockName").toString();
    	   String stockPrice= jSonObject.get("stockPrice").toString();
    	   double stockPrice1 =Double.parseDouble(stockPrice);
    	  
    	   String NumberOfShare= jSonObject.get("NumberOfShare").toString();
    	   double NumberOfShare1=Double.parseDouble(NumberOfShare);
    	   amount=stockPrice1*NumberOfShare1;
    	   totalStockValue=amount+totalStockValue;
    	
	  }
       
    	System.out.println("the stokReport:"+totalStockValue);
     
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e1) 
    {
        e1.printStackTrace();
    }

}
}

