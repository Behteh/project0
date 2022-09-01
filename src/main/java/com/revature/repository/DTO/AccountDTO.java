package com.revature.repository.DTO;

import java.util.Objects;

public class AccountDTO {
	
	protected Integer account_id;
	protected Integer accountnumber;
	protected Integer accountbalance;
	
	public AccountDTO(Integer account_id, Integer accountnumber, Integer accountbalance) {
		
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public Integer getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Integer accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Integer getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(Integer accountbalance) {
		this.accountbalance = accountbalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account_id, accountbalance, accountnumber);
	}

	@Override
	public String toString() {
		return "AccountInfoDTO [account_id=" + account_id + ", accountnumber=" + accountnumber + ", accountbalance="
				+ accountbalance + "]";
	}

}

