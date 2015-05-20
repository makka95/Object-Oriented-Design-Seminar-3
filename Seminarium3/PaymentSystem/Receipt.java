package PaymentSystem;

public class Receipt {
	
	private int cost;
	private String regNumber;
	
	/**
	 * Creates a receipt to be printed for the customer
	 * @param regNumber The registration number of the vehicle
	 * @param cost The cost of the inspection
	 */
	public Receipt(String regNumber, int cost) {
		this.regNumber = regNumber;
		this.cost = cost;
	}
	
	public void printReceipt() {
		//Prints receipt if there was an printer connection...
	}
}
