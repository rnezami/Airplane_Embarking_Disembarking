package LA5Q;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class Airplane { //Main class
    public static void main(String[] args) {
        boolean flag = false; //flag for the while loop
        myHeader(5, 1);//myfooter
        System.out.println("\nWelcome to Nezami Airlines where comfortability and reliability is our top priority!. We are travelling to our destination in the Boeing 737.");
        Scanner scanner = new Scanner(System.in); //scanner which takes userinput
        System.out.println("Flight Attendant Please Enter Name:");
        String info = scanner.nextLine();//takes the flight attendant name
        System.out.println("Welcome flight attendant " + info + " to Nezami Airlines");
        Map<String, String> plane = new TreeMap<>(); //i am using a hasmap to store values and a treemap inorder to sort it
        int choose = 0;//a variable which stores the option we need to choose

        do {//Using a do while loop to keep bringing up the choices until 4 is typed

                System.out.println("Choose an Option");   //options printed
                System.out.println("1. Boarding Passengers on the Boeing 737.");
                System.out.println("2. Edit seating.");
                System.out.println("3. Disembarking Passengers on the Boeing 737.");
                System.out.println("4. Shut down program.");
            try {//try block for if an inputMismatch exception takes place meaning if a letter is inputted
                choose = scanner.nextInt(); // Where the user inputs their option //takes the input
                scanner.nextLine(); //  clears buffers
            } catch (InputMismatchException ime) {//catch block catching the exception and print invalid input
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // again Clears the buffer
                continue; // Skip the rest of the loop and prompt again
            }
            if (choose < 1 || choose > 4) {
                    System.out.println("Invalid choice. Please select a valid option.");
                    continue; // Skip the switch statement and loop back to the menu
                }
                switch (choose) {//using a switch statement in order to show the options
                    case 1: //This is responsible for adding the values to the hashmap by using put
                        System.out.println("Enter Seat from (01a-15f)");
                        String seat = scanner.next(); //takes seat number from user
                        System.out.println("Enter Name");
                        String name = scanner.next();//takes name from user
                        if (plane.containsKey(seat)) { //checking if seat is occupied
                            System.out.println("Passenger found, Try another seat please");
                            break;
                        }
                        plane.put(seat, name); //puts in hashmap
                        System.out.println(plane); //prints as we are adding so that the flight attendant can see the people onboard
                        break;//important to break so that it does not automatically continue on to the other cases
                    case 2://second case of editing the seats
                        System.out.println("Enter Seat number to be replaced from (01a-15f).");
                        seat = scanner.next(); //takes seat to be replaced
                        if (plane.containsKey(seat)) { //checks if seat is occupied and if so print find another seat
                            System.out.println("Passenger found, Try another seat please.");
                        }
                        else{ //if the seat isnt occupied run the next part
                            System.out.println("Not occupied");
                            System.out.println("Would you like to put someone here enter yes or no?");//asking if they would like to enter a user
                            String choice1 = scanner.next();//choice of entering
                            if (choice1.equalsIgnoreCase("yes")) { //if user inpus yes
                                System.out.println("Enter Name"); //enter the name sear already declared
                                name = scanner.next();//takes name from user
                                plane.put(seat, name);//put in hashmap
                            } else {
                                break;//break case 2
                            }

                        }


                        break;
                    case 3://this case is responsible for disembarking the passengers
                        System.out.println("Passengers leaving starting from the people nearest to people in the back of the plane.");
                        // Iterate through the TreeMap's entries and print them with custom format
                        if (!plane.isEmpty()) {
                            // Create an iterator for the manifest entries
                            Iterator<Map.Entry<String, String>> iterator = plane.entrySet().iterator();

                            while (iterator.hasNext()) { // a while loop to print the next element
                                Map.Entry<String, String> entry = iterator.next();
                                seat = entry.getKey();
                                name = entry.getValue();
                                iterator.remove(); // Remove the entry using the iterator
                                System.out.println(name + " has exited from seat " + seat);
                            }
                        } else {
                            System.out.println("There were no Passengers on this flight");
                        }//no passengers exit code
                        System.exit(1); //exits code when passengers disembarks
                        break;

                    case 4://This is when the flight attendant is shutting down the program
                        System.out.println("Goodbye! Hope to see you again!");
                        flag = true;//flag is set to true so do while loop would not execute and will straight go to myfooter and end the code
                        break;//breaks the case
                }


    } while (flag == false);

    myFooter(5,1);//myfooter

    }


    public static void myHeader (int abc,int gef){ // my header method
        System.out.printf("=======================================================\n" +
                "Lab Exercise %d-Q%d\n" +
                "Prepared By: Rayyan Nezami\n" +
                "Student Number: 251294300\n" +
                "Goal of this Exercise: Creating an airplane in which we could disembark onboard and edit seats\n" +
                "======================================================= \n ", abc,gef);
    }
    public static void myFooter(int def,int yef) { //myFooter method
        System.out.printf("=======================================================\n" +
                "Completion of Lab %d-Q%d successful!\n" +
                "Signing off - Rayyan\n" +
                "=======================================================\n", def ,yef);
    }
}



