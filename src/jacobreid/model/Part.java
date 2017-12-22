/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author sirjackovich
 */
public abstract class Part {
    private int ID = 0;
    private final IntegerProperty partID;
    private StringProperty name;
    private DoubleProperty price;
    private IntegerProperty inventory;
    private IntegerProperty min;
    private IntegerProperty max;
    
    /**
     * Default constructor.
     */
    public Part() {
        this.partID = null;
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
    public Part(String name, double price, int inventory, int min, int max) {
        this.partID = new SimpleIntegerProperty(generateID());
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.inventory = new SimpleIntegerProperty(inventory);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
    }
    
//   We auto generate the ID so there is no need for a setter function   
//   void setPartID(int id){
//        partID = id;
//   }
    
    public int getPartID(){
        return this.partID.get();
    }
    
    public IntegerProperty IDProperty() {
        return partID;
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
    
    public IntegerProperty minProperty() {
        return min;
    }
    
    public void setMax(int max){
        this.max.set(max);
    }
    
    public int getMax(){
        return this.max.get();
    }
    
    public IntegerProperty maxProperty() {
        return max;
    }
    
    private int generateID(){
        return ID++;
    }
}
