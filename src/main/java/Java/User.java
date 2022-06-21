package Java;
//importing needed packages

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Customer information
 */
public class User {
    //declaring default methods and variables
    String name;
    String email;
    String phoneNumber;
    String gender;
    Integer age;

    /**
     * Asks the user questions and populates user information into the class.
     *
     * @param in Scanner for receiving user input
     */
    //taking user input to fill fields
    public void populateUserDataFromConsole(Scanner in) {
        System.out.println("What is your name?");
        this.name = in.nextLine();
        Matcher matcher;
        String userEmail;
//        Loop to ensure valid email
        do {
            System.out.println("enter your email:");
            userEmail = in.nextLine();
            Pattern pattern = Pattern.compile("\\S+?@\\S+?\\.\\S+");
            matcher = pattern.matcher(userEmail);
            if (!matcher.matches()) {
                System.out.println("your email should looks like this sample jimi.hendrix@gmail.com");
            }
        } while (!matcher.matches());
        this.email = userEmail;

        System.out.println("What is your phone number?");
        this.phoneNumber = in.nextLine();
//        Loop to ensure either male or female is entered
        do {
            System.out.println("Male or Female.");
            this.gender = in.nextLine().toLowerCase().strip();
            if (this.gender.startsWith("m")) {
                this.gender = "male";
            } else if (this.gender.startsWith("f")) {
                this.gender = "female";
            }
        } while (!(this.gender.equals("male") || this.gender.equals("female")));

        System.out.println("What is your age?");
        while (!in.hasNextInt()) {
            in.nextLine();  // throw away the bad input
            System.out.println("Please enter a valid number");
        }
        this.age = in.nextInt();
        in.nextLine();
    }
}
