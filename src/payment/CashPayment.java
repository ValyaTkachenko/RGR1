package payment;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Оплата готівкою: " + amount + " грн");
        return true;
    }
}
