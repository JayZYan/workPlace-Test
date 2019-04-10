package OOD.VendingMachine;

public class CreditCard implements Payment {
    @Override
    public boolean pay() {
        System.out.println("credit Payment");
        return true;
    }
}
