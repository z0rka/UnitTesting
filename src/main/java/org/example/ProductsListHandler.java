package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Kostiantyn Kvartyrmeister on 14.12.2022 Class createds to divide list of products for
 * shops and merges all products and counts middle price
 */
public class ProductsListHandler {


  /**
   * Methods finds all the shops from product list
   *
   * @param productList list of products
   * @List<String> list of shops
   */
  private List<String> findShops(ProductList productList) {
    List<String> shopsList = new ArrayList<>();

    productList.getProducts().forEach(a -> {
      if (!shopsList.contains(a.getShopName())) {
        shopsList.add(a.getShopName());
      }
    });

    return shopsList;
  }

  /**
   * Method maps
   *
   * @param productList list of Products to HashMap with keys - Shops names
   * @return Map<String, ProductList> map of shops and their products
   */
  private Map<String, ProductList> divideByShops(ProductList productList) {
    Map<String, ProductList> dividedList = new HashMap<>();
    List<String> shops = findShops(productList);

    shops.forEach(a -> dividedList.put(a, new ProductList()));

    productList.getProducts().forEach(a -> dividedList.get(a.getShopName()).add(a));

    return dividedList;
  }

  private Map<String, ProductList> mergeAndCount(Map<String, ProductList> productMap) {
    return Collections.emptyMap();
  }

  public Map<String, ProductList> manageList(ProductList productList) {
    // Map<String, ProductList> productMap = divideByShops(productList);
    return Collections.emptyMap();
  }

}
