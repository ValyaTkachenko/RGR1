package products;

import model.Product;

public class InventoryProduct extends Product {
    private int warrantyMonths;

    public InventoryProduct(String title, double price, String category, int warrantyMonths) {
        super(title, price, category);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}

