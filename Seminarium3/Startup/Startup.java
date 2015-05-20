package Startup;

import inspectionPointManagement.inspectionPoint;

import java.util.Scanner;

import Controller.Controller;

/**
 * Starts the program and runs an sample execution
 * @author Marcus
 *
 */
public class Startup {

	private Controller controller;

	/**
	 * Creates an new instance of the <code>View</code> class of the application
	 * @param control, passes through an referees to the control class created in the <code>startUp</code> class
	 */
	
	/**
	 * The main method for the program
	 * @param args - this program does not handle any parameters
	 */
	public Startup() {
		this.controller = new Controller();
		
		//Runs sampleExecution
		sampleExecution();
	}
	
	private void sampleExecution() {
		
		//Create input scanner
		Scanner in = new Scanner(System.in);
		boolean done = false;
		String regNumber = "";
		
		//Starts new inspection
		System.out.println("Enter a registration number for the vehicle: \n");
		while(!done) {
			try{
				regNumber = in.nextLine();
				controller.startNewInspection(regNumber);
				done = true;
			} catch(IllegalArgumentException exc) {
				System.out.println("Invalid registration number for the vehicle, try again: \n");
			}
		}
		System.out.println("Inspection Started! \n");
		
		//Updates Display and open garage doors
		controller.updateDisplay(regNumber);
		controller.openGarageDoors();
		
		//Customer enters garage, close garage doors
		controller.closeGarageDoors();
		
		//Get cost for inspection
		System.out.println("The cost of the inspection is: " + controller.getCost() + " kr \n");
		
		//Customer enters cardinformation
		System.out.println("Enter a valid cardnumber or leave it blank to pay by cash: \n");
		done = false;
		while(!done) {
			try{
				controller.makePayment(in.nextLine());
				done = true;
			} catch(IllegalArgumentException exc) {
				System.out.println("Invalid card number, try again: \n");
			}
		}
		
		//Perform inspection
		done = false;
		controller.resetInspectionPointIterator();
		while(!done) {
			
			//Gets next inspection point
			inspectionPoint point = controller.getNextInspectionPoint();
			if(point != null) {
				//Prints the description of the inspection point
				System.out.println(point.getDescr() + " : PASSED");
				//Sets the result of the inspection
				point.setResult(true);
			} else {
				//If there are no more inspection points, we are done
				done = true;
			}
		}
		
		//Store inspection result and prints them
		controller.updateDatabase();
		
		//Open garage doors for customer to leave
		controller.openGarageDoors();

	}

}
