# Level 2 Task 7 -Capstone Project I: OOP

## THE TASK AT HAND

You are asked to create a food delivery system for a company called “Food Quick”.

Food Quick is the company that receives the orders and distributes them to a driver based on their current load and their location. They want you to create a program that can help them keep track of the orders and distribute accordingly.

Food Quick stores the following information for each customer:

● Order number

● Customer name

● Contact number of the customer

● Address of the customer

● Location (city) of the customer

● Email address of the customer

● Name of the restaurant

● Location of the restaurant

● Contact number of the restaurant

● How many of each meal is being ordered

● The list of meals being ordered and their prices

● Any special preparation instructions given by the customer

● The total amount to be paid

The information about the drivers is in the text file drivers.txt in the following format:

John Krill, Cape Town, 4

This shows that the driver’s name is John Krill who is in Durban and he currently has a load of 4 deliveries.

Food Quick would like you to be able to create an invoice for a customer after the above information has been inputted into the program. The invoice should be a text file with the following format:

Order number 1234

Customer: Jill Jack

Email: jilljack@yahoo.com

Phone number: 123 456 7890

Location: Cape Town

You have ordered the following from Aesop’s Pizza in Cape Town:

1 x Pepperoni pizza (R78.00)

2 x Hawaiian pizza (R82.00)

Special instructions: Extra tomato base on the Pepperoni pizza

Total: R242.00

John Krill is nearest to the restaurant and so he will be delivering your order to you at:

12 Cherry Road

Plumstead

If you need to contact the restaurant, their number is 098 765 4321.

## Task 1

Follow these steps:

● In a file called planning.txt, design your program to meet the specifications given by Quick Food. Write out the pseudocode of how you plan for your program to run. Include the creation of classes and the
methods you plan to have in those classes. You should also show the relationships between classes.

● Next, use your pseudocode to create a UML diagram and save it as a PDF in this task’s folder. You should now have a good idea of how your program is going to flow.

● You will not be marked on this, it is just to help you create a clear plan before creating your code.

## Task 2

Follow these steps:

● Code a Java program that will meet part of Quick Food’s specifications.

You will build upon this program in later Capstone projects. For this program, you should:

o Create a class that will be used to create a Customer object.

o Create a class that will be used to create a Restaurant object.

o Write a program that will allow a user to:

▪ Capture the details that are used to create a new Customer object.

▪ Capture the details that are used to create a new Restaurant object.

▪ Read the drivers.txt file and find the driver in the correct area with the smallest load. Note, you just need to check if the driver and the restaurant are in the same area.

▪ If the customer lives in a location that does not match a driver’s location, the invoice only needs to say: “Sorry! Our drivers are too far away from you to be able to deliver to your location.”

▪ Write up the invoice to a new text file for the customer called invoice.txt.