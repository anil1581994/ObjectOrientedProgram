package com.bridgelabz.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Utility {


	static Scanner scanner=new Scanner(System.in);
public static void inventoryManager() throws Exception 
{
	JSONObject jsonObj_rice=new JSONObject();
	jsonObj_rice.put("item_Name", "Rice");
	jsonObj_rice.put("wieght", 20);
	jsonObj_rice.put("item_price", 49);
	
	JSONObject jsonObj_Pulses=new JSONObject();
	jsonObj_Pulses.put("item_Name", "Pulses");
	jsonObj_Pulses.put("wieght", 30);
	jsonObj_Pulses.put("item_price", 55);
	
	JSONObject jsonObj_Wheat=new JSONObject();
	jsonObj_Wheat.put("item_Name", "Wheat");
	jsonObj_Wheat.put("wieght", 60);
	jsonObj_Wheat.put("item_price", 55);

	JSONArray jsonArray=new JSONArray();
	jsonArray.add(jsonObj_rice);
	jsonArray.add(jsonObj_Pulses);
	jsonArray.add(jsonObj_Wheat);
	
	FileWriter fileWriter=new FileWriter("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedPgm/src/files/write.json");
	fileWriter.write(jsonArray.toJSONString());
	fileWriter.close();
	
	//FileReader reader = new FileReader("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedPgm/src/files/info.json");
	JSONParser jsonParser = new JSONParser();
	

    try {

        Object obj = jsonParser.parse(new FileReader("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedPgm/src/files/info.json"));

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
       System.out.println("Total Inventary cost calculated by inventory manager......." +totalAmount);
       
    } 
    catch (FileNotFoundException e)
    {
        e.printStackTrace();
    } catch (IOException e1) 
    {
        e1.printStackTrace();
    }
}
/*
 * @param fullName
 * @param mobile_number
 * @return
 * Regular Expression to replace proper user name details,mobile number and current date.s
 */
static String regx_Name="<<name>>";
static String regx_FullName="<<full name>> ";
static String regx_MobileNumber="xxxxxxxxxx";
static String regx_DateVal="01/01/2016";

public static String regExpression(String fullName,String mobile_number,String message) {
	String[] userFullName=fullName.split(" ");
	long millis=System.currentTimeMillis();  
	Date date=new Date(millis);  
	
	String currDate=date.toString();
	
	Pattern p1= Pattern.compile(regx_Name);
	Matcher m1=p1.matcher(message);
	message = m1.replaceAll(userFullName[0]);
	
	Pattern p2 = Pattern.compile(regx_FullName);
	Matcher m2=p2.matcher(message);
	message = m2.replaceAll(fullName);
	
	Pattern p3 = Pattern.compile(regx_MobileNumber);
	Matcher m3=p3.matcher(message);
	message = m3.replaceAll(mobile_number);
	
	Pattern p5 = Pattern.compile(regx_DateVal);
	Matcher m4=p5.matcher(message);
	message = m4.replaceAll(currDate);
	
	return message;
	
}
//DeckofCard--9

/*
 * @param suits
 * @param cards
 * @return this method will return the Deck Of Cards as a String array.
 */
public String[] Deck(String[] suits, String[] ranks)
{
	String[] deck = new String[suits.length * ranks.length];
	
	for (int i = 0; i < ranks.length; i++) 
	{
		for (int j = 0; j < suits.length; j++) 
		{
			deck[suits.length*i + j] = ranks[i] + " of " + suits[j];
		}
	}

	// shuffle
	for (int i = 0; i < deck.length; i++) 
	{
		int r = i + (int) (Math.random() * (deck.length-i));
		String temp = deck[r];
		deck[r] = deck[i];
		deck[i] = temp;
	}
	return deck;
}

/*
 * @param deck
 * 
 * @description This method will distribute the deck of cards into four player.
 */
public void distribute(String[] deck)
{
	int indexOfDeck=0;
	String [][] deckOfcard=new String[4][9];
	for(int i=0; i<4; i++)
	{
		for(int j=0; j<9; j++)
		{
			deckOfcard[i][j]=deck[indexOfDeck];
			indexOfDeck++;
		}
	}
	for(int i=0; i<4; i++)
	{
		System.out.print("\nPlayer "+(i+1)+" : ");
		for(int j=0; j<9; j++)
		{
			System.out.print(deckOfcard[i][j]+", ");
		}
		System.out.print("\n---------------------");
	}
}
//sort 2D array

public static<T extends Comparable> T[][] Sort(T[][] arr) {
	 int i,j;
	 for(i=0;i<arr.length;i++) 
	 {
		 for(j=1;j<(arr.length)-i;j++)
		 {
			    if( (arr[j-1]).length > 0)

			    {
				 T[] temp=arr[j-1];
				 arr[j-1]=arr[j];
				 arr[j]=temp;
			 }
 }
	 }
return arr;

}
}
