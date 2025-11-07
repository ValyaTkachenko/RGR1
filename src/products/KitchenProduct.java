package products;

import model.Product;

public class KitchenProduct extends Product {
    private String material;

    public KitchenProduct(String title, double price, String category, String material) {
        super(title, price, category);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}

