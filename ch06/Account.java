package ch06;
//
public class Account {
	private String number;
	private String owner;
	private int balance;
	
	Account(String number, String owner, int money){
		this.number = number;
		this.owner = owner;
		this.balance = money;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}



