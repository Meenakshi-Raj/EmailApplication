package emailapplication;

import java.util.Random;
import java.util.Scanner;

public class Email {
    Scanner scan = new Scanner(System.in);
    private final String firstname;
    private final String lastname;
    private final String department;
    private String password;
    private String alterMail;
    private final String newMail;

    public Email(String fName, String lName){
        this.firstname = fName;
        this.lastname = lName;
        this.department = this.getDept();
        this.password = this.generatePassword();
        this.newMail = this.generateMail();
        System.out.println("New Employee registered with details: ");
        this.getInfo();
    }

    private String generateMail() {
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase() + ".com";
    }

    private String generatePassword() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*";
        String values = upper + lower + digits + special;
        for(int i = 0; i< 10; i++){
            sb.append(values.charAt(random.nextInt(values.length())));
        }
        return sb.toString();
    }

    public String getDept(){
        System.out.println("""
                Department Codes:
                1. Marketing
                2. HR
                3. Sales
                4. Operations""");
        boolean validInput = false;
        do {
            System.out.println("Enter department code: ");
            int code = scan.nextInt();
            switch (code) {
                case 1:
                    return "Marketing";
                case 2:
                    return "HR";
                case 3:
                    return "Sales";
                case 4:
                    return "Operations";
                default:
                    System.out.println("Invalid Department!");
            }
        }while(!validInput);
        return null;
    }

    public void getInfo() {
        System.out.println("Name: " + firstname + " " + lastname);
        System.out.println("Department: " + department);
        System.out.println("Email ID: " + newMail);
        System.out.println("Password: " + password);
    }

    public void changePassword() {
        System.out.println("Enter current password: ");
        String temp = scan.next();
        if (temp.equals(password)) {
            System.out.println("Enter new password: ");
            this.password = scan.next();
            System.out.println("Password changed!");
        }else {
            System.out.println("Unauthorized! " + '\n' +
                    "Password Change Request Rejected!");
        }
    }

    public void setAlterEmail() {
        System.out.println("Enter new email ID:");
        this.alterMail = scan.next();
        System.out.println("New email ID created!");
    }
}
