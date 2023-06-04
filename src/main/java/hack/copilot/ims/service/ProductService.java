package hack.copilot.ims.service;

import hack.copilot.ims.algorithm.ProductIdentity;
import hack.copilot.ims.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();

    //get product by name and company name
    public Product getProductByNameAndCompanyName(String name, String companyName) {
        return products.stream()
                .filter(p -> p.getName().equals(name) && p.getProductCompanyName().equals(companyName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    //update product quantity in stock
    public boolean updateProductQuantityByNameAndCompanyName(String name, String companyName, int quantity) {
        boolean isUpdated = false;
        Product product = getProductByNameAndCompanyName(name, companyName);
        //check if quantity is less than actual product quantity
        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Product quantity is less than actual quantity");
        }
        //substract product quantity from product
        product.setQuantity(product.getQuantity() - quantity);
        return isUpdated = true;
    }

    //add product quantity in stock
    public boolean addProductQuantityByNameAndCompanyName(String name, String companyName, int quantity) {
        boolean isUpdated = false;
        Product product = getProductByNameAndCompanyName(name, companyName);
        //add product quantity to product
        product.setQuantity(product.getQuantity() + quantity);
        return isUpdated = true;
    }

    //add product to stock
    public void addProduct(Product product) {
        //check if product already exists
            products.stream()
                .filter(p -> p.getName().equals(product.getName()) && p.getProductCompanyName().equals(product.getProductCompanyName()))
                .findFirst()
                .ifPresent(p -> {
                    throw new RuntimeException("Product already exists");
                });
        //get product id from algorithm
        String productId = new ProductIdentity().generateProductId();
        product.setProductId(productId);
        products.add(product);
    }

    //update product in stock
    public void updateProduct(Product product) {
        Product productToUpdate = products.stream()
                .filter(p -> p.getProductId().equals(product.getProductId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productToUpdate.setName(product.getName());
        productToUpdate.setProductCompanyName(product.getProductCompanyName());
        productToUpdate.setQuantity(product.getQuantity());
        productToUpdate.setPrice(product.getPrice());
    }

    //delete product from stock
    public boolean deleteProduct(String productId) {
        return products.removeIf(p -> p.getProductId().equals(productId));
    }


}
