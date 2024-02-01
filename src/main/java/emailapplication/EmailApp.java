package emailapplication;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter first name: ");
        String firstName = scan.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scan.nextLine();

        Email email = new Email(firstName,lastName);

        System.out.println("""
                            What do you wish to do today?:
                            1. See Information
                            2. Change password
                            3. Set alternate email address
                            4. exit""");
        int code = scan.nextInt();
        boolean validInput = false;
        do{
           switch (code){
               case 1:
                   validInput = true;
                   email.getInfo();
                   break;
               case 2:
                   validInput = true;
                   email.changePassword();
                   break;
               case 3:
                   validInput = true;
                   email.setAlterEmail();
                   break;
               case 4:
                   validInput = true;
                   System.out.println("Thank you!");
                   break;
               default:
                   System.out.println("Invalid Choice!" + '\n' +
                           "Please enter valid choice!: " + scan.nextInt());
           }
        }while(!validInput);
    }
}
