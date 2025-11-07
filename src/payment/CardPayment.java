package payment;

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Оплата карткою: " + amount + " грн");
        return true;
    }
}

