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
    private IntegerProperty inStock;
    private IntegerProperty min;
    private IntegerProperty max;
    
    /**
     * Default constructor.
     */
    public Part() {
        this.partID = null;
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
    public Part(String name, double price, int inStock, int min, int max) {
        this.partID = new SimpleIntegerProperty(generateID());
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
    }
    
//   We auto generate the ID so there is no need for a setter function   
//   void setPartID(int id){
//        partID = id;
//   }
    
    public IntegerProperty getPartID(){
        return this.partID;
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
    
    private int generateID(){
        return ID++;
    }
}
