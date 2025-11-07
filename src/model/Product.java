package model;

public class Product {
    private String title;
    private double price;
    private String category;

    public Product(String title, double price, String category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    public void setPrice(double price) {
        if (price < 0) {
            throw new exceptions.NegativePriceException("Price cannot be negative");
        }
        this.price = price;
    }

    public String getDescription() {
        return title + " (" + category + ")";
    }
}
