package com.bridgelabz.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonInventoryDataManagement {

	public static void main(String[] args) throws ParseException, org.json.simple.parser.ParseException {
		 JSONParser parser = new JSONParser();

		    try {

		        Object obj = parser.parse(new FileReader("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedPgm/src/files/info.json"));

		        JSONObject jsonObject = (JSONObject) obj;
		       // System.out.println(jsonObject);

		        //Reading the String
		        String item_Name = null ;
		        double amount=0.0 ,totalAmount=0.0;
		       // int price_per_kg = 0;
		      
		       JSONArray Itemlist = (JSONArray)jsonObject.get("Itemlist");
		     //Printing all the values
		       Iterator<?> iterator = Itemlist.iterator();
		       
		       while (iterator.hasNext()) 
		       {
		    	   JSONObject jSonObject=(JSONObject) iterator.next();
		    	   
		    	   String weight= jSonObject.get("weight").toString();
		    	   double weight1 =Double.parseDouble(weight);
		    	   System.out.println("itemName : "+jSonObject.get("item_Name")+" "+weight1+"kg");
		    	   
		    	  // System.out.println(weight1);
		    	   String price= jSonObject.get("price").toString();
		    	   double price1=Double.parseDouble(price);
		    	   amount=weight1*price1;
		    	     totalAmount=amount+totalAmount;
				 //  System.out.println("Total Inventary cost......." +weight1*price1);
			}
		       System.out.println("Total Inventary cost......." +totalAmount);
		    	
		     
		    } 
		    catch (FileNotFoundException e)
		    {
		        e.printStackTrace();
		    } catch (IOException e1) 
		    {
		        e1.printStackTrace();
		    }

		}
}
