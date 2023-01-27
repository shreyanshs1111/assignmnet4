package accounts;
public class Current extends Account{
    
    public Current(){
        minimumBalance = 0;
    }
    
    @Override
    public void display() {
        System.out.println("Overridden method in Current");
        System.out.println("accountId = "+accountId + "\ndescription = "+description+"\nminimum balance = "+minimumBalance);
    }
}

