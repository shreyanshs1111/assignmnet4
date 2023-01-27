package accounts;
public class AccountsTest1 {
    public static void main(String[] args) {
        Current current = new Current();
        Saving saving = new Saving();
        System.out.println("===========Current's display==========");
        current.display();
        System.out.println("===========Savings's display==========");
        saving.display();
    }
}

