import java.util.HashMap;
import java.util.Scanner;


import customers.Customer;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username, password;
        float balance;
        int choice;
        HashMap<String,Customer> customers = new HashMap<>();
        Customer customer;
        customers.put("username1", new Customer("username1", "password1"));
        System.out.println("\n\n***********Welcome to ABC Bank Limited************");
        do{
            System.out.println("\n==>Existing user? press 1 to Log In");
            System.out.println("==>Press 2 to Create new user");
            System.out.print("Enter your choice __ ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1: System.out.println("===================== LOG IN =====================");
                    System.out.print("\nEnter the username __ ");
                    username = sc.nextLine();
                    System.out.print("Enter the password __ ");
                    password = sc.nextLine();
                    customer = Customer.login(username, password, customers);
                    if (customer!=null){
                        do{
                            System.out.println("\n==========================\n");
                            System.out.println("Welcome "+ username + ", \nPlease select an option");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdrawal");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Edit profile");
                            System.out.println("5. Change password");
                            System.out.println("6. Exit");
                            System.out.print("Enter your choice __ ");
                            choice = Integer.parseInt(sc.nextLine());
                            System.out.println("\n===========================\n");
                            switch(choice){
                                case 1:System.out.print("Enter the amount to be deposited ___ ");
                                System.out.println("The final balance is = "+customer.deposit(Float.parseFloat(sc.nextLine())));
                                break;
                                case 2:System.out.print("Enter the amount to be withdrawn ___ ");
                                System.out.println("The final balance is = "+customer.withraw(Float.parseFloat(sc.nextLine())));
                                break;
                                case 3:System.out.println("The balance is = "+customer.checkBalance());
                                break;
                                case 4:customer.editProfile();
                                break;
                                case 5:customer.changePassword();
                                break;
                                case 6:break;
                                default: System.out.println("Invalid choice");
                            }
                            if(choice==6){
                                break;
                            }
                            System.out.print("Do you wish to continue working in this account?");
                        }while(sc.nextLine().equalsIgnoreCase("Yes"));
                    }
                    else{
                        System.out.println("Error: Username & password combination does not exist");
                    }
                    break;
                case 2:System.out.println("\n=============== CREATE NEW USER =============");
                    System.out.print("Enter the username ____ ");
                    username = sc.nextLine();
                    if(customers.containsKey(username)){
                        System.out.println("ERROR: Username already exists");
                        break;
                    }
                    System.out.print("Enter the password ____ ");
                    password = sc.nextLine();
                    System.out.print("Enter the deposit amount ___ ");
                    balance = Float.parseFloat(sc.nextLine());
                    customers.put(username, new Customer(username, password, balance));
                    System.out.println("\nUser Successfully Created");
                    break;
                default: System.out.println("Invalid input...");
            }
            System.out.println("*******************************************************");
            System.out.print("\nLogin/Create new user? press Yes to continue ___ ");
        }while(sc.nextLine().equalsIgnoreCase("Yes"));
        
        sc.close();
    }
}
