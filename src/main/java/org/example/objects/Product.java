package org.example.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Kostiantyn Kvartyrmeister on 14.12.2022 Class to create object of product from concrete
 * shop
 */

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Builder

public class Product {

  private String shopName;
  private String productName;
  private float price;
  private int amount;

  @Override
  public String toString() {
    return productName +
        ";" + price +
        ";" + amount + ";";
  }
}
