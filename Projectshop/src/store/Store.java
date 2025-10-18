package store;

import model.Product;
import model.ShoppingCart;

public class Store {
    private static Store instance;
    private ShoppingCart cart = new ShoppingCart();

    private Store() {}

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void addProduct(Product product) {
        cart.addProduct(product);
    }

    public double checkout() {
        return cart.calculateTotal();
    }
}

