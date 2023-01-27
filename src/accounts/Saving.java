package accounts;

public class Saving extends Account{
    
    Saving(){
        minimumBalance = 500;
    }

    @Override
    public void display() {
        System.out.println("Overridden method in Saving");
        System.out.println("accountId = "+accountId + "\ndescription = "+description+"\nminimum balance = "+minimumBalance);
    }
}
