package com.bridgelabz.programs;

import java.util.Date;

public class CompanyShare {
	String Symbol;

	public CompanyShare(String symbol, int numberOfShare, Date transactionDate) 
	{
	
		this.Symbol = symbol;
		this.numberOfShare = numberOfShare;
		this.transactionDate = transactionDate;
	}

	int numberOfShare;

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public int getNumberOfShare() {
		return numberOfShare;
	}

	public void setNumberOfShare(int numberOfShare) {
		this.numberOfShare = numberOfShare;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	Date transactionDate;
	// object this class should contain 3 details
	
}
