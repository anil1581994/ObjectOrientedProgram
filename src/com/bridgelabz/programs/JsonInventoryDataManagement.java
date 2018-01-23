package com.bridgelabz.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonInventoryDataManagement {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(
					new FileReader("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedProgram/src/files/info.json"));

			JSONObject jsonObject = (JSONObject) obj;
			// System.out.println(jsonObject);

			// Reading the String
			double amount = 0.0, totalAmount = 0.0;
			// int price_per_kg = 0;

			JSONArray Itemlist = (JSONArray) jsonObject.get("Itemlist");
			// Printing all the values
			Iterator<?> iterator = Itemlist.iterator();

			while (iterator.hasNext()) {
				JSONObject jSonObject = (JSONObject) iterator.next();

				double weight = Double.parseDouble(jSonObject.get("weight").toString());
				System.out.println("itemName : " + jSonObject.get("item_Name") + " " + weight + "kg");

				double price = Double.parseDouble(jSonObject.get("price").toString());

				amount = weight * price;
				totalAmount = amount + totalAmount;
			}
			System.out.println("Total Inventary cost......." + totalAmount);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
