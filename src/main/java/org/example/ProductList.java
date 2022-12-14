package org.example;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Kostiantyn Kvartyrmeister on 14.12.2022
 */
@NoArgsConstructor
@Getter
@EqualsAndHashCode

public class ProductList {

  private final List<Product> products = new ArrayList<>();

  public boolean add(Product product) {
    products.add(product);
    return true;
  }

  public boolean addList(List<Product> products) {
    this.products.addAll(products);
    return true;
  }

  public boolean del(int index) {
    products.remove(index);
    return true;
  }

  public boolean del(Product product) {
    products.remove(product);
    return true;
  }
}
