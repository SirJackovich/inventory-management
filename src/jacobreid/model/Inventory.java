package jacobreid.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
  private final ObservableList<Part> parts = FXCollections.observableArrayList();
  private final ObservableList<Product> products = FXCollections.observableArrayList();

  public void addProduct(Product product){
    products.add(product);
  }

//  we dont use this function, this functionality is handled elsewhere
//  public boolean removeProduct(int index){
//    
//  }

//  we dont use this function, this functionality is handled elsewhere
//  public Product lookupProduct(int index){
//    
//  }

//  we dont use this function, this functionality is handled elsewhere
//  public void updateProduct(int index){
//    
//  }

  public void addPart(Part part){
    parts.add(part);
  }

//  we dont use this function, this functionality is handled elsewhere
//  public boolean deletePart(Part p){
//
//  }

//  we dont use this function, this functionality is handled elsewhere
//  public Part lookupPart(int index){
//    
//  }

//  we dont use this function, this functionality is handled elsewhere
//  public void updatePart(int index){
//    
//  }

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
