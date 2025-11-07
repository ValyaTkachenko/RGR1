package main;

import model.Product;
import model.ShoppingCart;
import store.Store;
import payment.*;

public class Main {
    public static void main(String[] args) {
        Store store = Store.getInstance();

        Product Fryingpans = new Product("Tefal Hard Titanium frying pan", 599, "Dishes");
        Product Kitchenutensils = new Product("Magio kitchenware set 11 pieces", 1099, "Dishes");
        Product Ironingboards = new Product("Eurogold ironing board", 1099, "Inventory for the home");
        Product Householdequipment = new Product("Vileda Turbo Smart cleaning set", 659, "Inventory for the home");
        Product Blankets = new Product("MirSon All-season Euro Blanket 200x220 Wool", 699, "Home textiles");
        Product Plaids = new Product("Fleece plaid Love You 150x200 cm Gray", 499, "Home textiles");
        Product Pillows = new Product("Highfoam Dreamwave orthopedic pillow", 499, "Home textiles");

        store.addProduct(Fryingpans);
        store.addProduct(Kitchenutensils);
        store.addProduct(Ironingboards);
        store.addProduct(Householdequipment);
        store.addProduct(Blankets);
        store.addProduct(Plaids);
        store.addProduct(Pillows);

        System.out.println("List of Products in Cart");
        ShoppingCart shoppingcart = store.getCart();
        for (Product product : shoppingcart.getProducts()) {
            System.out.println(product.getTitle() + " Category: " + product.getCategory() + " Price: " + product.getPrice());
        }

        double sum = store.checkout();
        System.out.println("Total price=" + sum + "грн");

        PaymentStrategy payment = new CardPayment();
        store.checkout(payment);
    }
}
