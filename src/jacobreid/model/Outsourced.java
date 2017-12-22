/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author sirjackovich
 */
public final class Outsourced extends Part{
    private StringProperty companyName;
    
    /**
     * Default constructor.
     */
    public Outsourced() {
        super();
        this.companyName = null;
    }

    public Outsourced(String name, double price, int inStock, int min, int max, String companyName) {
        super(name, price, inStock, min, max);
        setCompanyName(companyName);
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = new SimpleStringProperty(companyName);
    }
    
    public StringProperty getCompanyName() {
        return this.companyName;
    }
}
