package org.example.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import lombok.NoArgsConstructor;
import org.example.objects.Product;
import org.example.objects.ProductList;
import org.example.exceptions.WrongFileException;

/**
 * @author Kostiantyn Kvartyrmeister on 14.12.2022 Class to parse files .csv that contains list of
 * products from different shops
 */

@NoArgsConstructor
public class OrderFileParser {

  /**
   * Method reads given .csv file , forms list of {@link Product}
   *
   * @return List<Product>
   */
  private ProductList read(File file) {
    String str;
    ProductList productList = new ProductList();

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      reader.readLine();
      str = reader.readLine();

      while (str != null) {
        String[] split = str.split(";");
        Product product = new Product(split[0], split[1], Float.parseFloat(split[2]),
            Integer.parseInt(split[3]));

        productList.add(product);
        str = reader.readLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return productList;
  }

  /**
   * Method gets
   *
   * @param filesNames list of files names ,checks each of them and sends for read creating new
   *                   object of {@link File}
   * @return List<Product> from all files in the list
   */

  public ProductList parseNamesFileList(List<String> filesNames) throws WrongFileException {
    if (filesNames == null) {
      return new ProductList();

    } else if (!filesNames.stream().allMatch(a -> a.contains(".csv"))) {
      throw new WrongFileException("Contains not correct file " + filesNames.toString());
    }

    ProductList list = new ProductList();
    filesNames.forEach(file -> list.addList(read(new File(file)).getProducts()));

    return list;
  }

  /**
   * Method gets
   *
   * @param files list of Files ,checks each of them and sends for read
   * @return List<Product> from all files in the list
   */
  public ProductList parseFilesList(List<File> files) throws WrongFileException {
    if (files == null) {
      return new ProductList();

    } else if (!files.stream().allMatch(a -> a.getName().contains(".csv"))) {
      throw new WrongFileException("Contains not correct file " + files.toString());
    }

    ProductList list = new ProductList();
    files.forEach(file -> list.addList(read(file).getProducts()));

    return list;
  }
}
