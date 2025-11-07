package products;

import model.Product;

public class HomeTextile extends Product {
    private String size;

    public HomeTextile(String title, double price, String category, String size) {
        super(title, price, category);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
