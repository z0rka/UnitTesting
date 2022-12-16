package org.example.handlers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.example.objects.ProductList;

/**
 * @author Kostiantyn Kvartyrmeister on 15.12.2022 Class writes down information about shop`s
 * products in new file
 */
public class ShopsFileWriter {

  /**
   * Method writes down information about products in each shop
   *
   * @param productMap - map of shops and their products
   * @return boolean - if worked correctly
   */
  private boolean writer(Map<String, ProductList> productMap) {
    Set<Entry<String, ProductList>> entries = productMap.entrySet();

    entries.forEach(entry -> {
      String fileName = entry.getKey() + "_res.csv";

      try (FileWriter writer = new FileWriter(fileName, false)) {

        writer.write("НАИМЕНОВАНИЕ;ЦЕНА;ШТ;");

        entry.getValue().getProducts().forEach(product -> {
          try {
            writer.write("\n" + product.toString());
          } catch (IOException e) {
            e.printStackTrace();
          }
        });

        writer.flush();

      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    return true;
  }

  /**
   * Method calls private method that writes down information about products in each shop
   *
   * @param productMap - map of shops and their products
   * @return boolean - if worked correctly
   */
  public boolean write(Map<String, ProductList> productMap) {
    return writer(productMap);
  }
}
