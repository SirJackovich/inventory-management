/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid;

import jacobreid.model.Inhouse;
import jacobreid.model.Inventory;
import jacobreid.model.Outsourced;
import jacobreid.model.Part;
import jacobreid.model.Product;
import jacobreid.view_controller.MainController;
import jacobreid.view_controller.PartController;
import jacobreid.view_controller.ProductController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author sirjackovich
 */
public class JacobReid extends Application {
  private Stage primaryStage;
  private BorderPane mainLayout;
  Inventory inventory = new Inventory();

  /**
   * Constructor
   */
  public JacobReid() {
    inventory.addPart(new Outsourced("outsourced part", 15, 3, 1, 5, "companyName"));
    inventory.addPart(new Inhouse("inhouse part", 10, 2, 1, 5, 7));
    inventory.addProduct(new Product("product one", 15, 3, 1, 5));
    inventory.addProduct(new Product("product two", 10, 2, 1, 5));
  }

  public ObservableList<Part> getParts() {
    return inventory.getParts();
  }
  
  public ObservableList<Product> getProducts() {
    return inventory.getProducts();
  }
    
  @Override
  public void start(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Inventory Management System");
    showMain();
  }
    
  public void showMain() throws IOException {
    // Load main layout from fxml file
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(JacobReid.class.getResource("view_controller/Main.fxml"));
    mainLayout = (BorderPane) loader.load();

    // Give the controller access to the main app.
    MainController mainController = loader.getController();
    mainController.setMain(this);

    // Show the scene containing the main layout
    Scene scene = new Scene(mainLayout);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
    
  public Part showAddPartDialog(Part part) {
      return partDialog(part, "Add Part", false);
  }
  
  public Part showModifyPartDialog(Part part) {
    return partDialog(part, "Modify part", true);
  }
  
  private Part partDialog(Part part, String title, boolean disableRadio){
    try {
      // Load the fxml file and create a new stage for the popup dialog.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(JacobReid.class.getResource("view_controller/Part.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      // Create the dialog Stage.
      Stage partStage = new Stage();
      partStage.setTitle(title);
      partStage.initModality(Modality.APPLICATION_MODAL);
      partStage.initOwner(primaryStage);
      Scene scene = new Scene(page);
      partStage.setScene(scene);

      // set the part in the controller
      PartController partController = loader.getController();
      partController.setPartLabel(title);
      if(disableRadio){
        partController.disableRadio();
      }
      partController.setPartStage(partStage);
      if(part != null){
        partController.setPart(part);
      }


      partStage.showAndWait();

      return partController.getPart();

     } catch (IOException e) {
      return null;
     }
  }
  
  public Product productDialog(Product product){
    try {
      // Load the fxml file and create a new stage for the popup dialog.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(JacobReid.class.getResource("view_controller/Product.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      // Create the dialog Stage.
      Stage productStage = new Stage();
      // productStage.setTitle(title);
      productStage.initModality(Modality.APPLICATION_MODAL);
      productStage.initOwner(primaryStage);
      Scene scene = new Scene(page);
      productStage.setScene(scene);

      // set the part in the controller
      ProductController prodcutController = loader.getController();
      // prodcutController.setProductLabel(title);
      
      prodcutController.setProductStage(productStage);
      if(product != null){
        prodcutController.setProduct(product);
      }


      productStage.showAndWait();

      return prodcutController.getProduct();

     } catch (IOException e) {
      return null;
     }
  }
  
  public ObservableList<Part> searchParts(String text) {
    ObservableList<Part> tempParts = FXCollections.observableArrayList();
    try{
      int partNumber = Integer.parseInt(text);
      for(Part part: inventory.getParts()){
        if(part.getID() == partNumber){
          tempParts.add(part);
        }
      }
    } catch(NumberFormatException e) {
      for(Part part: inventory.getParts()){
        if(part.getName().contains(text)){
          tempParts.add(part);
        }
      }
    }
    return tempParts;
  }
   
  public Stage getPrimaryStage() {
    return primaryStage;
  }
  
  public void close(){
    primaryStage.close();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
    
}
