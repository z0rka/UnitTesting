package org.example.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.example.objects.Product;
import org.example.objects.ProductList;

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
  public List<String> findShops(ProductList productList) {
    List<String> shopsList = new ArrayList<>();

    productList.getProducts().forEach(a -> {
      if (!shopsList.contains(a.getShopName())) {
        shopsList.add(a.getShopName());
      }
    });

    return shopsList;
  }


  /**
   * Method creates new HashMap with products and their av price
   *
   * @param productMap - not handled hashmap
   * @return Map<String, ProductList> - handled hashmap
   */
  private Map<String, ProductList> mergeAndCount(Map<String, ProductList> productMap) {
    var ref = new Object() {
      List<Product> list;
    };
    Map<String, ProductList> filteredProductMap = new HashMap<>();
    Set<Entry<String, ProductList>> entries = productMap.entrySet();

    entries.forEach(entry -> {
      ref.list = new ArrayList<>();
      entry.getValue().getProducts().forEach(product -> {
        if (ref.list.stream()
            .noneMatch(product1 -> product1.getProductName().equals(product.getProductName()))) {
          ref.list.add(Product.builder().productName(product.getProductName()).build());
        }
      });

      countAverage(ref.list, entry);
      ProductList list1 = new ProductList(ref.list);
      filteredProductMap.putIfAbsent(entry.getKey(), list1);
    });

    return filteredProductMap;
  }

  /**
   * Method counts average price of products and their amount
   *
   * @param list  - list of products
   * @param entry entry set from map of products
   */
  private void countAverage(List<Product> list, Entry<String, ProductList> entry) {
    AtomicReference<Float> price = new AtomicReference<>((float) 0);
    list.forEach(product -> {
      long count = entry.getValue().getProducts()
          .stream()
          .filter(product1 -> product1.getProductName().equals(product.getProductName()))
          .peek(product1 -> {

            product.setAmount(product.getAmount() + product1.getAmount());
            price.updateAndGet(v -> v + product1.getPrice());

          }).count();

      product.setPrice(price.get() / count);
      price.set(0f);
    });
  }

  /**
   * Method maps
   *
   * @param productList list of Products to HashMap with keys - Shops names
   * @return Map<String, ProductList> map of shops and their products
   */
  public Map<String, ProductList> divideByShops(ProductList productList) {
    if (productList == null) {
      return new HashMap<>();
    }

    Map<String, ProductList> dividedList = new HashMap<>();
    List<String> shops = findShops(productList);

    shops.forEach(a -> dividedList.put(a, new ProductList()));

    productList.getProducts().forEach(a -> dividedList.get(a.getShopName()).add(a));

    return dividedList;
  }

  /**
   * Method calls private methods that handler list and return final map
   *
   * @param productList list of products
   * @return Map<String, ProductList> filtered and merged map
   */
  public Map<String, ProductList> manageList(ProductList productList) {
    if (productList == null) {
      return new HashMap<>();
    }

    Map<String, ProductList> productMap = divideByShops(productList);
    return mergeAndCount(productMap);
  }
}
