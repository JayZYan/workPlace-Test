package OOD.VendingMachine;

public class coinPayment implements Payment {
    @Override
    public boolean pay() {
        System.out.println("coinPayment");
        return true;
    }
}
