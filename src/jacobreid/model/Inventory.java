package jacobreid.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
  private final ObservableList<Part> parts = FXCollections.observableArrayList();
  private final ObservableList<Product> products = FXCollections.observableArrayList();

  public void addProduct(Product product){
    products.add(product);
  }

  public boolean removeProduct(int index){
    // TODO: figure out what to do here
    return true;
  }

  public Product lookupProduct(int index){
    // TODO: figure out what to do here
    return products.get(index);
  }

  public void updateProduct(int index){
    // TODO: figure out what to do here
  }

  public void addPart(Part part){
    parts.add(part);
  }

  public boolean deletePart(Part p){
    // TODO: figure out what to do here
    parts.remove(p);
    return true;
  }

  public Part lookupPart(int index){
    // TODO: figure out what to do here
    return parts.get(index);
  }

  public void updatePart(int index){
    // TODO: figure out what to do here
  }

  public ObservableList<Part> getParts(){
    return parts;
  }

  public ObservableList<Product> getProducts() {
    return products;
  }
  
  public ObservableList<Part> searchParts(String text) {
    ObservableList<Part> tempParts = FXCollections.observableArrayList();
    try{
      int partNumber = Integer.parseInt(text);
      parts.stream().filter((part) -> (part.getID() == partNumber)).forEachOrdered((part) -> {
        tempParts.add(part);
      });
    } catch(NumberFormatException e) {
      parts.stream().filter((part) -> (part.getName().contains(text))).forEachOrdered((part) -> {
        tempParts.add(part);
      });
    }
    return tempParts;
  }
  
  public ObservableList<Product> searchProducts(String text) {
    ObservableList<Product> tempProducts = FXCollections.observableArrayList();
    try{
      int productNumber = Integer.parseInt(text);
      products.stream().filter((product) -> (product.getID() == productNumber)).forEachOrdered((product) -> {
        tempProducts.add(product);
      });
    } catch(NumberFormatException e) {
      products.stream().filter((product) -> (product.getName().contains(text))).forEachOrdered((product) -> {
        tempProducts.add(product);
      });
    }
    return tempProducts;
  }
}
