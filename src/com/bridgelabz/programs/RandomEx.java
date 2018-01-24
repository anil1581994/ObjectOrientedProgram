package com.bridgelabz.programs;

import java.util.Random;
import java.util.Scanner;

public class RandomEx {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	Random r = new Random();
	System.out.println("enter range how many number you want to genrate");
	int n=scanner.nextInt();
	int a[]=new int [n];
	for(int i=0;i<=n-1;i++)
	{
		a[i]=r.nextInt();
	}
	for(int l:a)
	{
	System.out.println(l);
	}
}
}
//Random r = new Random();
//for(int i=0;i<10;i++){
//System.out.println(r.nextInt()); 