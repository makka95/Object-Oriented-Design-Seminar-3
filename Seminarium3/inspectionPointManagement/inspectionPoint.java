package inspectionPointManagement;

public class inspectionPoint {

	private int cost;
	private Boolean result;
	private int num;
	private String descr;

	/**
	 * Creates an new instance of an inspectionPoint
	 * @param num the number of the inspection point
	 * @param regNumber the registration number of the vehicle which the description point belongs to
	 * @param descr The description of the inspection point
	 */
	public inspectionPoint(int num, String regNumber, String descr) {
		if (regNumber == null) {
			throw new NullPointerException("Invalid value for registration number.");
		}
		if(descr == null) {
			throw new NullPointerException("Invalid value for description.");
		}
		if (regNumber.length() != 6) {
			throw new IllegalArgumentException("The given registration number has an invalid length");
		}
		if(num < 0) {
			throw new IllegalArgumentException("Cannot have negative value on order number");
		}
		this.num = num;
		this.result = false;
		this.descr = descr;
		this.cost = 100 * num;
	}

	/**
	 * Returns the cost of the specified inspection point
	 * @return returns the cost of the inspection point
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Returns the description of the specified inspection point
	 * @return returns the description of the inspection point
	 */
	public String getDescr() {
		return this.descr;
	}

	/**
	 * Changes the result of an inspection point
	 * @param result the result to set the local variable to
	 */
	public void setResult(Boolean result) {
		this.result = result;
	}

}
