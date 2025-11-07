package test;

import model.Product;
import model.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import store.Store;
import payment.CardPayment;
import payment.PaymentStrategy;

public class StoreTest {

    @Test
    public void testAddProductToCart() {
        Store store = Store.getInstance();
        ShoppingCart cart = store.getCart();

        Product product = new Product("Test Product", 100, "Dishes");
        cart.addProduct(product);

        Assertions.assertEquals(1, cart.getProducts().size(), "Товар має бути доданий у кошик");
    }

    @Test
    public void testCalculateTotal() {
        Store store = Store.getInstance();
        ShoppingCart cart = store.getCart();
        cart.getProducts().clear(); // очищаємо попередні товари

        Product p1 = new Product("Pan", 500, "Dishes");
        Product p2 = new Product("Board", 300, "Home");

        cart.addProduct(p1);
        cart.addProduct(p2);

        double total = store.checkout();
        Assertions.assertEquals(800, total, 0.01, "Сума повинна бути 800 грн");
    }

    @Test
    public void testPaymentStrategy() {
        Store store = Store.getInstance();
        ShoppingCart cart = store.getCart();
        cart.getProducts().clear();

        Product p = new Product("Mixer", 1200, "Appliances");
        cart.addProduct(p);

        PaymentStrategy payment = new CardPayment();
        boolean success = store.checkout(payment);

        Assertions.assertTrue(success, "Оплата повинна пройти успішно");
    }
}
