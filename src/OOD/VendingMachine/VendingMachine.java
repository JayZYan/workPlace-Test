package OOD.VendingMachine;

public class VendingMachine {
    private Payment payment;

    public VendingMachine(Payment payment) {
        this.payment = payment;
    }
//    public void purchase(Item item) {
//        if (payment.pay()) {
//            item.release();
//        } else {
//            System.out.println("why cannot purchase");
//        }
//    }

}
