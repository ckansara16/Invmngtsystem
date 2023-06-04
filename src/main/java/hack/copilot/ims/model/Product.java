package hack.copilot.ims.model;

//Model to maintain stock of products  //add comment
public class Product {
    private String productId;   //add product id
    //add product name, description
    private String name;
    private String description;

    private String productCompanyName; //add company name

    private double price;
    private int quantity;   //add quantity

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getProductId() {
        return productId;
    }

    public String getProductCompanyName() {
        return productCompanyName;
    }

    public void setProductCompanyName(String productCompanyName) {
        this.productCompanyName = productCompanyName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
