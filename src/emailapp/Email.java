package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int mailboxCapacity;
    private String alternateEmail;

    //Constructior to get lastname and first name
    public Email(String fn, String ln) {
        this.firstName = fn;
        this.lastName = ln;
        System.out.println("New email for: " + firstName + " " + lastName);

        this.department = setDepartment();
        System.out.println("Department: " + this.department);
    }

    //Department
    private String setDepartment(){
        System.out.println("Department codes:");
        System.out.println("1 for Sales");
        System.out.println("2 for Development");
        System.out.println("3 for Accounting");
        System.out.println("0 for none");
        System.out.println("Enter the department code:");

        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();

        if(depChoice == 1) return "Sales";
        else if(depChoice == 2) return "Development";
        else if(depChoice == 3) return "Accounting";
        else return "";
    }
    
}
