package com.bridgelabz.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class AddressBook {
	public static void main(String[] args)
			throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException {
		File file = new File("/home/bridgeit/Desktop/AnilWorkSpace/ObjectOrientedProgram/src/files/address.json");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		@SuppressWarnings("unused")
		Utility utility = new Utility();
		int ch = 0;
		do {
			System.out.println("********Address...Book*******");
			System.out.println("1.Add new pesron Details");
			System.out.println("2.edit the details");
			System.out.println("3.delete the person");
			System.out.println("4.sortDetails");
			System.out.println("5.personDetails");
			System.out.println("******************************");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("you are going add new person to Book");
				Utility.addPerson(file);
				break;
			case 2:
				System.out.println("  you are updating the details: ");
				Utility.editPerson(file);
				break;

			case 3:
				System.out.println(" you are deleting pesron details  from Book");
				Utility.deletePerson(file);
				break;
			case 4:
				System.out.println(" your sorting the person by there column name");
				Utility.sortDetails(file);
				break;
			case 5:
				System.out.println("you want to get detail information of person");
				Utility.personDetails(file);
				break;
			   
			 default:

				System.out.println("if you want add more  person then again select the option");
				choice = scanner.nextInt();
				// System.out.println("if you want add more person then again select the
				// option");
			}

		} while (ch < 6);

	}
}
