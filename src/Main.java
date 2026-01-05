import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = List.of(
            new Product("01", "Laptop", new BigDecimal("999.99"), new Category("c1", "Electronics")),
            new Product("02", "Smartphone", new BigDecimal("499.99"), new Category("c2", "Electronics")),
            new Product("03", "Book", new BigDecimal("19.99"), new Category("c3", "Books")),
            new Product("04", "Headphones", new BigDecimal("79.99"), new Category("c1", "Electronics"))
        );

        // Create an order with selected products
        Order order = new Order(
            "01",
            StatusPay.PAID.getValue(),
            List.of(
                new Product("01", "Laptop", new BigDecimal("999.99"), new Category("c1", "Electronics")),
                new Product("02", "Smartphone", new BigDecimal("499.99"), new Category("c2", "Electronics"))
            )
        );

        List<User> user = List.of(
            new User(1, "Alice", 30, List.of(order)),
            new User(2, "Bob", 25, List.of())
        );

        System.out.println("All products purchased by users: " + User.getAllProductPurchasesByUsers(user));
        // Example: Print order products if paid
        System.out.println("Order ID: " + order.getId());
        System.out.println("Paid Status: " + order.getPaidStatus());
        System.out.println("Products in Order: " + order.getAllProductsPurchaseByStatusOrder());

        Order orderUnPaid = new Order("02",StatusPay.UNPAID.getValue(),
                List.of(
                        new Product("03", "Book", new BigDecimal("19.99"), new Category("c3", "Books")),
                        new Product("04", "Headphones", new BigDecimal("79.99"), new Category("c1", "Electronics"))
                ));
      System.out.println("Order ID: " + orderUnPaid.getId());
      System.out.println("Paid Status: " + orderUnPaid.getPaidStatus());
      System.out.println("Products in Order: " + orderUnPaid.getAllProductsUnPaidStatus());


      //Total From All Users
        BigDecimal totalFromAllUsers = User.totalRevenueFromAllUsers(user);
        System.out.println("Total Revenue from all users: " + totalFromAllUsers);
      //Calacute Total Revenue from all paid orders
        BigDecimal totalRevenue = order
                .totalRevenue();
        System.out.println("Total Revenue from paid orders: " + totalRevenue);
    }
}