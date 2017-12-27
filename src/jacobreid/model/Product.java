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
  private final StringProperty name;
  private final DoubleProperty price;
  private final IntegerProperty inventory;
  private final IntegerProperty min;
  private final IntegerProperty max;
    
  /**
   * Default constructor.
   */
  public Product() {
    this.productID = null;
    this.name = null;
    this.price = null;
    this.inventory = null;
    this.min = null;
    this.max = null;
  }

  /**
   * Constructor with some initial data.
   * 
   * @param name
   * @param price
   * @param inventory
   * @param min
   * @param max
   */
  public Product(String name, double price, int inventory, int min, int max) {
    this.productID = new SimpleIntegerProperty(generateID());
    this.name = new SimpleStringProperty(name);
    this.price = new SimpleDoubleProperty(price);
    this.inventory = new SimpleIntegerProperty(inventory);
    this.min = new SimpleIntegerProperty(min);
    this.max = new SimpleIntegerProperty(max);
  }

//  We auto generate the ID so there is no need for a setter function   
//  void setProductID(int id){
//    this.productID = id;
//  }
    
  public int getID(){
    return this.productID.get();
  }
  
  public IntegerProperty IDProperty() {
    return productID;
  }

  public void setName(String name){
    this.name.set(name);
  }

  public String getName(){
    return this.name.get();
  }
  
  public StringProperty nameProperty() {
    return name;
  }

  public void setPrice(double price){
    this.price.set(price);
  }
    
  public double getPrice(){
    return this.price.get();
  }
  
  public DoubleProperty priceProperty() {
    return price;
  }

  public void setInventory(int inventory){
    this.inventory.set(inventory);
  }

  public int getInventory(){
    return this.inventory.get();
  }
  
  public IntegerProperty inventoryProperty() {
    return inventory;
  }

  public void setMin(int min){
    this.min.set(min);
  }

  public int getMin(){
    return this.min.get();
  }

  public void setMax(int max){
    this.max.set(max);
  }
    
  public int getMax(){
    return this.max.get();
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
