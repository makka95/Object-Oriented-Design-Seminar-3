package GarageManagement;

public class GarageDoors {

	private boolean open;
	
	public GarageDoors () {
		this.open = false;
	}

	/**
	 *  Opens the garage door by setting the variable <code>open</code> to TRUE
	 */
	public void openGarageDoors() {
		this.open = true;
	}

	/**
	 *  Closes the garage door by setting the variable <code>open</code> to FALSE
	 */
	public void closeGarageDoors() {
		this.open = true;
	}

}
