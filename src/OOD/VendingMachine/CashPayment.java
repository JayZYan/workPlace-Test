package OOD.VendingMachine;

public class CashPayment implements Payment {
    @Override
    public boolean pay() {
        System.out.println("cashPayment");
        return true;
    }
}
