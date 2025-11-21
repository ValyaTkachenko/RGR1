package main;

import model.Product;
import store.Store;
import payment.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Store store = Store.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Додаємо товари в каталог
        store.addProductToCatalog(new Product("Tefal Hard Titanium frying pan", 599, "Dishes"));
        store.addProductToCatalog(new Product("Magio kitchenware set 11 pieces", 1099, "Dishes"));
        store.addProductToCatalog(new Product("Eurogold ironing board", 1099, "Home inventory"));
        store.addProductToCatalog(new Product("Vileda Turbo Smart cleaning set", 659, "Home inventory"));
        store.addProductToCatalog(new Product("MirSon All-season Euro Blanket", 699, "Home textile"));
        store.addProductToCatalog(new Product("Fleece plaid Love You 150x200 cm Gray", 499, "Home textile"));
        store.addProductToCatalog(new Product("Highfoam Dreamwave orthopedic pillow", 499, "Home textile"));

        boolean working = true;

        while (working) {
            System.out.println("\n========= МАГАЗИН ТЕХНІКИ ДЛЯ ДОМУ =========");
            System.out.println("1. Показати каталог товарів");
            System.out.println("2. Додати товар у кошик");
            System.out.println("3. Показати кошик");
            System.out.println("4. Видалити товар з кошика");
            System.out.println("5. Оформити покупку");
            System.out.println("0. Вийти");

            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showCatalog(store);
                    break;
                case 2:
                    addToCart(store, scanner);
                    break;
                case 3:
                    showCart(store);
                    break;
                case 4:
                    removeFromCart(store, scanner);
                    break;
                case 5:
                    checkout(store, scanner);
                    break;
                case 0:
                    working = false;
                    break;
                default:
                    System.out.println("Невірна команда!");
            }
        }
    }

    private static void showCatalog(Store store) {
        System.out.println("\n=== КАТАЛОГ ===");
        int i = 1;
        for (Product p : store.getAllProducts()) {
            System.out.println(i++ + ". " + p.getTitle() + " | " + p.getCategory() + " | " + p.getPrice() + " грн");
        }
    }

    private static void addToCart(Store store, Scanner scanner) {
        showCatalog(store);
        System.out.print("\nВведіть номер товару для додавання: ");
        int num = scanner.nextInt();

        if (num <= 0 || num > store.getAllProducts().size()) {
            System.out.println("Невірний номер!");
            return;
        }

        Product p = store.getAllProducts().get(num - 1);
        store.getCart().addProduct(p);
        System.out.println("Товар додано у кошик!");
    }

    private static void showCart(Store store) {
        System.out.println("\n=== КОШИК ===");
        if (store.getCart().getProducts().isEmpty()) {
            System.out.println("Кошик порожній");
            return;
        }

        int i = 1;
        for (Product p : store.getCart().getProducts()) {
            System.out.println(i++ + ". " + p.getTitle() + " | " + p.getPrice() + " грн");
        }
        System.out.println("Загальна сума: " + store.checkout() + " грн");
    }

    private static void removeFromCart(Store store, Scanner scanner) {
        showCart(store);
        System.out.print("\nВведіть номер товару для видалення: ");
        int num = scanner.nextInt();

        if (num <= 0 || num > store.getCart().getProducts().size()) {
            System.out.println("Невірний номер!");
            return;
        }

        store.getCart().removeProduct(num - 1);
        System.out.println("Товар видалено.");
    }

    private static void checkout(Store store, Scanner scanner) {
        if (store.getCart().getProducts().isEmpty()) {
            System.out.println("Кошик порожній!");
            return;
        }

        System.out.println("\nВиберіть спосіб оплати:");
        System.out.println("1 — Картка");
        System.out.println("2 — Готівка");
        int paymentType = scanner.nextInt();

        PaymentStrategy strategy =
                (paymentType == 1) ? new CardPayment() : new CashPayment();

        store.checkout(strategy);
    }
}
