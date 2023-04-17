// Import section
import java.io.*;
import java.time.*;
import java.util.*;

// Driver class program - Demonstrate the Coin class usage
public class Driver {
    public static void main(String[] args)throws IOException
    {
        // Variable declaration
        int heads = 0; // Accumulator variable
        int tails = 0;  // Accumulator variable
        double alltrials = 0;
        double avg;
        for (int i = 0; i < 10; i++)
            while ((heads < 1) && (tails < 1)) {
                int p = (int) (Math.random() * 2);
                if (p == 1) {
                    heads++;
                    tails++;
                }
                alltrials++;

            }
        boolean flag = false; // Flag variable
        String result = ""; // Variable to store sideUp results

        // Objects initialization
        Coin coinObj = new Coin(); // New coin instance
        LocalDate localDate = LocalDate.now(); // Date class instance
        LocalTime localTime = LocalTime.now(); // Time class instance
        Scanner in = new Scanner(System.in); // Scanner object to get user's input


        do
        {
            // User input request section
            System.out.println("Welcome to Coin Toss!");
            System.out.print("Would you like to show on the screen the past program pass? Y/N (Type N if this is the program's first run) : ");
            String userChoice = in.next().toLowerCase();

            // User input validation
            if(userChoice.contentEquals("y") || userChoice.contentEquals("n"))
            {
                flag = true; // If the input is expected turn on the flag to allow the loop to exit

                if(userChoice.contentEquals("y"))
                {
                    Coin.showPastRun(); // If the user decides to show the past program run
                }
            }

            if(flag == true) break; // If the flag is on, break the loop
            System.out.println("Invalid input! Please try again."); // If the user input it is out of range show message error

        } while(flag == false); // Keep running the loop if the flag is false

        in.close(); // Scanner object close

        // File and screen output code block
        PrintWriter outputFile = new PrintWriter("myoutput.txt");  // Open a writable file for output results
        outputFile.println("*** Program Output of " + localDate + " at " // Write file header
                + localTime.getHour() + ":" + localTime.getMinute() + " ***");

        outputFile.println("\nPast Coin-Toss Simulator Run: "); // File output
        System.out.println("\nNew Coin-Toss Simulator Run: "); // Screen output

        outputFile.println("Initially the coin faced up: " + coinObj.getSideUp()); // Write the Coin class field status on file
        System.out.println("Initial toss: " + coinObj.getSideUp()); // Screen output the Coin class field status

        for(int i = 1; i < 21; i++) // Loop 20 times starting from 1
        {
            result = Coin.toss(); // Call toss method of the class (Called directly due to is a static method)

            if (result.equals("heads"))
            {
                heads++; // adds 1 each pass to heads accumulator variable
            }
            else
            {
                tails++; // adds 1 each pass to tails accumulator variable
            }

            // Write the file and output to screen the result
            outputFile.println((i) + " Coin faced up: " + result);
            System.out.println(i + " Coin is facing up: " + result);
        }

        // Write the file and output header result section
        outputFile.println(" ");
        outputFile.println("Results: ");
        System.out.println("\nResults: ");

        // Result for heads running total
        outputFile.println("Heads: " + heads);
        System.out.println("Heads: " + heads);

        // Result for tails running total
        outputFile.println("Tails: " + tails);
        System.out.println("Tails: " + tails);

        outputFile.close(); // Close file output object
    }
}

