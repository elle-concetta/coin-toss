/*
Author: Elizabeth Fassler
Course: COP 2210 RVD 1231
Date: 03/30/2023
Assignment: Discussion (Loops)
Instructor: Sergio Pisano
Description: Coin Toss
*/

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

/*
/Users/ellefassler/Library/Java/JavaVirtualMachines/openjdk-19.0.2/Contents/Home/bin/java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:51003,suspend=y,server=n -javaagent:/Users/ellefassler/Library/Caches/JetBrains/IntelliJIdea2022.3/captureAgent/debugger-agent.jar -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/ellefassler/Desktop/java-workspace/Coin Toss/out/production/Coin Toss:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar Driver
Connected to the target VM, address: '127.0.0.1:51003', transport: 'socket'
Welcome to Coin Toss!
Would you like to show on the screen the past program pass? Y/N (Type N if this is the program's first run) : Y

*** Program Output of 2023-04-03 at 15:27 ***

Past Coin-Toss Simulator Run:
Initially the coin faced up: tails
1 Coin faced up: tails
2 Coin faced up: heads
3 Coin faced up: tails
4 Coin faced up: heads
5 Coin faced up: heads
6 Coin faced up: tails
7 Coin faced up: tails
8 Coin faced up: heads
9 Coin faced up: heads
10 Coin faced up: heads
11 Coin faced up: tails
12 Coin faced up: tails
13 Coin faced up: heads
14 Coin faced up: tails
15 Coin faced up: tails
16 Coin faced up: tails
17 Coin faced up: heads
18 Coin faced up: tails
19 Coin faced up: tails
20 Coin faced up: tails

Results:
Heads: 9
Tails: 13

***********************************

New Coin-Toss Simulator Run:
Initial toss: heads
1 Coin is facing up: tails
2 Coin is facing up: heads
3 Coin is facing up: heads
4 Coin is facing up: tails
5 Coin is facing up: heads
6 Coin is facing up: tails
7 Coin is facing up: heads
8 Coin is facing up: heads
9 Coin is facing up: tails
10 Coin is facing up: tails
11 Coin is facing up: heads
12 Coin is facing up: heads
13 Coin is facing up: tails
14 Coin is facing up: heads
15 Coin is facing up: tails
16 Coin is facing up: heads
17 Coin is facing up: tails
18 Coin is facing up: heads
19 Coin is facing up: tails
20 Coin is facing up: tails

Results:
Heads: 11
Tails: 11
Disconnected from the target VM, address: '127.0.0.1:51003', transport: 'socket'

Process finished with exit code 0

 */
