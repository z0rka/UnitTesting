package org.example.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.example.objects.Product;
import org.example.objects.ProductList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author Kostiantyn Kvartyrmeister on 16.12.2022
 */
public class ProductListHandlerTest {

  private static ProductsListHandler handler;
  private static ProductList testList;

  @BeforeAll
  public static void init() {
    testList = new ProductList();
    testList.add(new Product("AТБ", "Мука", 40.9f, 120));
    testList.add(new Product("AТБ", "Гречка", 42.2f, 130));
    testList.add(new Product("Сильпо", "Мука", 38.4f, 150));
    testList.add(new Product("Сильпо", "Гречка", 44.5f, 122));

    handler = new ProductsListHandler();
  }

  /**
   * Method tests {@link ProductsListHandler#manageList(ProductList)}
   */
  @Test
  void manageListTest() {
    Map<String, ProductList> stringProductListMap = handler.manageList(testList);
    Map<String, ProductList> stringProductListMap1 = handler.manageList(null);

    Assertions.assertEquals(2, stringProductListMap.size());
    Assertions.assertNull(stringProductListMap1);
  }

  /**
   * Method tests {@link ProductsListHandler#divideByShops(ProductList)}
   */
  @Test
  void divideByShopTest() {

    OrderFileParser parser = Mockito.mock(OrderFileParser.class);
    Mockito.when(parser.parseFilesList(new ArrayList<>())).thenReturn(testList);

    Map<String, ProductList> stringProductListMap = handler.divideByShops(
        parser.parseFilesList(new ArrayList<>()));

    Map<String, ProductList> stringProductListMap1 = handler.divideByShops(null);

    Assertions.assertInstanceOf(HashMap.class, stringProductListMap);
    Assertions.assertEquals(2, stringProductListMap.size());
    Assertions.assertNull(stringProductListMap1);
  }
}
