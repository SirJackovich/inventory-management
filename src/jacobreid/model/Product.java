/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Model class for a Product
 * 
 * @author sirjackovich
 */
public class Product {
  private static int ID = 0;
  private final ObservableList<Part> associatedParts = FXCollections.observableArrayList();
  private final IntegerProperty productID;
  private StringProperty name;
  private DoubleProperty price;
  private IntegerProperty inStock;
  private IntegerProperty min;
  private IntegerProperty max;
    
  /**
   * Default constructor.
   */
  public Product() {
    this.productID = null;
    this.name = null;
    this.price = null;
    this.inStock = null;
    this.min = null;
    this.max = null;
  }

  /**
   * Constructor with some initial data.
   * 
   * @param name
   * @param price
   * @param inStock
   * @param min
   * @param max
   */
  public Product(String name, double price, int inStock, int min, int max) {
    this.productID = new SimpleIntegerProperty(generateID());
    this.name = new SimpleStringProperty(name);
    this.price = new SimpleDoubleProperty(price);
    this.inStock = new SimpleIntegerProperty(inStock);
    this.min = new SimpleIntegerProperty(min);
    this.max = new SimpleIntegerProperty(max);
  }

//  We auto generate the ID so there is no need for a setter function   
//  void setProductID(int id){
//    this.productID = id;
//  }
    
  public IntegerProperty getProductID(){
    return this.productID;
  }

  public void setName(String name){
    this.name = new SimpleStringProperty(name);
  }

  public StringProperty getName(){
    return this.name;
  }

  public void setPrice(double price){
    this.price = new SimpleDoubleProperty(price);
  }
    
  public DoubleProperty getPrice(){
    return this.price;
  }

  public void setInStock(int inStock){
    this.inStock = new SimpleIntegerProperty(inStock);
  }

  public IntegerProperty getInStock(){
    return this.inStock;
  }

  public void setMin(int min){
    this.min = new SimpleIntegerProperty(min);
  }

  public IntegerProperty getMin(){
    return this.min;
  }

  public void setMax(int max){
    this.max = new SimpleIntegerProperty(max);
  }
    
  public IntegerProperty getMax(){
    return this.max;
  }

  public void addAssociatedPart(Part part){
    associatedParts.add(part);
  }

  public boolean removeAssociatedPart(int index){
    // TODO: figure out what to do here
    associatedParts.remove(index);
    return true;
  }

  public Part lookupAssociatedPart(int index){
    // TODO: figure out what to do here
    return associatedParts.get(index);
  }

  private int generateID(){
    return ID++;
  }
    
}
