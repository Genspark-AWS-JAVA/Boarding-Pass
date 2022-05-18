package Java;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class User {
    String name;
    String email;
    String phoneNumber;
    String gender;
    Integer age;

    public void populateUserDataFromConsole(Scanner in) {
        System.out.println("What is your name?");
        this.name = in.nextLine();
        Scanner input = new Scanner(System.in);
            Matcher matcher;
        do {
            System.out.println("enter your email:");
            String userEmail = input.next();
            Pattern pattern = Pattern.compile("\\S+?@\\S+?\\.com");
            matcher = pattern.matcher(userEmail);
            if (matcher.matches()) {
                System.out.println("Matches");
            }
            else {
                System.out.println("your email should looks like this sample jimi.hendrix@gmail.com");
            }
        } while(!matcher.matches());
            input.close();

        System.out.println("What is your phone number?");
        this.phoneNumber = in.nextLine();
        do {
            System.out.println("Male or Female.");
            this.gender = in.nextLine().toLowerCase().strip();
        } while (this.gender == "male" || this.gender == "female");
        System.out.println(this.gender);

        System.out.println("What is your age?");
        this.age = in.nextInt();
    }
}
