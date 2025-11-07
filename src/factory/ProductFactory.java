package factory;

import model.Product;
import products.HomeTextile;
import products.InventoryProduct;
import products.KitchenProduct;

public class ProductFactory {

    public static Product createProduct(String type, String title, double price, String category) {
        switch (type.toLowerCase()) {
            case "kitchen":
                return new KitchenProduct(title, price, category, "Steel");
            case "textile":
                return new HomeTextile(title, price, category, "200x220");
            case "inventory":
                return new InventoryProduct(title, price, category, 12);
            default:
                return new Product(title, price, category) {}; // анонімний клас
        }
    }
}
