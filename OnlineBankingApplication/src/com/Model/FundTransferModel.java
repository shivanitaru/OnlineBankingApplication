package com.Model;

import java.sql.Date;

public class FundTransferModel {

	public long remitterAccountNumber;
	public long beneficiaryAccountNumber;
	public String beneficiaryName;
	public String IFSCCode;
	public long amount;
	public Date dateOfTransaction;

	public long getRemitterAccountNumber() {
		return remitterAccountNumber;
	}

	public void setRemitterAccountNumber(long remitterAccountNumber) {
		this.remitterAccountNumber = remitterAccountNumber;
	}

	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

}
