package com.diffblue.demo.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Map;

/**
 * Controller for getting product information from the DB.
 * productList will get the names of all the products that are currently held in the DB
 */

@Controller
public class ProductController {

  private final ProductRepository productRepo;

  @Autowired
  public ProductController(ProductRepository productRepo2) {
    this.productRepo = productRepo2;
  }

  /**
   * Get the full list of products.
   * @param model where to put the list of product names (as Collection of strings)
   * @return Page for the output
   */

  @RequestMapping("/ProductList")
  public String productList(Map<String, Object> model) {

    Collection<String> allProducts = this.productRepo.findName();
    Application.log.info("Number of products: " + allProducts.size());
    Application.log.info("All Products as string: " + allProducts.toString());
    for (String p : allProducts) {
      Application.log.info("Product Name is: " + p.toString());
    }
    model.put("products", allProducts);
    return "ProductList";
  }

}
