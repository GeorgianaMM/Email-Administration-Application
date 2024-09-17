package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String companySuffix = "bdocompany.com";
    private String email;
    private String password;
    private int passwordLength;
    private int mailboxCapacity = 1024;
    private String alternateEmail;

    //Constructior to get lastname and first name
    public Email(String fn, String ln) {
        //Name
        this.firstName = fn;
        this.lastName = ln;
        //System.out.println("New email for: " + firstName + " " + lastName);
        
        //department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        //password
        System.out.print("Please enter the length for your new password: ");
        Scanner scanner = new Scanner(System.in);
        passwordLength = scanner.nextInt();
        this.password = randomPassword(passwordLength);
        System.out.println("Your generated password is: " + this.password);

        //Generate email
        if("".equals(department)) email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        else email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        //System.out.println("Your email is: " + email);
    }

    //Department
    private String setDepartment(){
        System.out.println("New worker " + firstName + ". Department codes:");
        System.out.println("1 for Sales");
        System.out.println("2 for Development");
        System.out.println("3 for Accounting");
        System.out.println("0 for none");
        System.out.print("Enter the department code: ");

        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();

        if(depChoice == 1) return "Sales";
        else if(depChoice == 2) return "Development";
        else if(depChoice == 3) return "Accounting";
        else return "";
    }

    //Generate random password
    private String randomPassword(int length){

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@!#$%";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){ //Encapsulation: public methods (to set proprieties) + hidding the actual proprieties 
        this.mailboxCapacity = capacity;
    }
    //Set alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    //Change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo(){
        return  "NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
