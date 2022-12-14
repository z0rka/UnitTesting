package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Kostiantyn Kvartyrmeister on 14.12.2022 Class to create object of product from concrete
 * shop
 */

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {

  private final String shopName;
  private final String productName;
  private final float price;
  private final int amount;

}
