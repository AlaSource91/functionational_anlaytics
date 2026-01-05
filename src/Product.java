import java.math.BigDecimal;
import java.util.List;

public class Product
{
    private String id;
    private String name;
    private BigDecimal price;
    private Category category;

    // Constructor
    public Product(String id, String name, BigDecimal price, Category category)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product productGreaterThan100USD(List<Product> products) {

     return    products.stream()
                .filter(product -> product.getPrice().compareTo(new BigDecimal("10.0")) > 0)
                .findAny()
             .orElseThrow();
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // toString method
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
