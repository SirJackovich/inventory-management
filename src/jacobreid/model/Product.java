package jacobreid.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {
  
  private final ObservableList<Part> associatedParts = FXCollections.observableArrayList();
  private final IntegerProperty inventory;
  private static int ID = 0;
  private final IntegerProperty max;
  private final IntegerProperty min;
  private final StringProperty name;
  private final DoubleProperty price;
  private final IntegerProperty productID;
 
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
   * @param associatedParts
   */
  public Product(String name, double price, int inventory, int min, int max, ObservableList<Part> associatedParts) {
    this.productID = new SimpleIntegerProperty(generateID());
    this.name = new SimpleStringProperty(name);
    this.price = new SimpleDoubleProperty(price);
    this.inventory = new SimpleIntegerProperty(inventory);
    this.min = new SimpleIntegerProperty(min);
    this.max = new SimpleIntegerProperty(max);
    if(associatedParts != null){
      associatedParts.forEach((part) -> {
        this.associatedParts.add(part);
      });
    }
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
  
  public ObservableList<Part> getAssociatedParts(){
    return this.associatedParts;
  }
  
//  we dont need these functions, this functionality is taken care of elsewhere
//  public boolean removeAssociatedPart(int index){
//    return associatedParts.remove(lookupAssociatedPart(index));
//  }
//  
//  public void removeAssociatedParts(){
//    for(int i = 0; i < associatedParts.size(); i++){
//      removeAssociatedPart(i);
//    }
//  }
//
//  public Part lookupAssociatedPart(int index){
//    return associatedParts.get(index);
//  }

  private int generateID(){
    return ID++;
  }
    
}
