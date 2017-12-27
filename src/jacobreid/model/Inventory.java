/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author sirjackovich
 */
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
}
