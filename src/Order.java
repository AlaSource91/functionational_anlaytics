import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Order
{
    private String id;
    private String paidStatus;
    private List<Product> products;

    // Constructor
    public Order(String id, String paidStatus, List<Product> products) {
        this.id = id;
        this.paidStatus = paidStatus;
        this.products = products;
    }

    public List<String> getAllProductsUnPaidStatus()
    {
        //Only return products if the order is unpaid
        if (this.paidStatus.equalsIgnoreCase(StatusPay.UNPAID.getValue()))
        {
            return  products.stream()
                    .map(Product::getName)
                    .toList();
        }
        return new ArrayList<>();
    }

    public BigDecimal totalRevenue()
    {
        // Only calculate revenue if the Order is Paid
        if (this.paidStatus.equalsIgnoreCase(StatusPay.PAID.getValue()))
        {
            return products.stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;
    }
    public List<String> getAllProductsPurchaseByStatusOrder()
    {
        // Only return products if the order is paid
        if (this.paidStatus.equalsIgnoreCase(StatusPay.PAID.getValue())) {
            return products.stream()
                    .map(Product::getName)
                    .toList();
        }
        return new ArrayList<>();
    }
    // Getters and Setters

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotalProductCount() {
        return products.size();
    }

    public String getMostCheaperProduct()
    {
        return  products.stream()
                .min(Comparator.comparing(Product::getPrice))
                .map(Product::getName)
                .orElse("No Products");
    }
    public String getMostExpensiveProduct()
    {
        return products
                .stream()
                .max((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                .map(Product::getName)
                .orElse("No Products");
    }

    //check if any Order is Paid
  public Boolean CheckIfOrderIsPaid(List<Order> orders)
  {
      return   orders
              .stream()
              .anyMatch(order -> order.getPaidStatus().equalsIgnoreCase(StatusPay.PAID.getValue()));
  }

    // toString method

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", paidStatus='" + paidStatus + '\'' +
                ", products=" + products +
                '}';
    }
}