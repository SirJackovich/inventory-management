/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author sirjackovich
 */
public final class Inhouse extends Part{
  private final IntegerProperty machineID;

  public Inhouse(String name, double price, int inventory, int min, int max, int machineID) {
    super(name, price, inventory, min, max);
    this.machineID = new SimpleIntegerProperty(machineID);
  }

  public void setMachineID(int machineID) {
    this.machineID.set(machineID);
  }

  public int getMachineID() {
    return this.machineID.get();
  }

  public IntegerProperty machineIDProperty() {
    return machineID;
  }

  @Override
  public String getPartType(){
    return "Inhouse";
  }
}
