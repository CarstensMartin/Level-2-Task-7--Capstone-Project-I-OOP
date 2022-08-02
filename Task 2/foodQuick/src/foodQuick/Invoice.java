package foodQuick;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Invoice {

	public static void main(String[] args) {

		//Declare file paths and initialize the arrays.
	
		// File path and create an array for Customer details
		String customerTextFile = "customers.txt";
		String customerWritingFileLocation = "customers";
		Customer[] customers = ObjectCreationCustomer(customerTextFile);

		// File path and create an array for Driver details
		String driverTextFile = "drivers.txt";
		String driverWritingFileLocation = "drivers";
		Driver[] drivers = ObjectCreationDriver(driverTextFile);

		// File path and create an array for Restaurant Order details
		String restaurantsTextFile = "restaurantOrders.txt";
		String restaurantWritingFileLocation = "restaurantOrders";
		Restaurant[] restaurants = ObjectCreationRestaurant(restaurantsTextFile);

		// File path where invoices are to be created
		String invoiceWritingFileLocation = "invoices/invoice";

		
		
		// ADD NEW ORDER PROMPTS:

		//Ask the user if the want to add a new order
		//Give user an option of "Yes" or "No"
		String[] optionsToCreateNewOrder = { "Yes", "No" };
		//Declare the quick food icon - (icon was down loaded from google)
		ImageIcon icon = new ImageIcon("src/images/imageQuickFood.png");
		//Prompt box and "Yes" - 0 is pre-selected
		String addNewOrder = (String) JOptionPane.showInputDialog(null, "Would you like to add a new Order?",
				"QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, optionsToCreateNewOrder,
				optionsToCreateNewOrder[0]);

		//Run a WHILE LOOP - to get the order information. Keep running the loop until the user have captured all of the orders
		while (addNewOrder.equals("Yes")) {

			// Generate a new order number that is 1 higher than the previous highest order number
			int newOrderNumber = 0;
			for (int i = 0; i < restaurants.length; i++) {
				if (customers[i].orderNumber > newOrderNumber) {
					newOrderNumber = restaurants[i].orderNumber;
				}
			}
			newOrderNumber++;

			// Prompt - Customer Name to add
			String addCustomerName = (String) JOptionPane.showInputDialog(null, "Name and Surname?",
					"QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, null, "Name Surname");

			// Prompt - Customer Contact Number add
			String addCustomerContactNumber = (String) JOptionPane.showInputDialog(null,
					"Please supply a contact number?", "QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon,
					null, "+27 ");

			// Prompt - Customer Street address add
			String addStreetAddressOfCustomer = (String) JOptionPane.showInputDialog(null,
					"Address: \nDelivery house number and Street name?", "QUICK FOOD DELIVERIES",
					JOptionPane.QUESTION_MESSAGE, icon, null, "House number - Street name");

			// Prompt - Customer Suburb address add
			String addSuburbAddressOfCustomer = (String) JOptionPane.showInputDialog(null,
					"Address: \nDelivery suburb?", "QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, null,
					null);

			// Customer City add - 
			// Give a Drop-down option to eliminate miss spelling. Give option "Other" if option not found
			//Also use this city option for food order option
			String[] createNewOrderCityOptios = { "Bloemfontein", "Cape Town", "Durban", "Johannesburg",
					"Port Elizabeth", "Potchefstroom", "Springbok", "Witbank", "Other" };
			String addCityCustomer = (String) JOptionPane.showInputDialog(null, "Which City do you stay?",
					"QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, createNewOrderCityOptios,
					createNewOrderCityOptios[0]);

			// If city is Other, Ask which other city and update addCityCustomer with city name
			if (addCityCustomer.equals("Other")) {
				// Customer City add
				addCityCustomer = (String) JOptionPane.showInputDialog(null, "Which Other city do you stay in?",
						"QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, null, null);
			}

			// Prompt - Customer email add
			String addEmailCustomer = (String) JOptionPane.showInputDialog(null, "What it your email address?",
					"QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, null, "example@gmail.com");

			// Prompt - Restaurant addRestaurantName
			// Give a Drop-down option to eliminate miss spelling. Give option "Other" if option not found
			String[] createNewOrderRestaurantNames = { "KFC", "MC Donalds", "Nandos", "Other" };
			String addRestaurantName = (String) JOptionPane.showInputDialog(null,
					"Which Restaurant do you want to order from?", "QUICK FOOD DELIVERIES",
					JOptionPane.QUESTION_MESSAGE, icon, createNewOrderRestaurantNames,
					createNewOrderRestaurantNames[0]);
			// If restaurant is Other, Ask which other restaurant and update
			if (addRestaurantName.equals("Other")) {
				// Prompt - Restaurant name added
				addRestaurantName = (String) JOptionPane.showInputDialog(null,
						"Type in a Restaurant name that you want to order from?", "QUICK FOOD DELIVERIES",
						JOptionPane.QUESTION_MESSAGE, icon, null, null);
			}

			// Prompt - Restaurant Special instruction add 
			// Give a Drop-down options for ease of use. Give option "Other" if option not found
			String[] createNewOrderSpecialInstruction = { "No Special Instructions", "No Tomato", "No Lettuce",
					"No Onions", "No Pickles", "No Mayo", "No Ketchup", "Other" };
			String addSpecialInstruction = (String) JOptionPane.showInputDialog(null,
					"Special instructions with this order?", "QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE,
					icon, createNewOrderSpecialInstruction, createNewOrderSpecialInstruction[0]);

			// If Special instruction is Other, Ask to describe
			if (addSpecialInstruction.equals("Other")) {
				// Customer City add
				addSpecialInstruction = (String) JOptionPane.showInputDialog(null,
						"Type in an Other Special Instruction?", "QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE,
						icon, null, null);
			}

			// Prompt - Restaurant Order item add 
			// Give a Drop-down options for ease of use.
			String[] createNewOrderItemsOnMenue = { "1 x Beef Burger Meal (R80.00)", "1 x Beef Burger Only (R60.00)",
					"1 x Chicken Burger Meal (R70.00)", "1 x Chicken Burger Only (R50.00)",
					"1 x Chicken Wrap (R80.00)" };
			String addOrderItem1 = (String) JOptionPane.showInputDialog(null, "Which Item would you like to order?",
					"QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, createNewOrderItemsOnMenue,
					createNewOrderItemsOnMenue[0]);

			// Prompt - Restaurant Order item add
			// Give a Drop-down options for ease of use.
			String[] createNewOrderItemsOnMenue2 = { "1 x Beef Burger Meal (R80.00)", "1 x Beef Burger Only (R60.00)",
					"1 x Chicken Burger Meal (R70.00)", "1 x Chicken Burger Only (R50.00)", "1 x Chicken Wrap (R80.00)",
					"No Thank you - only 1 item" };
			String addOrderItem2 = (String) JOptionPane.showInputDialog(null,
					"Second item that you would you like to order?", "QUICK FOOD DELIVERIES",
					JOptionPane.QUESTION_MESSAGE, icon, createNewOrderItemsOnMenue2, createNewOrderItemsOnMenue2[2]);
			

			//Based on the restaurant selected, give centralized contact number for Restaurant
			String addcontactNumberRestaurant;

			if (addRestaurantName.equals("KFC")) {
				addcontactNumberRestaurant = "+2786 0100 222";
			} else if (addRestaurantName.equals("MC Donalds")) {
				addcontactNumberRestaurant = "+2721 982 3391";
			} else if (addRestaurantName.equals("Nandos")) {
				addcontactNumberRestaurant = "+2786 011 3332";
			} 
			//If the user added a different restaurant - they must also add the contact number
			else {
				addcontactNumberRestaurant = (String) JOptionPane.showInputDialog(null,
						"Enter contact number of Restaurant?", "QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE,
						icon, null, "+27 ");
			}

			//Get the price of item 1 based on item selected
			double addItem1Price = 0;
			
			if (addOrderItem1.equals("1 x Beef Burger Meal (R80.00)")) {
				addItem1Price = 80.00;
			} else if (addOrderItem1.equals("1 x Beef Burger Only (R60.00)")) {
				addItem1Price = 60.00;
			} else if (addOrderItem1.equals("1 x Chicken Burger Meal (R70.00)")) {
				addItem1Price = 70.00;
			} else if (addOrderItem1.equals("1 x Chicken Burger Only (R50.00)")) {
				addItem1Price = 70.00;
			} else if (addOrderItem1.equals("1 x Chicken Wrap (R80.00)")) {
				addItem1Price = 80.00;
			}

			//Get the price of item 2 based on item selected
			double addItem2Price = 0;

			if (addOrderItem2.equals("1 x Beef Burger Meal (R80.00)")) {
				addItem2Price = 80.00;
			} else if (addOrderItem2.equals("1 x Beef Burger Only (R60.00)")) {
				addItem2Price = 60.00;
			} else if (addOrderItem2.equals("1 x Chicken Burger Meal (R70.00)")) {
				addItem2Price = 70.00;
			} else if (addOrderItem2.equals("1 x Chicken Burger Only (R50.00)")) {
				addItem2Price = 70.00;
			} else if (addOrderItem2.equals("1 x Chicken Wrap (R80.00)")) {
				addItem2Price = 80.00;
			} else if (addOrderItem2.equals("No Thank you - only 1 item")) {
				addItem2Price = 0.00;
			}
			
			//Total price of item 1 and 2 together
			double addtotalPriceOrderDouble = (addItem1Price + addItem2Price);
			//Convert total price to a string
			String addtotalPriceOrder = (addtotalPriceOrderDouble + "");

			// Declare a new Array with a size 1 bigger than the current restaurants array
			Restaurant[] restaurantsArrayNew = new Restaurant[(restaurants.length + 1)];
			// Declare a new object with the information gathered from the prompts
			Restaurant restaurantAddNew = new Restaurant(newOrderNumber, addRestaurantName, addCityCustomer,
					addcontactNumberRestaurant, addtotalPriceOrder, addSpecialInstruction, addOrderItem1,
					addOrderItem2);

			// Add the existing array data to the new array
			for (int x = 0; x < restaurants.length; x++) {
				restaurantsArrayNew[x] = restaurants[x];
			}

			// Add the new object to the array 
			// restaurants.length because index starts at 0 not 1
			restaurantsArrayNew[restaurants.length] = restaurantAddNew;

			//Replace the restaurants array with the new array
			restaurants = restaurantsArrayNew;

			// Declare a new Array with a size 1 bigger than the current customers array
			Customer[] customerArrayNew = new Customer[(customers.length + 1)];
			// Declare a new object with the information gathered from the prompts
			Customer customerAddNew = new Customer(newOrderNumber, addCustomerName, addCustomerContactNumber,
					addStreetAddressOfCustomer, addSuburbAddressOfCustomer, addCityCustomer, addEmailCustomer);

			// Add the existing array data to the new array
			for (int x = 0; x < customers.length; x++) {
				customerArrayNew[x] = customers[x];
			}

			// Add the new object to the array 
			// customers.length 1 less because index starts at 0 not 1
			customerArrayNew[customers.length] = customerAddNew;

			//Replace the customers array with the new array
			customers = customerArrayNew;

			// Ask if user want to add a new order? If yes - while loop runs again
			// Pre-populate the prompt with "No" - index 0
			addNewOrder = (String) JOptionPane.showInputDialog(null, "Would you like to add a new Order?",
					"QUICK FOOD DELIVERIES", JOptionPane.QUESTION_MESSAGE, icon, optionsToCreateNewOrder,
					optionsToCreateNewOrder[1]);
		}
		//***End of While loop***
		
		
		
		// Write The text files with the new Restaurant Order and Customer
		
		//Declare Strings for Text to be used in over writing the (customers) and (restaurantOrders) file 
		String outputMessageRestaurant = "";
		String outputMessageCustomer = "";
		String outputOrderNumber = "";
		String noErrorOutput = "";

		//Create the text for the restaurantOrders file
		for (int x = 0; x < restaurants.length; x++) {
			outputMessageRestaurant += restaurants[x].orderNumber + ", " + restaurants[x].restaurantName + ", "
					+ restaurants[x].cityRestaurant + ", " + restaurants[x].contactNumber + ", "
					+ restaurants[x].totalPrice + ", " + restaurants[x].specialInstruction + ", " + restaurants[x].item1
					+ ", " + restaurants[x].item2 + "\r\n";
		}
		
		//Over write the restaurantOrders text file using the FileCreatorMethod method
		FileCreatorMethod(restaurantWritingFileLocation, outputOrderNumber, outputMessageRestaurant, noErrorOutput);

		//Create the text for the customers file
		for (int x = 0; x < customers.length; x++) {
			outputMessageCustomer += customers[x].orderNumber + ", " + customers[x].customerName + ", "
					+ customers[x].contactNumber + ", " + customers[x].streetAddressOfCustomer + ", "
					+ customers[x].suburbAddressOfCustomer + ", " + customers[x].cityCustomer + ", "
					+ customers[x].emailCustomer + "\r\n";
		}

		//Over write the customers text file using the FileCreatorMethod method
		FileCreatorMethod(customerWritingFileLocation, outputOrderNumber, outputMessageCustomer, noErrorOutput);

		
		
		//PROCESS TO START CREATING THE INVOICES 
		
		// Create a for loop to run through every order in restaurantOrders
		for (int numberOfOrder = 0; numberOfOrder < restaurants.length; numberOfOrder++) {
			
			// Get the order number that is applicable to this order
			int orderNumber = restaurants[numberOfOrder].orderNumber;

			// Find the customer whose order it is by order number
			int customerObjectPosition = 0;
			// If customer is found - proceed with invoice, if customer is not found, give error invoice
			boolean availableCustomer = false;
			for (int i = 0; i < customers.length; i++) {
				if (customers[i].orderNumber == orderNumber) {
					customerObjectPosition = i;
					availableCustomer = true;
				}
			}

			// Allocate a Driver for the Order
			// Start with Object position 0
			int driverObjectPosition = 0;
			// Find the driver with the least amount of deliveries in the city
			// Start with a high unreachable number and work down
			int lowestDeliveries = 100000;
			// Change to True if a driver is available
			boolean availableDriver = false;

			// For loop to find out if driver is in the region and which has the lowest amount of loads
			for (int i = 0; i < drivers.length; i++) {
				if ((drivers[i].cityDriver.equals(restaurants[numberOfOrder].cityRestaurant))
						&& (drivers[i].deliveries < lowestDeliveries)) {
					// Update driver with least loads if another driver has less loads in the array at the position
					driverObjectPosition = i;
					// Update the driver if the delivery amount is lower than previous
					lowestDeliveries = drivers[i].deliveries;
					// If a driver for the region is found,change to 1 for yes driver is available
					availableDriver = true;
				}
			}

			// Declare all the input variables to form the output invoice message
			// Driver attributes
			String driverName = drivers[driverObjectPosition].driverName;
			// Customer attributes
			String customerName = customers[customerObjectPosition].customerName;
			String contactNumberCustomer = customers[customerObjectPosition].contactNumber;
			String streetAddressOfCustomer = customers[customerObjectPosition].streetAddressOfCustomer;
			String suburbAddressOfCustomer = customers[customerObjectPosition].suburbAddressOfCustomer;
			String cityCustomer = customers[customerObjectPosition].cityCustomer;
			String emailCustomer = customers[customerObjectPosition].emailCustomer;
			// Restaurant attributes
			String restaurantName = restaurants[numberOfOrder].restaurantName;
			String cityRestaurant = restaurants[numberOfOrder].cityRestaurant;
			String contactNumberRestaurant = restaurants[numberOfOrder].contactNumber;
			String totalPrice = restaurants[numberOfOrder].totalPrice;
			String specialInstruction = restaurants[numberOfOrder].specialInstruction;
			String item1 = restaurants[numberOfOrder].item1;
			String item2 = restaurants[numberOfOrder].item2;

			// Output text for successful invoice - Use method to compile message
			String outputMessage = InvoiceDetail(orderNumber, driverName, customerName, contactNumberCustomer,
					streetAddressOfCustomer, suburbAddressOfCustomer, cityCustomer, emailCustomer, restaurantName,
					cityRestaurant, contactNumberRestaurant, totalPrice, specialInstruction, item1, item2);

			// Output text for invoice if there is no driver available
			String driverErrorOutputMessage = "Sorry! \r\nOur drivers are too far away from you to be able to deliver to your location.";

			// Convert order number to String for in order to use the Method.
			String stringOrderNumber = orderNumber + "";
			// Give Message result:
			// If there is an error finding the order number in the client array - give error message in console and invoice text
			if (availableCustomer == false) {
				String customerNotFoundMessage = "Error file created - Customer matching order number " + orderNumber
						+ " could not be found";
				// Add to the file name that there was a driver error to improve visibility
				String error = "-customer-loading-error";
				// Use method to write the output text file
				FileCreatorMethod(invoiceWritingFileLocation, stringOrderNumber, customerNotFoundMessage, error);
				// Display error message on console
				System.out.println("\n" + customerNotFoundMessage);
			}

			// If there is no drivers available to complete the load - Display on console and invoice an error message
			else if (availableDriver == false) {
				// Add to the file name that there was a driver error to improve visibility
				String error = "-driver-error";
				// Use method to write the output text file
				FileCreatorMethod(invoiceWritingFileLocation, stringOrderNumber, driverErrorOutputMessage, error);
				// Display error message on console
				String fileCreatedMessage = ("Error file created - No driver available for order number "
						+ orderNumber);
				System.out.println("\n" + fileCreatedMessage);
			}

			// If all the loading is successful - create a CORRECT INVOICE
			else {
				// Declare no error (blank) for file name modifying
				String noError = "";
				// Use method to write the output text file
				String fileCreatedMessage = FileCreatorMethod(invoiceWritingFileLocation, stringOrderNumber, outputMessage, noError);
				// Display success/ unsuccessful message on console
				System.out.println("\n" + fileCreatedMessage);
				System.out.println("Driver " + driverName + " is allocated for this load.");
			}

			// If a driver is allocated to a load (1 = Yes)
			if (availableDriver == true) {
				// Update the drivers array after a load is allocated to be able to allocate the next load accurately.
				drivers[driverObjectPosition].deliveries = (drivers[driverObjectPosition].deliveries + 1);
			}

		}
		// *** END OF LOOP ***

		
		// UPDATE the driver file with the amendments
		
		String outputMessageDrivers = "";
		//Name of text file amendment
		String newFileOutput = "NewAfterAllocation";

		// Run a for loop to create the text of the txt file 
		for (int x = 0; x < drivers.length; x++) {
			outputMessageDrivers += drivers[x].driverName + ", " + drivers[x].cityDriver + ", " + drivers[x].deliveries
					+ "\r\n";
		}
		
		// Run the method to create a new file
		FileCreatorMethod(driverWritingFileLocation, outputOrderNumber, outputMessageDrivers,  newFileOutput);
		//***END OF UPDATE DRIVER FILE***
	}

	
	//METHODS THAT ARE USED:
	
	// Method to create files
	public static String FileCreatorMethod(String writingFileLocation, String orderNumber, String outputMessage,
			String error) {
		String fileCreatedMessage = "New invoice file " + orderNumber + " have been created.";
		try {
			// Create a new Text file
			Formatter newFileWrite = new Formatter(writingFileLocation + orderNumber + error + ".txt");
			// Write the new String text inside
			newFileWrite.format("%s", outputMessage);
			// Close the file writer
			newFileWrite.close();
		}
		// If there was a problem creating the file - display the below error message
		catch (FileNotFoundException e) {
			fileCreatedMessage = "Error - Invoice File NOT created for " + orderNumber;
		}
		// Return message if the file was successfully created
		return fileCreatedMessage;
	}

	
	// Invoice compilation Method for the text inside invoice
	public static String InvoiceDetail(int orderNumber, String driverName, String customerName,
			String contactNumberCustomer, String streetAddressOfCustomer, String suburbAddressOfCustomer,
			String cityCustomer, String emailCustomer, String restaurantName, String cityRestaurant,
			String contactNumberRestaurant, String totalPrice, String specialInstruction, String item1, String item2) {

		// Compiling the output message with the invoice detail
		String outputMessage = ("Order number " + orderNumber + 
				"\r\nCustomer: " + customerName + 
				"\r\nEmail: " + emailCustomer + 
				"\r\nPhone number: " + contactNumberCustomer + 
				"\r\nLocation: " + cityCustomer + 
				"\r\n" + "\r\nYou have ordered the following from  " + restaurantName + " in " + cityRestaurant + 
				"\r\n" + 
				"\r\n" + item1 + 
				"\r\n" + item2 + 
				"\r\n" + 
				"\r\nSpecial instructions: " + specialInstruction + 
				"\r\n" + "\r\nTotal: R" + totalPrice + 
				"\r\n" + 
				"\r\n" + driverName + " is nearest to the restaurant and so he will be delivering your" + 
				"\r\norder to you at:" + 
				"\r\n " + 
				"\r\n" + streetAddressOfCustomer + 
				"\r\n" + suburbAddressOfCustomer + 
				"\r\n " + 
				"\r\nIf you need to contact the restaurant, their number is " + contactNumberRestaurant);
		// Return the invoice text
		return outputMessage;
	}

	
	// Method to determine the number of lines - to know how many object to create in the array
	public static int NumberOfLines(String fileLocation) {
		// Declare countLines to count the number of lines
		int countLines = 0;
		// Use the scanner function and read the number of lines
		try {
			File file = new File(fileLocation);
			Scanner lineNumberReader = new Scanner(file);
			while (lineNumberReader.hasNextLine()) {
				countLines++;
				lineNumberReader.nextLine();
			}
			lineNumberReader.close();
		}
		// Error message if there is a problem loading the file
		catch (FileNotFoundException e) {
			System.out.println("Error reading number of lines at location: " + fileLocation);
		}
		// Return the amount of lines counted
		return countLines;
	}

	
	// CUSTOMERS:
	// Method to read data from text file and create array of customers
	public static Customer[] ObjectCreationCustomer(String fileLocation) {
		// Declare countLines - each line is an object in the array
		int countLines = 0;
		// Declare the array - call method NumberOfLines() to know the array size
		Customer[] customersArray = new Customer[NumberOfLines(fileLocation)];

		// Use the scanner method to scan the customer text file line my line
		try {
			File file = new File(fileLocation);
			Scanner lineScan = new Scanner(file);
			while (lineScan.hasNextLine()) {
				// Get the string value of the line
				String textLine = lineScan.nextLine();

				// Use the scanner function to scan the items inside the line
				try (Scanner itemScanner = new Scanner(textLine)) {
					// Use the delimiter to know until where the scanner must scan
					itemScanner.useDelimiter(", ");
					while (itemScanner.hasNext()) {
						// Declare the String variables to store the attributes
						String orderNumberString = itemScanner.next();
						String customerName = itemScanner.next();
						String contactNumber = itemScanner.next();
						String streetAddressOfCustomer = itemScanner.next();
						String suburbAddressOfCustomer = itemScanner.next();
						String cityCustomer = itemScanner.next();
						String emailCustomer = itemScanner.next();
						// Parse the string to an integer
						int orderNumber = Integer.parseInt(orderNumberString);

						// Declare a new object
						Customer customer1 = new Customer(orderNumber, customerName, contactNumber,
								streetAddressOfCustomer, suburbAddressOfCustomer, cityCustomer, emailCustomer);
						// Add the object to the array
						customersArray[countLines] = customer1;
					}
				}
				// Add 1 for the new array object
				countLines++;
			}
			// Close the scanner
			lineScan.close();
		}
		// If problem with executing scanner, give error message
		catch (FileNotFoundException e) {
			System.out.println("Error reading Customer Objects at location: " + fileLocation);
		}
		// Return the array of objects
		return customersArray;
	}

	
	// DRIVERS:
	// Method to read data from text file and create array of drivers
	public static Driver[] ObjectCreationDriver(String fileLocation) {
		// Declare countLines - each line is an object in the array
		int countLines = 0;
		// Declare the array - call method NumberOfLines() to know the array size
		Driver[] driverArray = new Driver[NumberOfLines(fileLocation)];

		// Use the scanner method to scan the customer text file line my line
		try {
			File file = new File(fileLocation);
			Scanner lineScan = new Scanner(file);
			while (lineScan.hasNextLine()) {
				// Get the string value of the line
				String textLine = lineScan.nextLine();

				// Use the scanner function to scan the items in the line
				try (Scanner itemScanner = new Scanner(textLine)) {
					// Use the delimiter to know until where the scanner must scan
					itemScanner.useDelimiter(", ");
					while (itemScanner.hasNext()) {
						// Declare the String variables to store the attributes
						String driverName = itemScanner.next();
						String cityDriver = itemScanner.next();
						String deliveriesString = itemScanner.next();

						// Parse the string to an integer
						int deliveries = Integer.parseInt(deliveriesString);

						// Declare a new object
						Driver driver1 = new Driver(driverName, cityDriver, deliveries);
						// Add the object to the array
						driverArray[countLines] = driver1;
					}
				}
				// Add 1 for the new array object position
				countLines++;
			}
			// Close the scanner
			lineScan.close();
		}
		// If problem with executing scanner, give error message
		catch (FileNotFoundException e) {
			System.out.println("Error reading Driver Objects at location: " + fileLocation);
		}
		// Return the array of objects
		return driverArray;
	}

	
	// RESTAURANT ORDERS:
	// Method to read data from text file and create array of Restaurants
	public static Restaurant[] ObjectCreationRestaurant(String fileLocation) {
		// Declare countLines - each line is an object in the array
		int countLines = 0;
		// Declare the array - call method NumberOfLines() to know the array size
		Restaurant[] restaurantsArray = new Restaurant[NumberOfLines(fileLocation)];

		// Use the scanner method to scan the customer text file line my line
		try {
			File file = new File(fileLocation);
			Scanner lineScan = new Scanner(file);
			while (lineScan.hasNextLine()) {
				// Get the string value of the line
				String textLine = lineScan.nextLine();

				// Use the scanner function to scan the items in the line
				try (Scanner itemScanner = new Scanner(textLine)) {
					// Use the delimiter to know until where the scanner must scan
					itemScanner.useDelimiter(", ");
					while (itemScanner.hasNext()) {
						// Declare the String variables to store the attributes
						String orderNumberString = itemScanner.next();
						String restaurantName = itemScanner.next();
						String cityRestaurant = itemScanner.next();
						String contactNumber = itemScanner.next();
						String totalPrice = itemScanner.next();
						String specialInstruction = itemScanner.next();
						String item1 = itemScanner.next();
						String item2 = itemScanner.next();

						// Parse the string to an integer
						int orderNumber = Integer.parseInt(orderNumberString);

						// Declare a new object
						Restaurant restaurant1 = new Restaurant(orderNumber, restaurantName, cityRestaurant,
								contactNumber, totalPrice, specialInstruction, item1, item2);
						// Add the object to the array
						restaurantsArray[countLines] = restaurant1;
					}
				}
				// Add 1 for the new array object
				countLines++;
			}
			// Close the scanner
			lineScan.close();
		}
		// If problem with executing scanner, give error message
		catch (FileNotFoundException e) {
			System.out.println("Error reading Restaurant Objects at location: " + fileLocation);
		}
		// Return the array of objects
		return restaurantsArray;
	}
}
