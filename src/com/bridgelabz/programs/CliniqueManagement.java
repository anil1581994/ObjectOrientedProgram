package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class CliniqueManagement {

	@SuppressWarnings("static-access")
	public static void main(String[] args) 
	{
			Utility utility=new Utility();
			Scanner sc = new Scanner(System.in);
			System.out.println("-----------------------------------------");
			System.out.println("..........(+)Sanjeevni..Care(+)..........");
			System.out.println("------------------------------------------");
			while (true) {
			System.out.println("Enter 1 to Add Doctors");
			System.out.println("Enter 2 to Add Patients");
			System.out.println("Enter 3 to Search Doctor");
			System.out.println("Enter 4 to Search Patient");
			System.out.println("Enter 5 to Take an appoitment");
			int choice = sc.nextInt();
			switch (choice) 
			{
			case 1:
				utility.addDoctors();
			break;
			case 2:
				utility.addPatient();
			break;
			case 3:
				utility.searchDoctor();
			break;
			case 4:
				utility.searchPatient();
			break;
			case 5:
				utility.takeAnAppointment();
			break;
			default:
				System.out.println("plz Enter the valid choice");
			}
			}
			}
	}

