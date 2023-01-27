package customers;

import java.util.HashMap;
import java.util.Scanner;

import accounts.Validation;

public class Customer implements Validation{
    public String name, username, password, ssn, address, email;
    public int age;
    public long phone;
    public float balance;

    public Customer(){
    }

    public Customer(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public Customer(String username, String password, String ssn, String address, String email, int age, long phone, float balance){
        this.username = username;
        this.password = password;
        this.ssn = ssn;
        this.address = address;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.balance = balance;

    }

    public Customer(String username, String password, float balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    // returns customer object if username and password are in the list of customers
    public static Customer login(String username, String password, HashMap<String, Customer> customers){
        if(customers.containsKey(username) && customers.get(username).password.equals(password)){
            return customers.get(username);
        }
        return null;
    }

    //returns the balance after deposit
    public float deposit(float cr){
        this.balance += cr;
        return balance;
    }

    //returns the balance after withdrawal
    public float withraw(float db){
        if(db<=balance){
            balance -= db;
        }
        else
            System.out.println("The withdrawal is not possible. Low account balance");
        return balance;
    }

    //return balance
    public float checkBalance(){
        return balance;
    }

    //returns true if the updation is successful else false
    public boolean editProfile(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter the field you want to edit __ ");
            String field = sc.nextLine();
            if(field.equalsIgnoreCase("name")){
                System.out.print("Enter the new Name __\t");
                name = sc.nextLine();
            }
            else if(field.equalsIgnoreCase("ssn")){
                System.out.print("Enter the new ssn __\t");
                ssn = sc.nextLine();
                if(this.validateSSN()){
                    System.out.println("Invalid SSN");
                }
            }
            else if(field.equalsIgnoreCase("address")){
                System.out.print("Enter the new Address __\t");
                address = sc.nextLine();
            }
            else if(field.equalsIgnoreCase("email")){
                System.out.print("Enter the new Email __\t");
                email = sc.nextLine();
            }
            else if(field.equalsIgnoreCase("age")){
                System.out.print("Enter the new Age __\t");
                age = Integer.parseInt(sc.nextLine());
                if(this.validateAge()){
                    System.out.println("Invalid Age");
                }
            }
            else if(field.equalsIgnoreCase("phone")){
                System.out.print("Enter the new Phone __\t");
                phone = Long.parseLong(sc.nextLine());
            }
            else{
                System.out.println("Invalid field name entered");
            }
            System.out.println("Do you wish to continue editing?\nEnter \"Yes\" or \"No\" __ ");;
        }while(sc.nextLine().equalsIgnoreCase("Yes"));
        System.out.println("\n--------------------\nThe updated employee details are\n");
        System.out.println("Name = " + name);
        System.out.println("username = " + username);
        System.out.println("ssn = " + ssn);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);
        System.out.println("----------------------");
        return true;
    }

    public boolean changePassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new password");
        password = sc.nextLine();
        return true;
    }

    @Override
    public boolean validateAge() {
        return this.age>18;
    }
    @Override
    public boolean validateSSN() {
        return this.ssn.length()==9 && this.ssn.matches("[0-9]+");
    } 
}
