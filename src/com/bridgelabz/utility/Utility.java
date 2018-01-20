package com.bridgelabz.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class Utility {

	static Scanner scanner;
	JSONArray jsonArray = new JSONArray();
	JSONObject jsonObject = new JSONObject();

	public Utility() {
		scanner = new Scanner(System.in);
	}

	public static String getString() {
		return scanner.nextLine();
	}

	public static int getInteger() {
		return scanner.nextInt();
	}

	public double getDouble() {
		return scanner.nextDouble();
	}

	public boolean getBoolean() {
		return scanner.nextBoolean();
	}

	public float getFloat() {
		return scanner.nextFloat();

	}

	// add person
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static void addPerson(File file) {

		FileWriter fileWriter = null;

		scanner = new Scanner(System.in);
		try {
			System.out.println("Enter Your First Name: ");
			String userFirstName = getString();

			System.out.println("Enter your Last Name: ");
			String userLastName = getString();

			System.out.println("Enter your Address: ");
			String userAddress = getString();

			System.out.println("Enter your City: ");
			String userCity = getString();

			System.out.println("Enter your State: ");
			String userState = getString();

			System.out.println("Enter your ZIP: ");
			int userZIP = getInteger();

			System.out.println("Enter your Mobile No: ");

			long userMobileNumber = scanner.nextLong();
			FileReader fileReader = new FileReader(file);
			JSONParser parser = new JSONParser();
			Object jsonArray = parser.parse(fileReader);
			// JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("FirstName", userFirstName);
			jsonObject.put("LastName", userLastName);
			jsonObject.put("Address", userAddress);
			jsonObject.put("City", userCity);
			jsonObject.put("State", userState);
			jsonObject.put("Zip", userZIP);
			jsonObject.put("MobileNumber", userMobileNumber);
			((java.util.ArrayList) jsonArray).add(jsonObject);
			try {
				fileWriter = new FileWriter(file);
				fileWriter.write(JSONValue.toJSONString(jsonArray));
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// edit person
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void editPerson(File file) throws FileNotFoundException {
		FileReader fileReader = null;
		@SuppressWarnings("unused")
		FileWriter fileWriter = null;
		System.out.println("Enter what you want edit");
		try {
			System.out.println("enter name whoose updation you want");
			String userEntry = getString();
			fileReader = new FileReader(file);//
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(fileReader);
			@SuppressWarnings("rawtypes")
			Iterator iterator = jsonArray.iterator();
			boolean isExit = false;
			while (iterator.hasNext()) {
				JSONObject jsonObject = (JSONObject) iterator.next();
				if (jsonObject.get("FirstName").equals(userEntry)) {
					System.out.println(
							"select option what you want to edit:\n 1.address \n 2.city \n 3.state \n 4.zip \n 5.mobileNumber \n 6.editAll");
					int choice = getInteger();
					switch (choice) {
					case 1:
						System.out.println("enter address to update");
						String userAddress = getString();
						jsonObject.put("Address", userAddress);
						break;
					case 2:
						System.out.println("enter city to update");
						String userCity = getString();
						jsonObject.put("City", userCity);
						break;
					case 3:
						System.out.println("enter state to update");
						String userState = getString();
						jsonObject.put("State", userState);
						break;
					case 4:
						System.out.println("enter zip code to update");
						int userZip = getInteger();
						jsonObject.put("Zip", userZip);
						break;
					case 5:
						System.out.println("enter a mobile Number");
						String userMobileNumber = getString();
						jsonObject.put("MobileNumber", userMobileNumber);
						break;
					case 6:
						System.out.println("enter all details once");
						System.out.println("enter user1 address");
						String userAddress1 = getString();
						System.out.println("enter user1 city");
						String userCity1 = getString();
						System.out.println("enter user1 state");
						String userState1 = getString();
						System.out.println("enetr user zip1");
						int userZip1 = getInteger();
						System.out.println("enter mobile number1");
						String mobileNumber1 = getString();
						jsonObject.put("Address", userAddress1);
						jsonObject.put("City", userCity1);
						jsonObject.put("State", userState1);
						jsonObject.put("Zip", userZip1);
						jsonObject.put("MobileNumber", mobileNumber1);
						break;
					default:
						System.out.println("wrong choice please can u enter valid choice");

					}// switch
						((java.util.ArrayList) jsonArray).add(jsonObject);

					FileWriter filewriter = new FileWriter(file);
					filewriter.write(JSONValue.toJSONString(jsonArray));
					filewriter.flush();
					filewriter.close();

					System.out.println("Person details has been updated");
					isExit = true;
					break;
				} // if

			} // while
			if (isExit == false) {
				System.out.println("person not found in address book");
			}
		} catch (Exception fe)// trys
		{
			System.out.println("file not found exception");

		}

	}// m()

	// delete
	/*
	 * @param file method delete the person
	 */
	@SuppressWarnings("resource")
	public static void deletePerson(File file) {
		Scanner scanner = null;
		FileWriter fileWriter = null;
		FileReader fileReader = null;

		scanner = new Scanner(System.in);
		System.out.println("Enter name you want delete: ");
		try {
			String userEntry = getString();
			fileReader = new FileReader(file);
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(fileReader);
			Iterator iterator = jsonArray.iterator();
			boolean isExist = false;
			while (iterator.hasNext()) {

				JSONObject jsonObject = (JSONObject) iterator.next();

				if (jsonObject.get("FirstName").equals(userEntry)) {

					jsonArray.remove(jsonObject);

					System.out.println("Deleted successfully: ");
					isExist = true;
					break;
				}

			}

			fileWriter = new FileWriter(file);
			fileWriter.write(JSONValue.toJSONString(jsonArray));
			fileWriter.flush();
			fileWriter.close();
			if (isExist == false) {
				System.out.println("User does not exist: ");
			}
		} catch (IOException | org.json.simple.parser.ParseException e) {

			e.printStackTrace();
		}

	}

	//
	@SuppressWarnings("unchecked")
	public static void sortDetails(File file) 
	{

		class SortDetails implements Comparator<Object> {
			String string = null;

			public SortDetails(String string) {
				this.string = string;
			}

			@Override
			public int compare(Object o1, Object o2) {
				JSONObject json1 = (JSONObject) o1;
				JSONObject json2 = (JSONObject) o2;

				return (json1.get(string).toString()).compareTo(json2.get(string).toString());
			}

		}

		FileReader fileReader = null;
		Scanner scanner = new Scanner(System.in);

		try {
			fileReader = new FileReader(file);
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(fileReader);

			boolean check = true;
			do {
				System.out.println(
						"Sort according to \n 1.First Name \n 2.Last Name \n 3. Address \n 4.City \n 5.State \n 6.Zip \n 7.Mobile Number  ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Sorting according to First Names: ");

					Collections.sort(jsonArray, new SortDetails("FirstName"));

					@SuppressWarnings("rawtypes")
					Iterator nameIterator = jsonArray.iterator();

					while (nameIterator.hasNext()) {
						JSONObject json = (JSONObject) nameIterator.next();
						System.out.println(json.get("FirstName") + "  " + json.get("LastName") + " "
								+ json.get("Address") + " " + json.get("City") + " " + " " + json.get("State") + " "
								+ json.get("Zip") + " " + json.get("MobileNumber"));
					}
					break;

				case 2: // Last Name sorting
					System.out.println("Sorting according to Last Names: ");

					Collections.sort(jsonArray, new SortDetails("LastName"));

					@SuppressWarnings("rawtypes")
					Iterator lastNameIterator = jsonArray.iterator();

					while (lastNameIterator.hasNext()) {

						JSONObject json = (JSONObject) lastNameIterator.next();
						System.out.println(json.get("FirstName") + "  " + json.get("LastName") + " "
								+ json.get("Address") + " " + json.get("City") + " " + " " + json.get("State") + " "
								+ json.get("Zip") + " " + json.get("MobileNumber"));
					}
					break;
				case 3: // Address sorting
					System.out.println("Sorting according to Address : ");
					Collections.sort(jsonArray, new SortDetails("Address"));
					Iterator addressIterator = jsonArray.iterator();
					while (addressIterator.hasNext()) {
						JSONObject json = (JSONObject) addressIterator.next();
						System.out.println(json.get("FirstName") + "  " + json.get("LastName") + " "
								+ json.get("Address") + " " + json.get("City") + " " + " " + json.get("State") + " "
								+ json.get("Zip") + " " + json.get("MobileNumber"));
					}
					break;

				case 4: // City sorting
					System.out.println("Sorting according to City : ");

					Collections.sort(jsonArray, new SortDetails("City"));

					Iterator cityIterator = jsonArray.iterator();
					while (cityIterator.hasNext()) {
						JSONObject json = (JSONObject) cityIterator.next();
						System.out.println(json.get("FirstName") + "  " + json.get("LastName") + " "
								+ json.get("Address") + " " + json.get("City") + " " + " " + json.get("State") + " "
								+ json.get("Zip") + " " + json.get("MobileNumber"));
					}
					break;

				case 5: // State Sorting
					System.out.println("Sorting according to State : ");

					Collections.sort(jsonArray, new SortDetails("State"));

					Iterator stateIterator = jsonArray.iterator();
					while (stateIterator.hasNext()) {
						JSONObject json = (JSONObject) stateIterator.next();
						System.out.println(json.get("FirstName") + "  " + json.get("LastName") + " "
								+ json.get("Address") + " " + json.get("City") + " " + " " + json.get("State") + " "
								+ json.get("Zip") + " " + json.get("MobileNumber"));
					}
					break;
				case 6: // Zip sorting
					System.out.println("Sorting according to Zip : ");

					Collections.sort(jsonArray, new SortDetails("Zip"));

					Iterator zipIterator = jsonArray.iterator();
					while (zipIterator.hasNext()) {
						JSONObject json = (JSONObject) zipIterator.next();
						System.out.println(json.get("FirstName") + "  " + json.get("LastName") + " "
								+ json.get("Address") + " " + json.get("City") + " " + " " + json.get("State") + " "
								+ json.get("Zip") + " " + json.get("MobileNumber"));
					}
					break;
				case 7: // Mobile number sorting
					System.out.println("Sorting according to Mobile number : ");

					Collections.sort(jsonArray, new SortDetails("MobileNumber"));

					Iterator mobileNumberIterator = jsonArray.iterator();
					while (mobileNumberIterator.hasNext()) {
						JSONObject json = (JSONObject) mobileNumberIterator.next();
						System.out.println(json.get("FirstName") + "  " + json.get("LastName") + " "
								+ json.get("Address") + " " + json.get("City") + " " + " " + json.get("State") + " "
								+ json.get("Zip") + " " + json.get("MobileNumber"));
					}

					break;
				default:
					System.out.println("Wrong Choice :");

				}
				System.out.println("you want try again press\"Y\" else press \"N\" ");
				String ch = scanner.next().toLowerCase();
				if (ch.equals("y")) {
					check = true;
				} else {
					check = false;
				}
			} while (check);

		} catch (IOException | org.json.simple.parser.ParseException e) {

			e.printStackTrace();
		}
	}

	/*
	 * @param file method to find the person
	 */
	public static void personDetails(File file) {

		FileReader fileReader = null;
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter a name want to search : ");
			String userName = scanner.nextLine();

			fileReader = new FileReader(file);
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(fileReader);
			Iterator iterator = jsonArray.iterator();

			while (iterator.hasNext()) {

				JSONObject jsonObject = (JSONObject) iterator.next();
				if (jsonObject.get("FirstName").equals(userName)) {

					Iterator iterator1 = jsonObject.keySet().iterator();
					while (iterator1.hasNext()) {

						String jsonKey = (String) iterator1.next();

						System.out.println(jsonKey + " :" + jsonObject.get(jsonKey));
					}
				}
			}
		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @param full_name
	 */
	@SuppressWarnings("unchecked")
	public static void inventoryManager() throws Exception {
		JSONObject jsonObj_rice = new JSONObject();
		jsonObj_rice.put("item_Name", "Rice");
		jsonObj_rice.put("wieght", 20);
		jsonObj_rice.put("item_price", 49);

		JSONObject jsonObj_Pulses = new JSONObject();
		jsonObj_Pulses.put("item_Name", "Pulses");
		jsonObj_Pulses.put("wieght", 30);
		jsonObj_Pulses.put("item_price", 55);

		JSONObject jsonObj_Wheat = new JSONObject();
		jsonObj_Wheat.put("item_Name", "Wheat");
		jsonObj_Wheat.put("wieght", 60);
		jsonObj_Wheat.put("item_price", 55);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObj_rice);
		jsonArray.add(jsonObj_Pulses);
		jsonArray.add(jsonObj_Wheat);

		FileWriter fileWriter = new FileWriter(
				"/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedPgm/src/files/write.json");
		fileWriter.write(jsonArray.toJSONString());
		fileWriter.close();

		// FileReader reader = new
		// FileReader("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedPgm/src/files/info.json");
		JSONParser jsonParser = new JSONParser();

		try {

			Object obj = jsonParser.parse(
					new FileReader("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedPgm/src/files/info.json"));

			JSONObject jsonObject = (JSONObject) obj;
			// System.out.println(jsonObject);

			// Reading the String
			@SuppressWarnings("unused")
			String item_Name = null;
			double amount = 0.0, totalAmount = 0.0;
			// int price_per_kg = 0;

			JSONArray Itemlist = (JSONArray) jsonObject.get("Itemlist");
			// Printing all the values
			Iterator<?> iterator = Itemlist.iterator();

			while (iterator.hasNext()) {
				JSONObject jSonObject = (JSONObject) iterator.next();

				String weight = jSonObject.get("weight").toString();
				double weight1 = Double.parseDouble(weight);
				System.out.println("itemName : " + jSonObject.get("item_Name") + " " + weight1 + "kg");

				// System.out.println(weight1);
				String price = jSonObject.get("price").toString();
				double price1 = Double.parseDouble(price);
				amount = weight1 * price1;
				totalAmount = amount + totalAmount;
				// System.out.println("Total Inventary cost......." +weight1*price1);
			}
			System.out.println("Total Inventary cost calculated by inventory manager......." + totalAmount);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * @param fullName
	 * 
	 * @param mobile_number
	 * 
	 * @return Regular Expression to replace proper user name details,mobile number
	 * and current date.s
	 */
	static String regx_Name = "<<name>>";
	static String regx_FullName = "<<full name>> ";
	static String regx_MobileNumber = "xxxxxxxxxx";
	static String regx_DateVal = "01/01/2016";

	public static String regExpression(String fullName, String mobile_number, String message) {
		String[] userFullName = fullName.split(" ");
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);

		String currDate = date.toString();

		Pattern p1 = Pattern.compile(regx_Name);
		Matcher m1 = p1.matcher(message);
		message = m1.replaceAll(userFullName[0]);

		Pattern p2 = Pattern.compile(regx_FullName);
		Matcher m2 = p2.matcher(message);
		message = m2.replaceAll(fullName);

		Pattern p3 = Pattern.compile(regx_MobileNumber);
		Matcher m3 = p3.matcher(message);
		message = m3.replaceAll(mobile_number);

		Pattern p5 = Pattern.compile(regx_DateVal);
		Matcher m4 = p5.matcher(message);
		message = m4.replaceAll(currDate);

		return message;

	}

	// sort 2D array

	public static <T extends Comparable> T[][] Sort(T[][] arr) {
		int i, j;
		for (i = 0; i < arr.length; i++) {
			for (j = 1; j < (arr.length) - i; j++) {
				if ((arr[j - 1]).length > 0)

				{
					T[] temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;

	}

}
