import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User
{
    private int id;
    private String name;
    private int age ;
    private List<Order> orders;

    // Constructor
    public User(int id, String name, int age, List<Order> orders)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.orders = orders;
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAllProductPurchasesByUser()
    {
        return orders.stream()
                .flatMap(order -> order.getProducts()
                        .stream())
                .map(Product::getName)
                .toList();
    }

    public static BigDecimal totalRevenueFromAllUsers(List< User> users)
    {
        return users
                .stream()
                .flatMap(user -> user.getOrders()
                        .stream())
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
    public static List<String> getAllProductPurchasesByUsers(List<User> users)
    {
        return users.stream()
                .flatMap(user -> user.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getName)
                .toList();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", orders=" + orders +
                '}';
    }
}
