package hack.copilot.ims.controller;

import hack.copilot.ims.model.Product;
import hack.copilot.ims.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/inventory")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //create rest api to add product in stock
    //add openapi documentation
    @RequestMapping(path="/product", method = RequestMethod.POST,consumes = "application/json")
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "New Product is added successfully, productId" + product.getProductId();
    }

    //create rest api to get product by name and company name
    @RequestMapping(path="/search/product/{name}/{companyName}",method = RequestMethod.GET,produces = "application/json")
    public Product getProduct(@PathVariable String name, @PathVariable String companyName){
        return productService.getProductByNameAndCompanyName(name, companyName);
    }

    //create rest api to update product in stock
    @RequestMapping(path = "/product", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return "Product updated successfully";
    }

    //create rest api to delete product from stock
    @RequestMapping(path = "/product", method = RequestMethod.DELETE)
    public String deleteProduct(String productId){
        productService.deleteProduct(productId);
        return "Product deleted successfully";
    }

    //add product quantity in stock
    @RequestMapping(path="/product/stock-add/{name}/{companyName}/{quantity}",method = RequestMethod.GET)
    public String addProduct(@PathVariable String name, @PathVariable String companyName, @PathVariable int quantity){
        productService.addProductQuantityByNameAndCompanyName(name, companyName, quantity);
        return "Product stock added successfully";
    }

    //update product quantity in stock
    @RequestMapping(path="/product/stock-update/{name}/{companyName}/{quantity}",method = RequestMethod.GET)
    public String updateProduct(@PathVariable  String name,@PathVariable  String companyName,@PathVariable  int quantity){
        productService.updateProductQuantityByNameAndCompanyName(name, companyName, quantity);
        return "Product stock updated successfully";
    }
}
