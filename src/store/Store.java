package store;

import model.Product;
import model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static Store instance;

    private List<Product> products = new ArrayList<>(); // каталог
    private ShoppingCart cart = new ShoppingCart();     // кошик

    private Store() {}

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void addProductToCatalog(Product product) {
        products.add(product);
    }

    public double checkout() {
        return cart.calculateTotal();
    }

    public boolean checkout(payment.PaymentStrategy strategy) {
        double amount = checkout();
        System.out.println("\n--- Виконується оплата ---");
        boolean paid = strategy.pay(amount);
        if (paid) {
            cart.clear();  // очищаємо кошик після покупки
        }
        return paid;
    }
}



