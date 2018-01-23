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
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(
					"/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedProgram/src/files/Stock_details.json"));

			JSONArray arry = (JSONArray) obj;
			System.out.println(arry.size());

			// Reading the String
			//String stockName = null;
			double amount = 0.0, totalStockValue = 0.0;

			//JSONArray jsonArray = (JSONObject) jsonObject.get("stockDetails");
			// Printing all the values
			Iterator<?> iterator = arry.iterator();
			String stockName ="";
			while (iterator.hasNext()) {
				JSONObject jSonObject = (JSONObject) iterator.next();
				stockName = jSonObject.get("stockName").toString();
				double stockPrice = Double.parseDouble(jSonObject.get("amount").toString());

				int NumberOfShare = Integer.parseInt(jSonObject.get("number_of_Share").toString());
				amount = stockPrice * NumberOfShare;
				totalStockValue = amount + totalStockValue;
			}

			System.out.println("the stokReport of:" +stockName +"Total value :"+totalStockValue);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
