package Model;

import PaymentSystem.PaymentAuthorization;
import PaymentSystem.Receipt;
import inspectionPointManagement.inspectionPoint;



public class Inspection {

	private Vehicle vehicle;
	private Receipt receipt;

	/**
	 * Creates an new instance of an inspection
	 * @param regNumber, the regNumber of the vehicle being inspected
	 */
	public Inspection(String regNumber) {
		if (regNumber.length() != 6) {
			throw new IllegalArgumentException("Invalid regNumber for vehicle");
		}
		vehicle = new Vehicle(regNumber);
	}

	/**
	 * Sets the result of an specified inspection point
	 * @param num the index of the inspection point
	 * @param result the result of the inspection point
	 */
	public void setInspectionResult(int num, boolean result) {
		vehicle.setInspectionPointResult(num, result);
	}

	/**
	 * Retrieves the next inspection point
	 * @return returns the next inspection point
	 */
	public inspectionPoint getNextInspectionPoint() {
		return vehicle.getNextInspectionPoint();
	}
	
	/**
	 * Retrieves the cost of the inspection
	 * @return the cost of the inspection
	 */
	public int getCost() {
		return vehicle.getTotalCost();
	}

	/**
	 * Creates an new instance of the <code>PaymentAuthorization</code> class and uses it to process the payment
	 * @param cardNum The number of the card used for the payment, set to null if payment is done by cash
	 */
	public void makePayment(String cardNum) {
		PaymentAuthorization PA = new PaymentAuthorization();
		boolean payComplete = PA.makePayment(cardNum, vehicle.getTotalCost());
		if(payComplete) {
			System.out.println("Payment was successfull");
			this.receipt = new Receipt(vehicle.getRegNumber(), vehicle.getTotalCost());
			System.out.println("Printing receipt...");
			this.receipt.printReceipt();
		}
	}
	
	/**
	 * Updates the database with the current inspection point list
	 */
	public void updateDatabase() {
		vehicle.updateDatabase();
	}
	
	/**
	 * Resets the iterator for the inspectionPoints contained in the list for the vehicle class
	 */
	public void resetInspectionPointIterator() {
		vehicle.resetListIterator();
	}
}
