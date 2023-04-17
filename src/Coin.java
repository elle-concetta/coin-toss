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
import java.util.*;

// Coin class
public class Coin {

    // Class field declaration
    private static String sideUp; // Declared as static due to there is going to be just one instance

    // Non-argument Constructor
    public Coin()
    {
        sideUp = toss();
    }

    // setSideUp method - Sets the sideUp class field content
    public void setSideUp(String side)
    {
        sideUp = side;
    }

    // getSideUp method - Get the sideUp class field content
    public String getSideUp()
    {
        return sideUp;
    }

    // toss method - Simulate a coin toss and returns its result in String format
    public static String toss()
    {
        Random rand = new Random(); // Create an instance of the Random class
        int randomNumber = rand.nextInt(2); // Returns a value between 0 to 1
        String result = "";  // local variable to handle the result string

        if(randomNumber == 0)
        {
            result = "heads"; // If the random generated number is 0, then return "heads"
        }
        else if(randomNumber == 1)
        {
            result = "tails"; // If the random generated number is 1, then return "tails"
        }

        return result; // Returns the toss result
    }

    // showPasrRun method - Reads the past program run and shows the result on the screen
    public static void showPastRun() throws IOException
    {
        File inputFile = new File("myoutput.txt"); // Sets input file object
        Scanner in = new Scanner(inputFile);  // Feeds the String stream with the file content
        System.out.print("\n");

        while(in.hasNext()) // Will run until there is a next available line in the stream
        {
            String str = in.nextLine(); // Reads next line
            System.out.println(str);
        }
        System.out.println("\n***********************************");
        in.close(); // Object closing
    }
}
