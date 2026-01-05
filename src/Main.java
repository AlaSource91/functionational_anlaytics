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
            new User(2, "Bob", 25, List.of()),
            new User(3, "Charlie", 16, List.of())
        );

        System.out.println("All products purchased by users: " + User.getAllProductPurchasesByUsers(user));
        System.out.println("Users under 18: " + User.findUsersUnderAge(user));
        System.out.println("Is any user under 18? " + User.checkIfAnyUserUnderAge(user));
        // Example: Print order products if paid
        System.out.println("Order ID: " + order.getId());
        System.out.println("Paid Status: " + order.getPaidStatus());
        System.out.println("Products in Order: " + order.getAllProductsPurchaseByStatusOrder());
        Order orderUnPaid = new Order("02",StatusPay.UNPAID.getValue(),
                List.of(
                        new Product("03", "Book", new BigDecimal("19.99"), new Category("c3", "Books")),
                        new Product("04", "Headphones", new BigDecimal("79.99"), new Category("c1", "Electronics"))
                ));

        List<Order> orders = List.of(order, orderUnPaid);

        // Example: Print all products purchased by a user
        //Check if any Order is paid
        boolean isPaidOrder = order.CheckIfOrderIsPaid(orders);
        System.out.println("Is there any paid order? " + isPaidOrder);
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

        //Get Most Expensive Product in the Order
        String productName = order.getMostExpensiveProduct();
        System.out.println("Most expensive product in the order: " + productName);

        //Get Most Cheaper Product in the Order
        String cheaperProductName = order.getMostCheaperProduct();
        System.out.println("Most cheaper product in the order: " + cheaperProductName);

        //Find users Under Age 18
        List<String> underAgeUsers = User.findUsersUnderAge(user);
        System.out.println("Users under age 18: " + underAgeUsers);

        boolean priceIsNegativeOrZero = order.checkIfProductPriceIsZeroOrNegative();
        System.out.println("Is there any product with price zero or negative? " + priceIsNegativeOrZero);

    }
}