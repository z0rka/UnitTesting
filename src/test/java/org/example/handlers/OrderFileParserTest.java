package org.example.handlers;

import java.util.ArrayList;
import java.util.List;
import org.example.objects.ProductList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 * @author Kostiantyn Kvartyrmeister on 17.12.2022
 */
class OrderFileParserTest {

  private static OrderFileParser parser;

  @BeforeAll
  static void init() {
    parser = new OrderFileParser();
  }

  /**
   * Method tests {@link OrderFileParser#parseNamesFileList(List)}
   */
  @Test
  void parseNamesFileList() {
    List<String> namesList = new ArrayList<>();
    namesList.add("src/main/resources/files/test.csv");

    List<String> brokenNamesList = new ArrayList<>();
    brokenNamesList.add("test");

    ProductList productList = parser.parseNamesFileList(namesList);
    ProductList productList1 = parser.parseNamesFileList(brokenNamesList);

    Assertions.assertEquals(2, productList.getProducts().size());
    Assertions.assertEquals("АТБ", productList.getProducts().get(0).getShopName());

    Assertions.assertEquals(0, productList1.getProducts().size());
  }
}
