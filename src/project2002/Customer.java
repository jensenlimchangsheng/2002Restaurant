package project2002;

public class Customer {
	private String name;
	private int number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Customer(String customername, int number) {
		this.name=customername;
		this.number=number;
	}

}
