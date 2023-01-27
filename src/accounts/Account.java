package accounts;

public abstract class Account {
    String accountId, description;
    float minimumBalance;
    
    abstract public void display();
}
