/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobreid;

import jacobreid.model.Inhouse;
import jacobreid.model.Inventory;
import jacobreid.model.Outsourced;
import jacobreid.model.Product;
import jacobreid.view_controller.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author sirjackovich
 */
public class JacobReid extends Application {
  private Stage primaryStage;
  private BorderPane mainLayout;
  private final Inventory inventory = new Inventory();

  /**
   * Constructor
   */
  public JacobReid() {
    inventory.addPart(new Outsourced("outsourced part", 15, 3, 1, 5, "companyName"));
    inventory.addProduct(new Product("product one", 15, 3, 1, 5, inventory.getParts()));
    inventory.addPart(new Inhouse("inhouse part", 10, 2, 1, 5, 7));
    inventory.addProduct(new Product("product two", 25, 2, 1, 5, inventory.getParts()));
  }

  public Inventory getInventory(){
    return inventory;
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
    mainController.setApp(this);
    mainController.setPrimaryStage(primaryStage);

    // Show the scene containing the main layout
    Scene scene = new Scene(mainLayout);
    primaryStage.setScene(scene);
    primaryStage.show();
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
